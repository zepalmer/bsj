package edu.jhu.cs.bsj.plugin.eclipse.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;

import edu.jhu.cs.bsj.plugin.eclipse.util.ColorManager;

public class BSJMetaprogramScanner extends RuleBasedScanner {
	
	private static final String[] bsjKeywords = {"#depends", "#import", "#mode", "#target", "#weak"};
	
	public BSJMetaprogramScanner(ColorManager colorManager) {
		
		IToken keyword = new Token(new TextAttribute(colorManager.getColor(BSJHighlightColorProvider.KEYWORD)));
		IToken other= new Token(new TextAttribute(colorManager.getColor(BSJHighlightColorProvider.DEFAULT)));
		
		List<IRule> rules = new ArrayList<IRule>();
		
		BSJKeywordRule keywordRule = new BSJKeywordRule(new BSJKeywordDetector());
		for(int i=0; i<bsjKeywords.length; i++)
			keywordRule.addWord(bsjKeywords[i], keyword);
		rules.add(keywordRule);
		
		IRule[] rulesArray = new IRule[rules.size()];
		rules.toArray(rulesArray);
		setRules(rulesArray);
	}
	
}
