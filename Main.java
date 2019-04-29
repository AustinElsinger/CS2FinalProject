package application;
	
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class Main extends Application
{
	private static final String[] WORD_BANK = {"JAVAFX", "POLYMORPHISM", "APPLICATION", "HANGMAN", "PROGRAMMING", "COMPUTER", "ELECTRONICS", "OBJECT", "INHERITANCE"};
	private ArrayList<String> letters;
	private String word;
	
	private PersonPane personPane;
	private WordPane wordPane;
	private ButtonPane buttonPane;
	
	@Override
	public void start(Stage primaryStage)
	{
		Random random = new Random();
		word = WORD_BANK[random.nextInt(WORD_BANK.length)];
		
		letters = new ArrayList<String>();
		for (int i = 0; i < word.length(); i++)
		{
			letters.add("" + word.charAt(i));
		}
		
		personPane = new PersonPane();
		wordPane = new WordPane(letters);
		buttonPane = new ButtonPane();
		
		Button alphabet[] = buttonPane.getAlphabet();
		for (int i = 0; i < alphabet.length; i++)
		{
			alphabet[i].setOnAction(this::processButtonPress);
		}
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(personPane);
		borderPane.setCenter(wordPane);
		borderPane.setBottom(buttonPane);
		
		Scene scene = new Scene(borderPane, 400, 650);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hangman");
		primaryStage.show();
	}
	
	public void processButtonPress(ActionEvent event)
	{
		String letter = ((Button) event.getSource()).getText();
		((Button) event.getSource()).setVisible(false);
		if (wordPane.checkLetter(letter) == false)
		{
			personPane.setBodyPartVisible();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
