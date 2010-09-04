package swtjfacedojo.dialogs.layouts;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class CustomDialog extends Dialog {
	
	protected IAdaptable input;
	
	public CustomDialog(Shell parentShell) {
		super(parentShell);
	}
	
   protected Control createDialogArea(Composite parent) {
      Composite composite = (Composite)super.createDialogArea(parent);
     
  	RowLayout rowLayout = new RowLayout();
		rowLayout.wrap = true;
		rowLayout.pack = true;
		rowLayout.justify = false;
		rowLayout.type = SWT.HORIZONTAL;
		rowLayout.marginLeft = 5;
		rowLayout.marginTop = 5;
		rowLayout.marginRight = 5;
		rowLayout.marginBottom = 5;
		rowLayout.spacing = 10;

      composite.setLayout(rowLayout);
      //List list = new List(composite, SWT.BORDER);      
      //list.add("point 1");
      //list.add("point 2");
      final Table table = new Table(parent, SWT.SINGLE | SWT.BORDER);
      TableColumn col1  =  new TableColumn(table,SWT.LEFT);
    	  col1.setText("Coloumn 1");
    	  col1.setWidth(80);
      TableColumn col2  = new TableColumn(table,SWT.LEFT);
    	  col2.setText("Coloumn 2");
    	  col2.setWidth(80);
    	  
    	  TableItem item1 = new TableItem(table,0);
    	  item1.setText(new String[]{"a","b"});
    	  TableItem item2 = new TableItem(table,0);
    	  item2.setText(new String[]{"a","b"});

    	  table.setHeaderVisible(true);
    	  table.setLinesVisible(true);
    	  


      composite.pack();
      
      return composite;
   }

	
}
