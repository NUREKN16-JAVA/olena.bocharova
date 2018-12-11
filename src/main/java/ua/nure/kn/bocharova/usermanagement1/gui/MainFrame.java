package ua.nure.kn.bocharova.usermanagement1.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ua.nure.kn.bocharova.usermanagement1.User;
import ua.nure.kn.bocharova.usermanagement1.DB.DaoFactory;
import ua.nure.kn.bocharova.usermanagement1.DB.UserDAO;
import ua.nure.kn.bocharova.usermanagement1.util.Messages;

public class MainFrame extends JFrame {
	
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;
	private JPanel contentPanel;
	private JPanel browsePanel;
	private AddPanel addPanel;
	private UserDAO dao;
	private EditPanel editPanel;
	private DetailsPanel detailsPanel;

	public MainFrame() {
		super();
		dao=DaoFactory.getInstance().getUserDao();
		initialize();
	}
	

	public UserDAO getDao() {
		return dao;
	}


	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setTitle(Messages.getString("MainFrame.user_management")); //$NON-NLS-1$
		this.setContentPane(getContentPanel());
		
	}

    private JPanel getContentPanel() {
		if(contentPanel == null) {
			contentPanel=new JPanel();
			contentPanel.setLayout(new BorderLayout());
			contentPanel.add(getBrowsePanel(),BorderLayout.CENTER);
			
		}
		
		
		return contentPanel;
	}

	private JPanel getBrowsePanel() {
		if(browsePanel==null) {
			browsePanel=new BrowsePanel(this);
		}
		((BrowsePanel)browsePanel).initTable();
		return browsePanel;
	}

	public static void main(String[] args) {
		MainFrame frame =  new MainFrame();
		frame.setVisible(true);

	}

	public void showAddPanel() {
		showPanel(getAddPanel());
		
	}

	private void showPanel(JPanel panel) {
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setVisible(true);
		panel.repaint();
		
	}

	private AddPanel getAddPanel() {
		if(addPanel == null) {
			addPanel = new AddPanel(this);
		}
		
		return addPanel;
	}
	 private EditPanel getEditPanel() {
	        if (editPanel == null) {
	            editPanel = new EditPanel(this);
	        }
	       
	        return editPanel;
	    }
	
	public void showBrowsePanel() {
		showPanel(getBrowsePanel());
	}


	public void showEditPanel() {
		showPanel(getEditPanel());
		
	}


	public User getSelectedUser() {
		
		return ((BrowsePanel) browsePanel).getSelectedUser();
	}


	public void showDetailsPanel() {
		showPanel(getDetailsPanel());
		
	}


	private DetailsPanel getDetailsPanel() {
		 if (detailsPanel == null) {
	            detailsPanel = new DetailsPanel(this);
	        }
	        return detailsPanel;
	}

}
