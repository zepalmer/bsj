package edu.jhu.cs.bsj.plugin.eclipse.editor;

import org.eclipse.ui.editors.text.TextEditor;

public class BSJEditor extends TextEditor {
	@Override
	protected void initializeEditor() {
		super.initializeEditor();
		setSourceViewerConfiguration(new BSJSourceViewerConfiguration());
	}
}
