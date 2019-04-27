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
			
			this.letters.get(i).setAlignment(Pos.CENTER);
			add(this.letters.get(i), i, 0);
			i++;
		}
		
		setGridLinesVisible(true);
		
		setAlignment(Pos.CENTER);
		
		setPrefHeight(100);
		setPrefWidth(400);
	}
}
