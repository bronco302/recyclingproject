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

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ImageIcon;


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
                finishButton.setEnabled(true);
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
                finishButton.setEnabled(true);
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
 		final StringBuilder tempBuilder = new StringBuilder();
 		JPanel panel = new JPanel();
 		panel.setLayout(new GridLayout(1,2));
 		finishButton = new JButton("Finish");
 		finishButton.setEnabled(false);
 		addItemButton = new JButton("Add Item");
 		addItemButton.setEnabled(false);
 		addItemButton.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e){
 				rcm.addItem();
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
	
	
	JPanel inputpanel = new JPanel();

    JTextArea messageTextArea;

    
    public RMOSUI(){
    	
    	
    	
    	setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	messageTextArea = new JTextArea();
    	
    	setBackground(Color.lightGray);
    	
        messageTextArea.setText("Recycling Monitoring System");
        messageTextArea.setEditable(false);
        messageTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	setGridLayout();
    }    
       
 	private void setGridLayout()
 	{	
 		
 		inputpanel.setLayout(new BorderLayout());
 		inputpanel.add(messageTextArea,BorderLayout.NORTH);
 		add(inputpanel);
 	}
 }
public class RecyclingSystem {
	
    JFrame mainFrame;
       
    RCMUI mainPanel;
    RMOSUI mainPanel1;
    public RecyclingSystem(RecyclingMachine rcm) {
        
        mainFrame = new JFrame("Auction House");
        mainFrame.pack();
        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new RCMUI(rcm);
        mainPanel1 = new RMOSUI();
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
	public static void main(String [] args){
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
	//	RecyclingMachine rcm2 = new RecyclingMachine();
	//	rcm2.setGroup(0);
	//	System.out.println(rcm1.getMachineID());
	//	System.out.println(rcm2.getMachineID());
	//	rmos.addExistingMachine(rcm1);
//		rmos.addExistingMachine(rcm2);
	//	rmos.addMachine();
		
	//	rmos.getMachineIDS();
		
		new RecyclingSystem(rcm);
		
	}
}
