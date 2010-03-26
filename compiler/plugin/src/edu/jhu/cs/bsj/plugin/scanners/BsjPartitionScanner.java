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

public class BsjPartitionScanner extends RuleBasedPartitionScanner 
{
    // three partitions for a document: multi-line comments, javadocs, and metaprograms
    // normal (non-meta) code is the default
    public final static String JAVA_MULTILINE_COMMENT = "__java_multiline_comment";
    public final static String JAVA_DOC = "__java_javadoc";
    //public final static String META_PROGRAM = "__meta";
    
    public BsjPartitionScanner() 
    {
        super();

        // define tokens for documen partitions
        IToken javaDoc = new Token(JAVA_DOC);
        IToken comment = new Token(JAVA_MULTILINE_COMMENT);
        //IToken meta = new Token(META_PROGRAM);
        
        List<IRule> rules = new ArrayList<IRule>();

        // Add rule for single line comments.
        rules.add(new EndOfLineRule("//", Token.UNDEFINED));

        // Add rule for strings and character constants.
        rules.add(new SingleLineRule("\"", "\"", Token.UNDEFINED, '\\'));
        rules.add(new SingleLineRule("'", "'", Token.UNDEFINED, '\\'));

        // Add special case word rule.
        rules.add(new WordPredicateRule(comment));

        // Add rules for multi-line comments and javadoc.
        rules.add(new MultiLineRule("/**", "*/", javaDoc, (char) 0, true));
        rules.add(new MultiLineRule("/*", "*/", comment, (char) 0, true));
        
        // Add rules for meta programs
        //rules.add(new MultiLineRule("[:", ":]", meta, (char) 0, true));
        //rules.add(new EndOfLineRule("@@", meta));
        
        IPredicateRule[] result= new IPredicateRule[rules.size()];
        rules.toArray(result);
        setPredicateRules(result);
    }    
    
    /**
     * Detector for empty comments.
     */
    static class EmptyCommentDetector implements IWordDetector 
    {
        /* (non-Javadoc)
        * Method declared on IWordDetector
        */
        @Override
        public boolean isWordStart(char c) 
        {
            return (c == '/');
        }

        /* (non-Javadoc)
        * Method declared on IWordDetector
        */
        @Override
        public boolean isWordPart(char c) 
        {
            return (c == '*' || c == '/');
        }
    }

    /**
     * Rule for special comment case.
     */
    static class WordPredicateRule extends WordRule implements IPredicateRule
    {
        private IToken fSuccessToken;

        public WordPredicateRule(IToken successToken)
        {
            super(new EmptyCommentDetector());
            fSuccessToken = successToken;
            addWord("/**/", fSuccessToken);
        }

        /*
         * @see
         * org.eclipse.jface.text.rules.IPredicateRule#evaluate(ICharacterScanner
         * , boolean)
         */
        @Override
        public IToken evaluate(ICharacterScanner scanner, boolean resume)
        {
            return super.evaluate(scanner);
        }

        /*
         * @see org.eclipse.jface.text.rules.IPredicateRule#getSuccessToken()
         */
        @Override
        public IToken getSuccessToken()
        {
            return fSuccessToken;
        }
    }
}
