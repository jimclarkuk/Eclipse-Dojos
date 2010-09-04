package org.eclipse.example.library.action;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.CommandActionHandler;
import org.eclipse.jface.viewers.IStructuredSelection;

public class DeleteBorrowedBooksAction extends CommandActionHandler {
    
	
	@Override
	public boolean updateSelection(IStructuredSelection selection) {
	
		return super.updateSelection(selection);
	}

	public DeleteBorrowedBooksAction(EditingDomain domain) {
        super(domain, "Delete Borrowed Books");
    }

	@Override
	public Command createCommand(Collection<?> selection) {
		EditingDomain editingDomain = this.getEditingDomain();
		if (null == editingDomain){
			return super.createCommand(selection);
		}
		
		Command delete = new DeleteCommand(editingDomain, selection);
		return delete;
	}

	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		super.run();
	}
}