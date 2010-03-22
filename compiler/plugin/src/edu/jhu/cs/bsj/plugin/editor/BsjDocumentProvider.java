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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

import edu.jhu.cs.bsj.plugin.scanners.BsjPartitionScanner;


public class BsjDocumentProvider extends FileDocumentProvider 
{

	protected IDocument createDocument(Object element) throws CoreException 
	{
		IDocument document = super.createDocument(element);
		if (document != null) 
		{
			IDocumentPartitioner partitioner =
				new FastPartitioner(
					new BsjPartitionScanner(),
					new String[] {
						BsjPartitionScanner.JAVA_DOC,
						BsjPartitionScanner.JAVA_MULTILINE_COMMENT,
						BsjPartitionScanner.META_PROGRAM});
			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
		}
		return document;
	}
}