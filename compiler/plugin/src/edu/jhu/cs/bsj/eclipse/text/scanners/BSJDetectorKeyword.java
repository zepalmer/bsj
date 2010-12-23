package edu.jhu.cs.bsj.eclipse.text.scanners;

import org.eclipse.jface.text.rules.IWordDetector;

public class BSJDetectorKeyword implements IWordDetector {

	private char prev = ' ';
	
	@Override
	public boolean isWordStart(char c) {
		boolean flag = !(prev=='#' || Character.isJavaIdentifierStart(prev))
			&& (c=='#' || Character.isJavaIdentifierStart(c));
		prev = c;
		return flag;
	}

	@Override
	public boolean isWordPart(char c) {
		return Character.isJavaIdentifierPart(c);
	}
	
}