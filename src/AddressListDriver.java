/**
 * AddressListDriver.java - Driver to test the Address List program.
 * The program accepts sets of contact information in the form of
 * name, number, email, address, and date of birth and then gives
 * the user options to search through input data as well as manipulate
 * the view of said data.
 *
 * @author Justin Watts
 * @version 11/19/15
 */
public class AddressListDriver
{
	/**
	 * Main method of AddressList program. Begins the program.
	 */
	public static void main(String[] args)
	{
		ListGUI addressList = new ListGUI();
		addressList.start();
	}
}