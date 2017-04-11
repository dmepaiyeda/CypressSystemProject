/**
 * @(#)ChangeInfo.java
 *
 *
 * @author
 * @version 1.00 2017/4/9
 */


public class ChangeInfo {
	String answer; //stores the answer to secret questions
	String profile; //stores user's profile info
	String username, password;
	/**
    public ChangeInfo() {
	//MAYBE TODO
    }
   */

    public boolean validate_answer(String answer) { //checks user's answer
		if(answer = true) {
		//TODO 			 //if the answer is true, 
		} else {
			return false;
		}
    }

    public boolean delete(String profile) { //delete user's profile
		if(profile = true) {
			username = "";
			password = "";			
		} else {
			return false;
		}
    }

}
