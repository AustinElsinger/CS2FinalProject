package application;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class PersonPane extends Pane
{
	private Circle head;
	private Line leftArm;
	private Line rightArm;
	private Line torso;
	private Line leftLeg;
	private Line rightLeg;
	
	public PersonPane()
	{
		head = new Circle(200, 125, 25);
		head.setFill(null);
    	head.setStroke(Color.BLACK);
    	head.setStrokeWidth(5);
    	head.setVisible(false);
		leftArm = new Line(150, 200, 200, 150);
		leftArm.setStrokeWidth(5);
		leftArm.setVisible(false);
		rightArm = new Line(250, 200, 200, 150);
		rightArm.setStrokeWidth(5);
		rightArm.setVisible(false);
		torso = new Line(200, 225, 200, 150);
		torso.setStrokeWidth(5);
		torso.setVisible(false);
		leftLeg = new Line(150, 300, 200, 225);
		leftLeg.setStrokeWidth(5);
		leftLeg.setVisible(false);
		rightLeg = new Line(250, 300, 200, 225);
		rightLeg.setStrokeWidth(5);
		rightLeg.setVisible(false);
		Group person = new Group(head, leftArm, rightArm, torso, leftLeg, rightLeg);
		
		Line rope = new Line(200, 100, 200, 50);
		Line horizontalBeam = new Line(200, 50, 325, 50);
		Line verticalBeam = new Line(325, 50, 325, 350);
		Line leftSupport = new Line(325, 300, 275, 350);
		Line rightSupport = new Line(325, 300, 375, 350);
		Line base = new Line(275, 350, 375, 350);
		Group gallows = new Group(base, verticalBeam, horizontalBeam, leftSupport, rightSupport, rope);
		
		getChildren().add(person);
		getChildren().add(gallows);
		
		setPrefHeight(400);
		setPrefWidth(400);
	}
	
	public void setBodyPartVisible()
	{
		if (head.isVisible() == false)
		{
			head.setVisible(true);
		}
		else if (leftArm.isVisible() == false)
		{
			leftArm.setVisible(true);
		}
		else if (rightArm.isVisible() == false)
		{
			rightArm.setVisible(true);
		}
		else if (torso.isVisible() == false)
		{
			torso.setVisible(true);
		}
		else if (leftLeg.isVisible() == false)
		{
			leftLeg.setVisible(true);
		}
		else if (rightLeg.isVisible() == false)
		{
			rightLeg.setVisible(true);
		}
	}
	
	public boolean isGameOver()
	{
		if (rightLeg.isVisible() == true)
		{
			return true;
		}
		return false;
	}
	
	public void reset()
	{
		head.setVisible(false);
		leftArm.setVisible(false);
		rightArm.setVisible(false);
		torso.setVisible(false);
		leftLeg.setVisible(false);
		rightLeg.setVisible(false);
	}
}
