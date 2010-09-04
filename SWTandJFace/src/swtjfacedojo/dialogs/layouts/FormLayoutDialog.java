package swtjfacedojo.dialogs.layouts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class FormLayoutDialog extends GeneralDialog {

	Object result;
	
	public FormLayoutDialog (Shell parent, int style) {
		super (parent, style);
	}

	public FormLayoutDialog (Shell parent) {
		this (parent, 0); 
	}

	public Object open () {
		Shell parent = getParent();
		Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText("Example of form layout");
		
		Composite composite = new Composite(shell, SWT.NONE);
		
		FormLayout layout = new FormLayout();
		layout.marginWidth = 5;
		layout.marginHeight = 5;
		layout.spacing = 5;
		
		composite.setLayout(layout);
				
		//this layout won't allow to use generic method - uncomment and see what happens
		//createGeneralDemoControls(composite);

		createControls(composite);
		
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
	
	public void createControls(Composite composite) {
		
		Label label = new Label(composite, SWT.BORDER);
		label.setText("this is example of form layout");
		
		FormData data = new FormData(150, SWT.DEFAULT);
		data.left = new FormAttachment(0,0);
		data.top = new FormAttachment(0,0);
		
		label.setLayoutData(data);
		
		List list = new List(composite, SWT.SINGLE | SWT.BORDER);
		list.add("example");
		list.add("example");
		list.add("example");
		list.add("example");
		list.add("example");
		
		list.select(2);
		
		data = new FormData(150, 150);
		data.left = new FormAttachment(0,0);
		data.top = new FormAttachment(label);
		
		list.setLayoutData(data);
		
		Button button = new Button(composite, SWT.PUSH);
		button.setText("no action");
		
		data = new FormData();
		data.left = new FormAttachment(list);
		data.top = new FormAttachment(label);
		
		button.setLayoutData(data);
		
	}
	
}
