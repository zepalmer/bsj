package edu.jhu.cs.bsj.eclipse.text;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class BSJWhitespaceDectector implements IWhitespaceDetector {
	
	@Override
	public boolean isWhitespace(char c) {
		return Character.isWhitespace(c);
	}
	
}
