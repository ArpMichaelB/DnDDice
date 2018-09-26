package com.glacier.handlers;

import com.glacier.util.Utility;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class showCorrectInputHandler implements EventHandler<ActionEvent> 
{
	private boolean oneLineStatus;
	private boolean multiLineStatus;

	public showCorrectInputHandler(boolean oneLineStatus, boolean multiLineStatus)
	{
		this.oneLineStatus = oneLineStatus;
		this.multiLineStatus = multiLineStatus;
	}

    @Override
    public void handle(ActionEvent event) 
    {
        if(oneLineStatus)
        {
        	Stage oneLineStage = new Stage();
            Scene primscene = setupOneLineHandler();
            oneLineStage.setScene(primscene);//make the scene and set it to a window
            oneLineStage.show();//show the menu window
        }
        else if(multiLineStatus)
        {
            Stage multiLineStage = new Stage();
            Scene primscene = setupMultiLineHandler();
            multiLineStage.setScene(primscene);//make the scene and set it to a window
            multiLineStage.show();//show the menu window
        }
    }

	private Scene setupMultiLineHandler() 
	{
        VBox inputs = new VBox();
        VBox labels = new VBox();
        HBox wrapbois = new HBox();
        Text howmanylabel = new Text("How many dice are we rolling?");
        Text sideslabel = new Text("How many sides on the dice?");//make the labels for the text boxes
        Button btRoll = new Button("Roll those dice my dude!");//make the button to roll the dice
        TextField diceToRoll = new TextField();
        TextField sidesOnDice = new TextField();
        labels.getChildren().add(howmanylabel);
        labels.getChildren().add(sideslabel);//add the labels to their vbox
        inputs.getChildren().add(diceToRoll);
        inputs.getChildren().add(sidesOnDice);//add the input text boxes to their vbox (which is separate from the labels for alignment purposes
        wrapbois.getChildren().add(labels);
        wrapbois.getChildren().add(inputs);
        wrapbois.getChildren().add(btRoll);//add the labels, inputs, and the button to press to roll the dice to the thing that goes in the window
        btRoll.setAlignment(Pos.CENTER);//align the button center because reasons
        btRoll.setOnAction(new multiLineRollHandler(sidesOnDice.getText(),diceToRoll.getText()));//wire the button for clickies
        diceToRoll.setOnKeyPressed(new rollhandlerKey(sidesOnDice.getText(),diceToRoll.getText()));
        sidesOnDice.setOnKeyPressed(new rollhandlerKey(sidesOnDice.getText(),diceToRoll.getText()));
        btRoll.setOnKeyPressed(new rollhandlerKey(sidesOnDice.getText(),diceToRoll.getText()));//wire all the focusable things for to do an allowance of using the enter key
        Scene scene = new Scene(wrapbois,Utility.MENU_SIZE,Utility.MENU_SIZE_TWO);
        return scene;
	}

	private Scene setupOneLineHandler() 
	{
        VBox inputs = new VBox();
        VBox labels = new VBox();
        HBox wrapbois = new HBox();
        Text diceinputlabel = new Text("Input your roll in standard format");
        Button btRoll = new Button("Roll those dice my dude!");//make the button to roll the dice
        TextField oneLineDiceText = new TextField();
        labels.getChildren().add(diceinputlabel);
        inputs.getChildren().add(oneLineDiceText);//add the input text boxes to their vbox (which is separate from the labels for alignment purposes
        wrapbois.getChildren().add(labels);
        wrapbois.getChildren().add(inputs);
        wrapbois.getChildren().add(btRoll);//add the labels, inputs, and the button to press to roll the dice to the thing that goes in the window
        btRoll.setAlignment(Pos.CENTER);//align the button center because reasons
        btRoll.setOnAction(new oneLineRollHandler(oneLineDiceText.getText()));//wire the button for clickies
        oneLineDiceText.setOnKeyPressed(new rollhandlerKey(oneLineDiceText.getText(),Utility.ONE_LINE_PLACEHOLDER));
        btRoll.setOnKeyPressed(new rollhandlerKey(oneLineDiceText.getText(),Utility.ONE_LINE_PLACEHOLDER));//wire all the focusable things for to do an allowance of using the enter key
        Scene scene = new Scene(wrapbois,Utility.MENU_SIZE,Utility.MENU_SIZE_TWO);
        return scene;
	}
}