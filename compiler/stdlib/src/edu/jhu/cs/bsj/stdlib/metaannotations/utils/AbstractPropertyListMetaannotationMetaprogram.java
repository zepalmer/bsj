package edu.jhu.cs.bsj.stdlib.metaannotations.utils;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.utils.TypeDeclUtils;


public abstract class AbstractPropertyListMetaannotationMetaprogram extends
		AbstractBsjMetaAnnotationMetaprogram {

    private String[] properties = null;


    @BsjMetaAnnotationElementGetter
    public String[] getProperties()
    {
        return this.properties;
    }

    @BsjMetaAnnotationElementSetter
    public void setProperties(String[] properties)
    {
        this.properties = properties;
    }
    
	public AbstractPropertyListMetaannotationMetaprogram(List<String> permanentTargets,
			List<String> permanentDependencies) {
		super(permanentTargets, permanentDependencies);
	}

	public AbstractPropertyListMetaannotationMetaprogram(List<String> asList,
			List<String> permanentTargets, List<String> permanentDependencies,
			MetaprogramLocalMode mutate, MetaprogramPackageMode readOnly) {
		super(asList, permanentTargets, permanentDependencies, mutate, readOnly);
	}

	@Override
	protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context) {
		// TODO Auto-generated method stub

		ClassMemberListNode members = TypeDeclUtils.getClassMembers(context, this);

        // establish the list of properties we will be using
        List<Pair<String, TypeNode>> getterDescriptions;
        if (this.properties == null)
        {
            getterDescriptions = Utility.getGetters(members);
        } else
        {
        	getterDescriptions = new MetaannotationMetaprogramToolkit(this, context).getGettersFromNames(properties);
        }
        
        execute(context, getterDescriptions);
	}
	
	public abstract void execute(Context<MetaAnnotationMetaprogramAnchorNode> context, List<Pair<String, TypeNode>> getterDescriptions);
	

	@Override
	public void complete() throws InvalidMetaAnnotationConfigurationException {
		// TODO Auto-generated method stub

	}

}
