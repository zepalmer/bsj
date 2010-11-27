package edu.jhu.cs.bsj.eclipse.text.scanners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

import edu.jhu.cs.bsj.eclipse.text.BSJTokenKeys;
import edu.jhu.cs.bsj.eclipse.util.IColorManager;

public class BSJJavaDocScanner extends BSJCommentScanner {

	public BSJJavaDocScanner(IColorManager colorManager,
			IPreferenceStore preferenceStore) {
		super(colorManager, preferenceStore, BSJTokenKeys.JAVADOC_DEFAULT);
	}
	
	@Override
	protected void initTokenKeys() {
		super.initTokenKeys();
		tokenKeys.add(BSJTokenKeys.JAVADOC_KEYWORD);
		tokenKeys.add(BSJTokenKeys.JAVADOC_TAG);
		tokenKeys.add(BSJTokenKeys.JAVADOC_LINK);
	}
	
	@Override
	protected List<IRule> createRules() {
		List<IRule> rules= new ArrayList<IRule>();
		
		Token defaultToken = getToken(defaultTokenKey);
		setDefaultReturnToken(defaultToken);
		
		Token token;
		
		// Add rule for white spaces
		token = defaultToken;
		rules.add(new WhitespaceRule(new BSJDetectorWhitespace(), token));
		
		// Add rule for java doc keywords
		token = getToken(BSJTokenKeys.JAVADOC_KEYWORD);
		rules.add(new BSJRuleJavaDocTag(token, defaultToken));
		
		// add simple rules for HTML
		token = getToken(BSJTokenKeys.JAVADOC_TAG);
		WordRule commentTag = new WordRule(new IWordDetector() {
			@Override
			public boolean isWordStart(char c) {
				return c=='<'||c=='-';
			}
			@Override
			public boolean isWordPart(char c) {
				return c=='!'||c=='-'||c=='>';
			}
		});
		commentTag.addWord("<!--", token);
		commentTag.addWord("-->", token);
		rules.add(commentTag);
		rules.add(new BSJRuleHTMLTag(token, defaultToken, this));
		
		// Add rule for links.
		token = getToken(BSJTokenKeys.JAVADOC_LINK);
		rules.add(new SingleLineRule("{@link", "}", token));
		rules.add(new SingleLineRule("{@value", "}", token));
		rules.add(new SingleLineRule("{@inheritDoc", "}", token));
		
		// add parent's rules
		rules.addAll(super.createRules());
		
		return rules;
	}
	
	public IDocument getDocument() {
		return fDocument;
	}
}
