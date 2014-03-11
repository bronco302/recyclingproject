package rmos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;

import rcm.*; 

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;


class RCMUI extends JPanel {
	
	private RecyclingMachine rcm;
	private ActionListener itemButtonEventHandler;
	private StringBuilder selectedItem;
	private JPanel inputpanel = new JPanel();
    private JTextArea messageTextArea,totalAmount;
    private JTextArea body;
    private JLabel machineIDLabel;
    private JLabel title,logo,selected;
    private JButton addItemButton,helpButton,finishButton;
    private JButton aluminumButton,plasticButton,glassButton;
    private ImageIcon icon;
    
    public RCMUI(RecyclingMachine rcm){
    	setBorder(BorderFactory.createLineBorder(Color.BLACK));	
    	this.rcm = rcm;
    	//machineIDLabel = new JLabel("Recycling Machine ID");
    	//machineIDLabel.setHorizontalTextPosition(SwingConstants.LEFT);
    	itemButtonEventHandler = new ItemButtonEventHandler();
    	selectedItem = new StringBuilder();
        setRCMcontrol();
    }    
    
    class ItemButtonEventHandler implements ActionListener
    {
    	
    	public void actionPerformed(ActionEvent event)
 	    {  
 		
 		   if (aluminumButton.isSelected()) { 
 			   aluminumButton.setEnabled(false);
 		   }
 		//   if (plasticButton.isSelected()) { 
 		 //   	  ecoOptions.append("Bamboo floors");
 		 //  }		   
 		//   if(glassButton.isSelected()){
 			   
 	//	   }
 	 
 	    }
    }
    
    
 	private void setRCMcontrol()
 	{	
 		JPanel titlePanel = createTitle();
 		JPanel buttonPanel = createItemButtons();
 		JPanel itemcountPanel = createItemCount();
 		JPanel addPanel = createControlButtons();
 		JPanel helpPanel = createHelpButton();
 		JPanel inputpanel = new JPanel(new GridLayout(5,1));
 			
 		inputpanel.add(titlePanel);
 		inputpanel.add(buttonPanel);
 	//	inputpanel.add(machineIDLabel);
 		inputpanel.add(itemcountPanel);
 		inputpanel.add(addPanel);
 		inputpanel.add(helpPanel);
 		inputpanel.setBorder(new EmptyBorder(20, 100, 30, 100));
 		add(inputpanel);
 	}
 	
 	public JPanel createTitle(){
 		JPanel panel = new JPanel();
 		panel.setLayout(new BorderLayout());
 		Font font = new Font("Verdana", Font.BOLD, 30);
 		icon = createImageIcon("/images/recycling.png","Recycling Symbol");
 		//if(icon ==  null){System.out.println("File not found or accessibleContext."); return panel;}
 		logo = new JLabel(icon,JLabel.CENTER);
 		title = new JLabel("Recycling Machine"); 	
    	title.setVerticalAlignment(JLabel.TOP);
    	title.setHorizontalAlignment(JLabel.CENTER);
    	title.setFont(font);
    
    	title.setBorder(new EmptyBorder(5, 5, 5, 5));
 		panel.add(title,BorderLayout.NORTH);
 		panel.add(logo,BorderLayout.SOUTH);
 		return panel;
 	}
 	
	public JPanel createItemButtons(){
 		
 		JPanel panel = new JPanel();
 		panel.setLayout(new GridLayout(1,3));
 		aluminumButton = new JButton("Aluminum Cans");
 		aluminumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
            
                aluminumButton.setEnabled(false);
                plasticButton.setEnabled(true);
                glassButton.setEnabled(true);
                addItemButton.setEnabled(true);
               
                rcm.initiateSession("Aluminum");
                selected.setText("You've selected Aluminum Cans, please begin inserting.");
                messageTextArea.setText(selectedItem.toString());
 				messageTextArea.append("Quantity: "+rcm.getQuantity());
 				messageTextArea.append("\nWeight(lbs): "+rcm.getWeight()+" ($"+rcm.getPaymentForItem()+"/lbs)");
 				totalAmount.setText("$"+rcm.getCurrentAmount());
                /*
                messageTextArea.append("\nYou've Selected Aluminum Cans, please begin inserting.");
                selectedItem.append("\nYou've Selected Aluminum Cans, please begin inserting.");
                */
            }
        }); 
        plasticButton = new JButton("Plastic Bottles");
        plasticButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
            	aluminumButton.setEnabled(true);
            	plasticButton.setEnabled(false);
            	glassButton.setEnabled(true);
                addItemButton.setEnabled(true);
               
                rcm.initiateSession("Plastic");
                selected.setText("You've selected Plastic Cans, please begin inserting.");
                messageTextArea.setText(selectedItem.toString());
 				messageTextArea.append("Quantity: "+rcm.getQuantity());
 				messageTextArea.append("\nWeight(lbs): "+rcm.getWeight()+" ($"+rcm.getPaymentForItem()+"/lbs)");
 				totalAmount.setText("$"+rcm.getCurrentAmount());
                /*
                messageTextArea.append("\nYou've Selected Plastic Bottles, please begin inserting.");
                selectedItem.append("\nYou've Selected Plastic Bottles, please begin inserting.");
                */
            }
        }); 
        glassButton = new JButton("Glass Bottles");
        
        panel.add(aluminumButton);
        panel.add(plasticButton);
        panel.add(glassButton);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        return panel;
         
 	}
 	
 	public JPanel createItemCount(){
 		
 		JPanel panel = new JPanel();
 		panel.setLayout(new BorderLayout());
 		JPanel innerpanel = new JPanel(new GridLayout(1,2));
 		JLabel label = new JLabel("Grand Total");
 		selected = new JLabel();
 		label.setHorizontalAlignment(JLabel.RIGHT);
 		
 		
 		messageTextArea = new JTextArea();
 		messageTextArea.setEditable(false);
 		messageTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));	
 		JScrollPane scroll = new JScrollPane (messageTextArea, 
  			   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
 		panel.add(scroll,BorderLayout.CENTER);
 		
 		totalAmount = new JTextArea("$ ");
 		totalAmount.setEditable(false);
 		totalAmount.setBorder(BorderFactory.createLineBorder(Color.BLACK));	
 		label.setBorder(new EmptyBorder(0, 0 , 0, 5));
 		innerpanel.add(label);
 		innerpanel.add(totalAmount);
 		innerpanel.setBorder(new EmptyBorder(5, 5, 5, 0));
 		panel.add(selected,BorderLayout.NORTH);
 		panel.add(innerpanel,BorderLayout.SOUTH);

 		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
 		
 		return panel;
 	}
 	

 	
 	public JPanel createControlButtons(){
 		
 		JPanel panel = new JPanel();
 		panel.setLayout(new GridLayout(1,2));
 		finishButton = new JButton("Finish");
 		finishButton.setEnabled(false);
 		finishButton.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e){
 				if(rcm.payCustomer()==0){
 					JOptionPane.showMessageDialog(getRootPane(),"Thank you for using our recycling services. Due to insufficient funds we will print you a coupon of equal value redeemble at any store. Coupon Value: "+rcm.getCurrentAmount());
 				}else{
 					JOptionPane.showMessageDialog(getRootPane(),"Thank you for using our recycling services. Retrieve your money from the cash dispenser. Total Amount: $"+rcm.getCurrentAmount());
 				}
 				try {
					FileHandler.writeToFile(rcm);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
 				rcm.clearData();
 				messageTextArea.setText("");
 				totalAmount.setText("$"+rcm.getCurrentAmount());
 				addItemButton.setEnabled(false);
 				finishButton.setEnabled(false);
 				aluminumButton.setEnabled(true);
 				plasticButton.setEnabled(true);
 				glassButton.setEnabled(true);
 				
 			}
 			
 		});
 		addItemButton = new JButton("Add Item");
 		addItemButton.setEnabled(false);
 		addItemButton.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e){
 				if(rcm.addItem()==0){
 					JOptionPane.showMessageDialog(getRootPane(),"This machine is full. Please finish any current transaction and/or try again later.");
 				}
 				finishButton.setEnabled(true);
 				messageTextArea.setText(selectedItem.toString());
 				messageTextArea.append("Quantity: "+rcm.getQuantity());
 				messageTextArea.append("\nWeight(lbs): "+rcm.getWeight()+" ($"+rcm.getPaymentForItem()+"/lbs)");
 				totalAmount.setText("$"+rcm.getCurrentAmount());
 			}
 			
 		});

 		panel.add(addItemButton);
 		panel.add(finishButton);
 		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
 		return panel;
 	}
 	public JPanel createHelpButton(){
 		JPanel panel = new JPanel();
 		panel.setLayout(new BorderLayout());
 		helpButton = new JButton("Help");
    	helpButton.setSize(new Dimension(20, 20));
 		panel.add(helpButton,BorderLayout.SOUTH);
 		return panel;
 	}
 	
 	private ImageIcon createImageIcon(String path, String description) {
 		java.net.URL imgURL = getClass().getResource(path);
 		if (imgURL != null) {	
 			return new ImageIcon(imgURL, description);
 		} else {
 			System.err.println("Couldn't find file: " + path);
 			return null;
 		}
	}
 	
 }


class RMOSUI extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel title;
	private JPanel inputpanel = new JPanel();
	private JList listofmachines;
	private String registeredmachines[];
	private RecyclingMonitoringStation rmos;
	
   
    public RMOSUI(RecyclingMonitoringStation rmos){
    	
    	this.rmos=rmos;
    	setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	setBackground(Color.lightGray);
    	adminLogin();
    //	if(adminLogin()){
    //		setRMOScontrol();
    //	}
    }    
    
    private void adminLogin(){
    	JPanel panel = new JPanel(new GridLayout(3,2));
    	JLabel user = new JLabel("Username");
    	JLabel pass = new JLabel("Password");
    	TitledBorder title = BorderFactory.createTitledBorder("Login");
    	JTextField username = new JTextField(5);
    	JTextField password = new JTextField(5);
    	JButton submit = new JButton("Submit");
    	
    	panel.add(user);
    	panel.add(username);
    	panel.add(pass);
    	panel.add(password);
    	panel.add(submit);
    	panel.setBorder(title);
    	
    	add(panel);
    }
    private void setRMOScontrol()
 	{	
    	JTabbedPane tabbedPane = new JTabbedPane();
    	JPanel machinespanel = new JPanel();
    	JPanel reportspanel = new JPanel();
    	tabbedPane.addTab("Machines",machinespanel);
    	tabbedPane.addTab("Reports",reportspanel);
 		JPanel titlePanel = createTitle();
 		JPanel machinesPanel = createMachinesList();
 		JPanel modifierPanel = createModifier();
 		//JPanel buttonPanel = createItemButtons();
 		//JPanel itemcountPanel = createItemCount();
 		//JPanel addPanel = createControlButtons();
 		//JPanel helpPanel = createHelpButton();
 		JPanel inputpanel = new JPanel(new BorderLayout());
 			
 		inputpanel.add(titlePanel,BorderLayout.NORTH);
 		inputpanel.add(machinesPanel,BorderLayout.WEST);
 		inputpanel.add(modifierPanel,BorderLayout.CENTER);
 	//	inputpanel.add(buttonPanel);
 	//	inputpanel.add(machineIDLabel);
 	//	inputpanel.add(itemcountPanel);
 	//	inputpanel.add(addPanel);
 	//	inputpanel.add(helpPanel);
 	//	inputpanel.setBorder(new EmptyBorder(20, 100, 30, 100));
 		
 		machinespanel.add(inputpanel);
 		add(tabbedPane);
 	}
    
    private JPanel createTitle(){
    	JPanel panel = new JPanel();
    	Font font = new Font("Verdana", Font.BOLD, 30);
    	
    	title = new JLabel("Recycling Monitoring Station");
    	title.setVerticalAlignment(JLabel.TOP);
    	title.setHorizontalAlignment(JLabel.CENTER);
    	title.setFont(font);
    	panel.add(title);
    	panel.setBorder(new EmptyBorder(20, 100, 30, 100));
    	return panel;
    }
    
    private JPanel createMachinesList(){
    	JPanel panel = new JPanel(new GridLayout(1,1));
    	TitledBorder title;
    	title = BorderFactory.createTitledBorder("Registered Machines (ID)");
    	listofmachines = new JList(splitStringToArray(rmos.getMachineIDS()));
    	listofmachines.setBorder(new EmptyBorder(10, 60, 100, 60));
    	panel.add(listofmachines);
    	panel.setBorder(title);
    	return panel;
    }
    
    private JPanel createModifier(){
    	JPanel panel = new JPanel();
    	
    	return panel;
    	
    }
    
    public String[] splitStringToArray(String string){
    	return string.split(",");
    }
 	
 }


public class RecyclingSystem {
	
    JFrame mainFrame;
       
    RCMUI mainPanel;
    RMOSUI mainPanel1;
    public RecyclingSystem(RecyclingMachine rcm, RecyclingMonitoringStation rmos) {
        
        mainFrame = new JFrame("Auction House");
        mainFrame.pack();
        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new RCMUI(rcm);
        mainPanel1 = new RMOSUI(rmos);
   		mainFrame.setLayout(new GridLayout(1,3));
   		mainFrame.getContentPane().add(mainPanel1);
       	mainFrame.getContentPane().add(mainPanel);
    	
       		      		
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	int height = screenSize.height;
    	int width = screenSize.width;
    	mainFrame.setSize(width, height);

    	mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
	public static void main(String [] args) throws IOException{
	/*
		Session s1 = new Session();
		s1.addRecyclableItem("Aluminum");
		s1.addItem("Aluminum");
		s1.addRecyclableItem("Plastic");
		s1.addItem("Plastic");

		System.out.println(s1.updateTotalAmount());
		
		
		RecyclingMachine rcm = new RecyclingMachine();
		
		rcm.initiateSession("Aluminum");
		rcm.addItem();
		rcm.initiateSession("Plastic");
		rcm.addItem();
		rcm.addItem();
		rcm.addItem();
		rcm.addItem();
		
		
		System.out.println(rcm.payCustomer());
		//System.out.println(rcm.getAvailableCash());
		
		 */
	//	RecyclingMonitoringStation rmos = new RecyclingMonitoringStation();
		
		RecyclingMachine rcm = new RecyclingMachine();
		RecyclingMonitoringStation rmos = new RecyclingMonitoringStation();
		RecyclingMachine rcm2 = new RecyclingMachine();
	//	rcm2.setGroup(0);
	//	System.out.println(rcm1.getMachineID());
	//	System.out.println(rcm2.getMachineID());
		rmos.addExistingMachine(rcm);
		rmos.addExistingMachine(rcm2);
		rcm2.initiateSession("Aluminum");
		rcm2.addItem();
		rcm2.initiateSession("Plastic");
		rcm2.addItem();
		rcm2.addItem();
		rcm2.addItem();
		rcm2.addItem();
	//	rmos.addMachine();
		
	//	rmos.getMachineIDS();
		//FileHandler.scanAndShow();
		FileHandler.writeToFile(rcm2);
		new RecyclingSystem(rcm,rmos);
		
	}
}
