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
	private Group person;
	
	private Line rope;
	private Line horizontalBeam;
	private Line verticalBeam;
	private Line leftSupport;
	private Line rightSupport;
	private Line base;
	private Group gallow;
	
	public PersonPane()
	{
		head = new Circle(200, 125, 25);
		head.setFill(null);
    	head.setStroke(Color.BLACK);
    	head.setStrokeWidth(5);
		leftArm = new Line(150, 200, 200, 150);
		leftArm.setStrokeWidth(5);
		rightArm = new Line(250, 200, 200, 150);
		rightArm.setStrokeWidth(5);
		torso = new Line(200, 225, 200, 150);
		torso.setStrokeWidth(5);
		leftLeg = new Line(150, 300, 200, 225);
		leftLeg.setStrokeWidth(5);
		rightLeg = new Line(250, 300, 200, 225);
		rightLeg.setStrokeWidth(5);
		person = new Group(head, leftArm, rightArm, torso, leftLeg, rightLeg);
		
		rope = new Line(200, 100, 200, 50);
		horizontalBeam = new Line(200, 50, 325, 50);
		verticalBeam = new Line(325, 50, 325, 350);
		leftSupport = new Line(325, 300, 275, 350);
		rightSupport = new Line(325, 300, 375, 350);
		base = new Line(275, 350, 375, 350);
		gallow = new Group(base, verticalBeam, horizontalBeam, leftSupport, rightSupport, rope);
		
		getChildren().add(person);
		getChildren().add(gallow);
		
		setPrefHeight(400);
		setPrefWidth(400);
	}
	
	public void setHeadVisible(boolean bool)
	{
		head.setVisible(bool);
	}
	
	public void setLeftArmVisible(boolean bool)
	{
		leftArm.setVisible(bool);
	}
	
	public void setRightArmVisible(boolean bool)
	{
		rightArm.setVisible(bool);
	}
	
	public void setTorsoVisible(boolean bool)
	{
		torso.setVisible(bool);
	}
	
	public void setLeftLegVisible(boolean bool)
	{
		leftLeg.setVisible(bool);
	}
	
	public void setRightLegVisible(boolean bool)
	{
		rightLeg.setVisible(bool);
	}
}
