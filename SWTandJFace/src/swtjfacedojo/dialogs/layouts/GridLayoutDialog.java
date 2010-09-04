package swtjfacedojo.dialogs.layouts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class GridLayoutDialog extends GeneralDialog {

	Object result;
	
	public GridLayoutDialog (Shell parent, int style) {
		super (parent, style);
	}

	public GridLayoutDialog (Shell parent) {
		this (parent, 0); 
	}

	public Object open () {
		Shell parent = getParent();
		Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText("Example of grid layout");
		
		Composite composite = new Composite(shell, SWT.NONE);
		
		GridLayout layout = new GridLayout(2, true);
		layout.verticalSpacing = 5;
		layout.horizontalSpacing = 5;

		composite.setLayout(layout);
		
		createGeneralDemoControls(composite);
		
		//plus widget in more than one cell:
		
		List list = new List(composite, SWT.SINGLE | SWT.BORDER);
		list.add("example");
		list.add("example");
		list.add("example");
		list.add("example");
		list.add("example");
		
		list.select(2);
		
		GridData data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = 2;

		list.setLayoutData(data);
		
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
