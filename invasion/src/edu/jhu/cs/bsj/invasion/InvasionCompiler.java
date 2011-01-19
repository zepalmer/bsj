package edu.jhu.cs.bsj.invasion;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.tool.BsjCompiler;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManagerFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

public class InvasionCompiler {

	public static void main(String[] args) throws Throwable {
		StringBuilder sb = new StringBuilder();
		for (File f : new File("BSJSource").listFiles()) {
			if (sb.length() > 0)
				sb.append(File.pathSeparator);
			sb.append(f.getPath() + File.separator + "src");
		}

		BsjFileManagerFactory fileManagerFactory = BsjServiceRegistry.getInstance().newFileManagerFactory();
		fileManagerFactory.setLocationManager(
				BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH,
				System.getProperty("sun.boot.class.path"));
		fileManagerFactory.setLocationManager(
				BsjCompilerLocation.METAPROGRAM_CLASSPATH,
				System.getProperty("java.class.path"));
		fileManagerFactory.setLocationManager(
				BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH,
				System.getProperty("java.class.path"));
		fileManagerFactory.setLocationManager(
				BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH,
				System.getProperty("sun.boot.class.path"));
		fileManagerFactory.setLocationManager(BsjCompilerLocation.SOURCE_PATH,
				sb.toString());
		createAndSetDirectoryLocationManager(fileManagerFactory,
				BsjCompilerLocation.GENERATED_SOURCE_PATH, "local"
						+ File.separator + "gensrc");
		createAndSetDirectoryLocationManager(fileManagerFactory,
				BsjCompilerLocation.CLASS_OUTPUT, "local" + File.separator
						+ "bin");

		BsjFileManager fileManager = fileManagerFactory.newFileManager();
		Iterable<? extends BsjFileObject> it = fileManager.getLocationManager(
				BsjCompilerLocation.SOURCE_PATH).listFiles("",
				Collections.singleton(JavaFileObject.Kind.OTHER), true);

		BsjToolkitFactory toolkitFactory = BsjServiceRegistry.getInstance()
				.newToolkitFactory();
		toolkitFactory.setFileManager(fileManager);
		BsjToolkit toolkit = toolkitFactory.newToolkit();

		BsjCompiler compiler = toolkit.getCompiler();
		compiler.compile(it, new DiagnosticListener<BsjSourceLocation>() {

			@Override
			public void report(
					Diagnostic<? extends BsjSourceLocation> diagnostic) {
				System.out.println(diagnostic.getMessage(null));
			}

		});
	}

	private static void createAndSetDirectoryLocationManager(
			BsjFileManagerFactory fileManagerFactory,
			BsjCompilerLocation location, String path) throws IOException {
		File dir = new File(path);
		rmdir(dir);
		dir.mkdirs();
		fileManagerFactory.setLocationManager(location, path);
	}

	private static void rmdir(File f) {
		if (f.isDirectory()) {
			for (File ff : f.listFiles()) {
				rmdir(ff);
			}
		}
		f.delete();
	}
}
