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
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;


class RCMUI extends JPanel {
	
	private RecyclingMachine rcm;
	private RecyclingMonitoringStation rmos;
	private RMOSUI rmosui;
	
	private ActionListener itemButtonEventHandler;
	private StringBuilder selectedItem;
	private JPanel inputpanel;
    private JTextArea messageTextArea,totalAmount;
    private JTextArea body;
    private JLabel machineIDLabel;
    private JLabel title,logo,selected;
    private JButton addItemButton,helpButton,finishButton;
    private JButton aluminumButton,plasticButton,glassButton;
    private ImageIcon icon;
    
    public RCMUI(RecyclingMachine rcm,RecyclingMonitoringStation rmos){
    	setBorder(BorderFactory.createLineBorder(Color.BLACK));	
    	this.rcm = rcm;
    	this.rmos = rmos;
    	inputpanel = new JPanel(new GridLayout(5,1));
    	//machineIDLabel = new JLabel("Recycling Machine ID");
    	//machineIDLabel.setHorizontalTextPosition(SwingConstants.LEFT);
    	
    	selectedItem = new StringBuilder();
        setRCMcontrol();
    }    
    
       
    public void rmosConnection(RMOSUI rmosui){
    	this.rmosui = rmosui;
    	
    }
 	public void setRCMcontrol()
 	{	
 		
 		JPanel titlePanel = createTitle();
 		JPanel buttonPanel = createItemButtons();
 		JPanel itemcountPanel = createItemCount();
 		JPanel addPanel = createControlButtons();
 		JPanel helpPanel = createHelpButton();
 		
 		inputpanel.removeAll();	
 		inputpanel.add(titlePanel);
 		inputpanel.add(buttonPanel);
 		inputpanel.add(itemcountPanel);
 		inputpanel.add(addPanel);
 		inputpanel.add(helpPanel);
 		inputpanel.setBorder(new EmptyBorder(20, 100, 30, 100));
 		inputpanel.revalidate();
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
            	if(rcm.itemValid("Aluminum")){
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
            }
        }); 
        plasticButton = new JButton("Plastic Bottles");
        plasticButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
            	if(rcm.itemValid("Plastic")){
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
            }
        }); 
        glassButton = new JButton("Glass Bottles");
        glassButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
            	if(rcm.itemValid("Glass")){
            	aluminumButton.setEnabled(true);
            	plasticButton.setEnabled(true);
            	glassButton.setEnabled(false);
                addItemButton.setEnabled(true);
               
                rcm.initiateSession("Glass");
                selected.setText("You've selected Glass Bottles, please begin inserting.");
                messageTextArea.setText(selectedItem.toString());
 				messageTextArea.append("Quantity: "+rcm.getQuantity());
 				messageTextArea.append("\nWeight(lbs): "+rcm.getWeight()+" ($"+rcm.getPaymentForItem()+"/lbs)");
 				totalAmount.setText("$"+rcm.getCurrentAmount());
                /*
                messageTextArea.append("\nYou've Selected Plastic Bottles, please begin inserting.");
                selectedItem.append("\nYou've Selected Plastic Bottles, please begin inserting.");
                */
            	}
            }
        }); 
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
 				rmosui.createSettings();
 				}
 			
 				
 			
 			
 		});
 		addItemButton = new JButton("Add Item");
 		addItemButton.setEnabled(false);
 		addItemButton.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e){
 				if (rcm.isActive()){
 					if(rcm.addItem()==0){
 						JOptionPane.showMessageDialog(getRootPane(),"This machine is full. Please finish any current transaction and/or try again later.");
 					}
 					finishButton.setEnabled(true);
 					messageTextArea.setText(selectedItem.toString());
 					messageTextArea.append("Quantity: "+rcm.getQuantity());
 					messageTextArea.append("\nWeight(lbs): "+rcm.getWeight()+" ($"+rcm.getPaymentForItem()+"/lbs)");
 					totalAmount.setText("$"+rcm.getCurrentAmount());
 				}
 				else{
 					finishButton.setEnabled(false);
						JOptionPane.showMessageDialog(getRootPane(),"RCM is currently unavailable. Please try again later.");

 				}
 			}
 			
 		});

 		panel.add(addItemButton);
 		panel.add(finishButton);
 		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
 		return panel;
 	}
 	public JPanel createHelpButton(){
 		JPanel panel = new JPanel();
 		JPanel panel2 = new JPanel(new GridLayout(1,2));
 		panel.setLayout(new BorderLayout());
 		JComboBox list = new JComboBox(splitStringToArray(rmos.getMachineIDS()));
 		list.setSelectedIndex(0);
 		list.addActionListener(new ActionListener(){
 		   
 		    public void actionPerformed(ActionEvent e) {
 		        JComboBox cb = (JComboBox)e.getSource();
 		       
			//	JOptionPane.showMessageDialog(getRootPane(),(String)cb.getSelectedItem());
				getRCM(Integer.parseInt((String)cb.getSelectedItem()));
				setRCMcontrol();
				
				

 		    }
 		    
 		});
 		JLabel machineidlabel = new JLabel("Machine ID: "+rcm.getMachineID());
 		
 		helpButton = new JButton("Help");
    	helpButton.setSize(new Dimension(20, 20));
    	panel2.add(machineidlabel);
    	panel2.add(list);
    	panel.add(panel2,BorderLayout.NORTH);
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
 	
 	public void getRCM(int machineID){
 		rcm = rmos.getRCM(machineID);
 		
 	}
 	
 	public String[] splitStringToArray(String string){
    	return string.split(",");
    }
 	
 }


class RMOSUI extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RCMUI rcmui;
	private JLabel title,machineIDlabel,operationalstatuslabel,moneyleftlabel,moneycapacitylabel,weightcapacitylabel,currentweightlabel,lastemptiedlabel;
	private JLabel machinelocationlabel;
	private JPanel inputpanel ;
	private JList listofmachines;
	private String registeredmachines[];
	private RecyclingMonitoringStation rmos;
	private JPanel modifierPanel,machinepanel;
	private JButton activationButton,emptyrcmButton;
	private int selectedmachine;
	private JPanel adminpanel;
	private BarChart chart;
	DecimalFormat df ;
	
   
    public RMOSUI(RecyclingMonitoringStation rmos){
    	
    	this.rmos=rmos;
    	setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	setBackground(Color.lightGray);
    	df = new DecimalFormat("#.##");
    	//adminLogin();
    //	if(adminLogin()){
    	inputpanel = new JPanel(new BorderLayout());
    	modifierPanel = new JPanel(new GridLayout(12,2));
    	machinepanel = new JPanel(new GridLayout(1,1));
   	//	setRMOScontrol();
    //	}
    	adminLogin();
    }    
    
    public void rcmConnect(RCMUI rcmui){
    	this.rcmui = rcmui;
    	
    }
    private void adminLogin(){
    	final Admin admin = new Admin();
    	adminpanel = new JPanel(new GridLayout(3,2));
    	JLabel user = new JLabel("Username");
    	JLabel pass = new JLabel("Password");
    	TitledBorder title = BorderFactory.createTitledBorder("Login");
    	final JTextField username = new JTextField(5);
    	final JTextField password = new JTextField(5);
    	JButton submit = new JButton("Submit");
    	submit.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			
 				if(admin.validate(username.getText(), password.getText())){
 					
 					setRMOScontrol();
 					return;
 				}
 				else
 				{
 					JOptionPane.showMessageDialog(getRootPane(),"The username and password combination are not valid. Please try again.");

 				}
 			
 			}
    	});
    	
    	
    	adminpanel.add(user);
    	adminpanel.add(username);
    	adminpanel.add(pass);
    	adminpanel.add(password);
    	adminpanel.add(submit);
    	adminpanel.setBorder(title);
    	inputpanel.add(adminpanel);
    	add(adminpanel);
    }
    private void setRMOScontrol()
 	{	
    	adminpanel.removeAll();
    	
    	inputpanel.removeAll();
    	
    	chart = new BarChart();
		
    	setPreferredSize(new Dimension(800,800));
		chart.addBar(Color.red, 100);
		chart.addBar(Color.green, 8);
		chart.addBar(Color.blue, 54);
		chart.addBar(Color.black, 23);

    	//adminpanel.revalidate();
    	createMachinesList();
    	final JTabbedPane tabbedPane = new JTabbedPane();
    	JPanel rmospanel = new JPanel();
    	JPanel reportspanel = new JPanel();
    	
    	
 		JPanel titlePanel = createTitle();
 		JPanel addButton = createAddButton();
 		
 		inputpanel.add(titlePanel,BorderLayout.NORTH);
 		inputpanel.add(machinepanel,BorderLayout.WEST);
 		inputpanel.add(modifierPanel,BorderLayout.CENTER);
 		inputpanel.add(addButton,BorderLayout.SOUTH);
 		adminpanel.revalidate();
 		inputpanel.revalidate(); 
 		
 		reportspanel.add(chart);
 		System.out.println(chart.getComponentCount());
 		rmospanel.add(inputpanel);
 	
 		tabbedPane.addTab("Machines",rmospanel);
    	tabbedPane.addTab("Reports",reportspanel);
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
    
    private void createMachinesList(){
    	machinepanel.removeAll();
    	TitledBorder title;
    	title = BorderFactory.createTitledBorder(rmos.getLocation());
    	listofmachines = new JList(splitStringToArray(rmos.getMachineIDS()));
    	listofmachines.setBorder(new EmptyBorder(10, 25, 100, 25));
    	listofmachines.addListSelectionListener(new ListSelectionListener(){
    		 public void valueChanged(ListSelectionEvent arg0) {
                 if (!arg0.getValueIsAdjusting()) {
                	 selectedMachine((String) listofmachines.getSelectedValue());
                	
               // 	 JOptionPane.showMessageDialog(getRootPane(),(String) listofmachines.getSelectedValue());
                       
                 }
             }
    	});
    	machinepanel.add(listofmachines);
    	machinepanel.setBorder(title);
    	machinepanel.revalidate();
    }
        
    public void selectedMachine(String machineID){

    	selectedmachine = Integer.parseInt(machineID);
    	createSettings();
    	
    	
    }
    
    
    
    public void createSettings(){
    	//JPanel panel = new JPanel(new GridLayout(3,1));
    	modifierPanel.removeAll();
    	JPanel aluminumpricepanel = new JPanel(new GridLayout(1,2));
    	JPanel plasticpricepanel = new JPanel(new GridLayout(1,2));
    	JPanel glasspricepanel = new JPanel(new GridLayout(1,2));
    	JLabel aluminumpricelabel = new JLabel("Aluminum Price: ");
    	JLabel plasticpricelabel = new JLabel("Plastic Price: ");
    	final JLabel glasspricelabel = new JLabel("Glass Price: ");
    	final JButton updatealuminumprice = new JButton("Update Price");
    	final JTextField aluminumpricefield = new JTextField(rmos.getPriceForItem("Aluminum", selectedmachine));
    	//aluminumpricefield.setText(rmos.getPriceForItem("Aluminum", selectedmachine));
    	final JTextField plasticpricefield = new JTextField(rmos.getPriceForItem("Plastic", selectedmachine));
    	final JTextField glasspricefield = new JTextField(rmos.getPriceForItem("Glass", selectedmachine));
    	updatealuminumprice.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			Double.parseDouble(aluminumpricefield.getText());
    			rmos.updatepPriceForItem("Aluminum",selectedmachine,Double.parseDouble(aluminumpricefield.getText()));
    			createSettings();
    			rcmui.setRCMcontrol();
    		}
    	});
    	JButton updateplasticprice = new JButton("Update Price");
    	updateplasticprice.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			Double.parseDouble(aluminumpricefield.getText());
    			rmos.updatepPriceForItem("Plastic",selectedmachine,Double.parseDouble(plasticpricefield.getText()));
    			createSettings();
    			rcmui.setRCMcontrol();
    		}
    	});
    	JButton updateglassprice = new JButton("Update Price");
    	updateglassprice.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			Double.parseDouble(aluminumpricefield.getText());
    			rmos.updatepPriceForItem("Glass",selectedmachine,Double.parseDouble(glasspricefield.getText()));
    			createSettings();
    			rcmui.setRCMcontrol();
    		}
    	});
    	JButton aluminum = new JButton();
    	if(rmos.isItemValid(selectedmachine, "Aluminum")){
    		aluminum.setText("Deactivate");
    	}
    	else
    	{
    		aluminum.setText("Activate");
    	}
    	aluminum.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			if(rmos.isItemValid(selectedmachine, "Aluminum")){
    				
    				rmos.removeItem(selectedmachine, "Aluminum");
    				createSettings();
    			}
    			else{
    				
    				rmos.addItemType(selectedmachine, "Aluminum");
    				createSettings();
    			}
    		}
    	});
    	JButton plastic = new JButton();
    	if(rmos.isItemValid(selectedmachine, "Plastic")){
    		plastic.setText("Deactivate");
    	}
    	else
    	{
    		plastic.setText("Activate");
    	}
    	plastic.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			if(rmos.isItemValid(selectedmachine, "Plastic")){
    				
    				rmos.removeItem(selectedmachine, "Plastic");
    				createSettings();
    			}
    			else{
    				
    				
    				rmos.addItemType(selectedmachine, "Plastic");
    				createSettings();
    			}
    		}
    	});
    	JButton glass = new JButton();
    	if(rmos.isItemValid(selectedmachine, "Glass")){
    		glass.setText("Deactivate");
    	}
    	else
    	{
    		glass.setText("Activate");
    	}
    	glass.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			if(rmos.isItemValid(selectedmachine, "Glass")){
    				
    				rmos.removeItem(selectedmachine, "Glass");
    				createSettings();
    			}
    			else{
    				
    				
    				rmos.addItemType(selectedmachine, "Glass");
    				createSettings();
    			}
    		}
    	});
    	JLabel aluminumtype = new JLabel("Aluminum Cans");
    	JLabel plastictype = new JLabel("Plastic Bottles");
    	JLabel glasstype = new JLabel("Glass Bottles");
    	
    	machineIDlabel = new JLabel("Recycling Machine ID: "+selectedmachine);
    	machineIDlabel.setHorizontalAlignment(JLabel.LEFT);
    	machinelocationlabel = new JLabel("Location: "+rmos.getLocation());
    	//modifierPanel.repaint();
    	emptyrcmButton = new JButton("Empty RCM");
    	emptyrcmButton.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			rmos.emptyRCM(selectedmachine);
    			createSettings();
    		}
    	});
    	activationButton = new JButton();
    	operationalstatuslabel = new JLabel("Operational Status: "+rmos.getOperationalStatus(selectedmachine));
    	if(rmos.getOperationalStatus(selectedmachine).equals("Active")){
    		activationButton.setText("Deactivate");
    	}
    	else
    	{
    		activationButton.setText("Activate");
    	}
    	activationButton.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			if(activationButton.getText().equals("Deactivate")){
    				rmos.setInactive(selectedmachine);
    				createSettings();
    			}
    			else{
    				
    				rmos.setActive(selectedmachine);
    				createSettings();
    			}
    		}
    	});
    	moneyleftlabel = new JLabel("Remaining Cash: "+df.format(rmos.getMoneyInMachine(selectedmachine)));
    	moneycapacitylabel = new JLabel("Cash Capacity: "+df.format(rmos.getMoneyCapacityInMachine(selectedmachine)));
    	currentweightlabel = new JLabel("Current Weight: "+df.format(rmos.getWeightForMachine(selectedmachine)));
    	weightcapacitylabel = new JLabel("Weight Capacity: "+rmos.getWeightCapacityForMachine(selectedmachine));
    	lastemptiedlabel = new JLabel("Last Time Emptied: "+rmos.getLastTimeEmptied(selectedmachine));
    	
    	JButton deletercmButton = new JButton("Delete RCM");
    	deletercmButton.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			rmos.deleteRCM(selectedmachine);
    			createMachinesList();
    			createSettings();
    			rcmui.setRCMcontrol();
    		}
    	});
    	
    	modifierPanel.add(machineIDlabel);
    	modifierPanel.add(machinelocationlabel);
    	modifierPanel.add(operationalstatuslabel);
    	modifierPanel.add(activationButton);
    	modifierPanel.add(moneyleftlabel);
    	modifierPanel.add(moneycapacitylabel);
    	modifierPanel.add(currentweightlabel);
    	modifierPanel.add(weightcapacitylabel);
    	modifierPanel.add(lastemptiedlabel);
    	modifierPanel.add(emptyrcmButton);
    	modifierPanel.add(aluminumtype);
    	modifierPanel.add(aluminum);
    	modifierPanel.add(plastictype);
    	modifierPanel.add(plastic);
    	modifierPanel.add(glasstype);
    	modifierPanel.add(glass);
    	
    	aluminumpricepanel.add(aluminumpricelabel);
    	aluminumpricepanel.add(aluminumpricefield);
    	modifierPanel.add(aluminumpricepanel);
    	modifierPanel.add(updatealuminumprice);
    	plasticpricepanel.add(plasticpricelabel);
    	plasticpricepanel.add(plasticpricefield);
    	modifierPanel.add(plasticpricepanel);
    	modifierPanel.add(updateplasticprice);
    	glasspricepanel.add(glasspricelabel);
    	glasspricepanel.add(glasspricefield);
    	modifierPanel.add(glasspricepanel);
    	modifierPanel.add(updateglassprice);
    	modifierPanel.add(deletercmButton);
    	modifierPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    	modifierPanel.revalidate();
    	
    }
    public JPanel createAddButton(){
    	JPanel panel = new JPanel(new BorderLayout());
    	JButton addbutton = new JButton("Add RCM");
    	addbutton.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			rmos.addMachine();
    			createMachinesList();
    			rcmui.setRCMcontrol();
    		
    		}
    	});
    	addbutton.setHorizontalAlignment(JButton.LEFT);
    	panel.add(addbutton,BorderLayout.WEST);
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
    RCMUI rcmtemp;
    RMOSUI rmostemp;
    public RecyclingSystem(RecyclingMachine rcm, RecyclingMonitoringStation rmos) {
        
        mainFrame = new JFrame("Auction House");
        mainFrame.pack();
        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new RCMUI(rcm,rmos);
       
        mainPanel1 = new RMOSUI(rmos);
        
        mainPanel.rmosConnection(mainPanel1);
        mainPanel1.rcmConnect(mainPanel);
        
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
		FileHandler.scanAndShow();
		new RecyclingSystem(rcm,rmos);
		
	}
}
