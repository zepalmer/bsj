import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;

public class UnparameterizedTypeNodeImpl
{
    /* GEN:start */
    @Override
    public Collection<? extends TypeNameBindingNode> getDeclarations()
    {
        return getBaseType().getDeclarations();
    }
    /* GEN:stop */
}