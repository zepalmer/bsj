package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map;

import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;

public class ErasedMethodSignatureNameExtractor implements Function<ErasedMethodSignature, String>
{
    public static final ErasedMethodSignatureNameExtractor INSTANCE = new ErasedMethodSignatureNameExtractor();

    @Override
    public String execute(ErasedMethodSignature argument)
    {
        return argument.getName();
    }
}
