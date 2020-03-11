package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import models.Parametar;
import views.MainFrame;
import views.ParametarView;

public class ShowParameterForm extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ShowParameterForm(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Parametar p1 = new Parametar();
		
		ParametarView pv1 = new ParametarView(p1);
		
		MainFrame.getInstance().setForma(pv1);
		
		MainFrame.getInstance().setLstatus2(MainFrame.getInstance().getResourceBundle().getString("statusShowPar"));
	}

}
