package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import models.Kompanija;
import views.KompanijaView;
import views.MainFrame;

public class ShowKompanijaForm extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShowKompanijaForm(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Kompanija k1 = new Kompanija();
		
		KompanijaView kv1 = new KompanijaView(k1);
		
		MainFrame.getInstance().setForma(kv1);
		
		MainFrame.getInstance().setLstatus2(MainFrame.getInstance().getResourceBundle().getString("statusShowKomp"));
	}

}
