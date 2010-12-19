package edu.jhu.cs.bsj.eclipse.builder;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class BSJBuilder extends IncrementalProjectBuilder {

	public BSJBuilder() {
	}
	
	@Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) 
	throws CoreException {
		switch(kind) {
			case FULL_BUILD:
				fullBuild(monitor); break;
			case INCREMENTAL_BUILD:
				incrementalBuild(monitor); break;
			case CLEAN_BUILD:
				cleanBuild(monitor); break;
			default:
				autoBuild(monitor);
		}
		return null;
	}
	
	protected void fullBuild(final IProgressMonitor monitor) 
	throws CoreException {
		BSJResourceVisitor vistor = new BSJResourceVisitor();
		getProject().accept(vistor);
	}
	
	protected void incrementalBuild(final IProgressMonitor monitor) 
	throws CoreException {
		//TODO get incremental build to work
		fullBuild(monitor);
	}
	
	protected void cleanBuild(final IProgressMonitor monitor) 
	throws CoreException {
	}
	
	protected void autoBuild(final IProgressMonitor monitor) 
	throws CoreException {
		incrementalBuild(monitor);
	}
	
	protected class BSJResourceVisitor implements IResourceVisitor {
		@Override
		public boolean visit(IResource resource) throws CoreException {
			return false;
		}
	}
	
	protected class BSJDeltaVisitor implements IResourceDeltaVisitor {
		@Override
		public boolean visit(IResourceDelta delta) throws CoreException {
			return false;
		}
	}
}
