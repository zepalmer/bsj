package edu.jhu.cs.bsj.eclipse.editor;

import org.eclipse.ui.editors.text.TextEditor;

import edu.jhu.cs.bsj.eclipse.text.BSJSourceViewerConfiguration;

public class BSJEditor extends TextEditor {
	
	public BSJEditor() {
		setSourceViewerConfiguration(new BSJSourceViewerConfiguration());
		setDocumentProvider(new BSJDocumentProvider());
	}
	
	public void dispose() {
		super.dispose();
	}
	
}
