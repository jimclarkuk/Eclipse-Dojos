package swtjfacedojo.dialogs.jface;

import java.util.ArrayList;
import java.util.List;

public class TableElementModel {

	private List<TableElement> list = new ArrayList<TableElement>();
	
	public TableElementModel() {
		list.add(new TableElement("item 1", "desc 1", "color 1"));
		list.add(new TableElement("item 2", "desc 2", "color 2"));
		list.add(new TableElement("item 3", "desc 3", "color 3"));
		list.add(new TableElement("item 4", "desc 4", "color 4"));
		list.add(new TableElement("item 5", "desc 5", "color 5"));

	}
	
	public List<TableElement> getModel() {
		return list;
	}
}
