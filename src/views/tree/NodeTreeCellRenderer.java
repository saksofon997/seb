package views.tree;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import models.Kompanija;
import models.Parametar;
import models.Proizvod;
import models.Workspace;

public class NodeTreeCellRenderer extends DefaultTreeCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1186172495609497167L;

	public NodeTreeCellRenderer() {

		// TODO Auto-generated constructor stub
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		if (value instanceof DefaultMutableTreeNode) {

			if(((DefaultMutableTreeNode) value).getUserObject() == null)
				return this;
			
			if(((DefaultMutableTreeNode) value).getUserObject() instanceof Workspace) {
				setIcon(new ImageIcon("images/workspace.png"));
				Workspace w1 = (Workspace)((DefaultMutableTreeNode) value).getUserObject();
				setText(w1.getName());
			}
			else if (((DefaultMutableTreeNode) value).getUserObject() instanceof Kompanija) {
            		setIcon(new ImageIcon("images/kompanija.png"));	
            		Kompanija k1 = (Kompanija) ((DefaultMutableTreeNode) value).getUserObject();
            		setText(k1.getNaziv());
            	} else if (((DefaultMutableTreeNode) value).getUserObject() instanceof Proizvod) {
            		setIcon(new ImageIcon("images/proizvod.png"));
            		Proizvod p1 = (Proizvod) ((DefaultMutableTreeNode) value).getUserObject();
            		setText(p1.getNaziv());
            	} else if (((DefaultMutableTreeNode) value).getUserObject() instanceof Parametar) {
            		setIcon(new ImageIcon("images/parametar.png"));
            		Parametar p2 = (Parametar) ((DefaultMutableTreeNode) value).getUserObject();
            		setText(p2.getNaziv());
            	}
		}

		return this;
	}
}
