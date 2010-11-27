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
import edu.jhu.cs.bsj.eclipse.text.scanners.BSJCommentScanner;
import edu.jhu.cs.bsj.eclipse.text.scanners.BSJJavaDocScanner;
import edu.jhu.cs.bsj.eclipse.text.scanners.BSJStringScanner;
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
		multiLineCommentScanner = new BSJCommentScanner(colorManager, preferenceStore, BSJTokenKeys.JAVA_MULTI_LINE_COMMENT);
		singleLineCommentScanner = new BSJCommentScanner(colorManager, preferenceStore, BSJTokenKeys.JAVA_SINGLE_LINE_COMMENT);
		stringScanner = new BSJStringScanner(colorManager, preferenceStore);
		javadocScanner = new BSJJavaDocScanner(colorManager, preferenceStore);
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
		
		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getCodeScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
		
		dr = new DefaultDamagerRepairer(getJavadocScanner());
		reconciler.setDamager(dr, BSJPartitionConstants.BSJ_JAVADOC);
		reconciler.setRepairer(dr, BSJPartitionConstants.BSJ_JAVADOC);
		
		dr = new DefaultDamagerRepairer(getMultiLineCommentScanner());
		reconciler.setDamager(dr, BSJPartitionConstants.BSJ_MULTILINE_COMMENT);
		reconciler.setRepairer(dr, BSJPartitionConstants.BSJ_MULTILINE_COMMENT);
		
		dr = new DefaultDamagerRepairer(getSingleLineCommentScanner());
		reconciler.setDamager(dr, BSJPartitionConstants.BSJ_SINGLELINE_COMMENT);
		reconciler.setRepairer(dr, BSJPartitionConstants.BSJ_SINGLELINE_COMMENT);
		
		dr = new DefaultDamagerRepairer(getStringScanner());
		reconciler.setDamager(dr, BSJPartitionConstants.BSJ_STRING);
		reconciler.setRepairer(dr, BSJPartitionConstants.BSJ_STRING);
		
		return reconciler;
	}
}
