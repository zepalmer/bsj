import java.util.List;

public interface NameNode
{
    /* GEN:start */
    /**
     * Retrieves the category for this node's name.
     * 
     * @param info The information used to load compilation units when determining the name category. This may be
     *            necessary if, for example, the meaning of the name is determined by an on-demand import.
     * @return The category into which this node falls.
     */
    public NameCategory getCategory(CompilationUnitLoadingInfo info);

    /**
     * Retrieves a qualified string representation of this name. For simple names, this is merely the text of the name;
     * for qualified names, this is a dot-separated name sequence.
     * 
     * @return The qualified representation of this name.
     */
    public String getNameString();
 
    /**
     * Retrieves a list of name components for this name.  The first element in the list is the root of the name; that
     * is, <tt>edu.jhu.bsj</tt> would produce <tt>["edu", "jhu", "bsj"]</tt>.
     * @return The name components for this name.
     */
    public List<String> getNameComponents();
    /* GEN:stop */
}