package edu.jhu.cs.bsj.eclipse.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

import edu.jhu.cs.bsj.eclipse.text.BSJPartitionScanner;

/**
 * Creates the BSJ Document Model
 */
public class BSJDocumentProvider extends FileDocumentProvider{
	
	protected IDocument createDocument(Object element) throws CoreException {
		IDocument document = super.createDocument(element);
		
		// Set up the code partitioner
		if (document != null) {
			IDocumentPartitioner partitioner =
				new FastPartitioner(
					new BSJPartitionScanner(),
					BSJPartitionScanner.BSJ_PARTITION_TYPES);
			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
		}
		
		return document;
	}
}
