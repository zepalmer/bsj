package edu.jhu.cs.bsj.eclipse.preference;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import edu.jhu.cs.bsj.eclipse.BSJPlugin;

public class EditorPreferencePage 
	extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	
	public EditorPreferencePage() {
		setPreferenceStore(BSJPlugin.getDefault().getPreferenceStore());
		setDescription("editor decription put here");
	}
	
	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createFieldEditors() {
		// TODO Auto-generated method stub
		
	}

}
