package edu.jhu.cs.bsj.eclipse.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;

import edu.jhu.cs.bsj.eclipse.util.ColorManager;

public class BSJMetaprogramScanner extends RuleBasedScanner {
	
	private static final String[] bsjKeywords = {"depends", "import", "mode", "target", "weak"};
	
	public BSJMetaprogramScanner(ColorManager colorManager) {
		
		IToken singleline = new Token(new TextAttribute(colorManager.getColor(BSJHighlightColorProvider.SINGLE_LINE_COMMENT)));
		IToken multiline = new Token(new TextAttribute(colorManager.getColor(BSJHighlightColorProvider.MULTI_LINE_COMMENT)));
		IToken string= new Token(new TextAttribute(colorManager.getColor(BSJHighlightColorProvider.STRING)));
		IToken keyword = new Token(new TextAttribute(colorManager.getColor(BSJHighlightColorProvider.KEYWORD)));
		//IToken other= new Token(new TextAttribute(colorManager.getColor(BSJHighlightColorProvider.DEFAULT)));
		
		List<IRule> rules = new ArrayList<IRule>();
		
		// comment
		rules.add(new EndOfLineRule("//", singleline));
		rules.add(new MultiLineRule("/*", "*/", multiline, '\0', true));
		
		// strings and character constants.
		rules.add(new SingleLineRule("\"", "\"", string, '\\'));
		rules.add(new SingleLineRule("'", "'", string, '\\'));
		
		// keyword
		BSJKeywordRule keywordRule = new BSJKeywordRule(new JavaWordDetector());
		for(int i=0; i<bsjKeywords.length; i++)
			keywordRule.addWord(bsjKeywords[i], keyword);
		rules.add(keywordRule);
		
		// whitespace
		rules.add(new WhitespaceRule(new JavaWhitespaceDetector()));
		
		IRule[] rulesArray = new IRule[rules.size()];
		rules.toArray(rulesArray);
		setRules(rulesArray);
	}
	
}
