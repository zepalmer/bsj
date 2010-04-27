package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.UserDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.user.BsjUserDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.BsjDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;

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
	protected Pair<List<Object>, Map<String, Integer>> getMessageArgs(Locale locale)
	{
		List<Object> list = Collections.<Object>singletonList(this.userDiagnostic.getMessage(locale));
		Map<String,Integer> map = Collections.singletonMap("diagnosticMessage", 0);
		return new Pair<List<Object>, Map<String,Integer>>(list, map);
				
	}
}
