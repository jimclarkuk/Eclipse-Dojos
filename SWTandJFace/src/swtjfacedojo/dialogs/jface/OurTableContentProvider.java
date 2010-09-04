package swtjfacedojo.dialogs.jface;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class OurTableContentProvider implements IStructuredContentProvider {
	public Object[] getElements(Object inputElement) {
		List<TableElement> elements = (List<TableElement>) inputElement;
		return elements.toArray();
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
}
