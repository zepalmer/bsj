package edu.jhu.cs.bsj.plugin.scanners;


import org.eclipse.jface.text.rules.IWordDetector;

/**
 * A meta programming word detector.
 */
public class MetaWordDetector implements IWordDetector 
{
	public boolean isWordStart(char c) 
	{
		return (c == '#' || c == '[' || c == ':' || c == '@');
	}
	
    public boolean isWordPart(char c) 
    {
        return (Character.isLetter(c) || c == ':' || c == ']' || c == '@');
    }
}
