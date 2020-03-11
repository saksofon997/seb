package installer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.apache.commons.io.IOUtils;

import models.Konfigurator;
import models.SerializableZipFile;

public class Wizard extends JFrame{

	private static Wizard instance = null;
	
	private ResourceBundle resourceBundle;
	
	private JPanel main;
	
	Konfigurator konfigurator;
	
	public Wizard() {		
		Locale.setDefault(new Locale("sr","RS"));
		resourceBundle =ResourceBundle.getBundle( "views.MessageResources.MessageResources", Locale.getDefault());
	}
	
	public void initGUI() {
		
		UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yesOption"));
		UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("noOption"));
		UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("okOption"));
		UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancelOption"));
		
		setSize(640,480);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(640, 480));
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		Image ipoc = kit.getImage("images/pocetak.png");
		setIconImage(ipoc);
		
		setLayout(new BorderLayout());
		
		setLocationRelativeTo(null);
		
		main = new JPanel();
		main.setSize(new Dimension(600, 400));
		add(main, BorderLayout.CENTER);
	}
	
	
	
	public static Wizard getInstance() {
		if(instance == null) {
		instance = new Wizard();
		instance.initGUI();
		}
		
		return instance;
	}



	public void unzip(File outputDir) throws IOException {
		SerializableZipFile zipFile = konfigurator.getZipFile();
		try {
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				File entryDestination = new File(outputDir, entry.getName());
				if (entry.isDirectory()) {
					entryDestination.mkdirs();
				} else {
					entryDestination.getParentFile().mkdirs();
					InputStream in = zipFile.getInputStream(entry);
					OutputStream out = new FileOutputStream(entryDestination);
					IOUtils.copy(in, out);
					IOUtils.closeQuietly(in);
					out.close();
				}
			}
		} finally {
			zipFile.close();
		}
	}

	public JPanel getMain() {
		return main;
	}

	public void setMain(JPanel panel) {
		this.remove(main);
        main = panel;
        this.add(main, BorderLayout.CENTER);
        invalidate(); validate();
        repaint();
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public void changeLanguage() {
		// TODO Auto-generated method stub
		resourceBundle = ResourceBundle.getBundle( "views.MessageResources.MessageResources", Locale.getDefault() );

		PocetakI.getInstance().initComponents();	
		
		UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yesOption"));
		UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("noOption"));
		UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("okOption"));
		UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancelOption"));
	}

	public void setInstall(Konfigurator konf) {
		// TODO Auto-generated method stub
		if(konf == null || !(konf instanceof Konfigurator)) {
			System.out.println("greska");
			System.exit(0);
		}
		konfigurator = konf;
		
		setTitle(konf.getName() + konf.getVersion());

	}

	public Konfigurator getKonfigurator() {
		return konfigurator;
	}
	
}
