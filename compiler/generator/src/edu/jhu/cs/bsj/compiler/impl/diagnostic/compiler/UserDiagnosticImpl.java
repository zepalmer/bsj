package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.UserDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.user.BsjUserDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.BsjDiagnosticImpl;

public class UserDiagnosticImpl extends BsjDiagnosticImpl implements UserDiagnostic
{
	/** The code for this type of diagnostic. */
	public static final String CODE = "bsj.compiler.user";
	/** The user diagnostic emitted by the metaprogram. */
	private BsjUserDiagnostic userDiagnostic;
	
	public UserDiagnosticImpl(BsjSourceLocation location, BsjUserDiagnostic userDiagnostic)
	{
		super(location, CODE, userDiagnostic.getKind());
		this.userDiagnostic = userDiagnostic;
	}

	@Override
	public BsjUserDiagnostic getUserDiagnostic()
	{
		return this.userDiagnostic;
	}

	@Override
	protected List<Object> getMessageArgs(Locale locale)
	{
		return Collections.<Object>singletonList(this.userDiagnostic.getMessage(locale));
	}
}
