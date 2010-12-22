package edu.jhu.cs.bsj.eclipse.builder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * Visit and accumulate all bsj and java files
 */
public class BSJSourceFileVisitor implements IResourceVisitor {
	private BsjFileManager fileManager;
	private IFolder srcFolder;
	private List<BsjFileObject> sourceFiles;
	
	public BSJSourceFileVisitor(IFolder srcFolder, BsjFileManager fileManager) {
		this.srcFolder = srcFolder;
		this.fileManager = fileManager;
		this.sourceFiles = new ArrayList<BsjFileObject>();
	}
	
	@Override
	public boolean visit(IResource resource) throws CoreException {
		if(resource instanceof IFile) {
			String ext = resource.getFileExtension();
			if( ext!=null && (ext.equals("bsj") || ext.equals("java")) ) {
				String srcStr = srcFolder.getProjectRelativePath().toString();
				String fileStr = resource.getProjectRelativePath().toString();
				String fullName = fileStr.substring(srcStr.length());
				if(fullName.startsWith("/"))
					fullName = fullName.substring(1);
				
				String packageString;
				String filename;
				if(fullName.indexOf("/")!=-1) {
					int index = fullName.lastIndexOf('/');
					packageString = fullName.substring(0, index).replaceAll("/", ".");
					filename = fullName.substring(index + 1);
				} else {
					packageString = "";
					filename = fullName;
				}
				
				try {
					BsjFileObject bfo = fileManager.getFileForInput(
							BsjCompilerLocation.SOURCE_PATH, packageString, filename);
					sourceFiles.add(bfo);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return true;
	}

	public List<BsjFileObject> getSourceFiles() {
		return sourceFiles;
	}
}