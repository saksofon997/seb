package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import models.Parametar;
import models.Proizvod;
import models.SerializableZipFile;
import views.tree.CheckBoxNode;
import views.tree.CheckBoxNodeEditor;
import views.tree.CheckBoxNodeRenderer;

public class Konfigurator extends JFrame{

	private static Konfigurator instance = null;
	
	private JLabel lizvor;
	private JLabel lwelcome;
	private JLabel llicence;
	private JLabel lverzija;
	
	private JTextField tfizvor;
	private JTextField tfwelcome;
	private JTextField tflicence;
	private JTextField tfverzija;
	
	private JPanel pleft;
	private JPanel pright;
	
	private JTree tree = new JTree();
	private DefaultTreeModel treeModel;
	
	private JButton btexport;
	private JButton btcancel;
	private JButton btfilechooser;
	
	private JScrollPane pane;
	
	private Properties properties;
	
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public Konfigurator() {
		super();
		
		setSize(640,480);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(640, 480));
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		Image ipoc = kit.getImage("images/pocetak.png");
		setIconImage(ipoc);
		
		setLayout(new BorderLayout());
		
		setTitle(MainFrame.getInstance().getResourceBundle().getString("konfTitle"));
		
		setLocationRelativeTo(null);
		
		pleft = new JPanel();
		pright = new JPanel();
		
		pleft = new JPanel(new BorderLayout());
		pleft.setPreferredSize(new Dimension(250, 500));
		
		pright.setLayout(new GridBagLayout());
		
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		lizvor = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lizvorkonf"));
		pright.add(lizvor, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		btfilechooser = new JButton("...");
		btfilechooser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fc=new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Zip Files", "zip", "zip");
				
				fc.setFileFilter(filter);
			    int a=fc.showOpenDialog(MainFrame.getInstance());
				File f=fc.getSelectedFile();
				
				String s=f.getPath();
				
				tfizvor.setText(s);
				
			}
		});
		pright.add(btfilechooser, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		tfizvor = new JTextField();
		pright.add(tfizvor, gbc);
		
		tfizvor.setPreferredSize(new Dimension(150, 20));
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		lwelcome = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lwelcomek"));
		pright.add(lwelcome, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		tfwelcome = new JTextField();
		pright.add(tfwelcome, gbc);
		
		tfwelcome.setPreferredSize(new Dimension(150, 120));
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		llicence = new JLabel(MainFrame.getInstance().getResourceBundle().getString("llicencek"));
		pright.add(llicence, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		tflicence = new JTextField();
		pright.add(tflicence, gbc);
		
		tflicence.setPreferredSize(new Dimension(150, 120));
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		lverzija = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lverzijak"));
		pright.add(lverzija, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		tfverzija = new JTextField();
		pright.add(tfverzija, gbc);
		
		tfverzija.setPreferredSize(new Dimension(150, 20));
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		btexport = new JButton(MainFrame.getInstance().getResourceBundle().getString("btexportk"));
		pright.add(btexport, gbc);
		btexport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				properties = new Properties();
				
				DefaultMutableTreeNode root = ((DefaultMutableTreeNode)tree.getModel().getRoot());
				
				writeProperties(properties, root);
				
				String welcome = tfwelcome.getText();
				String licence = tflicence.getText();
				String version = tfverzija.getText();
				
				SerializableZipFile zipFile = null;
				
				try {
					zipFile = new SerializableZipFile(new File(tfizvor.getText()));
				} catch (ZipException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				

				models.Konfigurator setup = null;
				try {
					setup = new models.Konfigurator(properties, ((Proizvod)root.getUserObject()).getNaziv(), welcome, licence, version, zipFile);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("greska u pravljenju setup fajla");
				}
				
				JFileChooser fileChooser = new JFileChooser();
				File fajl  = null;
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Properties", "ini", "ini");
				fileChooser.setFileFilter(filter);
				if (fileChooser.showSaveDialog(Konfigurator.getInstance()) == JFileChooser.APPROVE_OPTION) {
				  fajl = fileChooser.getSelectedFile();
				}
				
				try {
				File file = new File(fajl.getPath());
				FileOutputStream fileOut = new FileOutputStream(file);
				properties.store(fileOut, "Properties");
				fileOut.close();
			} catch (FileNotFoundException e4) {
				e4.printStackTrace();
			} catch (IOException e4) {
				e4.printStackTrace();
			}
				
				fileChooser = new JFileChooser();
				File file  = null;
				filter = new FileNameExtensionFilter(MainFrame.getInstance().getResourceBundle().getString("btKonf"), "cnf", "cnf");
				fileChooser.setFileFilter(filter);
				if (fileChooser.showSaveDialog(Konfigurator.getInstance()) == JFileChooser.APPROVE_OPTION) {
				  file = fileChooser.getSelectedFile();
				}
				
				
				ObjectOutputStream oos = null;
				try {
					oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					try {
						oos.writeObject(setup);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				} finally {
					try {
						oos.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} //Zatvara i tok nizeg nivoa.
				}
				
				setVisible(false);
				
				try {
					zipFile.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		btcancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("btOdustani"));
		pright.add(btcancel, gbc);
		btcancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		initKonf();

		pane = new JScrollPane(tree);
		pleft.add(pane);
		add(pleft, BorderLayout.WEST);
		add(pright, BorderLayout.CENTER);
		
	}
	
	protected void writeProperties(Properties prop, DefaultMutableTreeNode node) {
		// TODO Auto-generated method stub
		int childCount = node.getChildCount();  

	    for (int i = 0; i < childCount; i++) {

	        DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
	        if (childNode.getChildCount() > 0) {
	            writeProperties(prop, childNode);
	        } else {
	            String string = "";
	            findPath(childNode, string);
	            
	            if(((CheckBoxNode)childNode.getUserObject()).isChecked()) {
	            properties.setProperty(string, ((Parametar)((CheckBoxNode)childNode.getUserObject()).getPar()).getVrednost());
	            
	            }
	        }

	    }
	}

	protected void findPath(DefaultMutableTreeNode node, String s) {
		// TODO Auto-generated method stub

		    int childCount = node.getChildCount();

		    s = s + ((CheckBoxNode)node.getUserObject()).toString() + '.';

		    for (int i = 0; i < childCount; i++) {

		        DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
		        if (childNode.getChildCount() > 0) {
		            findPath(childNode, s);
		        } else {
		            return;
		        }

		    }

	}

	public static Konfigurator getInstance() {
		if(instance == null) {
		instance = new Konfigurator();
		}
		return instance;
	}
	
	public void initKonf() {
		DefaultMutableTreeNode sel = (DefaultMutableTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		
		DefaultMutableTreeNode novi = new DefaultMutableTreeNode(sel.getUserObject());
		
		if(!(sel.getUserObject() instanceof Proizvod))
			return;
		
		treeModel = new DefaultTreeModel(novi);
		metoda(((Proizvod)novi.getUserObject()).getChildren(), novi);
		
		treeModel.setAsksAllowsChildren(true);
		tree = new JTree(treeModel);
		tree.setEditable(false);
		
		final CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();
		tree.setCellRenderer(renderer);

		final CheckBoxNodeEditor editor = new CheckBoxNodeEditor(tree);
		tree.setCellEditor(editor);
		tree.setEditable(true);

		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		setTree(tree);
		
		
		if(instance != null) {
		pleft.remove(pane);
		pane = new JScrollPane(tree);
		pleft.add(pane);
        invalidate(); validate();
        repaint();
		}
		
		setVisible(true);
	}
	
	public void metoda(List<Object> list, DefaultMutableTreeNode parent) {
		if(list.isEmpty())
		{
			return;
		}
		for(int i = 0; i < list.size(); i++)
		{
				
				CheckBoxNode boxNode = new CheckBoxNode((Parametar)list.get(i), true);

				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(boxNode);
				
				treeModel.insertNodeInto(newNode, parent, parent.getChildCount());
				
				metoda(((Parametar) list.get(i)).getChildren(), newNode);
				
		}
	}

	public JTree getTree() {
		return tree;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}

	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(DefaultTreeModel treeModel) {
		this.treeModel = treeModel;
	}
	
	public void initComponents() {
		
		//lokalizacija
	}
}
