package edu.jhu.cs.bsj.compiler.impl.ast.delta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

public class EditScriptImpl implements EditScript
{
    private List<EditScriptElement> elements;
    private BsjSourceLocation location;

    public EditScriptImpl(BsjSourceLocation location, List<EditScriptElement> elements)
    {
        super();
        this.location = location;
        this.elements = Collections.unmodifiableList(elements);
    }

    @Override
    public BsjSourceLocation getLocation()
    {
        return location;
    }

    @Override
    public List<EditScriptElement> getElements()
    {
        return elements;
    }

    /**
     * Applies all changes indicated by this edit script.
     * 
     * @param patchState The initial state of the patch process.
     */
    public void apply(PatchState patchState)
    {
        for (EditScriptElement element : this.elements)
        {
            element.apply(patchState);
        }
    }

    /**
     * Translates this edit script to a different namespace. This operation will map all node IDs stored in this
     * edit script to the appropriate matching node IDs specified in the provided {@link TranslationState},
     * returning another script in which the translation has been applied.
     * 
     * @param translationState The current state of the translation process. The statefulness of translation ensures
     *            that all elements are translated properly.
     * @return The translated edit script element.
     * @throws IllegalArgumentException If one of the UIDs on this element cannot be properly translated.
     */
    public EditScript translate(TranslationState translationState) throws IllegalArgumentException
    {
        List<EditScriptElement> newElements = new ArrayList<EditScriptElement>(this.elements.size());
        for (EditScriptElement element : this.elements)
        {
            newElements.add(element.translate(translationState));
        }
        return new EditScriptImpl(this.location, newElements);
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Edit script:");
        for (EditScriptElement element : this.elements)
        {
            sb.append("\n    ");
            sb.append(element.toString());
        }
        return sb.toString();
    }
}
