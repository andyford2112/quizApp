package quizApp;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A simple quiz application.  Has labels to display instructions, questions, and feedback, as well 
 * as a text field for users to enter their answers.  Uses a list of exercises for its content.
 * 
 * @author Andy Ford
 *
 */
public class Quiz implements ActionListener {

	private ArrayList<Exercise> exercises;	// list of exercises
	private Exercise currentExercise;		// current exercise of the quiz
	private int exerciseIndex;				// index of the current exercise in list of exercises
	private JFrame frame;					// main window
	private JPanel pane;					// content pane
	private JLabel instructions;			// displays the instructions for each exercise
	private JLabel sentence;				// displays the sentence for each exercise
	private JTextField answer;				// textfield where the user enters their answers
	private JButton checkButton;			// button that checks whether the answer is correct
	private JButton nextButton;				// moves on to the next excercise
	private JLabel feedback;				// provides feedback about the user's answers
	private Font font;
	
	/**
	 * Constructor for new Quiz object.
	 * @param title - title of the quiz
	 * @param _exercises - list of exercises to be used in quiz
	 */
	public Quiz(String title, ArrayList<Exercise> _exercises) {
		exercises = _exercises;
		exerciseIndex = 0;
		currentExercise = exercises.get(exerciseIndex);
		font = new Font(Font.SERIF, 1, 22);
		
		// Set up the quiz window.
		frame = new JFrame(title);
		frame.setFont(font);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.setVisible(true);
		
		instructions = new JLabel(currentExercise.getInstructions());
		instructions.setFont(font);
		pane.add(instructions, new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		sentence = new JLabel(currentExercise.getSentence());
		sentence.setFont(font);
		pane.add(sentence, new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		answer = new JTextField();
		answer.setFont(font);
		pane.add(answer, new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		checkButton = new JButton("Check Answer");
		checkButton.setFont(font);
		checkButton.addActionListener(this);
		pane.add(checkButton, new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		nextButton = new JButton("Next");
		nextButton.setFont(font);
		nextButton.addActionListener(this);
		nextButton.setEnabled(false);
		pane.add(nextButton, new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		feedback = new JLabel(" ");
		feedback.setFont(font);
		pane.add(feedback, new BoxLayout(pane, BoxLayout.Y_AXIS));
		feedback.setVisible(true);
		
		frame.setContentPane(pane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}


	@Override
	/**
	 * Handles clicks to the check and next buttons.
	 */
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).equals(checkButton)) {
			if(answer.getText().equals(currentExercise.getAnswer())) {	// if user answers correctly
				feedback.setText("Correct!");
				nextButton.setEnabled(true);
			}
			else	// if user answers incorrectly
				feedback.setText("Incorrect.  The correct answer is \"" + 
								 exercises.get(exerciseIndex).getAnswer() + "\"");
		}
		else if(((JButton)e.getSource()).equals(nextButton)) {
			if(exerciseIndex < exercises.size()-1){	// if there are still exercises left
				currentExercise = exercises.get(++exerciseIndex);	// get the next exercise
				instructions.setText(currentExercise.getInstructions());	//reset labels and buttons
				sentence.setText(currentExercise.getSentence());
				answer.setText("");
				feedback.setText(" ");
				nextButton.setEnabled(false);
			}
			else {	// if there are no exercises left
				feedback.setText("There are no more exercises.");
				nextButton.setEnabled(false);
			}
		}
	}

}
