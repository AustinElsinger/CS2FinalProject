package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ButtonPane extends GridPane
{	
	private Button[] alphabetButtons;
	private Button resetButton;
	
	public ButtonPane()
	{
		alphabetButtons = new Button[26];
		
		char letter = 'A';
		for (int i = 0; i < alphabetButtons.length; i++)
		{
			alphabetButtons[i] = new Button("" + letter);
			alphabetButtons[i].setMinSize(30, 30);
			letter++;
		}
		
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
		
		Pane whiteSpace = new Pane();
		whiteSpace.setMinHeight(30);
		add(whiteSpace, 0, 3);
		
		resetButton = new Button("Reset");
		resetButton.setMinSize(60, 30);
		add(resetButton, 4, 4, 2, 1);
		
		setAlignment(Pos.CENTER);
		setPrefHeight(200);
		setPrefWidth(400);
	}
	
	public Button[] getAlphabetButtons()
	{
		return alphabetButtons;
	}
	
	public Button getResetButton()
	{
		return resetButton;
	}
	
	public void gameOver()
	{
		for (int i = 0; i < alphabetButtons.length; i++)
		{
			alphabetButtons[i].setDisable(true);
		}
	}
	
	public void reset()
	{
		for (int i = 0; i < alphabetButtons.length; i++)
		{
			alphabetButtons[i].setVisible(true);
			alphabetButtons[i].setDisable(false);
		}
	}
}
