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

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.graphics.RGB;

import edu.jhu.cs.bsj.plugin.editor.BsjColorProvider;

public class BsjMetaScanner extends RuleBasedScanner 
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
    
    private static String[] metaChars= {"[:", ":]"};
    
    private IToken makeToken(RGB color, BsjColorProvider provider)
    {
        return new Token(new TextAttribute(
                provider.getColor(BsjColorProvider.KEYWORD), 
                provider.getColor(BsjColorProvider.META_BACKGROUND), 
                0));
    }
    
    /**
     * Creates a Java code scanner with the given color provider.
     *
     * @param provider the color provider
     */
    public BsjMetaScanner(BsjColorProvider provider) 
    {
        IToken keyword = makeToken(BsjColorProvider.KEYWORD, provider);
        IToken type = makeToken(BsjColorProvider.TYPE, provider);
        IToken string = makeToken(BsjColorProvider.STRING, provider);
        IToken comment = makeToken(BsjColorProvider.SINGLE_LINE_COMMENT, provider);
        IToken other = makeToken(BsjColorProvider.DEFAULT, provider);
        IToken meta = makeToken(BsjColorProvider.META_PROGRAM, provider);
        List<IRule> rules= new ArrayList<IRule>();

        // Add rule for single line comments.
        rules.add(new EndOfLineRule("//", comment));

        // Add rule for strings and character constants.
        rules.add(new SingleLineRule("\"", "\"", string, '\\'));
        rules.add(new SingleLineRule("'", "'", string, '\\'));
        
        // Add generic whitespace rule.
        rules.add(new WhitespaceRule(new JavaWhitespaceDetector(),meta));

        // Add word rule for keywords, types, constants, and meta characters.
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
        
        for (int i= 0; i < metaChars.length; i++)
        {
            wordRule.addWord(metaChars[i], meta);
        }
        
        rules.add(wordRule);

        IRule[] result= new IRule[rules.size()];
        rules.toArray(result);
        setRules(result);
    }
}
