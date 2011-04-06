package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.IfNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaprogramMetaAnnotation;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.utils.MethodDeclUtils;

/**
 * This meta-annotation metaprogram generates null checks for a method.  All non-primitive parameters
 * of the method are checked.  The "parameters" property can be used to override the default functionality by
 * explicitly listing what parameters are to be null checked, thus allowing unlisted parameters to be null.
 * 
 * @author Joseph Riley
 */
public class GenerateNullChecks extends AbstractBsjMetaprogramMetaAnnotation
{
    /** The explicitly-specified list of properties. */
    private String[] parameters = null;
    
    public GenerateNullChecks()
    {
        super(
                Arrays.asList("nullChecks"), 
                Collections.<String> emptyList(), 
                Arrays.asList("memoized"), 
                MetaprogramLocalMode.MUTATE,
                MetaprogramPackageMode.READ_ONLY);
    }
    
    @BsjMetaAnnotationElementGetter
    public String[] getParameters()
    {
        return this.parameters;
    }

    @BsjMetaAnnotationElementSetter
    public void setParameters(String[] parameters)
    {
        this.parameters = parameters;
    }
    
    @Override
    protected void execute(Context<MetaAnnotationMetaprogramAnchorNode,MetaAnnotationMetaprogramAnchorNode> context)
    {
        MethodDeclarationNode method = MethodDeclUtils.getNearestMethodDeclaration(context, this);
        BsjNodeFactory factory = context.getFactory();        
        List<BlockStatementNode> statements = new ArrayList<BlockStatementNode>();
        
        // filter the parameters for checking using properties if needed
        VariableListNode checkedVariables = filterVariables(method.getParameters(), factory);
        
        // create null checks for each parameter that needs one
        for (VariableNode variable : checkedVariables)
        {
            TypeNode type = variable.getType();
            String varName = variable.getIdentifier().getIdentifier();
            
            // only create null checks for non-primitive parameters
            if (type instanceof PrimitiveTypeNode)
            {
                continue;
            }

            // if (<:varName:> == null) {throw new IllegalArgumentException("...");}
            IfNode ifNode = factory.makeIfNode(
                    factory.makeBinaryExpressionNode(
                            factory.makeVariableAccessNode(null, factory.makeIdentifierNode(varName)), 
                            factory.makeNullLiteralNode(), 
                            BinaryOperator.EQUAL), 
                    factory.makeThrowNode(factory.makeUnqualifiedClassInstantiationNode(
                            factory.makeUnparameterizedTypeNode(
                                    factory.parseNameNode("IllegalArgumentException")),
                            factory.makeExpressionListNode(factory.makeStringLiteralNode(
                                    "Parameter " + varName + " cannot be null.")))));
            
            // add this check in to our new statements
            statements.add(ifNode);
        }
        
        // insert the null checks in order starting at the beginning of the method body
        for (int i = 0; i < statements.size(); i++)
        {
            method.getBody().add(i, statements.get(i));
        }
    }

    /**
     * Filters out specific parameters for null checking if needed.
     * @param presentParams the parameters for the method.
     * @param factory the factory for our metaprogram.
     * @return the original list of parameters if parameters property 
     *      is null or empty, or the new list of parameters filtered using 
     *      the variable names stored in the parameters property.
     */
    private VariableListNode filterVariables(
            VariableListNode presentParams, BsjNodeFactory factory)
    {
        if (parameters == null || parameters.length == 0)
        {
            return presentParams;
        }
        
        // new filtered list of parameters
        VariableListNode retNode = factory.makeVariableListNode();
        
        // extract only the parameters specified in the parameters property
        for (VariableNode variable : presentParams)
        {
            for (String varName : parameters)
            {
                if (variable.getIdentifier().getIdentifier().equals(varName))
                {
                    retNode.add(variable.deepCopy(factory));
                }
            }
        }
        
        return retNode;
    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {       
    }
}
