package edu.jhu.cs.bsj.tests.support;

import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaprogramMetaAnnotation;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

public class HelloWorldMetaAnnotation extends AbstractBsjMetaprogramMetaAnnotation
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
        if (this.id != null)
        {
            System.out.println("I got the following identifier: " + id.getIdentifier());
        }
        if (this.ids != null)
        {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (IdentifierNode id : this.ids)
            {
                if (!first)
                    sb.append(',');
                sb.append(id.getIdentifier());
                first = false;
            }
            System.out.println("I got the following identifiers: " + sb.toString());
        }
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

    private IdentifierNode[] ids;

    @BsjMetaAnnotationElementGetter
    public IdentifierNode[] getIds()
    {
        return this.ids;
    }

    @BsjMetaAnnotationElementSetter
    public void setIds(IdentifierNode[] ids)
    {
        this.ids = ids;
    }
}
