package swtjfacedojo.data;

public enum LayoutType {
	Fill,
	Row,
	Grid,
	Form,
	Composite,
	Table,
	TableViewer;
	
	public String toString() {
		return this.name() + " layout";
	}
}
