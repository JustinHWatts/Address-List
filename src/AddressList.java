/**
 * AddressList.java - Contains the data and methods for a singly linked
 * list of contact list data. Gives the user ability to add new contacts,
 * search the list, and manipulate existing data within the list.
 *
 * @author Justin Watts
 * @version 11/19/15
 */
public class AddressList
{
	/**
 	  This nested, private class represents a node of a singly linked list.
	 */
	private class ListNode
	{
		private String name;
		private String tel; // Telephone number
		private String email;
		private String addr; // Address
		private String dob; // Date of birth
		private ListNode next; // Pointer to the next node
		
		/**
		 * Constructor for the nested ListNode class. Sets up the elements
		 * of a single contact's information for the address list and
		 * provides getter and setter methods for each element.
		 * 
		 * @param name name of contact as a String
		 * @param tel phone number of contact as a String
		 * @param email email of contact as a String
		 * @param addr address of contact as a String
		 * @param dob date of birth of a contact as a String
		 */
		private ListNode(String name, String tel, String email, String addr, String dob)
		{
			this.name = name;
			this.tel = tel;
			this.email = email;
			this.addr = addr;
			this.dob = dob;
		} // end of the constructor

		public String getName() { return name; }
		public String getTel() { return tel; }
		public String getEmail() { return email; }
		public String getAddr() { return addr; }
		public String getDob() {return dob; }

		public void setName(String name) { this.name = name; }
		public void setTel(String tel) { this.tel = tel; }
		public void setEmail(String email) { this.email = email; }
		public void setAddr(String addr) { this.addr = addr; }
		public void setDob(String dob) { this.dob = dob; }

		public ListNode getNext() { return next; }
		public void setNext(ListNode link) { next = link; }
	} // end of class ListNode
	
	private ListNode head; //Top of Linked List
	private ListNode currentNode; //Current node within Linked List
	
	/**
	 * Returns a boolean value telling the caller whether or not
	 * the address list contains any addresses.
	 * 
	 * @return Boolean whether or not the address list is empty
	 */
	public boolean isEmpty()
	{
		boolean bool = false;
		
		if (head == null)
			bool = true;
		
		return bool;
	}
	
	/**
	 * Adds a new address to the front of the list of addresses.
	 * 
	 * @param name name of contact as a String
	 * @param tel phone number of contact as a String
	 * @param email email of contact as a String
     * @param addr address of contact as a String
	 * @param dob date of birth of a contact as a String
	 */
	public void addToFront(String name, String tel, String email, String address, String dob)
	{
		ListNode newNode = new ListNode(name, tel, email, address, dob);
		
		newNode.setNext(head);
		head = newNode;
	}
	
	/**
	 * Adds a new address to the back of the list of addresses
	 * using a recursive helper method.
	 * 
	 * @param name name of contact as a String
	 * @param tel phone number of contact as a String
	 * @param email email of contact as a String
     * @param addr address of contact as a String
	 * @param dob date of birth of a contact as a String
	 */
	public void addToBack(String name, String tel, String email, String address, String dob)
	{
		ListNode newNode = new ListNode(name, tel, email, address, dob);
		
		this.addToBackHelper(newNode, head);
	}
	
	/**
	 * Recursive helper method which runs through list of addresses
	 * and finds the end of the list in order to place the new address
	 * in said position.
	 * 
	 * @param newNode the node being added to the back of the list
	 * @param current the current node of the list being run through
	 */
	private void addToBackHelper(ListNode newNode, ListNode current)
	{
		if (this.isEmpty())
		{
			head = newNode;
			head.setNext(null);
		}
		else if (current.getNext() != null)
			addToBackHelper(newNode, current.getNext());
		else
		{
			currentNode = current;
			currentNode.setNext(newNode);
		}
	}
	
	/**
	 * Returns each contact within the address list as a single
	 * String value using a recursive helper method.
	 * 
	 * @return String value containing all of the data within 
	 * the address list as a String
	 */
	public String toString()
	{
		String result = "";
		
		return this.toStringHelper(head, result);
	}
	
	/**
	 * Recursive helper method which runs through list of addresses
	 * and adds each one to the String value being returned.
	 * 
	 * @param current the current node of the list being run through
	 * @param result resulting String containing all of the addresses
	 * @return String value containing all of the data within 
	 * the address list as a String
	 */
	private String toStringHelper(ListNode current, String result)
	{
		if (this.isEmpty())
			return result;
		else if (current.getNext() == null)
		{
			result = result + "\nName: " + current.name + "\nNumber: " + current.tel 
					+ "\nEmail: " + current.email + "\nAddress: " + current.addr 
					+ "\nDate of Birth: " + current.dob + "\n";
			
			return result;
		}
		else
		{
			result = result + "\nName: " + current.name + "\nNumber: " + current.tel 
					+ "\nEmail: " + current.email + "\nAddress: " + current.addr 
					+ "\nDate of Birth: " + current.dob + "\n";
		}
		
		return this.toStringHelper(current.getNext(), result);
	}
	
	/**
	 * Returns each contact within the address list in reverse 
	 * as a single String value using a recursive helper method.
	 * 
	 * @return String value containing all of the data within 
	 * the address list as a String
	 */
	public String reverseToString()
	{
		String result = "";
		
		return this.reverseToStringHelper(head, result);
	}
	
	/**
	 * Recursive helper method which runs through list of addresses
	 * and adds each one to the String value being returned.
	 * 
	 * @param current the current node of the list being run through
	 * @param result resulting String containing all of the addresses
	 * @return String value containing all of the data within 
	 * the address list as a String
	 */
	private String reverseToStringHelper(ListNode current, String result)
	{
		if (this.isEmpty())
			return result;
		else if (current.getNext() != null)
		{
			result = result + this.reverseToStringHelper(current.getNext(), result);
			
			result = result + "\nName: " + current.name + "\nNumber: " + current.tel 
					+ "\nEmail: " + current.email + "\nAddress: " + current.addr 
					+ "\nDate of Birth: " + current.dob + "\n";
		}
		else
		{
			result = result + "\nName: " + current.name + "\nNumber: " + current.tel 
					+ "\nEmail: " + current.email + "\nAddress: " + current.addr 
					+ "\nDate of Birth: " + current.dob + "\n";
		}
		
		return result;
	}
	
	/**
	 * Returns a reversed version of the current instance of
	 * the address list using a recursive helper method.
	 * 
	 * @return AddressList a new address list containing all
	 * existing addresses in reverse
	 */
	public AddressList reverse()
	{
		AddressList reverseList = new AddressList();
		
		return this.reverseHelper(head, reverseList);
	}
	
	/**
	 * Recursive helper method which runs through list of addresses
	 * and adds each one to a new AddressList in reverse order.
	 * 
	 * @param current the current node of the list being run through
	 * @param reverseList AddressList being created with entries
	 * in reverse
	 * @return AddressList a new address list containing all
	 * existing addresses in reverse
	 */
	private AddressList reverseHelper(ListNode current, AddressList reverseList)
	{
		if (current == null)
			return reverseList;
		
		reverseList.addToFront(current.getName(), current.getTel(), current.getEmail(),
				current.getAddr(), current.getDob());
		
		reverseList = this.reverseHelper(current.getNext(), reverseList);
		
		return reverseList;
	}
	
	/**
	 * Returns the number of contacts within the address list
	 * using a recursive helper method.
	 * 
	 * @return int number of addresses within the list
	 */
	public int sizeOf()
	{
		int count = 0;
		
		return this.sizeOfHelper(head, count);
	}
	
	/**
	 * Recursive helper method which runs through list of addresses
	 * and increments an int value to determine how many addresses
	 * are within the list.
	 * 
	 * @param current the current node of the list being run through
	 * @param count the number of addresses being incremented with
	 * each pass
	 * @return int number of addresses within the list
	 */
	private int sizeOfHelper(ListNode current, int count)
	{
		if (this.isEmpty())
			return count;
		else if (current.getNext() == null)
		{
			count = count + 1;
			
			return count;
		}
		else
			count = count + 1;
		
		return this.sizeOfHelper(current.getNext(), count);
	}
	
	/**
	 * Searches the address list and returns the phone number
	 * of a contact if the given name is found using a recursive 
	 * helper method.
	 * 
	 * @param name the name of the contact being searched for
	 * @return String phone number of given contact name
	 */
	public String phoneNumberByName(String name)
	{
		return this.phoneNumberByNameHelper(head, name);
	}
	
	/**
	 * Recursive helper method which runs through list of addresses
	 * and searches for a contact by name to return said contact's
	 * phone number.
	 * 
	 * @param current the current node of the list being run through
	 * @param name the name of the contact being searched for
	 * @return String phone number of given contact name
	 */
	private String phoneNumberByNameHelper(ListNode current, String name)
	{
		if (this.isEmpty() || current == null)
			return "No matching data";
		else if (current.getName().equals(name))
			return current.getTel();
		else
			return this.phoneNumberByNameHelper(current.getNext(), name);
	}
	
	/**
	 * Searches the address list and returns the email
	 * of a contact if the given name is found using a recursive 
	 * helper method.
	 * 
	 * @param name the name of the contact being searched for
	 * @return String email of given contact name
	 */
	public String emailByName(String name)
	{
		return this.emailByNameHelper(head, name);
	}
	
	/**
	 * Recursive helper method which runs through list of addresses
	 * and searches for a contact by name to return said contact's
	 * email.
	 * 
	 * @param current the current node of the list being run through
	 * @param name the name of the contact being searched for
	 * @return String email of given contact name
	 */
	private String emailByNameHelper(ListNode current, String name)
	{
		if (this.isEmpty() || current == null)
			return "No matching data";
		else if (current.getName().equals(name))
			return current.getEmail();
		else
			return this.emailByNameHelper(current.getNext(), name);
	}
	
	/**
	 * Searches the address list and returns the name
	 * of a contact if the given phone number is found 
	 * using a recursive helper method.
	 * 
	 * @param tel the number of the contact being searched for
	 * @return String name of given contact number
	 */
	public String nameByPhoneNumber(String tel)
	{
		return this.nameByPhoneNumberHelper(head, tel);
	}
	
	/**
	 * Recursive helper method which runs through list of addresses
	 * and searches for a contact by phone number to return said contact's
	 * name.
	 * 
	 * @param current the current node of the list being run through
	 * @param tel the number of the contact being searched for
	 * @return String name of given contact number
	 */
	private String nameByPhoneNumberHelper(ListNode current, String tel)
	{
		if (this.isEmpty() || current == null)
			return "No matching data";
		else if (current.getTel().equals(tel))
			return current.getName();
		else
			return this.nameByPhoneNumberHelper(current.getNext(), tel);
	}
	
	/**
	 * Searches the address list and returns the date of birth
	 * of a contact if the given name is found using a recursive 
	 * helper method.
	 * 
	 * @param name the name of the contact being searched for
	 * @return String dob of given contact name
	 */
	public String dobByName(String name)
	{
		return this.dobByNameHelper(head, name);
	}
	
	/**
	 * Recursive helper method which runs through list of addresses
	 * and searches for a contact by name to return said contact's
	 * date of birth.
	 * 
	 * @param current the current node of the list being run through
	 * @param name the name of the contact being searched for
	 * @return String dob of given contact name
	 */
	private String dobByNameHelper(ListNode current, String name)
	{
		if (this.isEmpty() || current == null)
			return "No matching data";
		else if (current.getName().equals(name))
			return current.getDob();
		else
			return this.dobByNameHelper(current.getNext(), name);
	}
}