package edu.jhu.cs.bsj.plugin.eclipse.editor;

import org.eclipse.core.filebuffers.IDocumentSetupParticipant;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;

import edu.jhu.cs.bsj.plugin.eclipse.text.BSJPartitionScanner;

/**
 * Set up the code partitioner
 * This doesn't work
 * @author luwei
 */
public class BSJDocumentSetupParticipant implements IDocumentSetupParticipant {

	@Override
	public void setup(IDocument document) {	
		if (document instanceof IDocumentExtension3) {
			IDocumentExtension3 extension3 = (IDocumentExtension3)document;
			IDocumentPartitioner partitioner = new FastPartitioner(
					new BSJPartitionScanner(), BSJPartitionScanner.BSJ_PARTITION_TYPES);
			extension3.setDocumentPartitioner("__bsj_partitioning", partitioner);
			partitioner.connect(document);
		}
	}
}
