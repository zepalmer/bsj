package edu.jhu.cs.bsj.eclipse.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class BSJPerspectiveFactory implements IPerspectiveFactory {

	final static String ID_CONSOLE ="org.eclipse.ui.console.ConsoleView";
	
	@Override
	public void createInitialLayout(IPageLayout layout) {
		 String editorArea = layout.getEditorArea();
		 
		 IFolderLayout left = layout.createFolder(
				 "left", IPageLayout.LEFT, 0.25f, editorArea);
		 left.addView(IPageLayout.ID_PROJECT_EXPLORER);
		 
		 IFolderLayout middleBottom = layout.createFolder(
				 "middleBottom", IPageLayout.BOTTOM, 0.75f, editorArea);
		 middleBottom.addView(IPageLayout.ID_PROBLEM_VIEW);
		 middleBottom.addView(ID_CONSOLE);
		 
		 IFolderLayout right = layout.createFolder(
				 "right", IPageLayout.RIGHT, 0.75f, editorArea);
		 right.addView(IPageLayout.ID_OUTLINE);
	}
	
}
