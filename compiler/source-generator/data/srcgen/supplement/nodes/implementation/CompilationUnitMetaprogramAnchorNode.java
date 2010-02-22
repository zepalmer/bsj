import edu.jhu.cs.bsj.compiler.ast.node.ImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;

public class CompilationUnitMetaprogramAnchorNodeImpl
{
	/* GEN:start */
	@Override
	public PackageDeclarationNode getPackageDeclaration()
	{
		return getReplacement().getPackageDeclaration();
	}

	@Override
	public MetaprogramImportListNode getMetaimports()
	{
		return getReplacement().getMetaimports();
	}

	@Override
	public ImportListNode getImports()
	{
		return getReplacement().getImports();
	}

	@Override
	public TypeDeclarationListNode getTypeDecls()
	{
		return getReplacement().getTypeDecls();
	}

	@Override
	public void setPackageDeclaration(PackageDeclarationNode packageDeclaration)
	{
		// TODO: now what?  Exception?  Permission violation?
	}

	@Override
	public void setMetaimports(MetaprogramImportListNode metaimports)
	{
		// TODO: now what?  Exception?  Permission violation?
	}

	@Override
	public void setImports(ImportListNode imports)
	{
		// TODO: now what?  Exception?  Permission violation?
	}

	@Override
	public void setTypeDecls(TypeDeclarationListNode typeDecls)
	{
		// TODO: now what?  Exception?  Permission violation?
	}
	/* GEN:stop */
}