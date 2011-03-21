package edu.jhu.cs.bsj.compiler.impl.ast.delta;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * Represents an edit script such as is created by metaprogram execution.
 * 
 * @author Zachary Palmer
 */
public interface EditScript
{
    /**
     * Retrieves the location of the metaprogram that created this edit script.
     * 
     * @return The location of the metaprogram that created this edit script.
     */
    public BsjSourceLocation getLocation();

    /**
     * Retrieves the elements of this edit script.
     * 
     * @return The elements of this edit script.
     */
    public List<EditScriptElement> getElements();

    /**
     * Applies all changes indicated by this edit script.
     * 
     * @param patchState The initial state of the patch process.
     */
    public void apply(PatchState patchState);

    /**
     * Translates this edit script to a different namespace. This operation will map all node IDs stored in this edit
     * script to the appropriate matching node IDs specified in the provided {@link TranslationState}, returning another
     * script in which the translation has been applied.
     * 
     * @param translationState The current state of the translation process. The statefulness of translation ensures
     *            that all elements are translated properly.
     * @return The translated edit script element.
     * @throws IllegalArgumentException If one of the UIDs on this element cannot be properly translated.
     */
    public EditScript translate(TranslationState translationState) throws IllegalArgumentException;
}
