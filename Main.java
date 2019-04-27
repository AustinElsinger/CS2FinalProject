package application;
	
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application
{
	private static final String[] WORD_BANK = {"JAVAFX", "POLYMORPHISM", "APPLICATION", "HANGMAN", "PROGRAMMING"};
	private ArrayList<String> letters;
	private String word;
	
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
		
		PersonPane personPane = new PersonPane();
		WordPane wordPane = new WordPane(letters);
		ButtonPane buttonPane = new ButtonPane();
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(personPane);
		borderPane.setCenter(wordPane);
		borderPane.setBottom(buttonPane);
		
		Scene scene = new Scene(borderPane, 400, 650);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hangman");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
