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

//testing again if this works



class RCMUI extends JPanel {
	
	private RecyclingMachine rcm;
	JPanel inputpanel = new JPanel();
    JTextArea messageTextArea;
    JTextArea body;
    JLabel machineIDLabel;
    JLabel title;
    JButton addItemButton,helpButton,finishButton;
    JButton aluminumButton,plasticButton,glassButton;
    ImageIcon icon;
    
    public RCMUI(RecyclingMachine rcm){
    	setBorder(BorderFactory.createLineBorder(Color.BLACK));	
    	this.rcm = rcm;
    	//machineIDLabel = new JLabel("Recycling Machine ID");
    	//machineIDLabel.setHorizontalTextPosition(SwingConstants.LEFT);
   
    	setBackground(Color.lightGray);
        
    	helpButton = new JButton("Help");
    	helpButton.setSize(new Dimension(20, 20));
       
      //  setSelectionMenu();
        setRCMcontrol();
    }    
       
 	private void setSelectionMenu(){
 		
 		inputpanel.setLayout(new BorderLayout());
 		
 		inputpanel.add(title,BorderLayout.NORTH);
 
 	}
 	private void setRCMcontrol()
 	{	
 		JPanel buttonPanel = createItemButtons();
 		JPanel itemcountPanel = createItemCount();
 		JPanel addPanel = createControlButtons();
 		JPanel titlePanel = createTitle();
 		JPanel inputpanel = new JPanel(new GridLayout(5,1));
 			
 		inputpanel.add(titlePanel);
 		inputpanel.add(buttonPanel);
 	//	inputpanel.add(machineIDLabel);
 		inputpanel.add(itemcountPanel);
 		inputpanel.add(addPanel);
 		inputpanel.add(helpButton,BorderLayout.SOUTH);

 		inputpanel.setBorder(new EmptyBorder(100, 100, 100, 100));
 		add(inputpanel);

 		
 	}
 	
 	public JPanel createTitle(){
 		JPanel panel = new JPanel();
 		icon = createImageIcon("images/recycling.png","Recycling Symbol");
 	//	if(icon ==  null){System.out.println("File not found or accessibleContext."); return panel;}
 		title = new JLabel("Recycling Machine",icon,JLabel.CENTER); 	
    	title.setVerticalAlignment(JLabel.TOP);
    	title.setHorizontalAlignment(JLabel.CENTER);
 		
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

	public JPanel createItemButtons(){
 		
 		JPanel panel = new JPanel();
 		panel.setLayout(new GridLayout(1,3));
 		aluminumButton = new JButton("Aluminum Cans");
 		aluminumButton.setPreferredSize(new Dimension(50, 80));
        plasticButton = new JButton("Plastic Bottles");
        glassButton = new JButton("Glass Bottles");
        panel.add(aluminumButton);
        panel.add(plasticButton);
        panel.add(glassButton);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        return panel;
         
 	}
 	
 	public JPanel createItemCount(){
 		JPanel panel = new JPanel();
 		panel.setLayout(new GridLayout(1,1));
 	//	JLabel label = new JLabel("");
 		messageTextArea = new JTextArea();
 		messageTextArea.setEditable(false);
 		messageTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));	
 		panel.add(messageTextArea);
 		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
 		return panel;
 	}
 	
 	public JPanel createControlButtons(){
 		JPanel panel = new JPanel();
 		panel.setLayout(new BorderLayout());
 		finishButton = new JButton("Finish");
 		finishButton.setPreferredSize(new Dimension(90, 40));
 		addItemButton = new JButton("Add Item");
 		addItemButton.setPreferredSize(new Dimension(90,40));
 		panel.add(addItemButton,BorderLayout.WEST);
 		panel.add(finishButton,BorderLayout.EAST);
 		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
 		return panel;
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
		RecyclingMachine rcm = new RecyclingMachine();
		new RecyclingSystem(rcm);
		
	}
}
