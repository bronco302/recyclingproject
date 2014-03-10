package rmos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.*;

import rcm.*; 

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


//testing again if this works



class RCMUI extends JPanel {
	
	private RecyclingMachine rcm;
	JPanel inputpanel = new JPanel();
    JTextArea messageTextArea;
    JTextArea body;
    JLabel machineIDLabel;
    JLabel title;
    JButton addItemButton,helpButton;
    JButton aluminumButton,plasticButton,glassButton;
    
    public RCMUI(RecyclingMachine rcm){
    	setBorder(BorderFactory.createLineBorder(Color.BLACK));	
    	this.rcm = rcm;
    	machineIDLabel = new JLabel("Recycling Machine ID");
    	machineIDLabel.setHorizontalTextPosition(SwingConstants.LEFT);
    
    	title = new JLabel("Recycling Machine"); 	
    	messageTextArea = new JTextArea();
    	setBackground(Color.lightGray);
        body = new JTextArea(10,20);
        addItemButton = new JButton("Add Item");
    	helpButton = new JButton("Help");
    	helpButton.setSize(new Dimension(20, 20));
        aluminumButton = new JButton("Aluminum Cans");
        aluminumButton.setPreferredSize(new Dimension(50, 80));
        plasticButton = new JButton("Plastic Bottles");
        glassButton = new JButton("Glass Bottles");
      //  setSelectionMenu();
        setBorderLayout();
    }    
       
 	private void setSelectionMenu(){
 		
 		inputpanel.setLayout(new BorderLayout());
 		
 		inputpanel.add(title,BorderLayout.NORTH);
 	//	inputpanel.add(aluminumButton,BorderLayout.CENTER);
 	//	inputpanel.add(plasticButton,BorderLayout.CENTER);
 	//	inputpanel.add(glassButton,BorderLayout.CENTER);
 	}
 	private void setBorderLayout()
 	{	
 		JPanel innerGrid = new JPanel(new GridLayout(1,3));
 		inputpanel.setLayout(new BorderLayout());
 		inputpanel.setSize(400,700);
 		System.out.println(inputpanel.getSize());
 		innerGrid.add(aluminumButton);
 		innerGrid.add(plasticButton);
 		innerGrid.add(glassButton);
 		//inputpanel.add(messageTextArea);
 		inputpanel.add(title,BorderLayout.NORTH);
 		inputpanel.add(innerGrid,BorderLayout.CENTER);
 		//inputpanel.add(addItemButton,BorderLayout.CENTER);
 		//inputpanel.add(aluminumButton,BorderLayout.CENTER);
 	 	//inputpanel.add(plasticButton,BorderLayout.CENTER);
 	 	//inputpanel.add(glassButton,BorderLayout.CENTER);
 		inputpanel.add(machineIDLabel,BorderLayout.WEST);
 		inputpanel.add(helpButton,BorderLayout.SOUTH);
 		
 		
 
 		add(inputpanel);
 	//	createSelectionMenu();
 		
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
   		mainFrame.setLayout(new GridLayout(1,2));
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
