package edu.jhu.cs.bsj.eclipse.wizards;

import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.runtime.IPath;

public abstract class BSJFileBuilder extends BSJAbstractBuilder {
	private IPath sourcePath;
	private String packageName;
	private String extension;
	private String fileType;
	
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
