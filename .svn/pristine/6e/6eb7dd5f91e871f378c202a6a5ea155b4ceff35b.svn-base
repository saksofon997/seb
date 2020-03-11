package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class HelpDialog extends JFrame{
	
	private static HelpDialog instance;
	
	static {
		instance = new HelpDialog();
	}
		
		private JTextField hpomoc;
		private JPanel doc;
		private String filePath;
		
		public HelpDialog() {
			// TODO Auto-generated constructor stub
			super();
			
			setSize(200,200);
			setLocationRelativeTo(null);
			setMinimumSize(new Dimension(200, 200));
			
			Toolkit kit = Toolkit.getDefaultToolkit();
			
			Image ihelp = kit.getImage("images/help.png");
			setIconImage(ihelp);
			
			this.filePath = "help/doc.pdf";
		     SwingController controller = new SwingController();

		        SwingViewBuilder factory = new SwingViewBuilder(controller);

		        JPanel viewerComponentPanel = factory.buildViewerPanel();

		        controller.getDocumentViewController().setAnnotationCallback(
		                new org.icepdf.ri.common.MyAnnotationCallback(
		                        controller.getDocumentViewController()));
			
			setLayout(new BorderLayout());

			setTitle(MainFrame.getInstance().getResourceBundle().getString("helpTitle"));
			
			setLocationRelativeTo(null);
			
			add(viewerComponentPanel);
			
			controller.openDocument(filePath);

	        this.pack();

		}
	
	public static HelpDialog getInstance() {
		return instance;
	}
}