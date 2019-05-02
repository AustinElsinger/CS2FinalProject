package application;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

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
public class PersonPane extends Pane
{
	//class variables
	private Circle head;
	private Line leftArm;
	private Line rightArm;
	private Line torso;
	private Line leftLeg;
	private Line rightLeg;
	
	/********************************************************************************
	 * This method is the default constructor for a PersonPane object.
	 ********************************************************************************/
	public PersonPane()
	{		
		//format head
		head = new Circle(200, 125, 25);
		head.setFill(null);
    	head.setStroke(Color.BLACK);
    	head.setStrokeWidth(5);
    	head.setVisible(false);
    	
    	//format leftArm
		leftArm = new Line(150, 200, 200, 150);
		leftArm.setStrokeWidth(5);
		leftArm.setVisible(false);
		
		//format rightArm
		rightArm = new Line(250, 200, 200, 150);
		rightArm.setStrokeWidth(5);
		rightArm.setVisible(false);
		
		//format torso
		torso = new Line(200, 225, 200, 150);
		torso.setStrokeWidth(5);
		torso.setVisible(false);
		
		//format leftLeg
		leftLeg = new Line(150, 300, 200, 225);
		leftLeg.setStrokeWidth(5);
		leftLeg.setVisible(false);
		
		//format rightLeg
		rightLeg = new Line(250, 300, 200, 225);
		rightLeg.setStrokeWidth(5);
		rightLeg.setVisible(false);
		
		Group person = new Group(head, leftArm, rightArm, torso, leftLeg, rightLeg);
		
		//format rope
		Line rope = new Line(200, 100, 200, 50);
		
		//format horizontalBeam
		Line horizontalBeam = new Line(200, 50, 325, 50);
		
		//format verticalBeam
		Line verticalBeam = new Line(325, 50, 325, 350);
		
		//format leftSupport
		Line leftSupport = new Line(325, 300, 275, 350);
		
		//format rightSupport
		Line rightSupport = new Line(325, 300, 375, 350);
		
		//format base
		Line base = new Line(275, 350, 375, 350);
		
		Group gallows = new Group(base, verticalBeam, horizontalBeam, leftSupport, rightSupport, rope);
		
		//add groups to the pane
		getChildren().add(person);
		getChildren().add(gallows);
		
		//format pane
		setPrefSize(400, 400);
	}
	
	/********************************************************************************
	 * This method sets one of the six body parts to be visible.  The body part
	 * being set visible depends on a particular sequence and which parts are already
	 * visible.  The sequence of body parts is as follows: head, leftArm, rightArm,
	 * torso, leftLeg, rightLeg.
	 ********************************************************************************/
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
	
	/********************************************************************************
	 * This method checks to see if the game is over based on the last body part 
	 * being visible or not.
	 * 
	 * @return true if the last body part is visible and the game is over; false if
	 *         there are still invisible body parts.
	 ********************************************************************************/
	public boolean isGameOver()
	{
		//check if last body part is visible
		if (rightLeg.isVisible() == true)
		{
			return true;
		}
		return false;
	}
	
	/********************************************************************************
	 * This method resets the Pane by setting all the body parts to be invisible.
	 ********************************************************************************/
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
