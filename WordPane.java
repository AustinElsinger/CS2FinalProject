package application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/****************************************************************************************************
 * @author Andrew Beidel
 * @author Austin Elsinger
 * 
 * @version 1.0
 * @since 2 May 2019
 * 
 *     |-| CHANGELOG |-|
 * N/A
 ****************************************************************************************************/
public class WordPane extends GridPane
{
	//global variables
	private Label[] letters;
	
	/********************************************************************************
	 * This method is a constructor for a WordPane object.
	 * 
	 * @param word The word to be guessed by the user.
	 ********************************************************************************/
	public WordPane(String word)
	{
		//creates an array with length equal to the number of characters in the word
		letters = new Label[word.length()];
		
		//adds a new Label to letters for each character in word
		for (int i = 0; i < word.length(); i++)
		{
			//creates new Label with the next letter in word
			letters[i] = new Label("" + word.charAt(i));
			
			//format Label
			letters[i].setMinSize(30, 30);
			letters[i].setVisible(false);
			letters[i].setAlignment(Pos.CENTER);
			
			//add Label to Pane
			add(letters[i], i, 0);
		}
		
		//format pane
		setGridLinesVisible(true);
		setAlignment(Pos.CENTER);
		setPrefSize(400, 100);
	}
	
	/********************************************************************************
	 * This method checks to see if a letter is contained in the array of Labels that
	 * make up the word being guessed.  All instances of the letter (if any) are made
	 * visible.
	 * 
	 * @param letter The letter to check if it is contained in the word being guessed.
	 * 
	 * @return true if the letter is contained in the word being guessed; false if
	 *         the letter is not contained in the word being guessed.
	 ********************************************************************************/
	public boolean checkLetter(String letter)
	{
		boolean isContained = false;
		
		//check if letter is contained in the array
		for (int i = 0; i < letters.length; i++)
		{
			//set all instances of the letter to be visible
			if (letters[i].getText().equals(letter))
			{
				letters[i].setVisible(true);
				
				//change return value
				isContained = true;
			}
		}
		
		return isContained;
	}
	
	/********************************************************************************
	 * This method checks to see if the game is over based on all the letter Labels
	 * being visible or not.
	 * 
	 * @return true if all the letter Labels are visible and the game is over; false
	 *         if there are still invisible letter Labels and the game is not over.
	 ********************************************************************************/
	public boolean isGameOver()
	{
		boolean wordCompleted = true;
		
		//check for any invisible letter Labels
		for (int i = 0; i < letters.length; i++)
		{
			if (letters[i].isVisible() == false)
			{
				//change return value
				wordCompleted = false;
			}
		}
		
		return wordCompleted;
	}
	
	/********************************************************************************
	 * This method displays any unguessed/invisible letter Labels as red text to
	 * notify the user of missed letters.
	 ********************************************************************************/
	public void gameOver()
	{
		for (int i = 0; i < letters.length; i++)
		{
			if (letters[i].isVisible() == false)
			{
				//set invisible letter Labels to red text
				letters[i].setStyle("-fx-text-fill: red;");
				
				//set invisible letter Labels to visible
				letters[i].setVisible(true);
			}
		}
	}
	
	/********************************************************************************
	 * This method resets the Pane by removing any Labels and adding new Labels 
	 * corresponding the the letter in newWord.
	 * 
	 * @param newWord The new word to be guessed by the user.
	 ********************************************************************************/
	public void reset(String newWord)
	{
		//remove Labels
		getChildren().removeAll(letters);
		
		//creates an array with length equal to the number of characters in the new word
		letters = new Label[newWord.length()];
		
		for (int i = 0; i < newWord.length(); i++)
		{
			//creates new Label with the next letter in word
			letters[i] = new Label("" + newWord.charAt(i));
			
			//format Label
			letters[i].setMinSize(30, 30);
			letters[i].setVisible(false);
			letters[i].setAlignment(Pos.CENTER);
			
			//add Label to Pane
			add(letters[i], i, 0);
		}
	}
}
