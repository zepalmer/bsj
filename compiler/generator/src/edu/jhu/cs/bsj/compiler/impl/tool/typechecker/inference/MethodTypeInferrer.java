package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.inference;

import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;

/**
 * This class performs the type inference algorithm specified in §15.12.2.7 of the JLS.
 * 
 * @author Zachary Palmer
 * 
 */
public class MethodTypeInferrer
{
    public MethodTypeInferrer()
    {
    }

    public Map<BsjTypeVariable, BsjTypeArgument> infer(Set<MethodInvocationConversionConstraint> initalConstraints)
            throws AbstractMethodTypeInferenceException
    {
        throw new NotImplementedYetException();
    }

}
