package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.inference;

import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationNode;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExecutableType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;

/**
 * This class performs the type inference algorithm specified in §15.12.2.7 of the JLS.
 * @author Zachary Palmer
 *
 */
public class MethodTypeInferrer
{
    public MethodTypeInferrer(MethodInvocationNode node, List<BsjType> argumentTypes, BsjExecutableType executableType)
    {
        // TODO Auto-generated constructor stub
    }

    public Map<BsjTypeVariable, BsjTypeArgument> infer() throws AbstractMethodTypeInferenceException
    {
        throw new NotImplementedYetException();
    }

}
