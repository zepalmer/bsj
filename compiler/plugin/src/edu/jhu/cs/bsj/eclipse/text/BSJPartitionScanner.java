package edu.jhu.cs.bsj.eclipse.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

/**
 * Partition scanner that partitions code into 
 * multiline comment, javadoc, metaprogram, and default content type (IDocument.DEFAULT_CONTENT_TYPE)
 */
public class BSJPartitionScanner extends RuleBasedPartitionScanner {
	
	public static final String[] BSJ_PARTITION_TYPES = new String[] {
		BSJPartitionConstants.JAVA_MULTILINE_COMMENT,
		BSJPartitionConstants.JAVA_JAVADOC,
		BSJPartitionConstants.BSJ_METAPROGRAM,
	};
	
	public BSJPartitionScanner() {
		IToken multilineComment = new Token(BSJPartitionConstants.JAVA_MULTILINE_COMMENT);
		IToken javadoc = new Token(BSJPartitionConstants.JAVA_JAVADOC);
		IToken metaprogram = new Token(BSJPartitionConstants.BSJ_METAPROGRAM);
		
		List<IPredicateRule> rules = new ArrayList<IPredicateRule>();
		rules.add(new MultiLineRule("/**", "*/", javadoc, '\0', true));
		rules.add(new MultiLineRule("/*", "*/", multilineComment, '\0', true));
		rules.add(new MultiLineRule("[:", ":]", metaprogram, '\0', true));
		
		IPredicateRule[] rulesArray = new IPredicateRule[rules.size()];
		rules.toArray(rulesArray);
		setPredicateRules(rulesArray);
	}
	
}
