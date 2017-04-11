/*
 * this class is for allowing the user select the language they the system to be in
 * this is for the Language Selection use case
 */
public class LanguageSelect
{
		
				//attributes//
				String language; //stores the language the user selects
				/*public static void main(String[] args) {
					change ("French");

				}*///testing
				
				public LanguageSelect() {//constructor
					language = "English";
				}
				
				//methods//
				/*
				 * @param Language stores the language the user selects
				 * @return False if the user did not select the French language 
				 */
				boolean change (String language){//changes the language option of the user to French
					
					if (language == "French")
					{
						//System.out.println(" french"); //testing
						return true;
					}
						return false;

				}

}
