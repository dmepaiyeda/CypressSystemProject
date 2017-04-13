public class Authentication
{
	public Profiles profiles;
	public Authentication(Profiles profiles)
	{
		this.profiles = profiles;
	}
	public int validate_user(String user_name, String pass_word)
	{
		int user_num = profiles.validate_user(user_name);
		if (user_num > -1)
		{
			if (!profiles.passwords.isEmpty() && profiles.passwords.size() > user_num && profiles.passwords.get(user_num).equals(pass_word))
			{
				return user_num;
			}
		}
		return -1;
	}
	public boolean change_pass(int user_num, String answer)
	{
		if (user_num > -1)
		{
			try
			{
				profiles.answers.set(user_num, answer);
				return true;
			}
			catch (IndexOutOfBoundsException e)
			{
				return false;
			}
		}
		return false;
	}
}