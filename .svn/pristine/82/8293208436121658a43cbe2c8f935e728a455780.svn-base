package installer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FinishPanel extends JPanel{
	
	private JTextField field;
	private JPanel dugmici;
	private JButton btnext;
	private JButton btcancel;
	
	public FinishPanel() {
		
		setSize(600, 400);
		
		setLayout(new BorderLayout());
		
		field = new JTextField(Wizard.getInstance().getResourceBundle().getString("uspesnainstall"));
		field.setEditable(false);
		
		field.setSize(new Dimension(500, 300));
		
		dugmici = new JPanel();
		dugmici.setLayout(new FlowLayout());
		
		btnext = new JButton(Wizard.getInstance().getResourceBundle().getString("btKraj"));
		btnext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		dugmici.add(btnext);
		
		add(field, BorderLayout.CENTER);
		add(dugmici, BorderLayout.SOUTH);
	}
}
