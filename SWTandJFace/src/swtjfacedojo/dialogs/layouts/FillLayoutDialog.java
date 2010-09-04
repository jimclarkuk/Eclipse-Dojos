package swtjfacedojo.dialogs.layouts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class FillLayoutDialog extends GeneralDialog {

	Object result;
	
	public FillLayoutDialog (Shell parent, int style) {
		super (parent, style);
	}

	public FillLayoutDialog (Shell parent) {
		this (parent, 0); 
	}

	public Object open () {
		Shell parent = getParent();
		Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText("Example of fill layout");
		
		Composite composite = new Composite(shell, SWT.NONE);
		
		composite.setLayout(new FillLayout());
		
		createGeneralDemoControls(composite);
		
		composite.pack();
	
		shell.pack();
		
		shell.open();
		
		Display display = parent.getDisplay();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) 
				display.sleep();
		}
		
		return result;
	}
}
