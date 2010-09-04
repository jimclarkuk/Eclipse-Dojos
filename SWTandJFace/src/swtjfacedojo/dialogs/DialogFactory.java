package swtjfacedojo.dialogs;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import swtjfacedojo.data.LayoutType;
import swtjfacedojo.dialogs.jface.TableViewerDialog;
import swtjfacedojo.dialogs.layouts.CompositeLayoutDialog;
import swtjfacedojo.dialogs.layouts.FillLayoutDialog;
import swtjfacedojo.dialogs.layouts.FormLayoutDialog;
import swtjfacedojo.dialogs.layouts.GeneralDialog;
import swtjfacedojo.dialogs.layouts.GridLayoutDialog;
import swtjfacedojo.dialogs.layouts.RowLayoutDialog;
import swtjfacedojo.dialogs.layouts.TableDialog;

public class DialogFactory {

	public static GeneralDialog getDialog(LayoutType type) {
		Shell shell = Display.getDefault().getActiveShell();
		switch (type) {
			case Fill: return new FillLayoutDialog(shell);
			case Row:  return new RowLayoutDialog(shell);
			case Grid: return new GridLayoutDialog(shell);
			case Form: return new FormLayoutDialog(shell);
			case Composite: return new CompositeLayoutDialog(shell);
			case Table: return new TableDialog(shell);
			case TableViewer : return new TableViewerDialog(shell);
		}
		return null;
	}


}
