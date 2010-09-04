package swtjfacedojo.dialogs.jface;

import java.util.ArrayList;
import java.util.List;

public class TableElement {

	private String name;
	private String desc;
	private String color;

	
	
	public TableElement(String n, String d, String c) {
		name = n;
		desc = d;
		color = c;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
