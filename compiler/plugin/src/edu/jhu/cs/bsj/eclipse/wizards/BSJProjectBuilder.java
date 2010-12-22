package edu.jhu.cs.bsj.eclipse.wizards;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import edu.jhu.cs.bsj.eclipse.builder.BSJNature;

/**
 * Creates a bsj project with a bsj nature
 */
public class BSJProjectBuilder extends BSJAbstractBuilder {
	
	@Override
	public IResource build() {
		IProject project;
		
		try {
			project = createBaseProject();
			addNature(project);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		
		return project;
	}
	
	public IProject createBaseProject() 
	throws CoreException {
		IProject newProject = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(getName());
		
		if(!newProject.exists()) {
			IProjectDescription desc = newProject.getWorkspace().newProjectDescription(
					newProject.getName());
			if(getLocation()!=null && ResourcesPlugin.getWorkspace().getRoot()
					.getLocationURI().equals(getLocation())) {
				desc.setLocationURI(null);
			} else {
				desc.setLocationURI(getLocation());
			}
			newProject.create(desc, getProgressMonitor());
			if(!newProject.isOpen()) {
				newProject.open(getProgressMonitor());
			}
			createProjectStructure(newProject);
		}
		
		return newProject;
	}
	
	/**
	 * Creates a bsj project's internal structure
	 */
	protected void createProjectStructure(IProject project) 
	throws CoreException {
		IFolder folder ;
		
		folder = project.getFolder("src");
		createFolder(folder, getProgressMonitor());
		
		folder = project.getFolder("BSJ System Library");
		createFolder(folder, getProgressMonitor());
	}
	
	/**
	 * Adds the bsj nature to the given project
	 * @param project
	 * @throws CoreException
	 */
	protected void addNature(IProject project) 
	throws CoreException {
		if (!project.hasNature(BSJNature.NATURE_ID)) {
			IProjectDescription description = project.getDescription();
			String[] prevNatures = description.getNatureIds();
			String[] newNatures = new String[prevNatures.length + 1];
			System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
			newNatures[prevNatures.length] = BSJNature.NATURE_ID;
			description.setNatureIds(newNatures);
			project.setDescription(description, getProgressMonitor());
		}
	}
}
