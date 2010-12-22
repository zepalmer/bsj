package edu.jhu.cs.bsj.eclipse.wizards;

import java.net.URI;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Abstract parent for creating a resource
 */
public abstract class BSJAbstractBuilder {
	private String name;
	private URI location;
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

	public URI getLocation() {
		return location;
	}

	public void setLocation(URI location) {
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
		IContainer parent = folder.getParent();
		if (parent instanceof IFolder) {
			createFolder((IFolder) parent, monitor);
		}
		if (!folder.exists()) {
			folder.create(false, true, monitor);
		}
	}
}
