package views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import actions.AddProizvod;
import actions.ProizvodController;
import models.Proizvod;

public class ProizvodView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lbnaziv;
	private JLabel lbverzija;
	private JLabel lbkreator;
	private JLabel lblogo;
	private JTextField tfnaziv;
	private JTextField tfverzija;
	private JTextField tfkreator;
	
	private JButton btok;
	private JButton btdodaj;
	private JButton btlogo;
	private JButton btodustani;
	private JButton btuklonilogo;
	private JButton btkraj;
	
	private Proizvod proizvod;
	private ProizvodController proizvodController;
	
	private GridBagConstraints gbc = new GridBagConstraints();
	
	public ProizvodView(Proizvod proizvod) {
		initview();
		setProizvod(proizvod);
	}
	
	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
		proizvodController = null;
		refreshView();
	}
	
	public void refreshView() {
		tfnaziv.setText(proizvod.getNaziv());
		tfverzija.setText(proizvod.getVerzija());
		tfkreator.setText(proizvod.getKreator());
		Icon icon = null;
		if (proizvod.getLogo() != null) {
			icon = new ImageIcon(proizvod.getLogo());
		}
		lblogo.setIcon(icon);	
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
		lbkreator = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lbCena"));
		add(lbkreator, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		lbverzija = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lbVerzija"));
		add(lbverzija, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		lblogo = new JLabel();
		lblogo.setBorder(BorderFactory.createLoweredBevelBorder());
		lblogo.setPreferredSize(new Dimension(126, 85));
		lblogo.setMaximumSize(new Dimension(126, 85));
		add(lblogo, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		tfnaziv = new JTextField();
		add(tfnaziv, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		tfkreator = new JTextField();
		add(tfkreator, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		tfverzija = new JTextField();
		add(tfverzija, gbc);
		
		tfnaziv.setPreferredSize(new Dimension(100, 20));
		tfkreator.setPreferredSize(new Dimension(100, 20));
		tfverzija.setPreferredSize(new Dimension(100, 20));
		
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
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		btlogo = new JButton(MainFrame.getInstance().getResourceBundle().getString("btAddLogo"));
		btlogo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addLogo();
			}
		});
		add(btlogo, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 3;
		btuklonilogo = new JButton(MainFrame.getInstance().getResourceBundle().getString("btRemLogo"));
		btuklonilogo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removelogo();
			}
		});
		add(btuklonilogo, gbc);
		
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
		gbc.gridy = 3;
		btdodaj = new JButton(new AddProizvod(MainFrame.getInstance().getResourceBundle().getString("btDodaj")));
		add(btdodaj, gbc);
		
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
	
	protected void removelogo() {
		// TODO Auto-generated method stub
		lblogo.setIcon(null);
	}

	public void clear() {
		// TODO Auto-generated method stub
		tfnaziv.setText("");
		tfkreator.setText("");
		tfverzija.setText("");
		lblogo.setIcon(null);
	}

	protected void addLogo() {
		// TODO Auto-generated method stub
		JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			ImageIcon icon = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
			lblogo.setIcon(icon);
		}
	}

	public void ok() {
		if(proizvodController == null)
			proizvodController = new ProizvodController(proizvod, this);
		
		String naziv = tfnaziv.getText();
		String kreator = tfkreator.getText();
		String verzija = tfverzija.getText();
		Image logo = null;
		if(lblogo.getIcon() != null) {
			logo = ((ImageIcon) lblogo.getIcon()).getImage();
		}
		
		views.MainFrame.getInstance().setLstatus2(proizvodController.createProizvod(naziv, kreator, verzija, logo));
	}

}
