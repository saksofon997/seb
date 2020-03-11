package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import actions.EditAction;
import actions.ShowKompanijaForm;
import actions.ShowParameterForm;
import actions.ShowProizvodForm;

public class MyMenubar extends JMenuBar{

	private JMenu Mfile;
	private JMenu Medit;
	private JMenu Mview;
	private JButton Mhelp;
	private JButton Mabout;
	private JButton mniSrpski;
	private JButton mniEngleski;
	private JMenu Mnew;
	private JMenu Mimport;
	private JMenu Mexport;
	private JMenuItem Mopen;
	private JMenuItem Mexit;
	private JMenuItem Mkomp;
	private JMenuItem Mproiz;
	private JMenuItem Mparam;
	private JMenuItem Mswitch;
	private JMenuItem Msave;
	private JMenuItem Mtotext;
	private JMenuItem Mtoexcel;
	private JMenuItem Mtopdf;
	private JMenuItem Mfromtext;
	private JMenuItem Mfromexcel;
	private JMenuItem Mfrompdf;
	private JMenuItem Mcut;
	private JMenuItem Mcopy;
	private JMenuItem Mpaste;
	
	public MyMenubar() {
		
	this.setBackground(Color.LIGHT_GRAY);
	
	//glavni meni bar

	 Mfile = new JMenu(MainFrame.getInstance().getResourceBundle().getString("jmFile"));
	Mfile.setMnemonic('f');
	
	 Medit = new JMenu(MainFrame.getInstance().getResourceBundle().getString("jmEdit"));
	Medit.setMnemonic('e');
	
	 Mview = new JMenu(MainFrame.getInstance().getResourceBundle().getString("jmView"));
	Mview.setMnemonic('v');
	
	 Mhelp = new JButton(MainFrame.getInstance().getResourceBundle().getString("btHelp"));
	Mhelp.setMnemonic('h');
	Mhelp.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			HelpDialog.getInstance().setVisible(true);
		}
	});
	
	 Mabout = new JButton(MainFrame.getInstance().getResourceBundle().getString("btAbout"));
	Mabout.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(null, MainFrame.getInstance().getResourceBundle().getString("txtAbout"), MainFrame.getInstance().getResourceBundle().getString("aboutTitle"), JOptionPane.INFORMATION_MESSAGE);
		}
	});
	
	 mniSrpski=new JButton(MainFrame.getInstance().getResourceBundle().getString("mniSrpski"));
	mniSrpski.setSelected(true);
	mniSrpski.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Locale.setDefault(new Locale("sr","RS"));
			MainFrame.getInstance().changeLanguage();
			
			
		}
	});	
	
	 mniEngleski=new JButton(MainFrame.getInstance().getResourceBundle().getString("mniEngleski"));
	mniEngleski.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Locale.setDefault(new Locale("en","US"));
			MainFrame.getInstance().changeLanguage();
		}
	});
		
	//ugnjezdeni meniji
		
	 Mnew = new JMenu(MainFrame.getInstance().getResourceBundle().getString("jmNew"));
	Mnew.setMnemonic('n');
	
	 Mimport = new JMenu(MainFrame.getInstance().getResourceBundle().getString("jmImport"));
	Mimport.setMnemonic('i');
	
	 Mexport = new JMenu(MainFrame.getInstance().getResourceBundle().getString("jmExport"));
	Mexport.setMnemonic('e');
	
	//meni predmeti u file
		
	 Mopen = new JMenuItem(new EditAction(MainFrame.getInstance().getResourceBundle().getString("mOpen")));
	Mopen.setMnemonic('o');
	Mopen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK));
	
	 Mexit = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("mExit"));
	Mexit.setMnemonic('x');
	Mexit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	});
	
	 Mkomp = new JMenuItem(new ShowKompanijaForm(MainFrame.getInstance().getResourceBundle().getString("mKompanija")));
	Mkomp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, Event.CTRL_MASK));
	Mkomp.setMnemonic('k');
	
	 Mproiz = new JMenuItem(new ShowProizvodForm(MainFrame.getInstance().getResourceBundle().getString("mProizvod")));
	Mproiz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));
	Mproiz.setMnemonic('p');
	
	 Mparam = new JMenuItem(new ShowParameterForm(MainFrame.getInstance().getResourceBundle().getString("mParametar")));
	Mparam.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.CTRL_MASK));
	Mparam.setMnemonic('r');
	
	 Mswitch = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("mWorkspace"));
	Mswitch.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Pocetak.getInstance().setVisible(true);
			
			
		}
	});
	
	 Msave = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("mSave"));
	Msave.setMnemonic('s');
	Msave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
	
	 Mtotext = new JMenuItem("Txt");
	
	 Mtoexcel = new JMenuItem("Excel");
	
	 Mtopdf = new JMenuItem("PDF");
	
	 Mfromtext = new JMenuItem("Txt");
	
	 Mfromexcel = new JMenuItem("Excel");
	
	 Mfrompdf = new JMenuItem("PDF");
	
	//meni predmeti u edit
	
	 Mcut = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("mCut"));
	Mcut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
	Mcut.setMnemonic('u');
	
	 Mcopy = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("mCopy"));
	Mcopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
	Mcopy.setMnemonic('o');
	
	 Mpaste = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("mPaste"));
	Mpaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK));
	Mpaste.setMnemonic('a');
	
	//povezivanje
	
		//new
	Mnew.add(Mkomp);
	Mnew.add(Mproiz);
	Mnew.add(Mparam);
	
		//import
	Mimport.add(Mfromexcel);
	Mimport.add(Mfrompdf);
	Mimport.add(Mfromtext);
	
		//export
	Mexport.add(Mtoexcel);
	Mexport.add(Mtopdf);
	Mexport.add(Mtotext);
	
		//file
	Mfile.add(Mnew);
	Mfile.add(Mopen);
	Mfile.add(Mswitch);
	Mfile.addSeparator();
	Mfile.add(Msave);
	Mfile.addSeparator();
	Mfile.add(Mimport);
	Mfile.add(Mexport);
	Mfile.addSeparator();
	Mfile.add(Mexit);
	
		//edit
	Medit.add(Mcut);
	Medit.add(Mcopy);
	Medit.add(Mpaste);
	
		//view
	//Mview.add(Minprogress1);
	Mview.add(mniSrpski);
	Mview.add(mniEngleski);
	
		//glavni meni
	add(Mfile);
	add(Medit);
	add(Mview);
	add(Box.createHorizontalGlue());
	add(Mhelp);
	add(Box.createRigidArea(new Dimension(5, 10)));
	add(Mabout);
	}
	
	public void initComponents(){
		Mfile.setText(MainFrame.getInstance().getResourceBundle().getString("jmFile"));
		Medit.setText(MainFrame.getInstance().getResourceBundle().getString("jmEdit"));
		Mview.setText(MainFrame.getInstance().getResourceBundle().getString("jmView"));
		Mhelp.setText(MainFrame.getInstance().getResourceBundle().getString("btHelp"));
		Mabout.setText(MainFrame.getInstance().getResourceBundle().getString("btAbout"));
		Mnew.setText(MainFrame.getInstance().getResourceBundle().getString("jmNew"));
		Mimport.setText(MainFrame.getInstance().getResourceBundle().getString("jmImport"));
		Mexport.setText(MainFrame.getInstance().getResourceBundle().getString("jmExport"));
		Mopen.setText(MainFrame.getInstance().getResourceBundle().getString("mOpen"));
		Mexit.setText(MainFrame.getInstance().getResourceBundle().getString("mExit"));
		Mkomp.setText(MainFrame.getInstance().getResourceBundle().getString("mKompanija"));
		Mproiz.setText(MainFrame.getInstance().getResourceBundle().getString("mProizvod"));
		Mparam.setText(MainFrame.getInstance().getResourceBundle().getString("mParametar"));
		Mswitch.setText(MainFrame.getInstance().getResourceBundle().getString("mWorkspace"));
		Msave.setText(MainFrame.getInstance().getResourceBundle().getString("mSave"));
		Mcut.setText(MainFrame.getInstance().getResourceBundle().getString("mCut"));
		Mcopy.setText(MainFrame.getInstance().getResourceBundle().getString("mCopy"));
		Mpaste.setText(MainFrame.getInstance().getResourceBundle().getString("mPaste"));
		mniEngleski.setText(MainFrame.getInstance().getResourceBundle().getString("mniEngleski"));
		mniSrpski.setText(MainFrame.getInstance().getResourceBundle().getString("mniSrpski"));
	}
}
