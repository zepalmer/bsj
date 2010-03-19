package edu.jhu.cs.bsj.plugin.scanners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.*;

public class BsjPartitionScanner extends RuleBasedPartitionScanner 
{
    public final static String JAVA_MULTILINE_COMMENT = "__java_multiline_comment";
    public final static String JAVA_DOC = "__java_javadoc";
    
    public BsjPartitionScanner() 
    {
        super();

        IToken javaDoc= new Token(JAVA_DOC);
        IToken comment= new Token(JAVA_MULTILINE_COMMENT);

        List<IRule> rules= new ArrayList<IRule>();

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
    *
    */
   static class WordPredicateRule extends WordRule implements IPredicateRule 
   {
       private IToken fSuccessToken;

       public WordPredicateRule(IToken successToken) 
       {
           super(new EmptyCommentDetector());
           fSuccessToken= successToken;
           addWord("/**/", fSuccessToken); //$NON-NLS-1$
       }

       /*
        * @see org.eclipse.jface.text.rules.IPredicateRule#evaluate(ICharacterScanner, boolean)
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
