package swtjfacedojo.dialogs.layouts;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class GeneralDialog extends Dialog {
	protected Object result;
	
	public GeneralDialog (Shell parent, int style) {
		super (parent, style);
	}

	public GeneralDialog (Shell parent) {
		this (parent, 0); 
	}
	
	public Object open () {
		return result;
	}
	
	protected void createGeneralDemoControls(Composite composite) {
		Label label = new Label(composite, SWT.LEFT);
		label.setText("this is a label");
		
		Text text = new Text(composite, SWT.BORDER);
		text.setText("and this is a text");
		
		Combo combo = new Combo(composite, SWT.DROP_DOWN | SWT.BORDER);
		combo.add("and a combo box");
		combo.select(0);
		
		Button button1 = new Button(composite, SWT.PUSH);
		button1.setText("button 1");
		
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				MessageDialog.openInformation(
						GeneralDialog.this.getParent(),
						"SwtJFaceDojo Plug-in",
						"Button pressed!");
			}
		});
		
		Button button2 = new Button(composite, SWT.RADIO);
		button2.setText("button 2");
		
		Button button3 = new Button(composite, SWT.CHECK);
		button3.setText("button 3");
		
		Button button4 = new Button(composite, SWT.ARROW);
		button4.setText("button 4");
		
		new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);

	}
	
}
