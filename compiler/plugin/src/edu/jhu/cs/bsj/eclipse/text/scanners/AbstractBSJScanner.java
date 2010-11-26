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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import edu.jhu.cs.bsj.eclipse.preference.BSJPreferenceConverter;
import edu.jhu.cs.bsj.eclipse.preference.BSJPreferenceKeys;
import edu.jhu.cs.bsj.eclipse.util.IColorManager;

/**
 * Based on JDT's java scanners, so as to access JDT's text preferences.
 */
public abstract class AbstractBSJScanner extends BufferedRuleBasedScanner{
	
	private IColorManager colorManager;
	private IPreferenceStore preferenceStore;
	private static IPreferencesService preferenceService = Platform.getPreferencesService();
	private static String javaPreferenceLocation = "org.eclipse.jdt.ui";
	
	private String[] tokenKeys;
	private Map<String,Token> tokenMap = new HashMap<String,Token>();
	
	private String[] boldPrefKeys;
	private String[] italicPrefKeys;
	private String[] strikethroughPrefKeys;
	private String[] underlinePrefKeys;
	
	/**
	 * @see JDT's AbstractJavaScanner
	 * 
	 * Returns an array of preference keys which define the tokens 
	 * used in the rules of this scanner.
	 * 
	 * Use constants from BSJTokenKeys.java as token properties.
	 */
	abstract protected String[] getTokenProperties();

	/**
	 * @see JDT's AbstractJavaScanner
	 * 
	 * Creates the list of rules controlling this scanner.
	 */
	abstract protected List<IRule> createRules();
	
	
	public AbstractBSJScanner(IColorManager colorManager,
			IPreferenceStore preferenceStore) {
		super();
		this.colorManager = colorManager;
		this.preferenceStore = preferenceStore;
		this.tokenKeys = getTokenProperties();
		initPreferenceKeys();
		initScannerRules();
	}
	
	public IColorManager getColorManager() {
		return colorManager;
	}
	
	public IPreferenceStore getPreferenceStore() {
		return preferenceStore;
	}
	
	private void initPreferenceKeys() {
		int length = tokenKeys.length;
		boldPrefKeys = new String[length];
		italicPrefKeys = new String[length];
		strikethroughPrefKeys = new String[length];
		underlinePrefKeys = new String[length];
		
		for (int i= 0; i < length; i++) {
			boldPrefKeys[i]= getBoldKey(tokenKeys[i]);
			italicPrefKeys[i]= getItalicKey(tokenKeys[i]);
			strikethroughPrefKeys[i]= getStrikethroughKey(tokenKeys[i]);
			underlinePrefKeys[i]= getUnderlineKey(tokenKeys[i]);
		}
	}
	
	private void initScannerRules() {
		createTokens();
		
		List<IRule> rules= createRules();
		if (rules != null) {
			IRule[] result= new IRule[rules.size()];
			rules.toArray(result);
			setRules(result);
		}
	}
	
	protected Token getToken(String tokenKey) {
		return tokenMap.get(tokenKey);
	}
	
	private void createTokens() {
		int length = tokenKeys.length;
		for(int tokenIndex=0; tokenIndex<length; tokenIndex++) {
			tokenMap.put(
					tokenKeys[tokenIndex], 
					new Token(createTextAttribute(tokenIndex))
					);
		}
	}
	
	private TextAttribute createTextAttribute(int tokenIndex) {
		RGB rgb;
		boolean bold, italic, strikethrough, underline;
		
		/*
		boolean useJavaDefault = preferenceStore.getBoolean(
				BSJPreferenceKeys.getUseJavaPreferenceKey(tokenKeys[tokenIndex]));
		*/
		boolean useJavaDefault = true;
		if(useJavaDefault) {
			rgb = BSJPreferenceConverter.getRGB(
					preferenceService.getString(
						javaPreferenceLocation, tokenKeys[tokenIndex], "", null));
			bold = preferenceService.getBoolean(
					javaPreferenceLocation, boldPrefKeys[tokenIndex], false, null);
			italic = preferenceService.getBoolean(
					javaPreferenceLocation, italicPrefKeys[tokenIndex], false, null);
			strikethrough = preferenceService.getBoolean(
					javaPreferenceLocation, strikethroughPrefKeys[tokenIndex], false, null);
			underline = preferenceService.getBoolean(
					javaPreferenceLocation, underlinePrefKeys[tokenIndex], false, null);
		} else {
			// TODO : fix this
			rgb = new RGB(0,0,0);
			bold = false;
			italic = false;
			strikethrough = false;
			underline = false;
		}
		
		Color color = colorManager.getColor(rgb);
		int style = bold ? SWT.BOLD : SWT.NORMAL;
		if (italic)
			style |= SWT.ITALIC;
		if (strikethrough)
			style |= TextAttribute.STRIKETHROUGH;
		if (underline)
			style |= TextAttribute.UNDERLINE;

		return new TextAttribute(color, null, style);
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
