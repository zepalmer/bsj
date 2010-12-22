package edu.jhu.cs.bsj.eclipse.builder;

import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;

/**
 * Visit and accumulate all bsj and java files that need compiling
 */
public class BSJSourceFileDeltaVisitor implements IResourceDeltaVisitor {
	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		// TODO: part incremental builder
		return false;
	}
}
