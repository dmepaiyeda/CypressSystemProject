
public class Registration {
	
	static String digitPattern = "(?=.*[0-9])";
	//static String digitPattern = "(.*)\\d(.*)";
	static String casePattern = "(?=.*[a-z])(?=.*[A-Z])";
	static String specialCharPattern = "(?=.*[@#$%^&+=])";
	static String charNum_spaces = "(?=\\S+$).{8,}"; //checks 
//	static String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
	
	public Registration() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//String passwd = "aaZZa44@"; 
	   // String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
	    //System.out.println(passwd.matches(pattern));
		validateUser ("eee3");
		validatePasswrd("ejds34j$D dbt");

	}
	static boolean validateUser(String user_name)
	{
		boolean correctUsername = true;
		
		if (user_name.length() < 3)
		{
			System.out.println("Username must be at least 3 characters long");
			return false;
		}
		return correctUsername;		
		
		
	}
	static boolean validatePasswrd(String pass_word)
	{
		String errormssg = "Your password must contain at least 1 digit, at least one uppercase and lowercase letter, at least one special "
		+ "character and must not contain a whitespace";
		if (pass_word.length() < 8)
		{
			System.out.println("Password must contain at least 8 characters");
			return false;
		}

		else 
		{
			if (!pass_word.matches( charNum_spaces ) && !pass_word.matches(digitPattern)
			&& !pass_word.matches(casePattern) && !pass_word.matches( specialCharPattern ))
			{
				System.out.println(errormssg);
				return false;
			}
		}
		return true;
	}
}
