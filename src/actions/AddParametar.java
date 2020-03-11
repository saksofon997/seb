package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import models.Parametar;
import models.Proizvod;
import views.MainFrame;

public class AddParametar extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddParametar(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		
		if(parentNodeView == null) return;
		
		if(parentNodeView.getUserObject() instanceof Proizvod)
		{
		
		Proizvod parentNodeModel = (Proizvod)parentNodeView.getUserObject();
		
		Parametar childNodeModel = actions.ParametarController.getParametar();
		
		actions.ParametarController.resetParametar();
		
		childNodeModel.setParent(parentNodeModel);
		
		parentNodeModel.addParametar(childNodeModel);
		
		DefaultMutableTreeNode childNodeView = new DefaultMutableTreeNode(childNodeModel);
		
		DefaultTreeModel model = MainFrame.getInstance().getTreeModel();
		
		model.insertNodeInto(childNodeView, parentNodeView, parentNodeView.getChildCount());
		
		JTree tree = MainFrame.getInstance().getTree();
		tree.setSelectionPath(new TreePath(childNodeView.getPath()));
		tree.scrollPathToVisible(new TreePath(childNodeView.getPath()));
		
		views.MainFrame.getInstance().setLstatus2(MainFrame.getInstance().getResourceBundle().getString("statusAddPar"));
		}
		else if(parentNodeView.getUserObject() instanceof Parametar) {
			
			Parametar parentNodeModel = (Parametar)parentNodeView.getUserObject();
			
			Parametar childNodeModel = actions.ParametarController.getParametar();
			
			actions.ParametarController.resetParametar();
			
			childNodeModel.setParent(parentNodeModel);
			
			parentNodeModel.addParametar(childNodeModel);
			
			DefaultMutableTreeNode childNodeView = new DefaultMutableTreeNode(childNodeModel);
			
			DefaultTreeModel model = MainFrame.getInstance().getTreeModel();
			
			model.insertNodeInto(childNodeView, parentNodeView, parentNodeView.getChildCount());
			
			JTree tree = MainFrame.getInstance().getTree();
			tree.setSelectionPath(new TreePath(childNodeView.getPath()));
			tree.scrollPathToVisible(new TreePath(childNodeView.getPath()));
			
			views.MainFrame.getInstance().setLstatus2(MainFrame.getInstance().getResourceBundle().getString("statusAddPar"));
		}
		else {
			MainFrame.getInstance().setLstatus2(MainFrame.getInstance().getResourceBundle().getString("statusGreska"));
			return;
		}
	}

}
