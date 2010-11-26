package edu.jhu.cs.bsj.eclipse.text.scanners;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class BSJWhitespaceDetector implements IWhitespaceDetector {
	
	public boolean isWhitespace(char c) {
		return Character.isWhitespace(c);
	}
	
}