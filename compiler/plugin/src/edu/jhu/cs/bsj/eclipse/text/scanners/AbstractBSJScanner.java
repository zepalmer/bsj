package edu.jhu.cs.bsj.eclipse.text.scanners;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;

public abstract class AbstractBSJScanner extends BufferedRuleBasedScanner{
	
	private IPreferenceStore preferenceStore;
	private IPreferenceStore javaPreferenceStore;
	
}
