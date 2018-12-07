package com.glacier.handlers;

import java.net.URISyntaxException;

import com.glacier.exceptions.NegativeDiceException;
import com.glacier.util.Utility;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class multiLineRollHandler implements EventHandler<ActionEvent>
{

	private String howManySides;
	private String howManyDice;
	
	public multiLineRollHandler(String howManySides, String howManyDice)
	{
		this.howManyDice = howManyDice;
		this.howManySides = howManySides;
	}

    @Override
    public void handle(ActionEvent event) {
        Stage rollStage = new Stage();
    	HBox aech = new HBox();
        Text results = new Text("yoooo");
        ScrollPane scrolledBar = new ScrollPane();
        scrolledBar.setContent(results);
        aech.getChildren().add(scrolledBar);
        scrolledBar.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrolledBar.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrolledBar.setMinHeight(Utility.RESULTS_SIZE_TWO);
        scrolledBar.setMinWidth(Utility.RESULTS_SIZE);
        int numdice = 0;
        int numface = 0;
        try{
            int[] dicedeets = {0,0};
            dicedeets = Utility.parseMultiLineInput(howManySides, howManyDice);
            numdice = dicedeets[0];
            numface = dicedeets[1];
            if (numdice<=0 || numface <=0)
            {
                throw new NegativeDiceException(Utility.NEGATIVE_DICE_ERROR + Utility.getCurrentTimestamp());
            }
            //get the number of dice being rolled and the number of faces each die has
            Scene rollScene = Utility.getResult(dicedeets, Utility.ONE_LINE_PLACEHOLDER);
            rollStage.setScene(rollScene);//set the scene of the roll display to be the one containing the results
            rollStage.show();//show the results
        }
        catch(NumberFormatException e)
        {
        	rollStage.close();
        	if(e instanceof NegativeDiceException)
        	{
        		results.setText(e.getMessage());
        	}
        	else
        	{
        		results.setText("Seems like " + e.getMessage().substring(e.getMessage().indexOf("\"")+1, e.getMessage().lastIndexOf("\"")) + " isn't a number. Try again?");
        	}
            Scene rollScene = new Scene(aech,Utility.MENU_SIZE,Utility.MENU_SIZE_TWO);
            rollStage.setScene(rollScene);
            rollStage.show();
        } 
        catch (URISyntaxException e)
        {
			rollStage.close();
			results.setText("Oh dear, I can't seem to find the image. \nToss the logs (in /glacier nester/logs) to glaciernester@gmail.com");
        	e.printStackTrace();
        	Scene rollScene = new Scene(aech,Utility.MENU_SIZE,Utility.MENU_SIZE_TWO);
        	rollStage.setScene(rollScene);
        	rollStage.show();
		}
    }
    
}