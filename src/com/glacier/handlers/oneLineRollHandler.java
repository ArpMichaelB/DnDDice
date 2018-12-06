package com.glacier.handlers;

import com.glacier.exceptions.NegativeDiceException;
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
        try{
            int[] dicedeets = {0,0,0};
            dicedeets = Utility.parseOneLineInput(oneLineDiceText);
            if (dicedeets[0]<=0 || dicedeets[1]<=0)
            {
                throw new NegativeDiceException(Utility.NEGATIVE_DICE_ERROR + Utility.getCurrentTimestamp());
            }
            
            Scene rollScene = Utility.getResult(dicedeets,oneLineDiceText);
            rollStage.setScene(rollScene);//set the scene of the roll display to be the one containing the results
            rollStage.show();//show the results
        }
        catch(NumberFormatException e)
        {
        	rollStage.close();
        	if(e instanceof NegativeDiceException)
        	{
        		results.setText(e.getMessage());
        		System.err.println(e.getMessage());
        	}
        	else
        	{
        		results.setText("Seems like " + e.getMessage().substring(e.getMessage().indexOf("\"")+1, e.getMessage().lastIndexOf("\"")) + " isn't a number. Try again?");
        	}
            //if one of the numbers was not a number, tell the user they goofed.
            Scene rollScene = new Scene(aech,Utility.MENU_SIZE,Utility.MENU_SIZE_TWO);
            rollStage.setScene(rollScene);
            rollStage.show();
            e.printStackTrace();
        }
    }
}