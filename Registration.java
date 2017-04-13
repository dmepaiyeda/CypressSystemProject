/*
 * this class is for allowing user to register 
 * allows user to create username and password 
 * validates their username and password 
 * this is for the registration use case
 */
public class Registration {
	Profiles profiles;
	
	static String digitPattern = "(?=.*[0-9])";
	//static String digitPattern = "(.*)\\d(.*)";
	static String casePattern = "(?=.*[a-z])(?=.*[A-Z])";
	static String specialCharPattern = "(?=.*[@#$%^&+=])";
	static String charNum_spaces = "(?=\\S+$).{8,}"; //checks 
//	static String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
	
	public Registration(Profiles profiles) {
		this.profiles = profiles;
	}

	public String validateUser(String user_name)
	{
		if (user_name.length() < 3)
		{
			return "Username must be at least 3 characters long.";
		}
		return "";			
	}
	public String validatePassword(String password)
	{
		String errormssg = "Your password must contain at least 1 digit,\n at least one uppercase and lowercase letter,\n at least one special character\n and must not contain a whitespace.";
		if (password.length() < 8)
		{
			return "Password must contain at least 8 characters.";
		}
		else 
		{
			if (!password.matches( charNum_spaces ) && !password.matches(digitPattern)
			&& !password.matches(casePattern) && !password.matches( specialCharPattern ))
			{
				return errormssg;
			}
		}
		return "";
	}

	public String validate_user(String username, String password, String answer)
	{
		if (!validateUser(username).equals(""))
		{
			return validateUser(username);
		}
		if (!validatePassword(password).equals(""))
		{
			return validatePassword(password);
		}
		if (!profiles.try_validate_user(username, password, answer))
		{
			return "Username already exists. Please try a different username.";
		}
		return "User profile was successfully created.";
	}
}