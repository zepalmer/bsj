package edu.jhu.cs.bsj.plugin.eclipse.editor;

import org.eclipse.ui.editors.text.TextEditor;

public class BSJEditor extends TextEditor {
	
	public BSJEditor() {
		setSourceViewerConfiguration(new BSJSourceViewerConfiguration());
		setDocumentProvider(new BSJDocumentProvider());
	}
	
	public void dispose() {
		super.dispose();
	}
	
}
