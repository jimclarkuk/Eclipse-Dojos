package swtjfacedojo.dialogs.layouts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class RowLayoutDialog extends GeneralDialog {

	Object result;
	
	public RowLayoutDialog (Shell parent, int style) {
		super (parent, style);
	}

	public RowLayoutDialog (Shell parent) {
		this (parent, 0); 
	}

	public Object open () {
		Shell parent = getParent();
		Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText("Example of row layout");
		
		Composite composite = new Composite(shell, SWT.NONE);
		
	  	RowLayout rowLayout = new RowLayout();
		rowLayout.wrap = true;
		rowLayout.pack = true;
		rowLayout.justify = false;
		rowLayout.type = SWT.VERTICAL;
		rowLayout.marginLeft = 5;
		rowLayout.marginTop = 5;
		rowLayout.marginRight = 5;
		rowLayout.marginBottom = 5;
		rowLayout.spacing = 10;
		
		composite.setLayout(rowLayout);
		
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
