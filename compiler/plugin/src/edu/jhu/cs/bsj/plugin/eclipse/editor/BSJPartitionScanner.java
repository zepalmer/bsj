package edu.jhu.cs.bsj.plugin.eclipse.editor;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

public class BSJPartitionScanner extends RuleBasedPartitionScanner {
	
	public final static String BSJ_SINGLELINE_COMMENT = "__bsj__singleline_comment";
	public final static String BSJ_MULTILINE_COMMENT = "__java_multiline_comment";
	public final static String BSJ_JAVADOC = "__bsj_javadoc";
	public final static String BSJ_METAPROGRAM = "__bsj_metaprogram";
	public static final String[] BSJ_PARTITION_TYPES = new String[] {
		BSJ_SINGLELINE_COMMENT,
		BSJ_MULTILINE_COMMENT,
		BSJ_JAVADOC,
		BSJ_METAPROGRAM
	};
	
	public BSJPartitionScanner() {
		IToken singlelineComment = new Token(BSJ_SINGLELINE_COMMENT);
		IToken multilineComment = new Token(BSJ_MULTILINE_COMMENT);
		IToken javadoc = new Token(BSJ_JAVADOC);
		IToken metaprogram = new Token(BSJ_METAPROGRAM);
		
		List<IPredicateRule> rules = new ArrayList<IPredicateRule>();
		rules.add(new EndOfLineRule("//", singlelineComment));
		rules.add(new MultiLineRule("/**", "*/", javadoc, '\0', true));
		rules.add(new MultiLineRule("/*", "*/", multilineComment, '\0', true));
		rules.add(new MultiLineRule("[:", ":]", metaprogram, '\0', true));
		
		IPredicateRule[] rulesArray = new IPredicateRule[rules.size()];
		rules.toArray(rulesArray);
		setPredicateRules(rulesArray);
	}
	
}
