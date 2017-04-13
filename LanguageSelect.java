public class LanguageSelect
{
	//attributes//
	String language; //stores the language the user selects
				
	public LanguageSelect() {//constructor
		language = "English";
	}
				
	//methods//
	/*
	 * @param Language stores the language the user selects
	 * @return False if the user did not select the French language 
	 */
	public boolean change (String language){//changes the language option of the user to French
		if (language == "French")
		{
			//System.out.println(" french"); //testing
			return true;
		}
		return false;
	}

}