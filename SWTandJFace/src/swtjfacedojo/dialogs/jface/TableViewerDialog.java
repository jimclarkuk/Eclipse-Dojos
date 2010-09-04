package swtjfacedojo.dialogs.jface;

import java.util.Iterator;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import swtjfacedojo.dialogs.layouts.GeneralDialog;

public class TableViewerDialog extends GeneralDialog {
	Object result;

	private String title1 = "name";
	private String title2 = "description";
	private String title3 = "color";

	private TableViewer viewer;

	private TableElementModel model = new TableElementModel();
	
	private final class OurTableCellEditor implements ICellModifier {
		private final TableViewer viewer;

		private OurTableCellEditor(TableViewer viewer) {
			this.viewer = viewer;
		}

		public boolean canModify(Object element, String property) {
			return true;
		}

		public Object getValue(Object element, String property) {
			if (title1.equals(property))
				return ((TableElement) element).getName();
			else if (title2.equals(property))
				return ((TableElement) element).getDesc();
			else 
				return ((TableElement) element).getColor();
		}

		public void modify(Object element, String property, Object value) {
			TableItem tableItem = (TableItem) element;
			TableElement data = (TableElement) tableItem.getData();
			if (title1.equals(property))
				data.setName(value.toString());
			if (title2.equals(property))
				data.setDesc(value.toString());
			if (title3.equals(property))
				data.setColor(value.toString());

			viewer.refresh(data);
		}
	}


	public TableViewerDialog (Shell parent, int style) {
		super (parent, style);
	}

	public TableViewerDialog (Shell parent) {
		this (parent, 0); 
	}

	public Object open () {
		Shell parent = getParent();
		Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText("Example of table viewer layout");

		Composite composite = new Composite(shell, SWT.NONE);
		FormLayout layout = new FormLayout();
		layout.marginWidth = 5;
		layout.marginHeight = 5;
		layout.spacing = 5;

		composite.setLayout(layout);

		createTableViewer(composite); 

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

	private Table createControls(Composite composite) {
		Label label = new Label(composite, SWT.BORDER);
		label.setText("table: ");

		FormData data = new FormData(150, SWT.DEFAULT);
		data.left = new FormAttachment(0,0);
		data.top = new FormAttachment(0,0);

		label.setLayoutData(data);

		Table table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION );

		data = new FormData(300, 150);
		data.left = new FormAttachment(0,0);
		data.top = new FormAttachment(label);

		table.setLayoutData(data);

		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableLayout layout = new TableLayout();

		layout.addColumnData(new ColumnWeightData(30, 75, true));
		layout.addColumnData(new ColumnWeightData(30, 75, true));
		layout.addColumnData(new ColumnWeightData(40, 75, true));
		table.setLayout(layout);

		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		TableColumn tc2 = new TableColumn(table, SWT.LEFT);
		TableColumn tc3 = new TableColumn(table, SWT.LEFT);

		tc1.setText(title1);
		tc2.setText(title2);
		tc3.setText(title3);

		Button addButton = new Button(composite, SWT.PUSH);
		addButton.setText("Add row");
		
		data = new FormData(75, SWT.DEFAULT);
		data.left = new FormAttachment(table);
		data.top = new FormAttachment(label);
		
		addButton.setLayoutData(data);
		
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableElement newItem = new TableElement("new row", "", "");
				model.getModel().add(newItem);
				viewer.refresh();
			}
			
		});
		
		Button removeButton = new Button(composite, SWT.PUSH);
		removeButton.setText("Remove row");
		
		data = new FormData(75, SWT.DEFAULT);
		data.left = new FormAttachment(table);
		data.top = new FormAttachment(addButton);
		
		removeButton.setLayoutData(data);
		
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = viewer.getSelection();
				
				if (selection != null && selection instanceof IStructuredSelection) {
					IStructuredSelection sel = (IStructuredSelection) selection;

					for (Iterator<TableElement> iterator = sel.iterator(); iterator.hasNext();) {
						TableElement element = iterator.next();
						model.getModel().remove(element);
					}
					viewer.refresh();
				}
			}
			
		});
		
		
		return table;
	}

	public void createTableViewer(Composite composite) {
		Table table = createControls(composite);
		viewer = new TableViewer(table); 
		viewer.setContentProvider(createContentProvider());
		viewer.setLabelProvider(createLabelProvider());

		try {
		viewer.setInput(model.getModel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		addCellEdition(viewer, table);
	}


	private IStructuredContentProvider createContentProvider() {
		IStructuredContentProvider content = new OurTableContentProvider();
		return content;

	}

	private ITableLabelProvider createLabelProvider() {
		ITableLabelProvider labelProvider = new OurTableLabelProvider();
		return labelProvider;
	}

	private void addCellEdition(final TableViewer viewer, Composite parent) {
		viewer.setCellModifier(new OurTableCellEditor(viewer));

		viewer.setCellEditors(new CellEditor[] { new TextCellEditor(parent),
				new TextCellEditor(parent), new TextCellEditor(parent) });

		viewer.setColumnProperties(new String[] { title1,
				title2, title3 });
	}

}
