package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.Arrays;
import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

/**
 * This meta-annotation metaprogram adds the Builder Pattern to a class.
 * 
 * TODO
 * 
 * @author Joseph Riley
 */
public class GenerateBuilder extends AbstractBsjMetaAnnotationMetaprogram
{
    public GenerateBuilder()
    {
        super(
                Arrays.asList("builder"), 
                Collections.<String> emptyList(), 
                Collections.<String> emptyList(), 
                MetaprogramLocalMode.MUTATE,
                MetaprogramPackageMode.READ_ONLY);
    }
    
    @Override
    protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {
    }
}
