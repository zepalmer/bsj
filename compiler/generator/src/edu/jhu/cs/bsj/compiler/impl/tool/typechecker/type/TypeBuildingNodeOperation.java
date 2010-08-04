package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.ArrayTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeSelectNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VoidTypeNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public class TypeBuildingNodeOperation extends BsjDefaultNodeOperation<Void, TypeMirror>
{
	private TypecheckerModelManager manager;
	
	public TypeBuildingNodeOperation(TypecheckerModelManager manager)
	{
		super();
		this.manager = manager;
	}

	@Override
	public TypeMirror executeArrayTypeNode(ArrayTypeNode node, Void p)
	{
		return new ArrayTypeImpl(this.manager, node.getType().executeOperation(this, p));
	}

	@Override
	public TypeMirror executeDefault(Node node, Void p)
	{
		return null;
	}

	@Override
	public TypeMirror executeParameterizedTypeNode(ParameterizedTypeNode node, Void p)
	{
		// TODO Auto-generated method stub
		return super.executeParameterizedTypeNode(node, p);
	}

	@Override
	public TypeMirror executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, Void p)
	{
		// TODO Auto-generated method stub
		return super.executeParameterizedTypeSelectNode(node, p);
	}

	@Override
	public TypeMirror executePrimitiveTypeNode(PrimitiveTypeNode node, Void p)
	{
		return new PrimitiveTypeImpl(this.manager, node.getPrimitiveType());
	}

	@Override
	public TypeMirror executeUnparameterizedTypeNode(UnparameterizedTypeNode node, Void p)
	{
		// TODO Auto-generated method stub
		return super.executeUnparameterizedTypeNode(node, p);
	}

	@Override
	public TypeMirror executeVoidTypeNode(VoidTypeNode node, Void p)
	{
		return NoTypeImpl.makeVoid(this.manager);
	}
}
