package installer;

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

import views.Pocetak;

public class PocetakI extends JFrame{

	private static PocetakI instance;
	
	static {
		instance = new PocetakI();
	}
	
	private JButton btok;
	
	private JButton srp;
	private JButton eng;
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public PocetakI() {
		super();
		
		setSize(350,200);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(350, 200));
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		Image ipoc = kit.getImage("images/pocetak.png");
		setIconImage(ipoc);
		
		setLayout(new GridBagLayout());
		
		setLocationRelativeTo(null);
		
		setTitle(Wizard.getInstance().getResourceBundle().getString("startTitle"));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		srp = new JButton(Wizard.getInstance().getResourceBundle().getString("mniSrpski"));
		srp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Locale.setDefault(new Locale("sr","RS"));
				Wizard.getInstance().changeLanguage();
			}
		});
		add(srp, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		eng = new JButton(Wizard.getInstance().getResourceBundle().getString("mniEngleski"));
		eng.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Locale.setDefault(new Locale("en","US"));
				Wizard.getInstance().changeLanguage();
			}
		});
		add(eng, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		btok = new JButton(Wizard.getInstance().getResourceBundle().getString("btOk"));
		btok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ok();
			}
		});
		add(btok, gbc);
	}
	
	public static PocetakI getInstance() {
		return instance;
	}
	
	public void initComponents() {
		setTitle(Wizard.getInstance().getResourceBundle().getString("startTitle"));
		btok.setText(Wizard.getInstance().getResourceBundle().getString("btOk"));
		srp.setText(Wizard.getInstance().getResourceBundle().getString("mniSrpski"));
		eng.setText(Wizard.getInstance().getResourceBundle().getString("mniEngleski"));
	}
	
	public void ok() {
		setVisible(false);
		WelcomePanel panel = new WelcomePanel(Wizard.getInstance().getKonfigurator());
		Wizard.getInstance().setMain(panel);
		Wizard.getInstance().setVisible(true);
	}
}
