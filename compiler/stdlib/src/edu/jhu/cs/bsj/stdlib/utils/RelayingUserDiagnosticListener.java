package edu.jhu.cs.bsj.stdlib.utils;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.user.BsjUserDiagnosticListener;
import edu.jhu.cs.bsj.stdlib.diagnostic.impl.UserRelayedDiagnosticImpl;

/**
 * This diagnostic listener will wrap any received compiler diagnostics in a BSJ user diagnostic.  The purpose of this listener
 * is to allow mechanisms which produce compiler diagnostics to be used by metaprograms.  The resulting user diagnostic
 * will report the full compiler diagnostic as well as the metaprogram that produced it.
 * @author Zachary Palmer
 *
 */
public class RelayingUserDiagnosticListener implements DiagnosticListener<BsjSourceLocation>
{
    private BsjUserDiagnosticListener userDiagnosticListener;

    public RelayingUserDiagnosticListener(BsjUserDiagnosticListener userDiagnosticListener)
    {
        super();
        this.userDiagnosticListener = userDiagnosticListener;
    }

    @Override
    public void report(Diagnostic<? extends BsjSourceLocation> diagnostic)
    {
        this.userDiagnosticListener.report(new UserRelayedDiagnosticImpl(diagnostic));
    }
}
