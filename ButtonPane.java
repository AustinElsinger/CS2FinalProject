package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ButtonPane extends GridPane
{	
	private Button[] alphabet;
	
	public ButtonPane()
	{
		alphabet = new Button[26];
		
		char letter = 'A';
		for (int i = 0; i < alphabet.length; i++)
		{
			alphabet[i] = new Button("" + letter);
			alphabet[i].setMinSize(30, 30);
			letter++;
		}
		
		for (int i = 0; i < alphabet.length; i++)
		{
			if (i < 10)
			{
				add(alphabet[i], i, 0);
			}
			else if (i > 9 && i < 20)
			{
				add(alphabet[i], i - 10, 1);
			}
			else
			{
				add(alphabet[i], i - 18, 2);
			}
		}
		
		setAlignment(Pos.CENTER);
		setPrefHeight(150);
		setPrefWidth(400);
	}
	
	public Button[] getAlphabet()
	{
		return alphabet;
	}
	
	public void resetButtons()
	{
		for (int i = 0; i < alphabet.length; i++)
		{
			alphabet[i].setVisible(true);
		}
	}
}
