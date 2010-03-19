package edu.jhu.cs.bsj.plugin.editor;

import org.eclipse.ui.editors.text.TextEditor;

public class BsjEditor extends TextEditor {

	private BsjColorProvider colorProvider;

	public BsjEditor() 
	{
		super();
		colorProvider = new BsjColorProvider();
		setSourceViewerConfiguration(new BsjConfiguration(colorProvider));
		setDocumentProvider(new BsjDocumentProvider());
	}
	
	public void dispose() 
	{
	    colorProvider.dispose();
		super.dispose();
	}

}
