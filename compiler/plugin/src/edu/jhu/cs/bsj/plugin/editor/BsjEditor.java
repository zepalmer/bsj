package edu.jhu.cs.bsj.plugin.editor;

import org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.ui.editors.text.TextEditor;

public class BsjEditor extends TextEditor {

	private BsjColorProvider colorProvider;

	public BsjEditor() 
	{
		super();
		colorProvider = new BsjColorProvider();
		setSourceViewerConfiguration(new BsjConfiguration(colorProvider));
		
//TODO build a decorator around JavaSourceViewerConfiguration to add functionality to it?		
//		JavaSourceViewerConfiguration jsvc = 
//		    new JavaSourceViewerConfiguration(
//		            colorProvider, 
//		            new PreferenceStore(), 
//		            this, 
//		            null);
//		setSourceViewerConfiguration(jsvc);
		
		setDocumentProvider(new BsjDocumentProvider());
	}
	
	public void dispose() 
	{
	    colorProvider.dispose();
		super.dispose();
	}

}
