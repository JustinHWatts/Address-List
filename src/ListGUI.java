import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ListGUI.java - Sets up the GUI of the AddressList program,
 * creating the main window, display, text fields, and buttons
 * allowing the user to input contact data and search through or
 * manipulate it using the button commands. Also sets up button
 * listeners for each individual button action.
 *
 * @author Justin Watts
 * @version 11/19/15
 */
public class ListGUI
{
	private JFrame main;
	//Main panels
	private JPanel displayPanel, addPanel, lookupPanel, otherFunctionsPanel;
	//Panels within main panels
	private JPanel addTextPanel, addButtonPanel;
	private JPanel lookupTextPanel, lookupButtonPanel;
	
	private JTextArea display;
	private JScrollPane scrollBar;
	private JTextField name, tel, email, addr, dob, lookup;
	
	private JButton isEmpty, addToFront, addToBack, toString, reverseToString, reverse, 
			sizeOf, numberByName, emailByName, nameByNumber, dobByName;
	private JLabel addInstruction, lookupInstruction;
	
	private AddressList addressList;
	
	/**
	 * Constructor for the ListGUI class. Sets up the elements of
	 * the AddressList GUI and adds action listeners to all buttons.
	 */
	public ListGUI()
	{
		main = new JFrame("Address List");
		displayPanel = new JPanel();
		
		addPanel = new JPanel();
		addTextPanel = new JPanel();
		addButtonPanel = new JPanel();
		
		lookupPanel = new JPanel();
		lookupTextPanel = new JPanel();
		lookupButtonPanel = new JPanel();
		
		otherFunctionsPanel = new JPanel();
		
		display = new JTextArea(15, 40);
		scrollBar = new JScrollPane(display);
		
		name = new JTextField(15);
		name.setText("Name");
		tel = new JTextField(15);
		tel.setText("Phone Number");
		email = new JTextField(15);
		email.setText("Email");
		addr = new JTextField(15);
		addr.setText("Address");
		dob = new JTextField(15);
		dob.setText("Date of Birth");
		lookup = new JTextField(15);
		
		
		isEmpty = new JButton("Empty Check");
		isEmpty.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for isEmpty button to
			 * determine whether or not the contact list
			 * contains any addresses.
			 */
			public void actionPerformed(ActionEvent event)
			{
				if (addressList.isEmpty())
					display.setText("Address List is empty");
				else
					display.setText("Address List is not empty");
			}
		});
		
		addToFront = new JButton("Add to Front");
		addToFront.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for addToFront button to
			 * add all entered data as a single contact to the
			 * front of the address list.
			 */
			public void actionPerformed(ActionEvent event)
			{
				addressList.addToFront(name.getText(), tel.getText(), 
						email.getText(), addr.getText(), dob.getText());
				
				name.setText("Name");
				tel.setText("Phone Number");
				email.setText("Email");
				addr.setText("Address");
				dob.setText("Date of Birth");
			}
		});
		
		addToBack = new JButton("Add to Back");
		addToBack.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for addToBack button to
			 * add all entered data as a single contact to the
			 * back of the address list.
			 */
			public void actionPerformed(ActionEvent event)
			{
				addressList.addToBack(name.getText(), tel.getText(), 
						email.getText(), addr.getText(), dob.getText());
				
				name.setText("Name");
				tel.setText("Phone Number");
				email.setText("Email");
				addr.setText("Address");
				dob.setText("Date of Birth");
			}
		});
		
		toString = new JButton("Display List");
		toString.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for toString button to
			 * display all of the contents of the address list.
			 */
			public void actionPerformed(ActionEvent event)
			{
				if (addressList.sizeOf() > 0)
					display.setText(addressList.toString());
				else
					display.setText("No addresses found");
			}
		});
		
		reverseToString = new JButton("Display Reverse");
		reverseToString.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for reverseToString button to
			 * display all of the contents of the address list in
			 * reverse.
			 */
			public void actionPerformed(ActionEvent event)
			{
				if (addressList.sizeOf() > 0)
					display.setText(addressList.reverseToString());
				else
					display.setText("No addresses found");
			}
		});
		
		reverse = new JButton("Reverse List");
		reverse.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for reverse button to
			 * reverse the contents of the address list.
			 */
			public void actionPerformed(ActionEvent event)
			{
				addressList = addressList.reverse();
			}
		});
		
		sizeOf = new JButton("Check Size");
		sizeOf.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for sizeOf button to
			 * display the number of contacts within the
			 * address list.
			 */
			public void actionPerformed(ActionEvent event)
			{
				if (addressList.sizeOf() == 1)
					display.setText("Address List contains " + addressList.sizeOf() + " address");
				else
					display.setText("Address List contains " + addressList.sizeOf() + " addresses");
			}
		});
		
		numberByName = new JButton("Number by Name");
		numberByName.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for numberByName button to
			 * find the number of a contact within the address
			 * list associated with the name entered.
			 */
			public void actionPerformed(ActionEvent event)
			{
				display.setText(addressList.phoneNumberByName(lookup.getText()));
			}
		});
		
		emailByName = new JButton("Email by Name");
		emailByName.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for emailByName button to
			 * find the email of a contact within the address
			 * list associated with the name entered.
			 */
			public void actionPerformed(ActionEvent event)
			{
				display.setText(addressList.emailByName(lookup.getText()));
			}
		});
		
		nameByNumber = new JButton("Name by Number");
		nameByNumber.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for nameByNumber button to
			 * find the name of a contact within the address
			 * list associated with the number entered.
			 */
			public void actionPerformed(ActionEvent event)
			{
				display.setText(addressList.nameByPhoneNumber(lookup.getText()));
			}
		});
		
		dobByName = new JButton("DoB by Name");
		dobByName.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for dobByName button to
			 * find the date of birth of a contact within the 
			 * address list associated with the name entered.
			 */
			public void actionPerformed(ActionEvent event)
			{
				display.setText(addressList.dobByName(lookup.getText()));
			}
		});
		
		addInstruction = new JLabel("Enter Contact Info");
		lookupInstruction = new JLabel("Enter Name or Number");
		
		addressList = new AddressList();
	}
	
	/**
	 * Begins the AddressList program by displaying the main window
	 * of the program and adding each panel to its respective
	 * position within the window.
	 */
	public void start()
	{
		main.setLayout(new BorderLayout());
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setLocation(500, 300);
		
		displayPanel.setLayout(new FlowLayout());
		
		addPanel.setLayout(new FlowLayout());
		addPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); 
		addTextPanel.setLayout(new BoxLayout(addTextPanel, BoxLayout.PAGE_AXIS));
		addButtonPanel.setLayout(new BoxLayout(addButtonPanel, BoxLayout.PAGE_AXIS));
		
		lookupPanel.setLayout(new BoxLayout(lookupPanel, BoxLayout.PAGE_AXIS));
		lookupPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); 
		lookupTextPanel.setLayout(new BoxLayout(lookupTextPanel, BoxLayout.PAGE_AXIS));
		lookupButtonPanel.setLayout(new GridLayout(2,2));
		
		otherFunctionsPanel.setLayout(new GridLayout(5,1));
		otherFunctionsPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); 
		
		
		displayPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
		displayPanel.add(scrollBar);
		display.setEditable(false);
		
		addTextPanel.add(addInstruction);
		addTextPanel.add(name);
		addTextPanel.add(tel);
		addTextPanel.add(email);
		addTextPanel.add(addr);
		addTextPanel.add(dob);
		addButtonPanel.add(addToFront);
		addButtonPanel.add(addToBack);
		
		addPanel.add(addTextPanel);
		addPanel.add(addButtonPanel);
		
		lookupTextPanel.add(lookupInstruction);
		lookupTextPanel.add(lookup);
		lookupTextPanel.add(Box.createVerticalStrut(35));
		lookupButtonPanel.add(numberByName);
		lookupButtonPanel.add(emailByName);
		lookupButtonPanel.add(nameByNumber);
		lookupButtonPanel.add(dobByName);
		
		lookupPanel.add(lookupTextPanel);
		lookupPanel.add(lookupButtonPanel);
		
		otherFunctionsPanel.add(isEmpty);
		otherFunctionsPanel.add(toString);
		otherFunctionsPanel.add(reverseToString);
		otherFunctionsPanel.add(reverse);
		otherFunctionsPanel.add(sizeOf);
		
		
		main.add(displayPanel, BorderLayout.NORTH);
		main.add(addPanel, BorderLayout.WEST);
		main.add(lookupPanel, BorderLayout.CENTER);
		main.add(otherFunctionsPanel, BorderLayout.EAST);
		
		main.setResizable(false);
		main.pack();
		main.setVisible(true);
	}
}