/**
 * QuesAns Class
 *
 * Manages the frequently asked questions and their answers.
 */
public class QuesAns {

  String[] questions = new String[2];
  String[] answers = new String[2];

  enum categories{

  }
 // int category_page_y(){}

  /**
   * Default constructor of the QuesAns Class.
   */
  public QuesAns(){
    questions[0] = "What?";
    questions[1] = "Where?";
    answers[0] = "This!";
    answers[1] = "There!";
  }

  /**
   *
   * @param q
   * @param a
   */
  public QuesAns(String[] q, String[] a){
    q = questions;
    a = answers;

  }

  /**
   * Retrieves the FAQ questions and answers from their respective arrays.
   */
  public String[] retrieveFAQ() {

    //Loads the questions and answers into the JLabels of the GUI
    //TODO
    String[] a,b;
    a=questions;
    b=answers;
    return new QuesAns(questions, answers);
  }

  /**
   *
   */
  public void goToCategory() {

    //TODO

  }

}
