package edu.jhu.cs.bsj.eclipse.preference;

import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import edu.jhu.cs.bsj.eclipse.editor.BSJEditor;

public class SyntaxColoringPreferenceChangeListener implements
		IPreferenceChangeListener {

	@Override
	public void preferenceChange(PreferenceChangeEvent event) {
		IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
		for(int i=0; i<windows.length; i++) {
			IWorkbenchPage[] pages = windows[i].getPages();
			for(int j=0; j<pages.length; j++) {
				IEditorReference[] editorRefs = pages[j].getEditorReferences();
				for(int k=0; k<editorRefs.length; k++) {
					IEditorPart editor = editorRefs[k].getEditor(true);
					if(editor instanceof BSJEditor) {
						BSJEditor bsjEditor = (BSJEditor)editor;
						bsjEditor.invalidateTextPresentation();
						// TODO: FIGURE THIS OUT
					}
				}
			}
		}
	}

}
