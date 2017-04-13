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
	public Profiles(int num_of_users, String[] usernames, String[] some_passwords, String[] some_answers)
	{
		users = new ArrayList<String>();
		passwords = new ArrayList<String>();
		answers = new ArrayList<String>();
		for (int i = 0; i < num_of_users; i++)
		{
			users.add(usernames[i]);
			passwords.add(some_passwords[i]);
			answers.add(some_answers[i]);
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
	public int validate_user(String username)
	{
		int found = -1;
		if (!users.isEmpty())
		{
			for (int i = 0; i < users.size(); i++)
			{
				if (users.get(i).equals(username))
				{
					found = i;
				}
			}
		}
		return found;
	}
	public boolean try_validate_user(String username, String password, String answer)
	{
		if (!users.contains(username))
		{
			users.add(username);
			passwords.add(password);
			answers.add(answer);
			return true;
		}
		return false;
	}
	public boolean change_pass(int userNum, String password)
	{
		if (userNum > -1)
		{
			try
			{
				passwords.set(userNum, password);
				return true;
			}
			catch (IndexOutOfBoundsException e)
			{
				return false;
			}
		}
		return false;
	}
	public int answer_is_correct(String user, String answer)
	{
		for (int i = 0; i < users.size(); i++)
		{
			if (users.get(i).equals(user) && answers.get(i).equals(answer))
			{
				return i;
			}
		}
		return -1;
	}
}