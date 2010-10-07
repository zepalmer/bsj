package edu.jhu.cs.bsj.plugin.eclipse.text;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;

/**
 * 
 * @author luwei
 *
 */
public class BSJKeywordRule extends WordRule {
	
	public BSJKeywordRule(IWordDetector wd) {
		super(wd);
	}
	
	@Override
	public IToken evaluate(ICharacterScanner scanner) {
		char c = (char)scanner.read();
		if(c!='#') {
			scanner.unread();
			return Token.UNDEFINED;
		}
		
		int count = 1;
		do {
			c = (char)scanner.read();
			count++;
		} while(Character.isWhitespace(c));
		scanner.unread();
		count--;
		
		IToken token = super.evaluate(scanner);
		if(token.isUndefined()) {
			for(int i=0; i<count; i++)
				scanner.unread();
			return token;
		}
		return token;
	}
	
	/*
	@Override
	public IToken evaluate(ICharacterScanner scanner) {
		String text = "";
		char c;
		
		c = (char)scanner.read();
		if(c!='#') {
			scanner.unread();
			return Token.UNDEFINED;
		}
		text += c;
		
		do {
			c = (char)scanner.read();
			text += c;
		} while (Character.isWhitespace(c));
		
		do {
			c = (char)scanner.read();
			text += c;
		} while (!Character.isWhitespace(c));
		
		String derivedKeyword = text.replaceAll(" ", "");
		
		System.out.println(derivedKeyword);
		
		if(derivedKeyword.equals(keyword)) {
			scanner.unread();
			return token;
		} else {
			int count = text.length();
			for(int i=0; i<count; i++)
				scanner.unread();
			return Token.UNDEFINED;
		}
	}
	*/
	
}
