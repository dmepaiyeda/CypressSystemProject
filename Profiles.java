import java.util.ArrayList;

public class Profiles
{
	ArrayList<String> users;
	ArrayList<String> passwords;
	ArrayList<String> answers;
	public Profiles()
	{
		users = new ArrayList<String>();
		passwords = new ArrayList<String>();
		answers = new ArrayList<String>();
	}
	public Profiles(int num_of_users, String[] usernames, String[] some_passwords)
	{
		users = new ArrayList<String>();
		passwords = new ArrayList<String>();
		answers = new ArrayList<String>();
		for (int i = 0; i < num_of_users; i++)
		{
			users.add(usernames[i]);
		}
	}
	public String getUser(int userNum)
	{
		if (userNum >= 0)
		{
			return users.get(userNum);
		}
		return "<invalid user>";
	}
	public int validate_user(String username, String password)
	{
		int found = -1;
		if (!users.isEmpty() && !passwords.isEmpty())
		{
			for (int i = 0; i < users.size(); i++)
			{
				if (users.get(i).equals(username) && passwords.get(i).equals(password))
				{
					found = i;
				}
			}
		}
		return found;
	}
	public boolean try_validate_user(String username, String password)
	{
		if (!users.contains(username) && !passwords.contains(password))
		{
			users.add(username);
			passwords.add(password);
			return true;
		}
		return false;
	}
	public boolean change_pass(int userNum, String password)
	{
		try
		{
			passwords.set(userNum, password);
		}
		catch (IndexOutOfBoundsException e)
		{
			return false;
		}
		return true;
	}
}