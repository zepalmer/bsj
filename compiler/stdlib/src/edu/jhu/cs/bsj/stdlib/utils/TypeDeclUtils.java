package edu.jhu.cs.bsj.stdlib.utils;

import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.diagnostic.impl.InvalidEnclosingTypeDiagnosticImpl;

/**
 * Contains utility methods for use in metaprograms dealing with type declarations.
 * 
 * @author Zachary Palmer
 * @author Joseph Riley
 */
public class TypeDeclUtils
{
    /**
     * Determines the identifier for this context's enclosing class.
     * @param context the context referenced.
     * @param caller the metaprogram calling this method.
     * @return an IdentifierNode corresponding to the enclosing class for the context.
     */
    public IdentifierNode getEnclosingTypeName(
            Context<MetaAnnotationMetaprogramAnchorNode> context,
            AbstractBsjMetaAnnotationMetaprogram caller)
    {
        TypeDeclarationNode enclosingTypeDeclaration = context.getAnchor().getNearestAncestorOfType(
                TypeDeclarationNode.class);
        
        if (enclosingTypeDeclaration instanceof ClassDeclarationNode)
        {
            return ((ClassDeclarationNode) enclosingTypeDeclaration).getIdentifier();
        } 
        else if (enclosingTypeDeclaration instanceof EnumDeclarationNode)
        {
            return ((EnumDeclarationNode) enclosingTypeDeclaration).getIdentifier();
        } 
        else if (enclosingTypeDeclaration instanceof InterfaceDeclarationNode)
        {
            return ((InterfaceDeclarationNode) enclosingTypeDeclaration).getIdentifier();
        }
        else
        {
            List<Class<? extends TypeDeclarationNode>> typeDeclarationList = new ArrayList<Class<? extends TypeDeclarationNode>>();
            typeDeclarationList.add(ClassDeclarationNode.class);
            typeDeclarationList.add(EnumDeclarationNode.class);
            typeDeclarationList.add(InterfaceDeclarationNode.class);
            context.getDiagnosticListener().report(
                    new InvalidEnclosingTypeDiagnosticImpl(caller.getClass(), enclosingTypeDeclaration, typeDeclarationList));
            throw new MetaprogramExecutionFailureException();
        }
    }
}
