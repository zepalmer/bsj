package edu.jhu.cs.bsj.eclipse.text.scanners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.ui.text.IJavaColorConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

import edu.jhu.cs.bsj.eclipse.text.BSJTokenKeys;
import edu.jhu.cs.bsj.eclipse.util.IColorManager;


public class BSJCodeScanner extends AbstractBSJScanner {
	
	public BSJCodeScanner(IColorManager colorManager,
			IPreferenceStore preferenceStore) {
		super(colorManager, preferenceStore);
		initialize();
	}
	
	@Override
	protected String[] getTokenProperties() {
		return tokenKeys;
	}

	@Override
	protected List<IRule> createRules() {
		List<IRule> rules= new ArrayList<IRule>();
		
		Token defaultToken = getToken(IJavaColorConstants.JAVA_DEFAULT);
		setDefaultReturnToken(defaultToken);
		
		Token token;
		
		// Add rule for characters
		token = getToken(IJavaColorConstants.JAVA_STRING);
		rules.add(new SingleLineRule("\'", "\'", token, '\\'));
		
		// Add rule for java keywords
		token = getToken(IJavaColorConstants.JAVA_KEYWORD);
		WordRule javaKeywordRule = new WordRule(new BSJDetectorKeyword());
		for (int i= 0; i <  javaKeywords.length; i++)
			javaKeywordRule.addWord(javaKeywords[i], token);
		rules.add(javaKeywordRule);
		
		// Add rule for return keyword
		token = getToken(IJavaColorConstants.JAVA_KEYWORD_RETURN);
		WordRule returnKeywordRule = new WordRule(new BSJDetectorKeyword());
		returnKeywordRule.addWord(returnKeyword, token);
		rules.add(returnKeywordRule);
		
		// Add rule for bsj keywords
		token = getToken(IJavaColorConstants.JAVA_KEYWORD);
		WordRule bsjKeywordRule = new WordRule(new BSJDetectorKeyword());
		for (int i= 0; i <  bsjKeywords.length; i++)
			bsjKeywordRule.addWord(bsjKeywords[i], token);
		rules.add(bsjKeywordRule);
		
		// Add rule for java types
		token = getToken(IJavaColorConstants.JAVA_KEYWORD);
		WordRule javaTypeRule = new WordRule(new BSJDetectorKeyword());
		for (int i= 0; i <  javaTypes.length; i++)
			javaTypeRule.addWord(javaTypes[i], token);
		rules.add(javaTypeRule);
		
		// Add rule for constants
		//token = getToken(BSJTokenKeys.JAVA_KEYWORD);
		WordRule javaConstantRule = new WordRule(new BSJDetectorKeyword());
		for (int i= 0; i <  javaConstants.length; i++)
			javaConstantRule.addWord(javaConstants[i], token);
		rules.add(javaConstantRule);
		
		// Add rule for brackets
		rules.add(new BSJRuleBrackets(
				getToken(IJavaColorConstants.JAVA_BRACKET), 
				getToken(IJavaColorConstants.JAVA_BRACKET)
				));
		
		// Add rule for operators
		token = getToken(IJavaColorConstants.JAVA_OPERATOR);
		rules.add(new BSJRuleJavaOperators(token));
		
		// Add whitespace rule.
		token = defaultToken;
		rules.add(new WhitespaceRule(new BSJDetectorWhitespace(), token));
		
		return rules;
	}
	
	private final static String[] tokenKeys= {
		BSJTokenKeys.JAVA_KEYWORD,
		BSJTokenKeys.JAVA_STRING,
		BSJTokenKeys.JAVA_DEFAULT,
		BSJTokenKeys.JAVA_KEYWORD_RETURN,
		BSJTokenKeys.JAVA_OPERATOR,
		BSJTokenKeys.JAVA_BRACKET,
		};
	
	private final static String[] javaKeywords = { 
		"abstract", "assert", "break", "case", "catch", "class", "continue", "default", "do", 
		"else", "enum", "extends", "final", "finally", "for", "if", "implements", "import", 
		"instanceof", "interface", "native", "new", "package", "private", "protected", 
		"public", "return", "static", "super", "switch", "synchronized", "this", "throw", 
		"throws", "transient", "try", "volatile", "while" 
		};
	
	private static final String returnKeyword = "return";

	private static final String[] bsjKeywords = {
		"#depends", "#import", "#mode", "#target", "#weak",
		};
	
	private final static String[] javaTypes = { 
		"void", "boolean", "char", "byte", "short", 
		"int", "long", "float", "double" 
		};

	private final static String[] javaConstants = { 
		"false", "null", "true" 
		};
	
}
