package edu.jhu.cs.bsj.plugin.eclipse.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

import edu.jhu.cs.bsj.plugin.eclipse.codepartition.BSJPartitionScanner;

/**
 * Creates the BSJ Document Model
 */
public class BSJDocumentProvider extends FileDocumentProvider{
	/**
	 * Set up the code partitioner
	 */
	protected IDocument createDocument(Object element) throws CoreException {
		IDocument document = super.createDocument(element);
		
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
