package edu.jhu.cs.bsj.eclipse.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class NewBSJClassWizard extends Wizard implements INewWizard {
	
	private static final String WIZARD_NAME = "New BSJ Class";
	private static final String PAGE_ONE_NAME = "Creating a BSJ class.";
	private static final String PAGE_ONE_TITLE = "Create a new BSJ class.";
	private static final String PAGE_ONE_DESCRIPT = "Enter a class name.";
	private WizardNewFileCreationPage pageOne;
	
	private IStructuredSelection structSelection;
	
	public NewBSJClassWizard() {
	}
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		structSelection = selection;
	}
	
	@Override
	public void addPages() {
		super.addPages();
		setWindowTitle(WIZARD_NAME);
		setHelpAvailable(false);
		
		pageOne = new WizardNewFileCreationPage(PAGE_ONE_NAME, structSelection);
		pageOne.setTitle(PAGE_ONE_TITLE);
		pageOne.setDescription(PAGE_ONE_DESCRIPT);
		pageOne.setAllowExistingResources(false);
		pageOne.setFileExtension("bsj");
		addPage(pageOne);
	}

	@Override
	public boolean performFinish() {
		BSJClassBuilder builder = new BSJClassBuilder();
		builder.setName(pageOne.getFileName()
				.replace("."+pageOne.getFileExtension(), ""));
		builder.setExtension(pageOne.getFileExtension());
		builder.setLocation(pageOne.getContainerFullPath());
		builder.setPackageName(BSJClassBuilder.extractPackageName(structSelection));
		builder.build();
		return true;
	}
}
