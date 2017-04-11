/**
 * @(#)ReportResolve.java
 *
 *
 * @author
 * @version 1.00 2017/4/9
 */


public class ReportResolve {
	String alertList[]; //contains list of notifications
	String resolved; //stores all the resolved problems
	//String thanks; //says thanks to users

/**
    public ReportResolve() {
    }
*/

//Not sure if I should use a boolean or a String[] method
//whichever you prefer
    public boolean notify() { //todo 
	if(resolved = false) {
	  System.out.println("There is a problem.");
	} else {
		
	}//TODO
    }


    public String[] notify() { //notifys problem
	//TODO
    }

    public boolean notify_user() { //notifiys user the problem is gone
	if(resolved = true) {	//if there's no problem, it thanks them and moves on
	  System.out.println("The problem has been resolved. Thank you for your contribution.");	
	} else {
	  return false;
	}
    }

}
