package quizApp;

import java.util.ArrayList;

/**
 * Provides an example of the Quiz class.  This particular example is a Spanish fill-in-the-blank style quiz.
 * 
 * @author Andy Ford
 *
 */
public class QuizExample {

	public static void main(String[] args) {
		// Create three exercises
		Exercise e1 = new Exercise("La familia Gomez. Escribe la forma del presente del verbo entre parentisis:",
									"Pedro Gomez __________ (vivir) con su familia en mi edificio de apartamentos.",
									"vive");
		
		Exercise e2 = new Exercise("La familia Gomez. Escribe la forma del presente del verbo entre parentisis:",
								   "Luc\u00EDa, la esposa de Pedro, no __________ (trabajar) todos los d\u00EDas.",
								   "trabaja");
		
		Exercise e3 = new Exercise("La familia Gomez. Escribe la forma del presente del verbo entre parentisis:",
				   				   "La hija, Mercedes, __________ (estudiar) en la universidad.",
				   				   "estudia");
		
		// Add the exercises to a list
		ArrayList<Exercise> exer = new ArrayList<Exercise>();
		exer.add(e1);
		exer.add(e2);
		exer.add(e3);
		
		// Start the quiz
		Quiz q1 = new Quiz("Spanish Quiz", exer);

	}
}
