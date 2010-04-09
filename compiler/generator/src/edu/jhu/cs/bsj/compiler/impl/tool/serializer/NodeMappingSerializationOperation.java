package edu.jhu.cs.bsj.compiler.impl.tool.serializer;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnnotationMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnonymousClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.BlockStatementMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.InterfaceMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependsNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.NormalMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SingleElementMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjNodeOperationProxy;
import edu.jhu.cs.bsj.compiler.impl.utils.LineAndColumnOutputStream;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.impl.utils.PrependablePrintStream;

/**
 * This BSJ source serializer helper wraps around another helper and is used to
 * 
 * @author Zachary Palmer
 */
public class NodeMappingSerializationOperation extends
		BsjNodeOperationProxy<PrependablePrintStream, Void, Void, Pair<String, SerializedNodeMap>>
{
	/** The current {@link PrependablePrintStream} being used. This value is meaningless between calls. */
	private PrependablePrintStream ps;
	/**
	 * The stream underlying the print stream which is used to capture line number information. This value is
	 * meaningless between calls.
	 */
	private LineAndColumnOutputStream positionStream;
	/** The current buffer being used. This value is meaningless between calls. */
	private ByteArrayOutputStream buffer;
	/** The current list of mappings from output positions to nodes. This value is meaningless between calls. */
	private List<Pair<OutputPosition, Node>> outputs;

	/**
	 * Creates a new instance of this class. This factory method is necessary to properly configure the operation.
	 */
	public static NodeMappingSerializationOperation make()
	{
		MapBuildingHelper helper = new MapBuildingHelper();
		NodeMappingSerializationOperation op = new NodeMappingSerializationOperation(helper);
		helper.setOwner(op);
		return op;
	}

	/**
	 * Creates a serializer using a default helper.
	 */
	protected NodeMappingSerializationOperation(MapBuildingHelper helper)
	{
		super(helper);
	}

	@Override
	protected Pair<String, SerializedNodeMap> after(Void r)
	{
		this.ps.close();
		String src = this.buffer.toString();
		Pair<String, SerializedNodeMap> ret = new Pair<String, SerializedNodeMap>(src, new SerializedNodeMapImpl(this.outputs));
		this.ps = null;
		this.positionStream = null;
		this.buffer = null;
		this.outputs = null;
		return ret;
	}

	@Override
	protected PrependablePrintStream before(Void p)
	{
		this.buffer = new ByteArrayOutputStream();
		this.positionStream = new LineAndColumnOutputStream(buffer);
		this.ps = new PrependablePrintStream(positionStream, "    ", 0);
		this.outputs = new ArrayList<Pair<OutputPosition, Node>>();
		return this.ps;
	}

	/**
	 * This class acts as an implementation of a serialized node map.
	 */
	private static class SerializedNodeMapImpl implements SerializedNodeMap
	{
		private static final Comparator<Pair<OutputPosition, Node>> POSITION_COMPARATOR = new Comparator<Pair<OutputPosition, Node>>()
		{
			@Override
			public int compare(Pair<OutputPosition, Node> a, Pair<OutputPosition, Node> b)
			{
				return a.getFirst().compareTo(b.getFirst());
			}
		};

		private List<Pair<OutputPosition, Node>> positionMappings;

		public SerializedNodeMapImpl(List<Pair<OutputPosition, Node>> positionMappings)
		{
			this.positionMappings = positionMappings;
			Collections.sort(this.positionMappings, POSITION_COMPARATOR);
		}

		@Override
		public Node get(int line, int column)
		{
			Pair<OutputPosition, Node> key = new Pair<OutputPosition, Node>(new OutputPosition(line, column, line,
					column), null);
			int index = Collections.binarySearch(this.positionMappings, key, POSITION_COMPARATOR);
			if (index < 0)
			{
				index = -index - 1;
			}
			if (index >= this.positionMappings.size())
			{
				index = this.positionMappings.size() - 1;
			}
			while (index >= 0)
			{
				Pair<OutputPosition, Node> mapping = this.positionMappings.get(index);
				if (mapping.getFirst().contains(line, column))
				{
					return mapping.getSecond();
				}
				index--;
			}
			return null;
		}
	}

	/**
	 * This class contains information about an output position in the underlying stream.
	 */
	@SuppressWarnings("unused")
	private static class OutputPosition implements Comparable<OutputPosition>
	{
		/** The starting line of this position. */
		private int startLine;
		/** The starting column of this position. */
		private int startColumn;
		/** The ending line of this position. */
		private int endLine;
		/** The ending column of this position. */
		private int endColumn;

		public OutputPosition(int startLine, int startColumn, int endLine, int endColumn)
		{
			super();
			this.startLine = startLine;
			this.startColumn = startColumn;
			this.endLine = endLine;
			this.endColumn = endColumn;
		}

		public int getStartLine()
		{
			return startLine;
		}

		public int getEndLine()
		{
			return endLine;
		}

		public int getStartColumn()
		{
			return startColumn;
		}

		public int getEndColumn()
		{
			return endColumn;
		}

		public boolean contains(int line, int column)
		{
			if (this.startLine > line)
				return false;
			if (this.endLine < line)
				return false;
			if (this.startLine == line && this.startColumn > column)
				return false;
			if (this.endLine == line && this.endColumn < column)
				return false;
			return true;
		}

		@Override
		public int compareTo(OutputPosition o)
		{
			if (this.startLine < o.startLine)
			{
				return -1;
			}
			if (this.startLine > o.startLine)
			{
				return 1;
			}
			if (this.startColumn < o.startColumn)
			{
				return -1;
			}
			if (this.startColumn > o.startColumn)
			{
				return 1;
			}
			if (this.endLine < o.endLine)
			{
				return -1;
			}
			if (this.endLine > o.endLine)
			{
				return 1;
			}
			if (this.endColumn < o.endColumn)
			{
				return -1;
			}
			if (this.endColumn > o.endColumn)
			{
				return 1;
			}
			return 0;
		}
	}

	/**
	 * This class is used to provide AOP-style support to the serializer helper to notify this class when node
	 * serialization starts and stops.
	 * 
	 * @author Zachary Palmer
	 */
	private static class MapBuildingHelper extends BsjSourceSerializerHelper
	{
		private Stack<Pair<Integer, Integer>> startPositionStack = new Stack<Pair<Integer, Integer>>();
		private NodeMappingSerializationOperation owner = null;

		public MapBuildingHelper()
		{
			super();
		}

		public void setOwner(NodeMappingSerializationOperation owner)
		{
			this.owner = owner;
		}

		private void before(Node node)
		{
			int line = owner.positionStream.getLine();
			int column = owner.positionStream.getColumn();
			startPositionStack.push(new Pair<Integer, Integer>(line, column));
		}

		private void after(Node node)
		{
			int line = owner.positionStream.getLastLine();
			int column = owner.positionStream.getLastColumn();
			Pair<Integer, Integer> start = startPositionStack.pop();
			owner.outputs.add(new Pair<OutputPosition, Node>(new OutputPosition(start.getFirst(), start.getSecond(),
					line, column), node));
		}

		@Override
		public Void executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAlternateConstructorInvocationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnnotationAnnotationValueNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnnotationArrayValueNode(AnnotationArrayValueNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnnotationArrayValueNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnnotationBodyNode(AnnotationBodyNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnnotationBodyNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnnotationDeclarationNode(AnnotationDeclarationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnnotationDeclarationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnnotationElementListNode(AnnotationElementListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnnotationElementListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnnotationElementNode(AnnotationElementNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnnotationElementNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnnotationExpressionValueNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnnotationListNode(AnnotationListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnnotationListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnnotationMemberListNode(AnnotationMemberListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnnotationMemberListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnnotationMemberMetaprogramAnchorNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnnotationMethodDeclarationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnnotationMethodModifiersNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnnotationModifiersNode(AnnotationModifiersNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnnotationModifiersNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnnotationValueListNode(AnnotationValueListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnnotationValueListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnonymousClassBodyNode(AnonymousClassBodyNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnonymousClassBodyNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnonymousClassMemberListNode(AnonymousClassMemberListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnonymousClassMemberListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAnonymousClassMemberMetaprogramAnchorNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeArrayAccessNode(ArrayAccessNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeArrayAccessNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeArrayInitializerCreationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeArrayInitializerNode(ArrayInitializerNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeArrayInitializerNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeArrayInstantiatorCreationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeArrayTypeNode(ArrayTypeNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeArrayTypeNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAssertStatementNode(AssertStatementNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAssertStatementNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeAssignmentNode(AssignmentNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeAssignmentNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeBinaryExpressionNode(BinaryExpressionNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeBinaryExpressionNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeBlockNode(BlockNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeBlockNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeBlockStatementListNode(BlockStatementListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeBlockStatementListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeBlockStatementMetaprogramAnchorNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeBooleanLiteralNode(BooleanLiteralNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeBooleanLiteralNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeBreakNode(BreakNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeBreakNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeCaseListNode(CaseListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeCaseListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeCaseNode(CaseNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeCaseNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeCatchListNode(CatchListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeCatchListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeCatchNode(CatchNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeCatchNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeCharLiteralNode(CharLiteralNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeCharLiteralNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeClassBodyNode(ClassBodyNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeClassBodyNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeClassDeclarationNode(ClassDeclarationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeClassDeclarationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeClassLiteralNode(ClassLiteralNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeClassLiteralNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeClassMemberListNode(ClassMemberListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeClassMemberListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeClassMemberMetaprogramAnchorNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeClassModifiersNode(ClassModifiersNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeClassModifiersNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeCodeLiteralNode(CodeLiteralNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeCodeLiteralNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeCompilationUnitNode(CompilationUnitNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeCompilationUnitNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeConditionalExpressionNode(ConditionalExpressionNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeConditionalExpressionNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeConstructorBodyNode(ConstructorBodyNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeConstructorBodyNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeConstructorDeclarationNode(ConstructorDeclarationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeConstructorDeclarationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeConstructorModifiersNode(ConstructorModifiersNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeConstructorModifiersNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeContinueNode(ContinueNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeContinueNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeDeclaredTypeListNode(DeclaredTypeListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeDeclaredTypeListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeDoubleLiteralNode(DoubleLiteralNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeDoubleLiteralNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeDoWhileLoopNode(DoWhileLoopNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeDoWhileLoopNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeEnhancedForLoopNode(EnhancedForLoopNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeEnhancedForLoopNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeEnumBodyNode(EnumBodyNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeEnumBodyNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeEnumConstantDeclarationListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeEnumConstantDeclarationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeEnumDeclarationNode(EnumDeclarationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeEnumDeclarationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeEnumModifiersNode(EnumModifiersNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeEnumModifiersNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeExpressionListNode(ExpressionListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeExpressionListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeExpressionStatementNode(ExpressionStatementNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeExpressionStatementNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeFieldAccessByExpressionNode(FieldAccessByExpressionNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeFieldAccessByExpressionNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeFieldAccessByNameNode(FieldAccessByNameNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeFieldAccessByNameNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeFieldDeclarationNode(FieldDeclarationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeFieldDeclarationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeFieldModifiersNode(FieldModifiersNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeFieldModifiersNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeFloatLiteralNode(FloatLiteralNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeFloatLiteralNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeForInitializerDeclarationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeForInitializerExpressionNode(ForInitializerExpressionNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeForInitializerExpressionNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeForLoopNode(ForLoopNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeForLoopNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeIdentifierListNode(IdentifierListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeIdentifierListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeIdentifierNode(IdentifierNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeIdentifierNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeIfNode(IfNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeIfNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeImportListNode(ImportListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeImportListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeImportOnDemandNode(ImportOnDemandNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeImportOnDemandNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeImportSingleTypeNode(ImportSingleTypeNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeImportSingleTypeNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeInitializerDeclarationNode(InitializerDeclarationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeInitializerDeclarationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeInlineTypeDeclarationNode(InlineTypeDeclarationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeInlineTypeDeclarationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeInstanceOfNode(InstanceOfNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeInstanceOfNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeInterfaceBodyNode(InterfaceBodyNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeInterfaceBodyNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeInterfaceDeclarationNode(InterfaceDeclarationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeInterfaceDeclarationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeInterfaceMemberListNode(InterfaceMemberListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeInterfaceMemberListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeInterfaceMemberMetaprogramAnchorNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeInterfaceModifiersNode(InterfaceModifiersNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeInterfaceModifiersNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeIntLiteralNode(IntLiteralNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeIntLiteralNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeJavadocNode(JavadocNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeJavadocNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeLabeledStatementNode(LabeledStatementNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeLabeledStatementNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		protected <T extends Node> Void executeListNode(ListNode<T> node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeLongLiteralNode(LongLiteralNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeLongLiteralNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMetaAnnotationArrayValueNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMetaAnnotationElementListNode(MetaAnnotationElementListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMetaAnnotationElementListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMetaAnnotationElementNode(MetaAnnotationElementNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMetaAnnotationElementNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMetaAnnotationExpressionValueNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMetaAnnotationListNode(MetaAnnotationListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMetaAnnotationListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMetaAnnotationMetaAnnotationValueNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMetaAnnotationMetaprogramAnchorNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMetaAnnotationValueListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMetaprogramDependsNode(MetaprogramDependsNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMetaprogramDependsNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMetaprogramImportListNode(MetaprogramImportListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMetaprogramImportListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMetaprogramImportNode(MetaprogramImportNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMetaprogramImportNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMetaprogramNode(MetaprogramNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMetaprogramNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMetaprogramPreambleNode(MetaprogramPreambleNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMetaprogramPreambleNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMetaprogramTargetNode(MetaprogramTargetNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMetaprogramTargetNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMethodDeclarationNode(MethodDeclarationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMethodDeclarationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMethodInvocationByExpressionNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMethodInvocationByNameNode(MethodInvocationByNameNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMethodInvocationByNameNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeMethodModifiersNode(MethodModifiersNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeMethodModifiersNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeNameListNode(NameListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeNameListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeNoOperationNode(NoOperationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeNoOperationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeNormalAnnotationNode(NormalAnnotationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeNormalAnnotationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeNormalMetaAnnotationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeNullLiteralNode(NullLiteralNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeNullLiteralNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executePackageDeclarationNode(PackageDeclarationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executePackageDeclarationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executePackageNode(PackageNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executePackageNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeParameterizedTypeNode(ParameterizedTypeNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeParameterizedTypeNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeParameterizedTypeSelectNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeParenthesizedExpressionNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executePrimitiveTypeNode(PrimitiveTypeNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executePrimitiveTypeNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeQualifiedClassInstantiationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeQualifiedNameNode(QualifiedNameNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeQualifiedNameNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeReferenceTypeListNode(ReferenceTypeListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeReferenceTypeListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeReturnNode(ReturnNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeReturnNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeSimpleNameNode(SimpleNameNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeSimpleNameNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeSingleElementAnnotationNode(SingleElementAnnotationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeSingleElementAnnotationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeSingleElementMetaAnnotationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeSingleStaticImportNode(SingleStaticImportNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeSingleStaticImportNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeStatementExpressionListNode(StatementExpressionListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeStatementExpressionListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeStaticImportOnDemandNode(StaticImportOnDemandNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeStaticImportOnDemandNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeStringLiteralNode(StringLiteralNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeStringLiteralNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeSuperclassConstructorInvocationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeSuperFieldAccessNode(SuperFieldAccessNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeSuperFieldAccessNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeSuperMethodInvocationNode(SuperMethodInvocationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeSuperMethodInvocationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeSwitchNode(SwitchNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeSwitchNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeSynchronizedNode(SynchronizedNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeSynchronizedNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeThisNode(ThisNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeThisNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeThrowNode(ThrowNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeThrowNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeTryNode(TryNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeTryNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeTypeArgumentListNode(TypeArgumentListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeTypeArgumentListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeTypeCastNode(TypeCastNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeTypeCastNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeTypeDeclarationListNode(TypeDeclarationListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeTypeDeclarationListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeTypeDeclarationMetaprogramAnchorNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeTypeParameterListNode(TypeParameterListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeTypeParameterListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeTypeParameterNode(TypeParameterNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeTypeParameterNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeUnaryExpressionNode(UnaryExpressionNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeUnaryExpressionNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeUnaryStatementExpressionNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeUnparameterizedTypeListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeUnparameterizedTypeNode(UnparameterizedTypeNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeUnparameterizedTypeNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node,
				PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeUnqualifiedClassInstantiationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeVariableDeclarationNode(VariableDeclarationNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeVariableDeclarationNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeVariableDeclaratorListNode(VariableDeclaratorListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeVariableDeclaratorListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeVariableDeclaratorNode(VariableDeclaratorNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeVariableDeclaratorNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeVariableInitializerListNode(VariableInitializerListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeVariableInitializerListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeVariableListNode(VariableListNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeVariableListNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeVariableModifiersNode(VariableModifiersNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeVariableModifiersNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeVariableNode(VariableNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeVariableNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeVoidTypeNode(VoidTypeNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeVoidTypeNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeWhileLoopNode(WhileLoopNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeWhileLoopNode(node, p);
			} finally
			{
				after(node);
			}
		}

		@Override
		public Void executeWildcardTypeNode(WildcardTypeNode node, PrependablePrintStream p)
		{

			before(node);
			try
			{
				return super.executeWildcardTypeNode(node, p);
			} finally
			{
				after(node);
			}
		}
	}
}
