package edu.jhu.cs.bsj.eclipse.text;

import org.eclipse.jdt.ui.text.IJavaColorConstants;

/**
 * Token keys are used to access color and text properties associated with the token.
 */
public interface BSJTokenKeys extends IJavaColorConstants {
	String BSJ_KEYWORD = "bsj_keyword";
	String BSJ_BRACKET = "bsj_bracket";
	String BSJ_ANNOTATION = "bsj_annotation";
}
