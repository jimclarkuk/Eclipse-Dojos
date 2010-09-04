package swtjfacedojo.dialogs.jface;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

public final class OurTableLabelProvider implements ITableLabelProvider {
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		switch (columnIndex) {
		case 0:
			String name = ((TableElement) element).getName();
			return name;
		case 1:
			String description = ((TableElement) element).getDesc();
			return description;
		case 2: 
			String color = ((TableElement) element).getColor();
			return color;
		default:
			return "Invalid column: " + columnIndex;
		}
	}

	public void addListener(ILabelProviderListener listener) {
	}

	public void dispose() {
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener lpl) {
	}
}