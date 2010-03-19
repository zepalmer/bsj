package edu.jhu.cs.bsj.plugin.scanners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

import edu.jhu.cs.bsj.plugin.editor.BsjColorProvider;


public class JavadocScanner extends RuleBasedScanner 
{
    private static String[] fgKeywords= { 
        "@author", "@deprecated", "@exception", "@param", "@return", 
        "@see", "@serial", "@serialData", "@serialField", "@since", 
        "@throws", "@version" };

    /**
     * Create a new javadoc scanner for the given color provider.
     *
     * @param provider the color provider
     */
     public JavadocScanner(BsjColorProvider provider) {
        super();

        IToken keyword= new Token(new TextAttribute(provider.getColor(BsjColorProvider.JAVADOC_KEYWORD)));
        IToken tag= new Token(new TextAttribute(provider.getColor(BsjColorProvider.JAVADOC_TAG)));
        IToken link= new Token(new TextAttribute(provider.getColor(BsjColorProvider.JAVADOC_LINK)));

        List<IRule> list= new ArrayList<IRule>();

        // Add rule for tags.
        list.add(new SingleLineRule("<", ">", tag));

        // Add rule for links.
        list.add(new SingleLineRule("{", "}", link));

        // Add generic whitespace rule.
        list.add(new WhitespaceRule(new JavaWhitespaceDetector()));

        // Add word rule for keywords.
        WordRule wordRule= new WordRule(new JavaDocWordDetector());
        for (int i= 0; i < fgKeywords.length; i++)
            wordRule.addWord(fgKeywords[i], keyword);
        list.add(wordRule);

        IRule[] result= new IRule[list.size()];
        list.toArray(result);
        setRules(result);
    }
     
     /**
      * A key word detector.
      */
     static class JavaDocWordDetector implements IWordDetector {

     /* (non-Javadoc)
      * Method declared on IWordDetector
      */
         @Override
         public boolean isWordStart(char c) {
             return (c == '@');
         }

         /* (non-Javadoc)
         * Method declared on IWordDetector
         */
         @Override
         public boolean isWordPart(char c) {
             return Character.isLetter(c);
         }
     }
}
