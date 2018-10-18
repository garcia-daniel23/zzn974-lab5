package application.model;

import java.io.File;
import java.util.Scanner;
/**
 * 
 * @author Daniel
 * Class that compares what the user entered to see if registered or not
 */
public class UserProfile {

	public String user;
	public String pass;
	private static Scanner scan;
	
	public UserProfile(String user, String pass)
	{
		this.user = user;
		this.pass = pass;
	}
	/**
	 * Takes the info and compares it as the file is read in
	 * @param user is username user provides
	 * @param pass is the password the user provides
	 * @return null or populated object
	 */
	public static UserProfile authenticate(String user, String pass)
	{
		String info = "";
		
		UserProfile login = new UserProfile(null,null);
		try
		{
			scan = new Scanner(new File("users.txt"));

		}
		catch(Exception e)
		{
			System.out.println("Cant find file");
		}
		while(scan.hasNextLine())
		{
			
			info = scan.nextLine();
			String[] parts = info.split(",");
			String part1 = parts[0];
			String part2 = parts[1];
			if(part1.equals(user)&& part2.equals(pass))
				login = new UserProfile(user,pass);
			else
				login = null;
			
		}
	System.out.println(info);
		return login;
}
}
