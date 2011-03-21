package edu.jhu.cs.bsj.compiler.impl.ast.delta;

/**
 * <p>
 * Represents an element of an edit script produced by a metaprogram. Each metaprogram produces a distinct edit script
 * through the instrumentation on the AST node implementations. A single edit script element reflects exactly one
 * change: the addition of an element to a list or the setting of a property.
 * </p>
 * 
 * <p>
 * Edit script elements are capable of applying the change that they represent to their target nodes. The target is
 * stored in the form of a UID to introduce an extra level of indirection. When the changes are applied, a mapping from
 * created node UIDs to the nodes themselves must be provided. This level of indirection allows the mapping to "lie" to
 * the edit script element during delta application. If a node <i>N</i> is created during the execution of the
 * metaprogram, a node with the same UID <i>N</i> cannot be created during application of the delta. The mapping,
 * however, can map <i>N</i> to a node of UID <i>N'</i>. As long as a given mapping is used consistently when applying
 * the delta, this permits the edit script elements to be used to create a replay of the metaprogram's actions.
 * </p>
 * 
 * @author Zachary Palmer
 */
public interface EditScriptElement
{
    /**
     * Retrieves the ID of the metaprogram that created this element.
     * 
     * @return The ID of the metaprogram that created this element.
     */
    public int getMetaprogramId();

    /**
     * Retrieves the ID of the node that this element changes.
     * 
     * @return The ID of the node that this element changes.
     */
    public long getTargetId();

    /**
     * Applies the change indicated by this edit script element.
     * 
     * @param patchState The current state of the patch process.
     */
    public void apply(PatchState patchState);

    /**
     * Translates this edit script element to a different namespace. This operation will map all node IDs stored in this
     * edit script element to the appropriate matching node IDs specified in the provided {@link TranslationState},
     * returning another element in which the translation has been applied. This routine must be called in order over
     * each element in an edit script to ensure proper translation of instantiated nodes.
     * 
     * @param translationState The current state of the translation process. The statefulness of translation ensures
     *            that all elements are translated properly.
     * @return The translated edit script element.
     * @throws IllegalArgumentException If one of the UIDs on this element cannot be properly translated.
     */
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException;
}
