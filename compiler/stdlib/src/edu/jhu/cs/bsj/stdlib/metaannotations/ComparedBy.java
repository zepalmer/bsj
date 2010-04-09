package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.diagnostic.impl.MissingMethodDeclarationDiagnosticImpl;
import edu.jhu.cs.bsj.stdlib.utils.TypeDeclUtils;

/**
 * This meta-annotation metaprogram generates the compareTo method for a class, as well as forcing it to implement the
 * Comparable<T> interface. The "properties" property is used to determine the fields used in the comparison and their
 * order of importance.
 * 
 * @author Joseph Riley
 */
public class ComparedBy extends AbstractBsjMetaAnnotationMetaprogram
{
    /** The explicitly-specified list of properties. */
    private String[] properties = null;

    public ComparedBy()
    {
        //TODO remove dependencies on targets other than property
        super(Arrays.asList("comparedBy"), Arrays.asList("property", "equalsAndHashCode", "toString"));
    }

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
    
    @Override
    protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        // get all the members of our enclosing class
        ClassMemberListNode members = TypeDeclUtils.getClassMembers(context, this);
        
        // get the properties to be used in comparison
        List<Pair<String, TypeNode>> getterDescriptions = new ArrayList<Pair<String, TypeNode>>();
        Map<String, MethodDeclarationNode> methodMap = new HashMap<String, MethodDeclarationNode>();
        for (ClassMemberNode member : members)
        {
            if (member instanceof MethodDeclarationNode)
            {
                MethodDeclarationNode methodDecl = (MethodDeclarationNode) member;
                methodMap.put(methodDecl.getIdentifier().getIdentifier(), methodDecl);
            }
        }
        for (String propName : this.properties)
        {
            String getterName = "get" + Character.toUpperCase(propName.charAt(0)) + propName.substring(1);
            MethodDeclarationNode getterDeclaration = methodMap.get(getterName);
            if (getterDeclaration == null)
            {
                context.getDiagnosticListener().report(new MissingMethodDeclarationDiagnosticImpl(members, getterName));
                throw new MetaprogramExecutionFailureException();
            }
            getterDescriptions.add(new Pair<String, TypeNode>(getterName, getterDeclaration.getReturnType()));
        }
       
        // TODO finish
        IdentifierNode className = TypeDeclUtils.getEnclosingTypeName(context, this);
        addComparableInterface(context, className);
        members.add(generateCompareTo(context, getterDescriptions, className));
    }

    private void addComparableInterface(
            Context<MetaAnnotationMetaprogramAnchorNode> context, 
            IdentifierNode className)
    {
        BsjNodeFactory factory = context.getFactory();  
        TypeDeclarationNode enclosingTypeDeclaration = context.getAnchor().getNearestAncestorOfType(
                TypeDeclarationNode.class);
        DeclaredTypeListNode implementsClause = null;
        
        if (enclosingTypeDeclaration instanceof ClassDeclarationNode)
        {
            ClassDeclarationNode classNode = ((ClassDeclarationNode) enclosingTypeDeclaration);
            implementsClause = classNode.getImplementsClause();

        } 
        else if (enclosingTypeDeclaration instanceof EnumDeclarationNode)
        {
            EnumDeclarationNode enumNode = ((EnumDeclarationNode) enclosingTypeDeclaration);
            implementsClause = enumNode.getImplementsClause();
        } 
        else
        {
            //TODO blow up
        }
        
        // adding "implements Comparable<T>"
        implementsClause.add(factory.makeParameterizedTypeNode(
                factory.makeUnparameterizedTypeNode(factory.parseNameNode("Comparable")), 
                factory.makeTypeArgumentListNode(factory.makeUnparameterizedTypeNode(
                        factory.parseNameNode(className.getIdentifier())))));
    }

    private ClassMemberNode generateCompareTo(Context<MetaAnnotationMetaprogramAnchorNode> context,
            List<Pair<String, TypeNode>> getterDescriptions, IdentifierNode className)
    {
        // TODO finish
        
        BsjNodeFactory factory = context.getFactory();        
        List<BlockStatementNode> statements = new ArrayList<BlockStatementNode>();
        
        
        
        // create a method declaration for compareTo(T o)
        return factory.makeMethodDeclarationNode(
                factory.makeBlockNode(factory.makeBlockStatementListNode(statements)), 
                factory.makeMethodModifiersNode(AccessModifier.PUBLIC), 
                factory.makeIdentifierNode("compareTo"), 
                factory.makeVariableListNode(), 
                factory.makePrimitiveTypeNode(PrimitiveType.INT), 
                factory.makeJavadocNode(
                        "Implementation of compareTo.\n" +
                        "@param o the other object to compare to.\n" +
                        "@return -1, 0, or 1 if this object is less than, equal to, or greater than the other."));
    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {
        if (this.properties == null)
        {
            throw new InvalidMetaAnnotationConfigurationException(this, "Missing properties value");
        }
    }
}
