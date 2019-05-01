package application;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class WordPane extends GridPane
{
	private ArrayList<Label> letters;
	
	public WordPane(ArrayList<String> letters)
	{
		this.letters = new ArrayList<Label>();
		
		int i = 0;
		for (String element : letters)
		{
			this.letters.add(new Label(element));
			this.letters.get(i).setMinSize(30, 30);
			this.letters.get(i).setVisible(false);
			this.letters.get(i).setAlignment(Pos.CENTER);
			add(this.letters.get(i), i, 0);
			i++;
		}
		
		setGridLinesVisible(true);
		
		setAlignment(Pos.CENTER);
		
		setPrefHeight(100);
		setPrefWidth(400);
	}
	
	public boolean checkLetter(String letter)
	{
		boolean isContained = false;
		for (Label element : letters)
		{
			if (element.getText().equals(letter))
			{
				element.setVisible(true);
				isContained = true;
			}
		}
		return isContained;
	}
	
	public boolean isGameOver()
	{
		boolean wordCompleted = true;
		for (Label element : letters)
		{
			if (element.isVisible() == false)
			{
				wordCompleted = false;
			}
		}
		return wordCompleted;
	}
	
	public void gameOver()
	{
		for (Label element : letters)
		{
			if (element.isVisible() == false)
			{
				element.setVisible(true);
				element.setStyle("-fx-text-fill: red;");
			}
		}
	}
	
	public void reset(ArrayList<String> newLetters)
	{
		getChildren().removeAll(letters);
		letters.clear();
		
		int i = 0;
		for (String element : newLetters)
		{
			letters.add(new Label(element));
			letters.get(i).setMinSize(30, 30);
			letters.get(i).setVisible(false);
			letters.get(i).setAlignment(Pos.CENTER);
			add(letters.get(i), i, 0);
			i++;
		}
	}
}
