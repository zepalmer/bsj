package edu.jhu.cs.bsj.eclipse.text.scanners;

import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IRule;

import edu.jhu.cs.bsj.eclipse.util.IColorManager;

public class BSJJavaDocScanner extends AbstractBSJScanner {

	public BSJJavaDocScanner(IColorManager colorManager,
			IPreferenceStore preferenceStore) {
		super(colorManager, preferenceStore);
	}

	@Override
	protected String[] getTokenProperties() {
		return null;
	}

	@Override
	protected List<IRule> createRules() {
		return null;
	}
	
}
