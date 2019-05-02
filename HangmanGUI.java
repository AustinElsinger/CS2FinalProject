package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
public class HangmanGUI extends Application
{
	//global variables
	private String word;
	private PersonPane personPane;
	private WordPane wordPane;
	private ButtonPane buttonPane;
	
	/********************************************************************************
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 ********************************************************************************/
	@Override
	public void start(Stage primaryStage)
	{
		//generate random word to be guessed by the user
		RandomWord randomWord = new RandomWord();
		word = randomWord.getWord();
		
		//create Panes
		personPane = new PersonPane();
		wordPane = new WordPane(word);
		buttonPane = new ButtonPane();
		
		//assign event listener to alphabetButtons
		Button alphabetButtons[] = buttonPane.getAlphabetButtons();
		for (int i = 0; i < alphabetButtons.length; i++)
		{
			alphabetButtons[i].setOnAction(this::processAlphabetButtonPress);
		}
		
		//assign event listener to resetButton
		Button reset = buttonPane.getResetButton();
		reset.setOnAction(this::processResetButton);
		
		//format borderPane
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(personPane);
		borderPane.setCenter(wordPane);
		borderPane.setBottom(buttonPane);
		
		//format primaryStage
		Scene scene = new Scene(borderPane, 400, 650);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hangman");
		primaryStage.show();
	}
	
	/********************************************************************************
	 * This method processes the events of an alphabet Button press.
	 * 
	 * @param event The event used to call this method.
	 ********************************************************************************/
	public void processAlphabetButtonPress(ActionEvent event)
	{
		//store guessed letter
		String letter = ((Button) event.getSource()).getText();
		
		//set event source Button invisible
		((Button) event.getSource()).setVisible(false);
		
		//test for incorrect letter
		if (wordPane.checkLetter(letter) == false)
		{
			//set next body part visible
			personPane.setBodyPartVisible();
		}
		
		//test if game is over
		if (personPane.isGameOver() == true || wordPane.isGameOver() == true)
		{
			//call gameOver methods
			wordPane.gameOver();
			buttonPane.gameOver();
		}
	}
	
	/********************************************************************************
	 * This method processes the events of a reset Button press.
	 * 
	 * @param event The event used to call this method.
	 ********************************************************************************/
	public void processResetButton(ActionEvent event)
	{
		//generate random new word to be guessed by the user
		RandomWord randomWord = new RandomWord();
		word = randomWord.getWord();
		
		//reset personPane
		personPane.reset();
		
		//reset wordPane
		wordPane.reset(word);
		
		//reset buttonPane
		buttonPane.reset();
	}
	
	/********************************************************************************
	 * Application main method.
	 * 
	 * @param args
	 ********************************************************************************/
	public static void main(String[] args)
	{
		launch(args);
	}
}
