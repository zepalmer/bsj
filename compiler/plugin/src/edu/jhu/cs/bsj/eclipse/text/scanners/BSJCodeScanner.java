package edu.jhu.cs.bsj.eclipse.text.scanners;

import java.util.List;

import org.eclipse.jdt.ui.text.IJavaColorConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IRule;

import edu.jhu.cs.bsj.eclipse.text.BSJColorKeys;
import edu.jhu.cs.bsj.eclipse.util.IColorManager;


public class BSJCodeScanner extends AbstractBSJScanner {
	
	public BSJCodeScanner(IColorManager colorManager,
			IPreferenceStore preferenceStore) {
		super(colorManager, preferenceStore);
	}
	
	private final static String[] colorKeys= {
		BSJColorKeys.JAVA_KEYWORD,
		BSJColorKeys.JAVA_STRING,
		BSJColorKeys.JAVA_DEFAULT,
		BSJColorKeys.JAVA_KEYWORD_RETURN,
		BSJColorKeys.JAVA_OPERATOR,
		BSJColorKeys.JAVA_BRACKET,
		};
	
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

	@Override
	protected String[] getColorKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<IRule> createRules() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
