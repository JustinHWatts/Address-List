
public class TestDriver
{
	public static void main(String[] args)
	{
		AddressList list = new AddressList();
		System.out.println(list.isEmpty());
		list.addToFront("Justin Watts", "4345441187", "jlink4yoshi@gmail.com", "Lynchburg, VA", "1/24/1993");
		System.out.println(list.isEmpty());
		
		list.addToFront("Laurie George", "4345441088", "lauriejustingriffin@yahoo.com", "Lynchburg, VA", "2/20/1967");
		list.addToBack("Josh Madden", "4346100085", "madman4vt@yahoo.com", "Blacksburg, VA", "7/31/1992");
		
		System.out.println(list.toString());
		System.out.println(list.reverseToString());
		
		list = list.reverse();
		System.out.println(list.toString());
		
		System.out.println(list.sizeOf());
		
		System.out.println(list.phoneNumberByName("Justin Watts"));
		System.out.println(list.emailByName("Justin Watts"));
		System.out.println(list.nameByPhoneNumber("4345441187"));
		System.out.println(list.dobByName("Justin Watts"));
	}
}