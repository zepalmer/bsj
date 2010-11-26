package edu.jhu.cs.bsj.eclipse.text;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

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
	
	private static class SingleTokenScanner extends BufferedRuleBasedScanner {
		public SingleTokenScanner(TextAttribute attribute) {
			setDefaultReturnToken(new Token(attribute));
		}
	}
	
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {	
		PresentationReconciler reconciler = new PresentationReconciler();
		
		DefaultDamagerRepairer dr= new DefaultDamagerRepairer(getCodeScanner());
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
		
		dr = new DefaultDamagerRepairer(new SingleTokenScanner(
				new TextAttribute(new Color(Display.getCurrent(), new RGB(0,0,100)))));
		reconciler.setDamager(dr, BSJPartitionConstants.BSJ_JAVADOC);
		reconciler.setRepairer(dr, BSJPartitionConstants.BSJ_JAVADOC);
		
		dr = new DefaultDamagerRepairer(new SingleTokenScanner(
				new TextAttribute(new Color(Display.getCurrent(), new RGB(0,100,0)))));
		reconciler.setDamager(dr, BSJPartitionConstants.BSJ_MULTILINE_COMMENT);
		reconciler.setRepairer(dr, BSJPartitionConstants.BSJ_MULTILINE_COMMENT);
		
		return reconciler;
	}
}
