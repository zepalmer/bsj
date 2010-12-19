package edu.jhu.cs.bsj.eclipse.text.scanners;

import org.eclipse.jface.text.rules.IWordDetector;

public class BSJDetectorKeyword implements IWordDetector {

	@Override
	public boolean isWordStart(char c) {
		return c=='#' || Character.isJavaIdentifierStart(c);
	}

	@Override
	public boolean isWordPart(char c) {
		return Character.isJavaIdentifierPart(c);
	}
	
}