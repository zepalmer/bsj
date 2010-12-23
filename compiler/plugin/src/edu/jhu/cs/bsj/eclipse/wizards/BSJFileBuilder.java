package edu.jhu.cs.bsj.eclipse.wizards;

import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.IStructuredSelection;

import edu.jhu.cs.bsj.eclipse.builder.BSJBuilderConfig;

public abstract class BSJFileBuilder extends BSJAbstractBuilder {
	private IPath sourcePath;
	private String packageName = "";
	private String extension = "";
	private String fileType = "";
	
	/**
	 * Extract the the given package name from the selection
	 * @param structSelection the selection
	 * @return a package name
	 */
	public static String extractPackageName(IStructuredSelection structSelection) {
		Object element = structSelection.getFirstElement();
		if(element instanceof IResource) {
			IResource resource = (IResource)element;
			IProject project = (resource.getProject());
			BSJBuilderConfig bsjConfig = new BSJBuilderConfig(project);
			IPath srcPath = bsjConfig.getSourcePath();
			IPath resrcPath = resource.getLocation();
			String pack = resrcPath.makeRelativeTo(srcPath).toString();
			if(pack.startsWith("/"))
				pack = pack.substring(1);
			if(pack.endsWith("/"))
				pack = pack.substring(0,pack.length()-1);
			pack = pack.replaceAll("/", ".");
			return pack;
		}
		return "";
	}
	
	public IPath getSourcePath() {
		return sourcePath;
	}
	
	public void setSourcePath(IPath sourcePath) {
		this.sourcePath = sourcePath;
	}
	
	public String getPackageName() {
		return packageName;
	}
	
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public String getExtension() {
		return extension;
	}
	
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public String getFileType() {
		return fileType;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	// the following methods are subject to removal
	// ------------------------------------------------------------------------
	protected void writePackage(FileWriter writer, String pack) throws IOException {
		writer.write("package" + pack);
	}
	
	protected void writeImport(FileWriter writer, String impr) throws IOException {
		writer.write("package" + impr);
	}
	
	protected void writeTypeDeclr(FileWriter writer, String type) throws IOException {
		writer.write("public class " + type);
	}
	
	protected void writeExtends(FileWriter writer, String[] exts) throws IOException {
		
	}
	
	protected void writeImplements(FileWriter writer, String[] impls) throws IOException {
		
	}
	
	protected void writeMethodDeclr(FileWriter writer) throws IOException {
		
	}
	
	protected void writeOpenParen(FileWriter writer) throws IOException {
		writer.write("{");
	}
	
	protected void writeCloseParen(FileWriter writer) throws IOException {
		writer.write("}");
	}
	
	protected void writeNewLine(FileWriter writer) throws IOException {
		writer.write("\n");
	}
	// ------------------------------------------------------------------------
}
