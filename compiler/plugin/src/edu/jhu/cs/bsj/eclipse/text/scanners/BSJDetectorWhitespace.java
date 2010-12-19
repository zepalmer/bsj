package edu.jhu.cs.bsj.eclipse.text.scanners;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class BSJDetectorWhitespace implements IWhitespaceDetector {
	
	@Override
	public boolean isWhitespace(char c) {
		return Character.isWhitespace(c);
	}
	
}