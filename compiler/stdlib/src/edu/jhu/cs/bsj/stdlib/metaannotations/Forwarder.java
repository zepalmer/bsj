package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.Arrays;
import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;


/**
 * This meta-annotation metaprogram generates method forwards to fields and methods that have private access. 
 * 
 * @author Nathan Krasnopoler
 */

public class Forwarder extends AbstractBsjMetaAnnotationMetaprogram 
{
	
	private String[] methodNames = null;

	public Forwarder() 
	{
		super(Collections.singletonList("forwarder"), Arrays.asList("property"));
	}
	
	@BsjMetaAnnotationElementGetter
	public String[] getMethodNames()
	{
		return this.methodNames;
	}

	@BsjMetaAnnotationElementSetter
	public void setMethodNames(String[] methodNames)
	{
		this.methodNames = methodNames;
	}
	
	//TODO make this take a string array of arguments

	@Override
	protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context) 
	{
		// Prelude/preparation
			// get anchor and such
		// This is the factory that allows us to build new AST parts. 
		BsjNodeFactory factory = context.getFactory();
		MetaAnnotationMetaprogramAnchorNode anchor = context.getAnchor(); 

		
		// find out if we are anchored onto a field or a private method
		
			// we are on a field
			// Let fieldName be the name of the field
			// for each method in the argument list,
				// Let methodName be the method in the argument list
				// Let forwardedMethodName = fieldName + capitalizeFirstLetter(methodName)
				// make a new method declaration node called forwardedMethodName, make it public, 
					// and make it simply call methodName on fieldName. 
		
		// else
			// we are on a method
			// Let accessorName be the name of the method
			// for each method in the argument list,
				// Let methodName be the method in the argument list
				// Let forwardedMethodName = accessorName + capitalizeFirstLetter(methodName)
				// make a new method declaration node called forwardedMethodName, make it public, 
					// and make it simply call methodName on accessorName(). 
	

		// TODO Auto-generated method stub
		
	}

	@Override
	public void complete() throws InvalidMetaAnnotationConfigurationException 
	{
	}
}
