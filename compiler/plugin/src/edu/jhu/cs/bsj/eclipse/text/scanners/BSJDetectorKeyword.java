package edu.jhu.cs.bsj.eclipse.text.scanners;

import org.eclipse.jface.text.rules.IWordDetector;

public class BSJDetectorKeyword implements IWordDetector {

	public boolean isWordStart(char c) {
		return c=='#' || Character.isJavaIdentifierStart(c);
	}

	public boolean isWordPart(char c) {
		return Character.isJavaIdentifierPart(c);
	}
	
}