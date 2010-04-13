package edu.jhu.cs.bsj.stdlib.utils;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

/**
 * Contains utility methods for use in metaprograms dealing with method declarations.
 * 
 * @author Zachary Palmer
 * @author Joseph Riley
 */
public class MethodDeclUtils
{
    /**
     * Private constructor prevents instantiation.
     */
    private MethodDeclUtils()
    {
        
    }
    
    /**
     * Determines the nearest method declaration.
     * @param context the context referenced.
     * @param caller the metaprogram calling this method.
     * @return a MethodDeclarationNode for the nearest method declaration.
     */
    public static MethodDeclarationNode getNearestMethodDeclaration(
            Context<MetaAnnotationMetaprogramAnchorNode> context,
            AbstractBsjMetaAnnotationMetaprogram caller)
    {
        MethodDeclarationNode enclosingMethodDeclaration = context.getAnchor().getNearestAncestorOfType(
                MethodDeclarationNode.class);

        if (enclosingMethodDeclaration == null)
        {
            //TODO diagnostics
            throw new MetaprogramExecutionFailureException();
        }
        
        return enclosingMethodDeclaration;
    }
}
