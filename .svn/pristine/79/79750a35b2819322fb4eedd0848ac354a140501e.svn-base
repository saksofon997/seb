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

import actions.AddKompanija;
import actions.KompanijaController;
import models.Kompanija;

public class KompanijaView extends JPanel{

	private JLabel lbnaziv;
	private JLabel lbsediste;
	private JLabel lbceo;
	private JTextField tfnaziv;
	private JTextField tfsediste;
	private JTextField tfceo;
	
	private JButton btok;
	private JButton btdodaj;
	private JButton btodustani;
	private JButton btkraj;
	
	private Kompanija kompanija;
	private KompanijaController kompcont;
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public KompanijaView(Kompanija kompanija) {
		initview();
		setKompanija(kompanija);
	}

	public void setKompanija(Kompanija kompanija) {
		this.kompanija = kompanija;
		kompcont = null;
		refreshView();
	}

	public void refreshView() {
		tfnaziv.setText(kompanija.getNaziv());
		tfsediste.setText(kompanija.getSediste());
		tfceo.setText(kompanija.getCEO());
		
	}

	public void initview() {
		
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
		lbsediste = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lbAdresa"));
		add(lbsediste, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		lbceo = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lbCeo"));
		add(lbceo, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		tfnaziv = new JTextField();
		add(tfnaziv, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		tfsediste = new JTextField();
		add(tfsediste, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		tfceo = new JTextField();
		add(tfceo, gbc);
		
		tfnaziv.setPreferredSize(new Dimension(100, 20));
		tfsediste.setPreferredSize(new Dimension(100, 20));
		tfceo.setPreferredSize(new Dimension(100, 20));
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		btok = new JButton(MainFrame.getInstance().getResourceBundle().getString("btOk"));
		btok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ok();
			}
		});
		add(btok, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		btdodaj = new JButton(new AddKompanija(MainFrame.getInstance().getResourceBundle().getString("btDodaj")));
		add(btdodaj, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
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
		gbc.gridy = 4;
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
		tfsediste.setText("");
		tfceo.setText("");
	}

	public void ok() {
		if(kompcont == null)
			kompcont = new KompanijaController(kompanija, this);
		
		String naziv = tfnaziv.getText();
		String sediste = tfsediste.getText();
		String ceo = tfceo.getText();
		
		views.MainFrame.getInstance().setLstatus2(kompcont.createKompanija(naziv, sediste, ceo));
		
	}
}
