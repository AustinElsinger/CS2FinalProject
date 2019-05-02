package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

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
public class ButtonPane extends GridPane
{
	//global variables
	private Button[] alphabetButtons;
	private Button resetButton;
	
	/********************************************************************************
	 * This method is a constructor for a ButtonPane object.
	 ********************************************************************************/
	public ButtonPane()
	{
		//create array of Buttons the length of the alphabet
		alphabetButtons = new Button[26];
		
		//create 26 alphabetical Buttons
		char letter = 'A';
		for (int i = 0; i < alphabetButtons.length; i++)
		{
			//create Button with text letter
			alphabetButtons[i] = new Button("" + letter);
			
			//format Button
			alphabetButtons[i].setMinSize(30, 30);
			
			//next alphabetical letter
			letter++;
		}
		
		//add alphabetButtons to the Pane in formatted way
		for (int i = 0; i < alphabetButtons.length; i++)
		{
			if (i < 10)
			{
				add(alphabetButtons[i], i, 0);
			}
			else if (i > 9 && i < 20)
			{
				add(alphabetButtons[i], i - 10, 1);
			}
			else
			{
				add(alphabetButtons[i], i - 18, 2);
			}
		}
		
		//create blank Pane for whitespace
		Pane whiteSpace = new Pane();
		
		//format whiteSpace
		whiteSpace.setMinHeight(30);
		
		//add whiteSpace to Pane
		add(whiteSpace, 0, 3);
		
		//create resetButton
		resetButton = new Button("Reset");
		
		//format resetButton
		resetButton.setMinSize(60, 30);
		
		//add resetButton to Pane
		add(resetButton, 4, 4, 2, 1);
		
		//format Pane
		setAlignment(Pos.CENTER);
		setPrefSize(400, 200);
	}
	
	/********************************************************************************
	 * This method gets the array of alphabetical Buttons.
	 * 
	 * @return The array of alphabetical Buttons.
	 ********************************************************************************/
	public Button[] getAlphabetButtons()
	{
		return alphabetButtons;
	}
	
	
	/********************************************************************************
	 * This method gets the reset Button.
	 * 
	 * @return The reset Button.
	 ********************************************************************************/
	public Button getResetButton()
	{
		return resetButton;
	}
	
	/********************************************************************************
	 * This method disables all the alphabetButtons to no longer be clickable.
	 ********************************************************************************/
	public void gameOver()
	{
		for (int i = 0; i < alphabetButtons.length; i++)
		{
			//disable Button
			alphabetButtons[i].setDisable(true);
		}
	}
	
	/********************************************************************************
	 * This method resets the Pane by setting all alphabetButtons visible and
	 * enabling them to be clickable.
	 ********************************************************************************/
	public void reset()
	{
		for (int i = 0; i < alphabetButtons.length; i++)
		{
			//set Buttons visible
			alphabetButtons[i].setVisible(true);
			
			//enable Buttons
			alphabetButtons[i].setDisable(false);
		}
	}
}
