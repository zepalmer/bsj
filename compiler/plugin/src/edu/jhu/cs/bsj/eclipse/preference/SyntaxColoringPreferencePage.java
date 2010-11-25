package edu.jhu.cs.bsj.eclipse.preference;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import edu.jhu.cs.bsj.eclipse.BSJPlugin;

public class SyntaxColoringPreferencePage
	extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	
	public SyntaxColoringPreferencePage() {
		setPreferenceStore(BSJPlugin.getDefault().getPreferenceStore());
	}
	
	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createFieldEditors() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void performDefaults() {
		// TODO Auto-generated method stub
		super.performDefaults();
	}
	
	@Override
	public boolean performOk() {
		// TODO Auto-generated method stub
		return super.performOk();
	}
}
