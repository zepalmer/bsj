package edu.jhu.cs.bsj.plugin.eclipse.text;

import org.eclipse.jface.text.rules.IWordDetector;

public class BSJKeywordDetector implements IWordDetector {
	
	public boolean isWordStart(char c) {
		return c=='#';
	}
	
	public boolean isWordPart(char c) {
		return Character.isJavaIdentifierPart(c);
	}
	
}
