package edu.jhu.cs.bsj.eclipse.wizards;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

import edu.jhu.cs.bsj.eclipse.util.ResourceUtilities;

/**
 * Abstract parent for creating a resource
 * 
 * NOTE Has nothing to do BSJ Nature/Builder
 * 
 */
public abstract class BSJAbstractBuilder {
	private String name;
	private IPath location;
	private IProgressMonitor progressMonitor;
	
	/**
	 * Create a resource
	 * @return a file, project, etc
	 */
	public abstract IResource build();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IPath getLocation() {
		return location;
	}

	public void setLocation(IPath location) {
		this.location = location;
	}

	public IProgressMonitor getProgressMonitor() {
		return progressMonitor;
	}

	public void setProgressMonitor(IProgressMonitor progressMonitor) {
		this.progressMonitor = progressMonitor;
	}

	/**
	 * Creates a folder, creating its parent if necessary
	 * @param folder folder to create
	 * @throws CoreException if any error occurred
	 */
	public static void createFolder(IFolder folder, IProgressMonitor monitor)
	throws CoreException  {
		ResourceUtilities.createFolder(folder, monitor);
	}
}
