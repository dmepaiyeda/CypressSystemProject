public class QuesAns
{
	String[] questions;
	String[] answers;
	public QuesAns()
	{
		questions = new String[4];
		answers = new String[4];
		questions[0] = "What is CYPRESS?";
		answers[0] = "CYPRESS is the City of Toronto's brand new\nproblem reporting software. Easily report any\ncity-related problems here!";
		questions[1] = "How do I use CYPRESS?";
		answers[1] = "Using CYPRESS is easy! Just register a new account,\nlogin, and report your issue!";
		questions[2] = "Is CYPRESS free to use?";
		answers[2] = "Yes! CYPRESS is 100% free to use.";
		questions[3] = "Where can I find more information?";
		answers[3] = "Visit http://www.toronto.ca/ for more information.";
	}
	public String[][] retrieveFAQ()
	{
		String[][] output = new String[2][4];
		output[0] = questions;
		output[1] = answers;
		return output;
	}
	void goToCategory()
	{
		//TODO
	}
}