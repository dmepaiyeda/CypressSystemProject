import java.util.ArrayList;

/*
 * class that handles the login use case and canceling 
 * checks if the user if already registered by searching the database for their username
 * the GUI can handle the canceling part
 * 
 */
public class Authentication {

	//attributes//
			public String user_name;
			String pass_word;
			String answer; //stores answer to user’s secret question
			static ArrayList <String> answers ; //MADE AN ANSWERS ARRAYLIST FOR TESTING. WE WILL USE THE ONE YOU CREATED
			
			public static void main(String[] args) {//tester
				answers = new ArrayList <String>();
				answers.add("cheese");
				answers.add("hello");
				forgot_passwrd("hello");
				

			}
	/*public Authentication() 
	{
		
	}*/

	//methods//
	/*boolean checkIfRegistered(String [] array, String user_name )
	{
		
		
	}*/
	/*
	 * @param user_name Stores the user's username
	 * @return True if there is such a username in the database
	 * @return False if there is no such username in the database
	 */
	static boolean checkUserExists(String user_name)
	{ //I WAS THINKING TO SEARCH THROUGH THE DATATBASE TO SEE 
		//IF THE USERNAME  EXISTS BUT IM NOT SURE HOW YOU ARE IMPLEMENTING THE DATABASE
		//TODO
				if (username)
				
				
	}
	/*
	 * @param pass_word Stores the user's password
	 * @return True if there is such a password in the database
	 * @return False if there is no such password in the database
	 */
	static boolean checkPasswrdExists(String pass_word)
	{
		//I WAS THINKING TO SEARCH THROUGH THE DATATBASE TO SEE 
		//IF THE PASSWORD EXISTS BUT IM NOT SURE HOW YOU ARE IMPLEMENTING THE DATABASE
				//TODO
		
	}
	
	/*
	 * @param answer The user's answer to the question
	 * @return True if the user's answer to the secret question correct
	 * @return False if the user's answer to the secret question is incorrect
	 */
	static boolean forgot_passwrd(String answer) //changes user’s password based on their answer to secret question
	{ 
		//I WAS THINKING THAT WE SHOULD HAVE A DATABASE TO STORE THE QUESTIONS AND ANSWERS
		//SO THAT THE SYSTEM CAN CHECK IF THE ANSWER IS RIGHT AND IF SO SEND IT TO AN EMAIL ACCOUNT
		for (String string :  answers)
		{
			if (string.contains(answer))
			{
				//System.out.println("found"); //testing 
				//TODO -- HAVE SYSTEM SEND PASSWORD TO USER'S EMAIL - we could have the GUI handle that 
				return true;
			}
			
		}
		//System.out.println("not found"); //testing
		return false;
	}
	
	
	
	
}
	


