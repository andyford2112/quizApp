package quizApp;

/**
 * Represents a quiz exercise with instructions, sentence/question, and answer.
 * 
 * @author Andy Ford
 *
 */
public class Exercise {
	
	private String instructions;	// instructions for how to do the exercise
	private String sentence;		// can be a sentence or question prompt
	private String answer;			// answer to the prompt
	
	/**
	 * Constructor for a new exercise.
	 * @param _instructions - instructions for the exercise
	 * @param _sentence - sentence or question prompt
	 * @param _answer - answer to prompt
	 */
	public Exercise(String _instructions, String _sentence, String _answer) {
		instructions = _instructions;
		sentence = _sentence;
		answer = _answer;
	}
	
	/**
	 * Instructions getter method.
	 * @return - instructions
	 */
	public String getInstructions() {
		return instructions;
	}
	
	/**
	 * Sentence getter method.
	 * @return - sentence
	 */
	public String getSentence() {
		return sentence;
	}
	
	/**
	 * Answer getter method.
	 * @return - answer
	 */
	public String getAnswer() {
		return answer;
	}

}
