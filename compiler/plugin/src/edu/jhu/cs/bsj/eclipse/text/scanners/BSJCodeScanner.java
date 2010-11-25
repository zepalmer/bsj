package edu.jhu.cs.bsj.eclipse.text.scanners;

import org.eclipse.jdt.ui.text.IJavaColorConstants;


public class BSJCodeScanner extends AbstractBSJScanner {
	
	private final static String[] keywords = { 
		"abstract", "break", "case", "catch", "class", "continue", "default", "do", 
		"else", "extends", "final", "finally", "for", "if", "implements", "import", 
		"instanceof", "interface", "native", "new", "package", "private", "protected", 
		"public", "return", "static", "super", "switch", "synchronized", "this", "throw", 
		"throws", "transient", "try", "volatile", "while" 
		};
	
	private final static String[] types = { 
		"void", "boolean", "char", "byte", "short", 
		"int", "long", "float", "double" 
		};

	private final static String[] constants = { 
		"false", "null", "true" 
		};
	
	private final static String[] fgTokenProperties= {
		IJavaColorConstants.JAVA_KEYWORD,
		IJavaColorConstants.JAVA_STRING,
		IJavaColorConstants.JAVA_DEFAULT,
		IJavaColorConstants.JAVA_KEYWORD_RETURN,
		IJavaColorConstants.JAVA_OPERATOR,
		IJavaColorConstants.JAVA_BRACKET,
	};
	
}
