package edu.jhu.cs.bsj.stdlib.metaannotations.utils;

import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.diagnostic.impl.InvalidAnnotatedDeclarationDiagnosticImpl;

public abstract class AbstractDeclarationMetaannotationMetaprogram<T extends Node> extends AbstractBsjMetaAnnotationMetaprogram {

	private Class<T> clazz;

	public AbstractDeclarationMetaannotationMetaprogram(
		List<String> permanentTargets, List<String> permanentDependencies,
		List<String> permanentWeakDependencies, MetaprogramLocalMode localMode,
		MetaprogramPackageMode packageMode, Class<T> clazz) {
	super(permanentTargets, permanentDependencies, permanentWeakDependencies,
			localMode, packageMode);
	this.clazz = clazz;
}

	public AbstractDeclarationMetaannotationMetaprogram(
		List<String> permanentTargets, List<String> permanentDependencies,
		List<String> permanentWeakDependencies, Class<T> clazz) {
	super(permanentTargets, permanentDependencies, permanentWeakDependencies);
	this.clazz = clazz;
}

	public AbstractDeclarationMetaannotationMetaprogram(
			List<String> permanentTargets, List<String> permanentDependencies,
			Class<T> clazz) {
		super(permanentTargets, permanentDependencies);
		this.clazz = clazz;
	}

	protected abstract void execute(Context<MetaAnnotationMetaprogramAnchorNode> context, T declaration);
	
	protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context) {
		Node greatGreatGrandparent = Utility.getAncestor(context.getAnchor(), 4);
		T declaration;
		if (clazz.isInstance(greatGreatGrandparent)) {
			declaration = clazz.cast(greatGreatGrandparent);
			execute(context, declaration);
		} else {
			context.getDiagnosticListener().report(
			new InvalidAnnotatedDeclarationDiagnosticImpl(getClass(), null,
					Collections.<Class<? extends Node>> singletonList(clazz)));
			throw new MetaprogramExecutionFailureException();
		}
	}	
}
