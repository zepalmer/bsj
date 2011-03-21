import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;

/* GEN:headerstart */
/* GEN:headerstop */

public abstract class QualifiedNameNodeImpl
{
	/* GEN:start */
	/**
	 * Retrieves a string representation of this name.
	 * @return The string representation of this name.
	 */
	public String getNameString()
	{
		return getBase().getNameString() + "." + getIdentifier().getIdentifier();
	}

    public List<String> getNameComponents()
    {
        List<String> list = new ArrayList<String>();
        NameNode n = this;
        while (n != null)
        {
            list.add(n.getIdentifier().getIdentifier());
            if (n instanceof QualifiedNameNode)
            {
                n = ((QualifiedNameNode)n).getBase();
            } else
            {
                n = null;
            }
        }
        Collections.reverse(list);
        return list;
    }
	/* GEN:stop */
}