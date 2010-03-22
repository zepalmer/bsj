/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     
 * Modified by Zachary Palmer and Joseph Riley for Backstage Java
 *******************************************************************************/

package edu.jhu.cs.bsj.plugin.scanners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.*;
import org.eclipse.jface.text.*;

import edu.jhu.cs.bsj.plugin.editor.BsjColorProvider;

public class BsjCodeScanner extends RuleBasedScanner 
{
    private static String[] fgKeywords= { 
        "abstract", "break", "case", "catch", "class", "continue", 
        "default", "do", "else", "extends", "final", "finally", 
        "for", "if", "implements", "import", "instanceof", "interface", 
        "native", "new", "package", "private", "protected", "public", 
        "return", "static", "strictfp", "super", "switch", "synchronized", "this", 
        "throw", "throws", "transient", "try", "volatile", "while" };
    
    private static String[] fgTypes= { 
        "void", "boolean", "char", "byte", "short", 
        "int", "long", "float", "double" };
    
    private static String[] fgConstants= {"false", "null", "true"};
    
    /**
     * Creates a Java code scanner with the given color provider.
     *
     * @param provider the color provider
     */
    public BsjCodeScanner(BsjColorProvider provider) 
    {
        IToken keyword = new Token(new TextAttribute(provider.getColor(BsjColorProvider.KEYWORD)));
        IToken type = new Token(new TextAttribute(provider.getColor(BsjColorProvider.TYPE)));
        IToken string = new Token(new TextAttribute(provider.getColor(BsjColorProvider.STRING)));
        IToken comment = new Token(new TextAttribute(provider.getColor(BsjColorProvider.SINGLE_LINE_COMMENT)));
        IToken other = new Token(new TextAttribute(provider.getColor(BsjColorProvider.DEFAULT)));
        IToken meta = new Token(new TextAttribute(provider.getColor(BsjColorProvider.META_PROGRAM)));
        List<IRule> rules= new ArrayList<IRule>();

        // Add rule for single line comments.
        rules.add(new EndOfLineRule("//", comment));

        // Add rule for strings and character constants.
        rules.add(new SingleLineRule("\"", "\"", string, '\\'));
        rules.add(new SingleLineRule("'", "'", string, '\\'));

        // Add rule for meta programs
        //rules.add(new MultiLineRule("[:", ":]", meta));
        
        // Add generic whitespace rule.
        rules.add(new WhitespaceRule(new JavaWhitespaceDetector()));

        // Add word rule for keywords, types, and constants.
        WordRule wordRule= new WordRule(new JavaWordDetector(), other);
        
        for (int i= 0; i < fgKeywords.length; i++)
        {
            wordRule.addWord(fgKeywords[i], keyword);
        }
        
        for (int i= 0; i < fgTypes.length; i++)
        {
            wordRule.addWord(fgTypes[i], type);
        }
        
        for (int i= 0; i < fgConstants.length; i++)
        {
            wordRule.addWord(fgConstants[i], type);
        }
        
        rules.add(wordRule);

        IRule[] result= new IRule[rules.size()];
        rules.toArray(result);
        setRules(result);
    }
}
