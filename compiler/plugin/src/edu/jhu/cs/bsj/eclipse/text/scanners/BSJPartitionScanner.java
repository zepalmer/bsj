package edu.jhu.cs.bsj.eclipse.text.scanners;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

import edu.jhu.cs.bsj.eclipse.text.BSJPartitionConstants;

/**
 * At the first step, partition the document into javaDocs, multiline comments, and default content 
 */
public class BSJPartitionScanner extends RuleBasedPartitionScanner {
	
	public static final String[] BSJ_PARTITION_TYPES = new String[] {
		BSJPartitionConstants.BSJ_JAVADOC,
		BSJPartitionConstants.BSJ_MULTILINE_COMMENT,
		BSJPartitionConstants.BSJ_SINGLELINE_COMMENT,
		IDocument.DEFAULT_CONTENT_TYPE,
	};
	
	public BSJPartitionScanner() {
		IToken javadoc = new Token(BSJPartitionConstants.BSJ_JAVADOC);
		IToken multilineComment = new Token(BSJPartitionConstants.BSJ_MULTILINE_COMMENT);
		IToken singlelineComment = new Token(BSJPartitionConstants.BSJ_SINGLELINE_COMMENT);
		
		IPredicateRule[] rules = new IPredicateRule[3];
		rules[0] = new MultiLineRule("/**", "*/", javadoc, '\0', true);
		rules[1] = new MultiLineRule("/*", "*/", multilineComment, '\0', true);
		rules[2] = new EndOfLineRule("//", singlelineComment);
		
		setPredicateRules(rules);
	}
	
}
