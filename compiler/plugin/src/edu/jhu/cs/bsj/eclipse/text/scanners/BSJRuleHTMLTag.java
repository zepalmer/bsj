/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Anton Leherbauer (Wind River Systems) - [misc] Allow custom token for WhitespaceRule - https://bugs.eclipse.org/bugs/show_bug.cgi?id=251224
 *******************************************************************************/
package edu.jhu.cs.bsj.eclipse.text.scanners;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.SingleLineRule;

public class BSJRuleHTMLTag extends SingleLineRule {
	
	private IToken defaultToken;
	private BSJJavaDocScanner bsjscanner;
	
	/*
	 * @see SingleLineRule
	 */
	public BSJRuleHTMLTag(IToken token, IToken defaultToken, BSJJavaDocScanner bsjscanner) {
		super("<", ">", token, (char) 0); //$NON-NLS-2$ //$NON-NLS-1$
		this.defaultToken = defaultToken;
		this.bsjscanner = bsjscanner;
	}

	
	private IToken evaluateToken() {
		try {
			final String token = bsjscanner.getDocument().get(bsjscanner.getTokenOffset(),
					bsjscanner.getTokenLength())
					+ "."; //$NON-NLS-1$

			int offset = 0;
			char character = token.charAt(++offset);

			if (character == '/')
				character = token.charAt(++offset);

			while (Character.isWhitespace(character))
				character = token.charAt(++offset);

			while (Character.isLetterOrDigit(character))
				character = token.charAt(++offset);

			while (Character.isWhitespace(character))
				character = token.charAt(++offset);

			if (offset >= 2 && token.charAt(offset) == fEndSequence[0])
				return fToken;

		} catch (BadLocationException exception) {
			// Do nothing
		}
		return defaultToken;
	}

	
	/*
	 * @see PatternRule#evaluate(ICharacterScanner)
	 */
	public IToken evaluate(ICharacterScanner scanner) {
		IToken result = super.evaluate(scanner);
		if (result == fToken)
			return evaluateToken();
		return result;
	}
	
}
