import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNameBindingNode;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;

public class UnparameterizedTypeNodeImpl
{
    /* GEN:start */
    @Override
    public Collection<? extends TypeNameBindingNode> getDeclarations()
    {
        List<TypeNameBindingNode> ret = new ArrayList<TypeNameBindingNode>();
        for (Node n : getDeclarationsInScope(getName()))
        {
            if (n instanceof TypeNameBindingNode)
            {
                ret.add((TypeNameBindingNode)n);
            }
        }
        return ret;
    }
    /* GEN:stop */
}