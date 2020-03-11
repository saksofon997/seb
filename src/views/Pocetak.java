package views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Pocetak extends JFrame{

	private static Pocetak instance;
	
	static {
		instance = new Pocetak();
	}
	
	private JLabel lradniprostor;
	private JLabel luser;
	
	private JTextField tfradniprostor;
	private JTextField tfuser;
	
	private JButton btok;
	
	private JButton srp;
	private JButton eng;
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public Pocetak() {
		super();
		
		setSize(350,200);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(350, 200));
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		Image ipoc = kit.getImage("images/pocetak.png");
		setIconImage(ipoc);
		
		setLayout(new GridBagLayout());
		
		setLocationRelativeTo(null);
		
		setTitle(MainFrame.getInstance().getResourceBundle().getString("startTitle"));
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		lradniprostor = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lbWorkspace"));
		add(lradniprostor, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		luser = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lbKorisnik"));
		add(luser, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		tfradniprostor = new JTextField();
		add(tfradniprostor, gbc);
		tfradniprostor.setPreferredSize(new Dimension(100, 20));
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		tfuser = new JTextField();
		add(tfuser, gbc);
		tfuser.setPreferredSize(new Dimension(100, 20));
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		srp = new JButton(MainFrame.getInstance().getResourceBundle().getString("mniSrpski"));
		srp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Locale.setDefault(new Locale("sr","RS"));
				MainFrame.getInstance().changeLanguage();
			}
		});
		add(srp, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		eng = new JButton(MainFrame.getInstance().getResourceBundle().getString("mniEngleski"));
		eng.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Locale.setDefault(new Locale("en","US"));
				MainFrame.getInstance().changeLanguage();
			}
		});
		add(eng, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		btok = new JButton(MainFrame.getInstance().getResourceBundle().getString("btOk"));
		btok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ok();
			}
		});
		add(btok, gbc);
	}
	
	public static Pocetak getInstance() {
		return instance;
	}
	
	public void initComponents() {
		setTitle(MainFrame.getInstance().getResourceBundle().getString("startTitle"));
		lradniprostor.setText(MainFrame.getInstance().getResourceBundle().getString("lbWorkspace"));
		luser.setText(MainFrame.getInstance().getResourceBundle().getString("lbKorisnik"));
		btok.setText(MainFrame.getInstance().getResourceBundle().getString("btOk"));
		srp.setText(MainFrame.getInstance().getResourceBundle().getString("mniSrpski"));
		eng.setText(MainFrame.getInstance().getResourceBundle().getString("mniEngleski"));
	}
	
	public void ok() {
		MainFrame.getInstance().setLkorisnik(tfuser.getText());
		MainFrame.getInstance().setWorkspaceName(tfradniprostor.getText());
		this.setVisible(false);
	}
}
