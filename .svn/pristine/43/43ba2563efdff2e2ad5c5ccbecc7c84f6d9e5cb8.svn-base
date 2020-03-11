package installer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import models.Konfigurator;
import views.MainFrame;

public class ExtractPanel extends JPanel{

	private JTextField field;
	private JLabel dest;
	private JButton choose;
	private JPanel dugmici;
	private JButton btnext;
	private JButton btcancel;
	private JPanel panel;
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public ExtractPanel(Konfigurator konfigurator) {
		setSize(600, 400);
		
		setLayout(new BorderLayout());
		
		dest = new JLabel(Wizard.getInstance().getResourceBundle().getString("destination"));
		
		
		field = new JTextField();
		field.setEditable(false);
		
		dugmici = new JPanel();
		dugmici.setLayout(new FlowLayout());
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(dest, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(field, gbc);
		
		field.setPreferredSize(new Dimension(200, 20));
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		choose = new JButton("...");
		choose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fc=new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fc.setAcceptAllFileFilterUsed(false);
			    int a=fc.showOpenDialog(MainFrame.getInstance());
				File f=fc.getSelectedFile();
				String s = null;
				s=f.getPath();
				if(s != null) {
					field.setText(s);
					btnext.setEnabled(true);
				}
				else
					JOptionPane.showConfirmDialog(null, Wizard.getInstance().getResourceBundle().getString("izaberidir"));
			}
		});
		panel.add(choose, gbc);
		
		
		btnext = new JButton(Wizard.getInstance().getResourceBundle().getString("btnext"));
		btnext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File file = new File(field.getText());
				try {
					Wizard.getInstance().unzip(file);
					FinishPanel panel = new FinishPanel();
					Wizard.getInstance().setMain(panel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, Wizard.getInstance().getResourceBundle().getString("greskainstall"));
					System.exit(0);
				}
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
		
		dugmici.add(btnext);
		dugmici.add(btcancel);
		
		add(panel, BorderLayout.CENTER);
		add(dugmici, BorderLayout.SOUTH);
	}
}
