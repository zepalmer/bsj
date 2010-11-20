package edu.jhu.cs.bsj.tests.support;

import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

public class HelloWorldMetaAnnotation extends AbstractBsjMetaAnnotationMetaprogram
{
    public HelloWorldMetaAnnotation()
    {
        super(Collections.<String> emptyList(), Collections.<String> emptyList());
    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {
    }

    @Override
    protected void execute(Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context)
    {
        System.out.println("*****************");
        System.out.println("* HELLO, WORLD! *");
        System.out.println("*****************");
        System.out.println("I got the following identifier: " + id.getIdentifier());
    }
    
    private IdentifierNode id;
    
    @BsjMetaAnnotationElementGetter
    public IdentifierNode getId()
    {
        return this.id;
    }
    
    @BsjMetaAnnotationElementSetter
    public void setId(IdentifierNode id)
    {
        this.id = id;
    }
}
