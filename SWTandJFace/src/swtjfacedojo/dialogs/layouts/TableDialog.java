package swtjfacedojo.dialogs.layouts;

import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class TableDialog extends GeneralDialog {

	Object result;

	public TableDialog (Shell parent, int style) {
		super (parent, style);
	}

	public TableDialog (Shell parent) {
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
		label.setText("table: ");
		
		FormData data = new FormData(150, SWT.DEFAULT);
		data.left = new FormAttachment(0,0);
		data.top = new FormAttachment(0,0);
		
		label.setLayoutData(data);
		
		Table table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		
		TableLayout layout = new TableLayout();
		
	    layout.addColumnData(new ColumnWeightData(30, 75, true));
	    layout.addColumnData(new ColumnWeightData(30, 75, true));
	    layout.addColumnData(new ColumnWeightData(40, 75, true));
	    table.setLayout(layout);
		
	    TableColumn tc1 = new TableColumn(table, SWT.LEFT);
	    TableColumn tc2 = new TableColumn(table, SWT.LEFT);
	    TableColumn tc3 = new TableColumn(table, SWT.LEFT);
	    
	    tc1.setText("Name");
	    tc2.setText("Description");
	    tc3.setText("Color");

	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);
	    
	    TableItem item1 = new TableItem(table, SWT.NONE);
	    item1.setText(new String[] { "Ingy", "new", "pink" });
	    TableItem item2 = new TableItem(table, SWT.NONE);
	    item2.setText(new String[] { "Pom - pom", "old", "red" });
	    TableItem item3 = new TableItem(table, SWT.NONE);
	    item3.setText(new String[] { "Pompon", "big", "blue" });
		
		
		data = new FormData(300, 150);
		data.left = new FormAttachment(0,0);
		data.top = new FormAttachment(label);
		
		table.setLayoutData(data);
	}

}
