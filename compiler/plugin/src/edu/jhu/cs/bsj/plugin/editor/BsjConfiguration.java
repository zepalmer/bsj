/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     
 * Modified by Zachary Palmer and Joseph Riley for Backstage Java
 *******************************************************************************/

package edu.jhu.cs.bsj.plugin.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

import edu.jhu.cs.bsj.plugin.scanners.BsjPartitionScanner;
import edu.jhu.cs.bsj.plugin.scanners.BsjCodeScanner;
import edu.jhu.cs.bsj.plugin.scanners.JavadocScanner;


public class BsjConfiguration extends SourceViewerConfiguration
{
    private BsjDoubleClickStrategy doubleClickStrategy;
    private JavadocScanner tagScanner;
    private BsjCodeScanner scanner;
    private BsjColorProvider colorProvider;

    public BsjConfiguration(BsjColorProvider colorManager)
    {
        this.colorProvider = colorManager;
    }

    public String[] getConfiguredContentTypes(ISourceViewer sourceViewer)
    {
        return new String[] { 
                IDocument.DEFAULT_CONTENT_TYPE,
                BsjPartitionScanner.JAVA_DOC, 
                BsjPartitionScanner.JAVA_MULTILINE_COMMENT,
                BsjPartitionScanner.META_PROGRAM};
    }

    public ITextDoubleClickStrategy getDoubleClickStrategy(
            ISourceViewer sourceViewer, String contentType)
    {
        if (doubleClickStrategy == null)
        {
            doubleClickStrategy = new BsjDoubleClickStrategy();
        }
        return doubleClickStrategy;
    }

    protected BsjCodeScanner getBsjScanner()
    {
        if (scanner == null)
        {
            scanner = new BsjCodeScanner(new BsjColorProvider());
            scanner.setDefaultReturnToken(new Token(new TextAttribute(
                    colorProvider.getColor(BsjColorProvider.DEFAULT))));
        }
        return scanner;
    }

    protected JavadocScanner getJavadocScanner()
    {
        if (tagScanner == null)
        {
            tagScanner = new JavadocScanner(colorProvider);
            tagScanner.setDefaultReturnToken(new Token(new TextAttribute(
                    colorProvider.getColor(BsjColorProvider.JAVADOC_DEFAULT))));
        }
        return tagScanner;
    }

    public IPresentationReconciler getPresentationReconciler(
            ISourceViewer sourceViewer)
    {
        PresentationReconciler reconciler = new PresentationReconciler();

        // Javadoc scanner
        DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getJavadocScanner());
        reconciler.setDamager(dr, BsjPartitionScanner.JAVA_DOC);
        reconciler.setRepairer(dr, BsjPartitionScanner.JAVA_DOC);

        // BSJ code scanner
        dr = new DefaultDamagerRepairer(getBsjScanner());
        reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
        reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

        // Multi-line comment scanner
        dr = new DefaultDamagerRepairer(new SingleTokenScanner(
                new TextAttribute(
                        colorProvider.getColor(BsjColorProvider.MULTI_LINE_COMMENT))));
        reconciler.setDamager(dr, BsjPartitionScanner.JAVA_MULTILINE_COMMENT);
        reconciler.setRepairer(dr, BsjPartitionScanner.JAVA_MULTILINE_COMMENT);
        
        //TODO remove
        dr = new DefaultDamagerRepairer(new SingleTokenScanner(
                new TextAttribute(
                        colorProvider.getColor(BsjColorProvider.META_PROGRAM))));
        reconciler.setDamager(dr, BsjPartitionScanner.META_PROGRAM);
        reconciler.setRepairer(dr, BsjPartitionScanner.META_PROGRAM);
        
        return reconciler;
    }
    
    /**
     * Single token scanner.
     */
    static class SingleTokenScanner extends BufferedRuleBasedScanner
    {
        public SingleTokenScanner(TextAttribute attribute)
        {
            setDefaultReturnToken(new Token(attribute));
        }
    }

}