package edu.jhu.cs.bsj.plugin.eclipse.editor;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
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

import edu.jhu.cs.bsj.plugin.eclipse.text.BSJMetaprogramScanner;
import edu.jhu.cs.bsj.plugin.eclipse.text.BSJPartitionConstants;
import edu.jhu.cs.bsj.plugin.eclipse.text.JavaCodeScanner;
import edu.jhu.cs.bsj.plugin.eclipse.util.ColorManager;

public class BSJSourceViewerConfiguration extends SourceViewerConfiguration {
	
	public BSJSourceViewerConfiguration() {
	}
	
	private static class SingleTokenScanner extends BufferedRuleBasedScanner {
		public SingleTokenScanner(TextAttribute attribute) {
			setDefaultReturnToken(new Token(attribute));
		}
	}
	
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();
		DefaultDamagerRepairer dr;
		
		dr = new DefaultDamagerRepairer(new JavaCodeScanner(new ColorManager()));
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
		
		dr = new DefaultDamagerRepairer(new SingleTokenScanner(
				new TextAttribute(new Color(Display.getCurrent(), new RGB(0,100,0)))));
		reconciler.setDamager(dr, BSJPartitionConstants.JAVA_MULTILINE_COMMENT);
		reconciler.setRepairer(dr, BSJPartitionConstants.JAVA_MULTILINE_COMMENT);
		
		dr = new DefaultDamagerRepairer(new SingleTokenScanner(
				new TextAttribute(new Color(Display.getCurrent(), new RGB(0,0,100)))));
		reconciler.setDamager(dr, BSJPartitionConstants.JAVA_JAVADOC);
		reconciler.setRepairer(dr, BSJPartitionConstants.JAVA_JAVADOC);
		
		dr = new DefaultDamagerRepairer(new BSJMetaprogramScanner(new ColorManager())) {
			@Override
			public IRegion getDamageRegion(ITypedRegion partition,
					DocumentEvent e, boolean documentPartitioningChanged) {
				return super.getDamageRegion(partition, e, true);
			}
		};
		reconciler.setDamager(dr, BSJPartitionConstants.BSJ_METAPROGRAM);
		reconciler.setRepairer(dr, BSJPartitionConstants.BSJ_METAPROGRAM);
		
		return reconciler;
	}
}
