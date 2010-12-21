package edu.jhu.cs.bsj.eclipse.wizards;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

public class NewBSJProjectWizard extends Wizard implements INewWizard, IExecutableExtension {
	
	private static final String WIZARD_NAME = "New BSJ Project";
	private static final String PAGE_ONE_NAME = "Creating a BSJ Project.";
	private static final String PAGE_ONE_TITLE = "Create a BSJ Project."; 
	private WizardNewProjectCreationPage pageOne;
	
	private IConfigurationElement configurationElement;
	
	public NewBSJProjectWizard() {
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}
	
	@Override
	public void addPages() {
		super.addPages();
		
		setWindowTitle(WIZARD_NAME);
		
		pageOne = new WizardNewProjectCreationPage(PAGE_ONE_NAME);
		pageOne.setTitle(PAGE_ONE_TITLE);
		pageOne.setDescription("Enter a project name");
		addPage(pageOne);
	}

	@Override
	public boolean performFinish() {
		
		// change to BSJ perspective
		BasicNewProjectResourceWizard.updatePerspective(configurationElement);
		
		return true;
	}
	
	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		// retrieve configuration data needed for changing perspective
		configurationElement = config;
	}
}
