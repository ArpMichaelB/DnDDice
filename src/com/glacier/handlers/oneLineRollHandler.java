package com.glacier.handlers;

import com.glacier.util.Utility;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class oneLineRollHandler implements EventHandler<ActionEvent> 
{
	private String oneLineDiceText;
	
	public oneLineRollHandler(String oneLineDiceText)
	{
		this.oneLineDiceText = oneLineDiceText;
	}
    @Override
    public void handle(ActionEvent event) {
        Stage rollStage = new Stage();
    	HBox aech = new HBox();
        Text results = new Text("yoooo");
        aech.getChildren().add(results);
        String numberHolder = "You Rolled:\n";
        int numdice = 0;
        int numface = 0;
        int bonus = 0;
        int total = 0;
        try{
            int[] dicedeets = {0,0,0};
            dicedeets = Utility.parseOneLineInput(oneLineDiceText);
            numdice = dicedeets[0];
            numface = dicedeets[1];
            bonus = dicedeets[2];
            if (numdice<=0 || numface <=0)
            {
                throw new NumberFormatException();
            }
            //get the number of dice being rolled and the number of faces each die has
            for(int i = 0; i <numdice; i++)
            {
                int temp = Utility.rand(1,numface);
                numberHolder += temp;
                numberHolder += "\n";
                total+=temp;
            }
            //however many dice are being rolled, pick a number between 1 and the number of faces each die has at random
            //i.e. roll the dice
            //then add the number to a holder
            //may change this later to instead add an image of the die face corresponding with the number rolled to the scene
            numberHolder+="Your total is: ";
            if(oneLineDiceText.contains("-"))
            {
                numberHolder+=(total-bonus);
            }
            else if(oneLineDiceText.contains("+"))
            {
                numberHolder+=(total+bonus);
            }
            else
            {
                numberHolder+=(total);
            }
            results.setText(numberHolder);//make the results text part of the display 
            Scene rollScene = new Scene(aech,Utility.RESULTS_SIZE,Utility.RESULTS_SIZE_TWO);
            rollStage.setScene(rollScene);//set the scene of the roll display to be the one containing the results
            rollStage.show();//show the results
        }
        catch(NumberFormatException e)
        {
            rollStage.close();
            //if one of the numbers was not a number, tell the user they goofed.
            results.setText("one of those \"numbers\" isn't a number that's on dice. why do you gotta.");
            Scene rollScene = new Scene(aech,Utility.MENU_SIZE,Utility.MENU_SIZE_TWO);
            rollStage.setScene(rollScene);
            rollStage.show();
        }
    }
}