package edu.jhu.cs.bsj.plugin.eclipse.text;

import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.WordRule;

public class BSJKeywordRule extends WordRule {
	
	public BSJKeywordRule(IWordDetector detector) {
		super(detector);
	}
	
}
