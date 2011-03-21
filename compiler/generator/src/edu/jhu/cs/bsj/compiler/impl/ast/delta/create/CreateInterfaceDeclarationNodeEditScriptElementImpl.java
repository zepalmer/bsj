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
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateInterfaceDeclarationNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long modifiers;
    private final Long extendsClause;
    private final Long body;
    private final Long typeParameters;
    private final Long identifier;
    private final Long javadoc;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateInterfaceDeclarationNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long modifiers,
            Long extendsClause,
            Long body,
            Long typeParameters,
            Long identifier,
            Long javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.modifiers = modifiers;
        this.extendsClause = extendsClause;
        this.body = body;
        this.typeParameters = typeParameters;
        this.identifier = identifier;
        this.javadoc = javadoc;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final InterfaceModifiersNode modifiersNode = 
                (InterfaceModifiersNode)patchState.getNode(this.modifiers);
        final NodeUnion<? extends InterfaceModifiersNode> modifiers;
        {
            final NodeUnion<? extends InterfaceModifiersNode> union;
            if (modifiersNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<InterfaceModifiersNode>((SpliceNode)modifiersNode);
            } else 
            {
                union = new NormalNodeUnion<InterfaceModifiersNode>((InterfaceModifiersNode)modifiersNode);
            }
            modifiers = union;
        }
        final DeclaredTypeListNode extendsClauseNode = 
                (DeclaredTypeListNode)patchState.getNode(this.extendsClause);
        final NodeUnion<? extends DeclaredTypeListNode> extendsClause;
        {
            final NodeUnion<? extends DeclaredTypeListNode> union;
            if (extendsClauseNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<DeclaredTypeListNode>((SpliceNode)extendsClauseNode);
            } else 
            {
                union = new NormalNodeUnion<DeclaredTypeListNode>((DeclaredTypeListNode)extendsClauseNode);
            }
            extendsClause = union;
        }
        final InterfaceBodyNode bodyNode = 
                (InterfaceBodyNode)patchState.getNode(this.body);
        final NodeUnion<? extends InterfaceBodyNode> body;
        {
            final NodeUnion<? extends InterfaceBodyNode> union;
            if (bodyNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<InterfaceBodyNode>((SpliceNode)bodyNode);
            } else 
            {
                union = new NormalNodeUnion<InterfaceBodyNode>((InterfaceBodyNode)bodyNode);
            }
            body = union;
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
        InterfaceDeclarationNode createdNode = patchState.getNodeFactory().makeInterfaceDeclarationNodeWithUnions(modifiers,
                extendsClause,
                body,
                typeParameters,
                identifier,
                javadoc,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<InterfaceDeclarationNode> getCreateType()
    {
        return InterfaceDeclarationNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":InterfaceDeclarationNode(" + "modifiers=" + "#" + modifiers + "," + "extendsClause=" + "#" + extendsClause + "," + "body=" + "#" + body + "," + "typeParameters=" + "#" + typeParameters + "," + "identifier=" + "#" + identifier + "," + "javadoc=" + "#" + javadoc + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateInterfaceDeclarationNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.modifiers),
                translateUid(translationState, this.extendsClause),
                translateUid(translationState, this.body),
                translateUid(translationState, this.typeParameters),
                translateUid(translationState, this.identifier),
                translateUid(translationState, this.javadoc),
                this.startLocation,
                this.stopLocation);
    }
    
}
