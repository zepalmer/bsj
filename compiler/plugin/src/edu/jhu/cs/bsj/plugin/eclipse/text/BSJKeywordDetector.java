package edu.jhu.cs.bsj.plugin.eclipse.text;

import org.eclipse.jface.text.rules.IWordDetector;

public class BSJKeywordDetector implements IWordDetector {
	
	private boolean inspace = false;
	
	public boolean isWordStart(char c) {
		if(c=='#') {
			inspace = true;
			return true;
		}
		return false;
	}
	
	public boolean isWordPart(char c) {
		if(Character.isWhitespace(c)) {
			return inspace;
		} else {
			inspace = false;
			return Character.isJavaIdentifierPart(c);
		}
	}
	
}
