package edu.jhu.cs.bsj.plugin.eclipse.editor;

import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class BSJSourceViewerConfiguration extends SourceViewerConfiguration {
	public BSJSourceViewerConfiguration() {
	}
	
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler= new PresentationReconciler();
		
		return reconciler;
	}
}
