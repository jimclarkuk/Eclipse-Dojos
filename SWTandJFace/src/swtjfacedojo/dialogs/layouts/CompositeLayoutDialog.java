package swtjfacedojo.dialogs.layouts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CompositeLayoutDialog extends GeneralDialog {

	Object result;

	public CompositeLayoutDialog (Shell parent, int style) {
		super (parent, style);
	}

	public CompositeLayoutDialog (Shell parent) {
		this (parent, 0); 
	}

	public Object open () {
		Shell parent = getParent();
		Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText("Example of form layout");

		Composite composite = new Composite(shell, SWT.NONE);

		Composite buttonComposite = new Composite(composite, SWT.NONE);
		Composite widgetComposite = new Composite(composite, SWT.NONE);

		FormLayout layout = new FormLayout();
		layout.marginWidth = 5;
		layout.marginHeight = 5;

		composite.setLayout(layout);

		FormData data = new FormData();
		data.left = new FormAttachment(0,0);
		data.top = new FormAttachment(0,0);

		widgetComposite.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(widgetComposite);
		data.top = new FormAttachment(0,0);
		buttonComposite.setLayoutData(data);

		GridLayout widgetLayout = new GridLayout(2, true);
		widgetLayout.verticalSpacing = 5;
		widgetLayout.horizontalSpacing = 5;
		
		widgetComposite.setLayout(widgetLayout);
		createGeneralDemoControls(widgetComposite);

	  	RowLayout rowLayout = new RowLayout();
		rowLayout.wrap = true;
		rowLayout.pack = true;
		rowLayout.justify = false;
		rowLayout.type = SWT.VERTICAL;
		rowLayout.marginLeft = 5;
		rowLayout.marginTop = 5;
		rowLayout.marginRight = 5;
		rowLayout.marginBottom = 5;
		rowLayout.spacing = 5;

		
		buttonComposite.setLayout(rowLayout);
		
		createButtons(buttonComposite);
		
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

	public void createButtons(Composite composite) {

		Button b1 = new Button(composite, SWT.PUSH);
		b1.setText("b1");
		b1.setLayoutData(new RowData(50, 40));

		Button b2 = new Button(composite, SWT.PUSH);
		b2.setText("b2");
		b2.setLayoutData(new RowData(50, 40));
		
		Button b3 = new Button(composite, SWT.PUSH);
		b3.setText("b3");
		b3.setLayoutData(new RowData(50, 40));
		
		Button b4 = new Button(composite, SWT.PUSH);
		b4.setText("b4");
		b4.setLayoutData(new RowData(50, 40));
	}

}
