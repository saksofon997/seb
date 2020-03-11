package installer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Konfigurator;

public class WelcomePanel extends JPanel{
	
	private JTextField field;
	private JPanel dugmici;
	private JButton btnext;
	private JButton btcancel;

	public WelcomePanel(Konfigurator konfigurator) {
		// TODO Auto-generated constructor stub
		
		setSize(600, 400);
		
		setLayout(new BorderLayout());
		
		field = new JTextField(konfigurator.getWelcome());
		field.setEditable(false);
		
		field.setSize(new Dimension(500, 300));
		
		dugmici = new JPanel();
		dugmici.setLayout(new FlowLayout());
		
		btnext = new JButton(Wizard.getInstance().getResourceBundle().getString("btnext"));
		btnext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LicencePanel panel = new LicencePanel(konfigurator);
				Wizard.getInstance().setMain(panel);
			}
		});
		
		btcancel = new JButton(Wizard.getInstance().getResourceBundle().getString("cancelOption"));
		btcancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		dugmici.add(btnext);
		dugmici.add(btcancel);
		
		add(field, BorderLayout.CENTER);
		add(dugmici, BorderLayout.SOUTH);
		
	}

}
