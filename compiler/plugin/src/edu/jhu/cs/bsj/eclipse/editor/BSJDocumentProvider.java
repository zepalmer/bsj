package edu.jhu.cs.bsj.eclipse.editor;

import junk.BSJPartitionScanner;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;


/**
 * Creates the BSJ Document Model
 */
public class BSJDocumentProvider extends FileDocumentProvider{
	
	protected IDocument createDocument(Object element) throws CoreException {
		IDocument document = super.createDocument(element);
		
		if (document != null) {
			setupCodePartitioner(document);
		}
		
		return document;
	}
	
	protected void setupCodePartitioner(IDocument document) {
		IDocumentPartitioner partitioner =
			new FastPartitioner(
				new BSJPartitionScanner(),
				BSJPartitionScanner.BSJ_PARTITION_TYPES);
		partitioner.connect(document);
		document.setDocumentPartitioner(partitioner);
	}
	
}
