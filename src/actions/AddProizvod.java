package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import models.Kompanija;
import models.Proizvod;
import views.MainFrame;

public class AddProizvod extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3858031153693773665L;

	public AddProizvod(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		
		if(parentNodeView == null) return;
		
		if(!(parentNodeView.getUserObject() instanceof Kompanija))
		{
			MainFrame.getInstance().setLstatus2(MainFrame.getInstance().getResourceBundle().getString("statusGreska"));
			return;
		}
		
		Kompanija parentNodeModel = (Kompanija)parentNodeView.getUserObject();
		
		Proizvod childNodeModel = actions.ProizvodController.getProizvod();
		
		actions.ProizvodController.resetProizvod();
		
		childNodeModel.setParent(parentNodeModel);
		
		parentNodeModel.addProizvod(childNodeModel);
		
		DefaultMutableTreeNode childNodeView = new DefaultMutableTreeNode(childNodeModel);
		
		DefaultTreeModel model = MainFrame.getInstance().getTreeModel();
		
		model.insertNodeInto(childNodeView, parentNodeView, parentNodeView.getChildCount());
		
		JTree tree = MainFrame.getInstance().getTree();
		tree.setSelectionPath(new TreePath(childNodeView.getPath()));
		tree.scrollPathToVisible(new TreePath(childNodeView.getPath()));
		
		views.MainFrame.getInstance().setLstatus2(MainFrame.getInstance().getResourceBundle().getString("statusAddPro"));
	}

}
