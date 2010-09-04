package swtjfacedojo.dialogs;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import swtjfacedojo.data.LayoutType;


public class SelectLayoutDialog extends Dialog {

	protected IAdaptable input;

	LayoutType result;
	Combo combo;
	
	public SelectLayoutDialog(Shell parentShell) {
		super(parentShell);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);

		Label label = new Label(composite, SWT.SHADOW_IN | SWT.LEFT);
		label.setText("Select dialog with specific layout: ");

		combo = new Combo(composite, SWT.READ_ONLY | SWT.DROP_DOWN);
		
		for (LayoutType type : LayoutType.values()) {
			combo.add(type.toString());
		}

		combo.select(1);

		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;

		combo.setLayoutData(gridData);

		composite.pack(); 
		return composite;
	}

	@Override
	protected void cancelPressed() {
		result = null;
		super.cancelPressed();
	}

	@Override
	protected void okPressed() {
		result = LayoutType.valueOf(
				combo.getText().substring(0, combo.getText().indexOf(" ")));
		super.okPressed();
	}

	
	public LayoutType getResult() {
		return result;
	}
}
