package edu.jhu.cs.bsj.eclipse.text.scanners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.Token;

import edu.jhu.cs.bsj.eclipse.text.BSJTokenKeys;
import edu.jhu.cs.bsj.eclipse.util.IColorManager;

public class BSJStringScanner extends AbstractBSJScanner {

	public BSJStringScanner(IColorManager colorManager,
			IPreferenceStore preferenceStore) {
		super(colorManager, preferenceStore);
		initialize();
	}

	@Override
	protected String[] getTokenProperties() {
		return new String[] {
				BSJTokenKeys.JAVA_STRING };
	}

	@Override
	protected List<IRule> createRules() {
		Token defaultToken = getToken(BSJTokenKeys.JAVA_STRING);
		setDefaultReturnToken(defaultToken);
		
		return new ArrayList<IRule>();
	}
	
}
