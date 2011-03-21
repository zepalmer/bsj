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
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateAnnotationDeclarationNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long modifiers;
    private final Long body;
    private final Long identifier;
    private final Long javadoc;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateAnnotationDeclarationNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long modifiers,
            Long body,
            Long identifier,
            Long javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.modifiers = modifiers;
        this.body = body;
        this.identifier = identifier;
        this.javadoc = javadoc;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final AnnotationModifiersNode modifiersNode = 
                (AnnotationModifiersNode)patchState.getNode(this.modifiers);
        final NodeUnion<? extends AnnotationModifiersNode> modifiers;
        {
            final NodeUnion<? extends AnnotationModifiersNode> union;
            if (modifiersNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<AnnotationModifiersNode>((SpliceNode)modifiersNode);
            } else 
            {
                union = new NormalNodeUnion<AnnotationModifiersNode>((AnnotationModifiersNode)modifiersNode);
            }
            modifiers = union;
        }
        final AnnotationBodyNode bodyNode = 
                (AnnotationBodyNode)patchState.getNode(this.body);
        final NodeUnion<? extends AnnotationBodyNode> body;
        {
            final NodeUnion<? extends AnnotationBodyNode> union;
            if (bodyNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<AnnotationBodyNode>((SpliceNode)bodyNode);
            } else 
            {
                union = new NormalNodeUnion<AnnotationBodyNode>((AnnotationBodyNode)bodyNode);
            }
            body = union;
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
        AnnotationDeclarationNode createdNode = patchState.getNodeFactory().makeAnnotationDeclarationNodeWithUnions(modifiers,
                body,
                identifier,
                javadoc,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<AnnotationDeclarationNode> getCreateType()
    {
        return AnnotationDeclarationNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":AnnotationDeclarationNode(" + "modifiers=" + "#" + modifiers + "," + "body=" + "#" + body + "," + "identifier=" + "#" + identifier + "," + "javadoc=" + "#" + javadoc + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateAnnotationDeclarationNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.modifiers),
                translateUid(translationState, this.body),
                translateUid(translationState, this.identifier),
                translateUid(translationState, this.javadoc),
                this.startLocation,
                this.stopLocation);
    }
    
}
