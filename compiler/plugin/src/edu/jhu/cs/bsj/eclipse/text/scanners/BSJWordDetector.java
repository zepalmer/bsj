package edu.jhu.cs.bsj.eclipse.text.scanners;

import org.eclipse.jface.text.rules.IWordDetector;

public class BSJWordDetector implements IWordDetector {

	public boolean isWordStart(char c) {
		return Character.isJavaIdentifierStart(c);
	}

	public boolean isWordPart(char c) {
		return Character.isJavaIdentifierPart(c);
	}
	
}