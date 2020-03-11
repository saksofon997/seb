package views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import actions.AddParametar;
import actions.ParametarController;
import models.Parametar;

public class ParametarView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel lbnaziv;
	private JLabel lbvrednost;
	
	private JTextField tfnaziv;
	private JTextField tfvrednost;
	
	private JButton btok;
	private JButton btdodaj;
	private JButton btodustani;
	private JButton btkraj;
	
	private Parametar parametar;
	private ParametarController parametarController;
	
	private GridBagConstraints gbc = new GridBagConstraints();
	
	public ParametarView(Parametar parametar) {
		initView();
		setParametar(parametar);
	}
	
	public void setParametar(Parametar parametar) {
		this.parametar = parametar;
		parametarController = null;
		refreshView();
	}
	
	public void refreshView() {
		tfnaziv.setText(parametar.getNaziv());
		tfvrednost.setText(parametar.getVrednost());	
	}
	
	public void initView() {
		setLayout(new GridBagLayout());
		
		setSize(new Dimension(640, 480));
		
		setVisible(true);
		
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		lbnaziv = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lbNaziv"));
		add(lbnaziv, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		lbvrednost = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lbVrednost"));
		add(lbvrednost, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		tfnaziv = new JTextField();
		add(tfnaziv, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		tfvrednost = new JTextField();
		add(tfvrednost, gbc);
		
		tfnaziv.setPreferredSize(new Dimension(100, 20));
		tfvrednost.setPreferredSize(new Dimension(100, 20));
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		btok = new JButton(MainFrame.getInstance().getResourceBundle().getString("btOk"));
		btok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ok();
			}
		});
		add(btok, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		btdodaj = new JButton(new AddParametar(MainFrame.getInstance().getResourceBundle().getString("btDodaj")));
		add(btdodaj, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		btodustani = new JButton(MainFrame.getInstance().getResourceBundle().getString("btOdustani"));
		btodustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clear();
			}
		});
		add(btodustani, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		btkraj = new JButton(MainFrame.getInstance().getResourceBundle().getString("btKraj"));
		btkraj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrame.getInstance().resetForme();
			}
		});
		add(btkraj, gbc);
	}
	
	public void clear() {
		// TODO Auto-generated method stub
		tfnaziv.setText("");
		tfvrednost.setText("");
	}
	
	public void ok() {
		if(parametarController == null)
			parametarController = new ParametarController(parametar, this);
		
		String naziv = tfnaziv.getText();
		String vrednost = tfvrednost.getText();
		
		views.MainFrame.getInstance().setLstatus2(parametarController.createParametar(naziv, vrednost));
	}
}
