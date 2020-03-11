package installer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import models.Konfigurator;
import views.MainFrame;

public class Installer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
	    Wizard wizard = Wizard.getInstance();
	    
	    JFileChooser fc=new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Setup Files", "cnf", "cnf");
		fc.setFileFilter(filter);
	    int a=fc.showOpenDialog(MainFrame.getInstance());
		File f=fc.getSelectedFile();
		
		PocetakI pocetak = PocetakI.getInstance();
	    
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showConfirmDialog(null, Wizard.getInstance().getResourceBundle().getString("greskawiz"));
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showConfirmDialog(null, Wizard.getInstance().getResourceBundle().getString("greskawiz"));
			System.exit(0);
		}
		try {
			Konfigurator konfigurator = (Konfigurator) ois.readObject();
			wizard.setInstall(konfigurator);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showConfirmDialog(null, Wizard.getInstance().getResourceBundle().getString("greskawiz"));
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showConfirmDialog(null, Wizard.getInstance().getResourceBundle().getString("greskawiz"));
			System.exit(0);
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		pocetak.setVisible(true); 
	}

}
