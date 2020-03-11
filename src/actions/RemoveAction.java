package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import models.Kompanija;
import models.Parametar;
import models.Proizvod;
import views.MainFrame;

public class RemoveAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RemoveAction(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) views.MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		
		if (childNodeView == null || childNodeView.isRoot())
			return;
		
		if(childNodeView.getUserObject() instanceof Kompanija) {
			Kompanija childNodeModel = (Kompanija) childNodeView.getUserObject();
			
			childNodeModel.removeFromParent();
			
		}
		else if(childNodeView.getUserObject() instanceof Proizvod) {
			Proizvod childNodeModel = (Proizvod)childNodeView.getUserObject();
			
			childNodeModel.removeFromParent();
		}
		else if(childNodeView.getUserObject() instanceof Parametar) {
			Parametar childNodeModel = (Parametar) childNodeView.getUserObject();
			
			childNodeModel.removeFromParent();
		}
		else {
			views.MainFrame.getInstance().setLstatus2(MainFrame.getInstance().getResourceBundle().getString("statusG"));
		}
		
		views.MainFrame.getInstance().getTreeModel().removeNodeFromParent(childNodeView);
		
		views.MainFrame.getInstance().setLstatus2(MainFrame.getInstance().getResourceBundle().getString("statusRem"));
		
		}

}
