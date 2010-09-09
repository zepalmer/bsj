package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import javax.tools.Diagnostic.Kind;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.AlternateConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInstantiatorCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AssignmentNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConditionalExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParenthesizedExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReturnNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperMethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperclassConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeCastNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnqualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorOwnerNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableInitializerListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SingleElementMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.CountingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.NoOperationDiagnosticListener;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerEnvironment;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap.rule.ParseRuleExecution;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.ArrayTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjErrorType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParser;
import edu.jhu.cs.bsj.compiler.tool.parser.ParseRule;
import edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjRawCodeLiteralPayloadAntlrImpl;

/**
 * This operation is intended to evaluate the parse map relation as specified in the BSJ Language Specification. The
 * node on which this operation is being executed is the AST node in the relation; the return value of this operation is
 * the parse map. The operation's input value is an object indicating the environment at the time of the request.
 * <p/>
 * This operation may cache the results of the parsing operations over raw code literals. As a result, it should not be
 * used across AST mutations.
 * 
 * @author Zachary Palmer
 */
public class ParseMapOperation extends
		BsjDefaultNodeOperation<ParseMapperEnvironment, Map<RawCodeLiteralNode, ParseMapEntry>>
{
	/** The manager to use. */
	private TypecheckerManager manager;
	/** The BSJ parser that this manager should use for parsing nodes. */
	private BsjParser parser;
	/**
	 * A cache of the results which have been accumulated by parsing the given raw code literal node. This cache is used
	 * to prevent duplicate effort when this operation is used on the same node more than once (such as with different
	 * environments due to a wider, more inclusive parse mapping operation and thus a different environment).
	 */
	private Map<RawCodeLiteralNode, ParseResultCache> nodeParseCache;
	/** A cached instance of the BSJ AST Node type. */
	private BsjExplicitlyDeclaredType nodeType;

	public ParseMapOperation(TypecheckerManager manager, BsjParser parser)
	{
		super();
		this.manager = manager;
		this.parser = parser;

		this.nodeParseCache = new WeakHashMap<RawCodeLiteralNode, ParseResultCache>();

		this.nodeType = this.manager.getToolkit().getNodeElement().asType();
	}

	/**
	 * Provides a simple default operation most AST nodes: derive a new environment using {@link Node} as the expected
	 * type, recursively execute on the node's children, and then union the results.
	 */
	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeDefault(Node node, ParseMapperEnvironment env)
	{
		ParseMapperEnvironment childEnv = env.deriveForExpectedType(this.nodeType);
		return calculateNodeUnionWithEnvironment(node.getChildIterable(), childEnv);
	}

	/**
	 * Calculates the union of the parse maps of all of the specified nodes. The children are provided the specified
	 * environment.
	 * 
	 * @param nodes The node whose children are to be used.
	 * @param env The environment to provide the children.
	 * @return The union of the parse maps of the children.
	 */
	private Map<RawCodeLiteralNode, ParseMapEntry> calculateNodeUnionWithEnvironment(Iterable<? extends Node> nodes,
			ParseMapperEnvironment env)
	{
		Iterator<? extends Node> childIterator = nodes.iterator();
		if (childIterator.hasNext())
		{
			Map<RawCodeLiteralNode, ParseMapEntry> map = new WeakHashMap<RawCodeLiteralNode, ParseMapEntry>();
			while (childIterator.hasNext())
			{
				Node child = childIterator.next();
				if (child != null)
				{
					map.putAll(child.executeOperation(this, env));
				}
			}
			return Collections.unmodifiableMap(map);
		} else
		{
			return Collections.emptyMap();
		}
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAlternateConstructorInvocationNode(
			AlternateConstructorInvocationNode node, ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeArrayInitializerCreationNode(
			ArrayInitializerCreationNode node, ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeArrayInitializerNode(ArrayInitializerNode node,
			ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeArrayInstantiatorCreationNode(
			ArrayInstantiatorCreationNode node, ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAssignmentNode(AssignmentNode node, ParseMapperEnvironment env)
	{
		if (node.getOperator() != AssignmentOperator.ASSIGNMENT)
		{
			// Compound assignment operations do not provide any usable context.
			return executeDefault(node, env.deriveForExpectedType(this.nodeType));
		}

		// Otherwise, we treat the assignment expression as having an expected type of that matching the type of the
		// variable to which it is being assigned.
		BsjType variableType = this.manager.getTypechecker().getType(node.getVariable(), new TypecheckerEnvironment());
		if (variableType instanceof BsjErrorType)
		{
			variableType = this.nodeType;
		}

		return calculateNodeUnionWithEnvironment(node.getChildIterable(), env.deriveForExpectedType(variableType));
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeConditionalExpressionNode(ConditionalExpressionNode node,
			ParseMapperEnvironment env)
	{
		Map<RawCodeLiteralNode, ParseMapEntry> map = new HashMap<RawCodeLiteralNode, ParseMapEntry>();
		map.putAll(node.getCondition().executeOperation(this, env.deriveForExpectedType(this.nodeType)));
		map.putAll(node.getTrueExpression().executeOperation(this, env));
		map.putAll(node.getFalseExpression().executeOperation(this, env));
		return map;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeConstantDeclarationNode(ConstantDeclarationNode node,
			ParseMapperEnvironment env)
	{
		return handleVariableDeclaratorOwnerNode(node, env);
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeExpressionListNode(ExpressionListNode node,
			ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeFieldDeclarationNode(FieldDeclarationNode node,
			ParseMapperEnvironment env)
	{
		return handleVariableDeclaratorOwnerNode(node, env);
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeLocalVariableDeclarationNode(
			LocalVariableDeclarationNode node, ParseMapperEnvironment env)
	{
		return handleVariableDeclaratorOwnerNode(node, env);
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaAnnotationArrayValueNode(
			MetaAnnotationArrayValueNode node, ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaAnnotationElementListNode(
			MetaAnnotationElementListNode node, ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaAnnotationElementNode(MetaAnnotationElementNode node,
			ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaAnnotationExpressionValueNode(
			MetaAnnotationExpressionValueNode node, ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaAnnotationMetaAnnotationValueNode(
			MetaAnnotationMetaAnnotationValueNode node, ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node,
			ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaprogramNode(MetaprogramNode node,
			ParseMapperEnvironment env)
	{
		// We do not descend into metaprograms because their code literals are handled through a different type space.
		// Instead, the metaprograms' code literals will be handled when they are recursively compiled.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMethodDeclarationNode(MethodDeclarationNode node,
			ParseMapperEnvironment env)
	{
		BsjType returnType = this.manager.getToolkit().getTypeBuilder().makeType(node.getReturnType());
		ParseMapperEnvironment childEnv = env.deriveForExpectedReturnType(returnType);
		return calculateNodeUnionWithEnvironment(node.getChildIterable(), childEnv);
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMethodInvocationNode(MethodInvocationNode node,
			ParseMapperEnvironment env)
	{
		// *** NOTE: The initial draft of this rule is not going to work correctly! Overloading is not as simple as the
		// BLS makes it out to be. In order for this routine to function well, the BLS should actually state that the
		// candidate methods are dependent upon the process described in §15.12.2 of the JLSv3. If this is not the
		// case, then the description of how this is implemented is not sound.

		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executePackageNode(PackageNode node, ParseMapperEnvironment env)
	{
		// Requesting the parse map for an entire package doesn't make a lot of sense. This wouldn't specify if we
		// wanted on-demand loading or not and would be quite expensive. Return a dummy value instead.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeParenthesizedExpressionNode(ParenthesizedExpressionNode node,
			ParseMapperEnvironment env)
	{
		return node.getExpression().executeOperation(this, env);
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeQualifiedClassInstantiationNode(
			QualifiedClassInstantiationNode node, ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeRawCodeLiteralNode(RawCodeLiteralNode node,
			ParseMapperEnvironment env)
	{
		Collection<ParseRule<?>> validParseRules = calculateParseRulesForType(env.getCodeLiteralExpectedType());
		Set<ParseRuleExecution<?>> validParses = new HashSet<ParseRuleExecution<?>>(validParseRules.size());
		for (ParseRule<?> rule : validParseRules)
		{
			ParseRuleExecution<?> execution = createParseRuleExecution(node, rule);
			if (execution != null)
			{
				validParses.add(execution);
			}
		}

		ParseMapEntry entry = new ParseMapEntry(validParses, env.getCodeLiteralExpectedType());

		return Collections.<RawCodeLiteralNode, ParseMapEntry> singletonMap(node, entry);
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeReturnNode(ReturnNode node, ParseMapperEnvironment env)
	{
		if (node.getExpression() != null)
		{
			return node.getExpression().executeOperation(this,
					env.deriveForExpectedType(env.getCodeLiteralExpectedReturnType()));
		} else
		{
			return Collections.emptyMap();
		}
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeSingleElementMetaAnnotationNode(
			SingleElementMetaAnnotationNode node, ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeSuperMethodInvocationNode(SuperMethodInvocationNode node,
			ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeSuperclassConstructorInvocationNode(
			SuperclassConstructorInvocationNode node, ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeTypeCastNode(TypeCastNode node, ParseMapperEnvironment env)
	{
		BsjType type = this.manager.getToolkit().getTypeBuilder().makeType(node.getType());
		return node.getExpression().executeOperation(this, env.deriveForExpectedType(type));
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeUnqualifiedClassInstantiationNode(
			UnqualifiedClassInstantiationNode node, ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeVariableDeclaratorListNode(VariableDeclaratorListNode node,
			ParseMapperEnvironment env)
	{
		return calculateNodeUnionWithEnvironment(node.getChildren(), env);
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeVariableDeclaratorNode(VariableDeclaratorNode node,
			ParseMapperEnvironment env)
	{
		if (node.getInitializer() == null)
		{
			return Collections.emptyMap();
		}
		if (node.getArrayLevels() > 0)
		{
			BsjType type = env.getCodeLiteralExpectedType();
			for (int i = 0; i < node.getArrayLevels(); i++)
			{
				type = new ArrayTypeImpl(this.manager, type);
			}
			env = env.deriveForExpectedType(type);
		}
		return node.getInitializer().executeOperation(this, env);
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeVariableInitializerListNode(VariableInitializerListNode node,
			ParseMapperEnvironment env)
	{
		// TODO: Not implemented yet.
		return Collections.emptyMap();
	}

	private Map<RawCodeLiteralNode, ParseMapEntry> handleVariableDeclaratorOwnerNode(VariableDeclaratorOwnerNode node,
			ParseMapperEnvironment env)
	{
		BsjType variableType = this.manager.getToolkit().getTypeBuilder().makeType(node.getType());
		return node.getDeclarators().executeOperation(this, env.deriveForExpectedType(variableType));
	}

	private <T extends Node> ParseRuleExecution<T> createParseRuleExecution(RawCodeLiteralNode node, ParseRule<T> rule)
	{
		ParseResultCache cache = getParseCacheFor(node);
		T result = cache.parse(rule);
		if (result == null)
		{
			return null;
		} else
		{
			return new ParseRuleExecution<T>(node, rule, result);
		}
	}

	private ParseResultCache getParseCacheFor(RawCodeLiteralNode node)
	{
		ParseResultCache cache = this.nodeParseCache.get(node);
		if (cache == null)
		{
			cache = new ParseResultCache(node);
			this.nodeParseCache.put(node, cache);
		}
		return cache;
	}

	/**
	 * Calculates a collection of parse rules which have at least one output type which is a subtype of the specified
	 * type.
	 * 
	 * @param type The type in question.
	 * @return The parse rules for that type.
	 */
	private Collection<ParseRule<?>> calculateParseRulesForType(BsjType type)
	{
		Set<ParseRule<?>> rules = new HashSet<ParseRule<?>>();
		for (ParseRule<?> rule : ParseRule.values())
		{
			boolean applicable = false;
			for (Class<?> clazz : rule.getBottomMostClasses())
			{
				BsjType bottomType = this.manager.getToolkit().getTypeBuilder().makeMetaprogramClasspathType(clazz);
				if (type.isSupertypeOf(bottomType))
				{
					// Then this rule has an output which matches the provided one.
					applicable = true;
					break;
				}
			}
			if (applicable)
			{
				rules.add(rule);
			}
		}
		return rules;
	}

	private class ParseResultCache
	{
		private Map<ParseRule<?>, Node> results;
		private BsjRawCodeLiteralPayloadAntlrImpl payload;

		public ParseResultCache(RawCodeLiteralNode node)
		{
			this.results = new HashMap<ParseRule<?>, Node>();
			if (node.getValue() instanceof BsjRawCodeLiteralPayloadAntlrImpl)
			{
				this.payload = (BsjRawCodeLiteralPayloadAntlrImpl) node.getValue();
			} else
			{
				throw new IllegalStateException("Invalid raw code literal payload type: " + node.getValue().getClass());
			}
		}

		/**
		 * Retrieves the parse result for the code literal node on the given rule or <code>null</code> if the given
		 * parse rule does not parse this code literal.
		 * 
		 * @param <T> The type of node produced by the rule.
		 * @param rule The rule to use in parsing.
		 * @return The result or <code>null</code> if a parse error occurred.
		 */
		public <T extends Node> T parse(ParseRule<T> rule)
		{
			if (!results.containsKey(rule))
			{
				CountingDiagnosticProxyListener<BsjSourceLocation> listener = new CountingDiagnosticProxyListener<BsjSourceLocation>(
						new NoOperationDiagnosticListener<BsjSourceLocation>());
				T node = ParseMapOperation.this.parser.parse(this.payload, rule, listener);

				// TODO: should we maybe actually report these parse errors under certain circumstances? Should they be
				// recorded in the cache so that they can be retrieved later if desired? If this is the only valid
				// parse rule for the code literal, someone's going to want to know if it didn't parse correctly.
				if (listener.getCount(Kind.ERROR) > 0)
				{
					node = null;
				}

				this.results.put(rule, node);
				return node;
			} else
			{
				// Known to be safe because we only ever add nodes which match the generic types of their keys.
				@SuppressWarnings("unchecked")
				T node = (T) this.results.get(rule);
				return node;
			}
		}
	}
}
