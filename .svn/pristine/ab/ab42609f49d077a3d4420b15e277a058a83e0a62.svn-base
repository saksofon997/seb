package installer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Konfigurator;

public class LicencePanel extends JPanel{

	private JTextField field;
	private JPanel dugmici;
	private JButton btnext;
	private JButton btcancel;
	private JCheckBox box;

	public LicencePanel(Konfigurator konfigurator) {
		// TODO Auto-generated constructor stub
		
		setSize(600, 400);
		
		setLayout(new BorderLayout());
		
		field = new JTextField(konfigurator.getLicence());
		field.setEditable(false);
		
		field.setSize(new Dimension(500, 300));
		
		dugmici = new JPanel();
		dugmici.setLayout(new FlowLayout());
		
		btnext = new JButton(Wizard.getInstance().getResourceBundle().getString("btnext"));
		btnext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ExtractPanel panel = new ExtractPanel(konfigurator);
				Wizard.getInstance().setMain(panel);
			}
		});
		btnext.setEnabled(false);
		
		btcancel = new JButton(Wizard.getInstance().getResourceBundle().getString("cancelOption"));
		btcancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		box = new JCheckBox(Wizard.getInstance().getResourceBundle().getString("slaganje"));
		box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnext.setEnabled(true);
			}
		});
		
		dugmici.add(box);
		dugmici.add(btnext);
		dugmici.add(btcancel);
		
		add(field, BorderLayout.CENTER);
		add(dugmici, BorderLayout.SOUTH);
		
	}

}
