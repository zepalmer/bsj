/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Philippe Ombredanne <pombredanne@nexb.com> - https://bugs.eclipse.org/bugs/show_bug.cgi?id=150989
 *     Anton Leherbauer (Wind River Systems) - [misc] Allow custom token for WhitespaceRule - https://bugs.eclipse.org/bugs/show_bug.cgi?id=251224
 *******************************************************************************/
package edu.jhu.cs.bsj.eclipse.text.scanners;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class BSJRuleJavaOperators implements IRule {
	/** Java operators */
	private final char[] JAVA_OPERATORS= { ';', '.', '=', '/', '\\', '+', '-', '*', '<', '>', ':', '?', '!', ',', '|', '&', '^', '%', '~'};
	/** Token to return for this rule */
	private final IToken fToken;

	/**
	 * Creates a new operator rule.
	 *
	 * @param token Token to use for this rule
	 */
	public BSJRuleJavaOperators(IToken token) {
		fToken= token;
	}

	/**
	 * Is this character an operator character?
	 *
	 * @param character Character to determine whether it is an operator character
	 * @return <code>true</code> iff the character is an operator, <code>false</code> otherwise.
	 */
	public boolean isOperator(char character) {
		for (int index= 0; index < JAVA_OPERATORS.length; index++) {
			if (JAVA_OPERATORS[index] == character)
				return true;
		}
		return false;
	}

	/*
	 * @see org.eclipse.jface.text.rules.IRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner)
	 */
	@Override
	public IToken evaluate(ICharacterScanner scanner) {

		int character= scanner.read();
		if (isOperator((char) character)) {
			do {
				character= scanner.read();
			} while (isOperator((char) character));
			scanner.unread();
			return fToken;
		} else {
			scanner.unread();
			return Token.UNDEFINED;
		}
	}
}
