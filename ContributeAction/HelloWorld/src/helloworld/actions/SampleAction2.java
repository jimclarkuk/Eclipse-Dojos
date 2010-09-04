package helloworld.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class SampleAction2 implements IWorkbenchWindowActionDelegate {
	
	private IWorkbenchWindow window;

	public void dispose() {
		// TODO Auto-generated method stub

	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

	public void run(IAction action) {
		MessageDialog.openInformation(
				window.getShell(),
				"Moshi Moshi Plug-in",
				"Moshi Moshi, Eclipse world");

	}

	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
