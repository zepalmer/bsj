/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast.delta.create;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateMethodDeclarationNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long body;
    private final Long modifiers;
    private final Long identifier;
    private final Long parameters;
    private final Long varargParameter;
    private final Long returnType;
    private final Long throwTypes;
    private final Long typeParameters;
    private final Long javadoc;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateMethodDeclarationNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long body,
            Long modifiers,
            Long identifier,
            Long parameters,
            Long varargParameter,
            Long returnType,
            Long throwTypes,
            Long typeParameters,
            Long javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.body = body;
        this.modifiers = modifiers;
        this.identifier = identifier;
        this.parameters = parameters;
        this.varargParameter = varargParameter;
        this.returnType = returnType;
        this.throwTypes = throwTypes;
        this.typeParameters = typeParameters;
        this.javadoc = javadoc;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final BlockStatementListNode bodyNode = 
                (BlockStatementListNode)patchState.getNode(this.body);
        final NodeUnion<? extends BlockStatementListNode> body;
        {
            final NodeUnion<? extends BlockStatementListNode> union;
            if (bodyNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<BlockStatementListNode>((SpliceNode)bodyNode);
            } else 
            {
                union = new NormalNodeUnion<BlockStatementListNode>((BlockStatementListNode)bodyNode);
            }
            body = union;
        }
        final MethodModifiersNode modifiersNode = 
                (MethodModifiersNode)patchState.getNode(this.modifiers);
        final NodeUnion<? extends MethodModifiersNode> modifiers;
        {
            final NodeUnion<? extends MethodModifiersNode> union;
            if (modifiersNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<MethodModifiersNode>((SpliceNode)modifiersNode);
            } else 
            {
                union = new NormalNodeUnion<MethodModifiersNode>((MethodModifiersNode)modifiersNode);
            }
            modifiers = union;
        }
        final IdentifierNode identifierNode = 
                (IdentifierNode)patchState.getNode(this.identifier);
        final NodeUnion<? extends IdentifierNode> identifier;
        {
            final NodeUnion<? extends IdentifierNode> union;
            if (identifierNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<IdentifierNode>((SpliceNode)identifierNode);
            } else 
            {
                union = new NormalNodeUnion<IdentifierNode>((IdentifierNode)identifierNode);
            }
            identifier = union;
        }
        final VariableListNode parametersNode = 
                (VariableListNode)patchState.getNode(this.parameters);
        final NodeUnion<? extends VariableListNode> parameters;
        {
            final NodeUnion<? extends VariableListNode> union;
            if (parametersNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<VariableListNode>((SpliceNode)parametersNode);
            } else 
            {
                union = new NormalNodeUnion<VariableListNode>((VariableListNode)parametersNode);
            }
            parameters = union;
        }
        final VariableNode varargParameterNode = 
                (VariableNode)patchState.getNode(this.varargParameter);
        final NodeUnion<? extends VariableNode> varargParameter;
        {
            final NodeUnion<? extends VariableNode> union;
            if (varargParameterNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<VariableNode>((SpliceNode)varargParameterNode);
            } else 
            {
                union = new NormalNodeUnion<VariableNode>((VariableNode)varargParameterNode);
            }
            varargParameter = union;
        }
        final TypeNode returnTypeNode = 
                (TypeNode)patchState.getNode(this.returnType);
        final NodeUnion<? extends TypeNode> returnType;
        {
            final NodeUnion<? extends TypeNode> union;
            if (returnTypeNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<TypeNode>((SpliceNode)returnTypeNode);
            } else 
            {
                union = new NormalNodeUnion<TypeNode>((TypeNode)returnTypeNode);
            }
            returnType = union;
        }
        final UnparameterizedTypeListNode throwTypesNode = 
                (UnparameterizedTypeListNode)patchState.getNode(this.throwTypes);
        final NodeUnion<? extends UnparameterizedTypeListNode> throwTypes;
        {
            final NodeUnion<? extends UnparameterizedTypeListNode> union;
            if (throwTypesNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<UnparameterizedTypeListNode>((SpliceNode)throwTypesNode);
            } else 
            {
                union = new NormalNodeUnion<UnparameterizedTypeListNode>((UnparameterizedTypeListNode)throwTypesNode);
            }
            throwTypes = union;
        }
        final TypeParameterListNode typeParametersNode = 
                (TypeParameterListNode)patchState.getNode(this.typeParameters);
        final NodeUnion<? extends TypeParameterListNode> typeParameters;
        {
            final NodeUnion<? extends TypeParameterListNode> union;
            if (typeParametersNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<TypeParameterListNode>((SpliceNode)typeParametersNode);
            } else 
            {
                union = new NormalNodeUnion<TypeParameterListNode>((TypeParameterListNode)typeParametersNode);
            }
            typeParameters = union;
        }
        final JavadocNode javadocNode = 
                (JavadocNode)patchState.getNode(this.javadoc);
        final NodeUnion<? extends JavadocNode> javadoc;
        {
            final NodeUnion<? extends JavadocNode> union;
            if (javadocNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<JavadocNode>((SpliceNode)javadocNode);
            } else 
            {
                union = new NormalNodeUnion<JavadocNode>((JavadocNode)javadocNode);
            }
            javadoc = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        MethodDeclarationNode createdNode = patchState.getNodeFactory().makeMethodDeclarationNodeWithUnions(body,
                modifiers,
                identifier,
                parameters,
                varargParameter,
                returnType,
                throwTypes,
                typeParameters,
                javadoc,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<MethodDeclarationNode> getCreateType()
    {
        return MethodDeclarationNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":MethodDeclarationNode(" + "body=" + "#" + body + "," + "modifiers=" + "#" + modifiers + "," + "identifier=" + "#" + identifier + "," + "parameters=" + "#" + parameters + "," + "varargParameter=" + "#" + varargParameter + "," + "returnType=" + "#" + returnType + "," + "throwTypes=" + "#" + throwTypes + "," + "typeParameters=" + "#" + typeParameters + "," + "javadoc=" + "#" + javadoc + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateMethodDeclarationNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.body),
                translateUid(translationState, this.modifiers),
                translateUid(translationState, this.identifier),
                translateUid(translationState, this.parameters),
                translateUid(translationState, this.varargParameter),
                translateUid(translationState, this.returnType),
                translateUid(translationState, this.throwTypes),
                translateUid(translationState, this.typeParameters),
                translateUid(translationState, this.javadoc),
                this.startLocation,
                this.stopLocation);
    }
    
}
