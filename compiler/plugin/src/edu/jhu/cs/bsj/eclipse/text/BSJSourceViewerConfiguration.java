package edu.jhu.cs.bsj.eclipse.text;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

import edu.jhu.cs.bsj.eclipse.BSJPlugin;
import edu.jhu.cs.bsj.eclipse.text.scanners.AbstractBSJScanner;
import edu.jhu.cs.bsj.eclipse.text.scanners.BSJCodeScanner;
import edu.jhu.cs.bsj.eclipse.util.IColorManager;

public class BSJSourceViewerConfiguration extends SourceViewerConfiguration {
	
	private IColorManager colorManager;
	private IPreferenceStore preferenceStore;
	
	private AbstractBSJScanner codeScanner;
	private AbstractBSJScanner multiLineCommentScanner;
	private AbstractBSJScanner singleLineCommentScanner;
	private AbstractBSJScanner stringScanner;
	private AbstractBSJScanner javadocScanner;
	
	public BSJSourceViewerConfiguration() {
		initColorManager();
		initPreferenceStore();
		initScanners();
	}
	
	protected void initColorManager() {
		colorManager = BSJPlugin.getDefault().getColorManager();
	}
	
	protected void initPreferenceStore() {
		preferenceStore = BSJPlugin.getDefault().getPreferenceStore();	
	}
	
	protected void initScanners() {
		codeScanner = new BSJCodeScanner(colorManager, preferenceStore);
	}
	
	protected IColorManager getColorManager() {
		return colorManager;
	}
	
	protected AbstractBSJScanner getCodeScanner() {
		return codeScanner;
	}

	protected AbstractBSJScanner getMultiLineCommentScanner() {
		return multiLineCommentScanner;
	}

	protected AbstractBSJScanner getSingleLineCommentScanner() {
		return singleLineCommentScanner;
	}

	protected AbstractBSJScanner getStringScanner() {
		return stringScanner;
	}

	protected AbstractBSJScanner getJavadocScanner() {
		return javadocScanner;
	}
	
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {	
		PresentationReconciler reconciler = new PresentationReconciler();
		
		DefaultDamagerRepairer dr= new DefaultDamagerRepairer(getCodeScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
		
		return reconciler;
	}
}
