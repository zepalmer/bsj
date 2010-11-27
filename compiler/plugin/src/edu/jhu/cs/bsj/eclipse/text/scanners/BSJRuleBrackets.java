package edu.jhu.cs.bsj.eclipse.text.scanners;

import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.WordRule;

public class BSJRuleBrackets extends WordRule {
	
	private IToken javaBracketToken;
	private IToken bsjBracketToken;

	public BSJRuleBrackets(IToken javaBracketToken, IToken bsjBracketToken) {
		super(new IWordDetector() {
			@Override
			public boolean isWordStart(char c) {
				return c=='(' || c==')' || c=='{' || c=='}' || c=='[' || c==']' 
					|| c==':' || c=='~' || c=='<';
			}
			@Override
			public boolean isWordPart(char c) {
				return c==':' || c==']' || c=='>' || c=='~';
			}
		});
		
		this.javaBracketToken = javaBracketToken;
		this.bsjBracketToken = bsjBracketToken;
		
		createBrackets();
	}
	
	private void createBrackets() {
		addWord("[:", bsjBracketToken);
		addWord(":]", bsjBracketToken);
		addWord("<:", bsjBracketToken);
		addWord(":>", bsjBracketToken);
		addWord("~:", bsjBracketToken);
		addWord(":~", bsjBracketToken);
		
		addWord("(", javaBracketToken);
		addWord(")", javaBracketToken);
		addWord("{", javaBracketToken);
		addWord("}", javaBracketToken);
		addWord("[", javaBracketToken);
		addWord("]", javaBracketToken);
	}
}
