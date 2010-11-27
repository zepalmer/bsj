package edu.jhu.cs.bsj.eclipse.editor;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
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
	
	public void invalidateTextPresentation() {
		ISourceViewer sourceViewer = getSourceViewer();
		if(sourceViewer!=null)
			sourceViewer.invalidateTextPresentation();
	}
	
	public ISourceViewer getOpenSourceViewer() {
		return getSourceViewer();
	}
	
	public SourceViewerConfiguration getOpenSourceViewerConfiguration() {
		return getSourceViewerConfiguration();
	}
}
