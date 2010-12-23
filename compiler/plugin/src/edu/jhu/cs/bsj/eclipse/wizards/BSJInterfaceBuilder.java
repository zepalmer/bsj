package edu.jhu.cs.bsj.eclipse.wizards;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

public class BSJInterfaceBuilder extends BSJFileBuilder {
	
	@Override
	public IResource build() {
		IPath fileLoc = getLocation().append(getName())
			.addFileExtension(getExtension());
		IFile newFile = ResourcesPlugin.getWorkspace().getRoot()
			.getFile(fileLoc);
		
		if(newFile.exists()) {
			return newFile;
		}
		
		String content = "public interface " + getName() + " {\n\n}";
		InputStream contentStream = new ByteArrayInputStream(content.getBytes());
		try {
			newFile.create(contentStream, false, getProgressMonitor());
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		return newFile;
	}

}
