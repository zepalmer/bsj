package edu.jhu.cs.bsj.eclipse.wizards;

import java.net.URI;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import edu.jhu.cs.bsj.eclipse.builder.BSJNature;

/**
 * Assist creating BSJ projects and files
 */
public class BSJCreationUtilities {
	private BSJCreationUtilities() {
	}
	
	/**
	 * Creates a bsj project with the bsj nature
	 * @param projectName
	 * @param projectLocation
	 * @return a bsj project
	 */
	public static IProject createProject(String projectName, URI projectLocation) {
		IProject project;
		
		try {
			project = createBaseProject(projectName, projectLocation);
			addNature(project);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		
		return project;
	}
	
	/**
	 * Creates a bsj project without the bsj nature
	 * @param projectName
	 * @param projectLocation
	 * @return a bsj project
	 * @throws CoreException
	 */
	public static IProject createBaseProject(String projectName, URI projectLocation) 
	throws CoreException {
		IProject newProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		
		if(!newProject.exists()) {
			IProjectDescription desc = newProject.getWorkspace().newProjectDescription(
					newProject.getName());
			if(projectLocation!=null && ResourcesPlugin.getWorkspace().getRoot()
					.getLocationURI().equals(projectLocation)) {
				desc.setLocationURI(null);
			} else {
				// null location is the default location
				desc.setLocationURI(projectLocation);
			}
			newProject.create(desc, null);
			if(!newProject.isOpen()) {
				newProject.open(null);
			}
			createProjectStructure(newProject);
		}
		
		return newProject;
	}
	
	/**
	 * Creates a bsj project's internal structure
	 */
	private static void createProjectStructure(IProject project) 
	throws CoreException {
		IFolder folder ;
		
		folder = project.getFolder("src");
		createFolder(folder);
		
		folder = project.getFolder("BSJ System Library");
		createFolder(folder);
	}
	
	/**
	 * Creates a folder, creating its parent if necessary
	 */
	private static void createFolder(IFolder folder)
	throws CoreException  {
		IContainer parent = folder.getParent();
		if (parent instanceof IFolder) {
			createFolder((IFolder) parent);
		}
		if (!folder.exists()) {
			folder.create(false, true, null);
		}
	}
	
	/**
	 * Adds the bsj nature to the given project
	 * @param project
	 * @throws CoreException
	 */
	public static void addNature(IProject project) 
	throws CoreException {
		if (!project.hasNature(BSJNature.NATURE_ID)) {
			IProjectDescription description = project.getDescription();
			String[] prevNatures = description.getNatureIds();
			String[] newNatures = new String[prevNatures.length + 1];
			System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
			newNatures[prevNatures.length] = BSJNature.NATURE_ID;
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
		}
	}
}
