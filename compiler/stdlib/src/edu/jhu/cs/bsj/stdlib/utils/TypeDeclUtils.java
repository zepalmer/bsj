package edu.jhu.cs.bsj.stdlib.utils;

import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReferenceTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaprogramMetaAnnotation;
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
     * Private constructor prevents instantiation.
     */
    private TypeDeclUtils()
    {
        
    }
    
    /**
     * Determines the identifier for this context's enclosing class.
     * @param context the context referenced.
     * @param caller the metaprogram calling this method.
     * @return an IdentifierNode corresponding to the enclosing class for the context.
     */
    public static IdentifierNode getEnclosingTypeName(
            Context<MetaAnnotationMetaprogramAnchorNode,MetaAnnotationMetaprogramAnchorNode> context,
            AbstractBsjMetaprogramMetaAnnotation caller)
    {
        // Find our enclosing type declaration. It must be an enum, class, or interface for this to work.
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

    /**
     * Gets a list of the class members of the enclosing class.
     * @param context the context referenced.
     * @param caller the metaprogram calling this method.
     * @return a list of class members of the enclosing class.
     */
    public static ClassMemberListNode getClassMembers(
            Context<MetaAnnotationMetaprogramAnchorNode,MetaAnnotationMetaprogramAnchorNode> context,
            AbstractBsjMetaprogramMetaAnnotation caller)
    {
        // Find our enclosing type declaration. It must be an enum or a class for this to work.
        TypeDeclarationNode enclosingTypeDeclaration = context.getAnchor().getNearestAncestorOfType(
                TypeDeclarationNode.class);
        ClassMemberListNode members;
        
        if (enclosingTypeDeclaration instanceof ClassDeclarationNode)
        {
            members = ((ClassDeclarationNode) enclosingTypeDeclaration).getBody().getMembers();
        }
        else if (enclosingTypeDeclaration instanceof EnumDeclarationNode)
        {
            members = ((EnumDeclarationNode) enclosingTypeDeclaration).getBody().getMembers();
        }
        else
        {
            List<Class<? extends TypeDeclarationNode>> typeDeclarationList = new ArrayList<Class<? extends TypeDeclarationNode>>();
            typeDeclarationList.add(ClassDeclarationNode.class);
            typeDeclarationList.add(EnumDeclarationNode.class);
            context.getDiagnosticListener().report(
                    new InvalidEnclosingTypeDiagnosticImpl(caller.getClass(), enclosingTypeDeclaration, typeDeclarationList));
            throw new MetaprogramExecutionFailureException();
        }
        return members;
    }

    /**
     * Turns primitives into their non-primitive counterparts, leaves all other types unchanged.
     * @param inType the type to autobox.
     * @param factory the factory to use for new type creation.
     * @return the autoboxed (if necessary) type.
     */
    public static ReferenceTypeNode autoBoxPrimitives(TypeNode inType, BsjNodeFactory factory)
    {
        // only process primitives
        if (inType instanceof PrimitiveTypeNode)
        {
            PrimitiveTypeNode primitive = (PrimitiveTypeNode)inType;
            String name;
            switch (primitive.getPrimitiveType())
            {
                case BOOLEAN:
                    name = "Boolean";
                    break;
                case BYTE:
                    name = "Byte";
                    break;
                case CHAR:
                    name = "Character";
                    break;
                case DOUBLE:
                    name = "Double";
                    break;
                case FLOAT:
                    name = "Float";
                    break;
                case INT:
                    name = "Integer";
                    break;
                case LONG:
                    name = "Long";
                    break;
                case SHORT:
                    name = "Short";
                    break;
                default:
                	throw new IllegalStateException("Unrecognized primitive type!");
            }
            return factory.makeUnparameterizedTypeNode(factory.parseNameNode(name));
        }
        
        return (ReferenceTypeNode)inType.deepCopy(factory);
    }
}
