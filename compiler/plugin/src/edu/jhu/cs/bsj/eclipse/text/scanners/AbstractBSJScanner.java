/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package edu.jhu.cs.bsj.eclipse.text.scanners;

import java.util.List;

import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.IRule;

import edu.jhu.cs.bsj.eclipse.preference.BSJPreferenceKeys;
import edu.jhu.cs.bsj.eclipse.util.IColorManager;

/**
 * Based on JDT's java scanners, so as to access JDT's text preferences.
 */
public abstract class AbstractBSJScanner extends BufferedRuleBasedScanner{
	
	private IColorManager colorManager;
	private IPreferenceStore preferenceStore;
	
	private String[] boldPrefKeys;
	private String[] italicPrefKeys;
	private String[] strikethroughPrefKeys;
	private String[] underlinePrefKeys;
	
	abstract protected String[] getColorKeys();
	abstract protected List<IRule> createRules();
	
	public AbstractBSJScanner(IColorManager colorManager,
			IPreferenceStore preferenceStore) {
		super();
		this.colorManager = colorManager;
		this.preferenceStore = preferenceStore;
	}
	
	public IColorManager getColorManager() {
		return colorManager;
	}
	
	public IPreferenceStore getPreferenceStore() {
		return preferenceStore;
	}
	
	private void initPreferenceKeys() {
		String[] colorKeys = getColorKeys();
		int length = colorKeys.length;
		
		boldPrefKeys = new String[length];
		italicPrefKeys = new String[length];
		strikethroughPrefKeys = new String[length];
		underlinePrefKeys = new String[length];
		
		for (int i= 0; i < length; i++) {
			boldPrefKeys[i]= getBoldKey(colorKeys[i]);
			italicPrefKeys[i]= getItalicKey(colorKeys[i]);
			strikethroughPrefKeys[i]= getStrikethroughKey(colorKeys[i]);
			underlinePrefKeys[i]= getUnderlineKey(colorKeys[i]);
		}
	}
	
	private void initScannerRules() {
		
	}
	
	protected String getBoldKey(String colorKey) {
		return BSJPreferenceKeys.getBoldKey(colorKey);
	}

	protected String getItalicKey(String colorKey) {
		return BSJPreferenceKeys.getItalicKey(colorKey);
	}

	protected String getStrikethroughKey(String colorKey) {
		return BSJPreferenceKeys.getStrikethroughKey(colorKey);
	}

	protected String getUnderlineKey(String colorKey) {
		return BSJPreferenceKeys.getUnderlineKey(colorKey);
	}
}
