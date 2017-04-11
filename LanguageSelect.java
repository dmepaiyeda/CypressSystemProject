
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
				boolean change (String language){//changes the language option of the user
					//language = "English";
					if (language == "French")
					{
						//System.out.println(" french"); //testing
						return true;
					}
						//System.out.println("cheece"); //testing
						return false;

				}

}
