package edu.jhu.cs.bsj.eclipse.text.scanners;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class BSJRuleJavaDocTag implements IRule {
	
	private IToken token;
	private IToken defaultToken;
	
	public BSJRuleJavaDocTag(IToken token, IToken defaultToken) {
		this.token = token;
		this.defaultToken = defaultToken;
	}
	
	@Override
	public IToken evaluate(ICharacterScanner scanner) {
		int c;
		
		c = scanner.read();
		if((char)c != '@') {
			scanner.unread();
			return Token.UNDEFINED;
		}
		
		int count = 1;
		while(true) {
			c = scanner.read();
			count++;
			if(!Character.isJavaIdentifierPart(c)) {
				break;
			}
		}
		
		if(!Character.isWhitespace(c)) {
			while( (c=scanner.read())!=ICharacterScanner.EOF 
					&& !Character.isWhitespace(c));
			scanner.unread();
			return defaultToken;
		} else if(count>=3){
			scanner.unread();
			return token;
		} else {
			scanner.unread();
			return defaultToken;
		}
	}
}
