package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import models.Proizvod;
import views.MainFrame;
import views.ProizvodView;

public class ShowProizvodForm extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShowProizvodForm(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Proizvod p1 = new Proizvod();
		
		ProizvodView pv1 = new ProizvodView(p1);
		
		MainFrame.getInstance().setForma(pv1);
		
		MainFrame.getInstance().setLstatus2(MainFrame.getInstance().getResourceBundle().getString("statusShowPro"));
	}

}
