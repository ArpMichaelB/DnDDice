package com.glacier.handlers;

import com.glacier.util.Utility;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

class rollhandlerKey implements EventHandler<KeyEvent> 
{
	private String numberOfSidesOrOneLine;
	private String numberOfDice;
	
	public rollhandlerKey(String lineOne, String lineTwo)
	{
		this.numberOfSidesOrOneLine = lineOne;
		this.numberOfDice = lineTwo;
	}
	
    @Override
    public void handle(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER))
        {
            if(numberOfDice.equalsIgnoreCase(Utility.ONE_LINE_PLACEHOLDER))
            {
                new oneLineRollHandler(numberOfSidesOrOneLine).handle(new ActionEvent());
            }
            else
            {
                new multiLineRollHandler(numberOfSidesOrOneLine,numberOfDice).handle(new ActionEvent());
            }
            //basically, if the key pressed was enter
            //handle the appropriate type of input
            //otherwise do NOT A DARN THING
        }
    }
}