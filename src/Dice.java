

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Dice extends Application{

    TextField oneLineDiceText = new TextField();
    TextField howmany = new TextField();
    TextField sides = new TextField();
    RadioButton oneLine = new RadioButton("Input on one line (a-la 1d20+1)");
    RadioButton multiLine = new RadioButton("Input sides and number of dice separately");
    //the text fields and radiobuttons are global because several handlers need to access them
    Stage rollStage = new Stage();
    //this stage is global because it keeps the W I N D O W V O I D from happening 
    //since it being global lets the methods close the window before starting so the windows don't layer 
    int resSize = 250;
    int resSizeTwo = 400;//the size of the results screen, so I don't have to change it in a bunch of places
    int menuSize = 600;
    int menuSizeTwo = 105;//the size of the menu, for a similar reason to results
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox radioButtons = new VBox();
        HBox wrapThings = new HBox();
        ToggleGroup toggleGroup = new ToggleGroup();
        Button btChoose = new Button("Choose the selected input method");
        oneLine.setToggleGroup(toggleGroup);
        multiLine.setToggleGroup(toggleGroup);
        radioButtons.getChildren().add(oneLine);
        radioButtons.getChildren().add(multiLine);
        wrapThings.getChildren().add(radioButtons);
        wrapThings.getChildren().add(btChoose);
        btChoose.setOnAction(new showCorrectInputHandler());
        Scene primaryScene = new Scene(wrapThings,menuSize,menuSizeTwo);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    /**
     * because I'm too lazy to type math.random and remember how to get what I want out of it
     * @param min the smallest number you want from the function
     * @param max the high end of the range of random numbers
     * @return random number from min to max.
     */
    public int rand(int min, int max)
    {
        int r = (int) (Math.random()*max+min);
        return r;
    }
    
    /**
     * Based upon what's in the single line input box, return a set of 3 numbers
     * @return an array of three numbers: the number of dice, number of faces, and bonus. Bonus is 0 if not applicable.
     */
    public int[] parseOneLineInput()
    {
        int[] ret = {0,0,0};
        String input = oneLineDiceText.getText();
        String numberOfDice = "";
        String numberOfFaces = "";
        String bonus = "";
        if(!input.contains("d") && !input.contains("D"))
        {
        	throw new NumberFormatException("Error in dice formatting");
        }
        input = input.toLowerCase();
        String[] diceDetails = input.split("d");
        numberOfDice = diceDetails[0];
        diceDetails = diceDetails[1].split("\\+|-");
        numberOfFaces = diceDetails[0];
        if(diceDetails.length==2)
        {
            bonus = diceDetails[1];
        }
        ret[0] = Integer.parseInt(numberOfDice);
        ret[1] = Integer.parseInt(numberOfFaces);
        if(bonus.isEmpty())
        {
            ret[2] = 0;
        }
        else
        {
            ret[2] = Integer.parseInt(bonus);
        }
        return ret;
    }

    class showCorrectInputHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if(oneLine.isSelected())
            {
            	Stage oneLineStage = new Stage();
                Scene primscene = setupOneLineHandler();
                oneLineStage.setScene(primscene);//make the scene and set it to a window
                oneLineStage.show();//show the menu window
            }
            else if(multiLine.isSelected())
            {
                
                Stage multiLineStage = new Stage();
                Scene primscene = setupMultiLineHandler();
                multiLineStage.setScene(primscene);//make the scene and set it to a window
                multiLineStage.show();//show the menu window
            }
        }

		private Scene setupMultiLineHandler() {
			oneLineDiceText.setText("");
			//empty the single line text so the keypress handler works right
			VBox inputs = new VBox();
			VBox labels = new VBox();
			HBox wrapbois = new HBox();
			Text howmanylabel = new Text("How many dice are we rolling?");
			Text sideslabel = new Text("How many sides on the dice?");//make the labels for the text boxes
			Button btRoll = new Button("Roll those dice my dude!");//make the button to roll the dice
			labels.getChildren().add(howmanylabel);
			labels.getChildren().add(sideslabel);//add the labels to their vbox
			inputs.getChildren().add(howmany);
			inputs.getChildren().add(sides);//add the input text boxes to their vbox (which is separate from the labels for alignment purposes
			wrapbois.getChildren().add(labels);
			wrapbois.getChildren().add(inputs);
			wrapbois.getChildren().add(btRoll);//add the labels, inputs, and the button to press to roll the dice to the thing that goes in the window
			btRoll.setAlignment(Pos.CENTER);//align the button center because reasons
			btRoll.setOnAction(new multiLineRollHandler());//wire the button for clickies
			howmany.setOnKeyPressed(new rollhandlerKey());
			sides.setOnKeyPressed(new rollhandlerKey());
			btRoll.setOnKeyPressed(new rollhandlerKey());//wire all the focusable things for to do an allowance of using the enter key
			Scene scene = new Scene(wrapbois,menuSize,menuSizeTwo);
			return scene;
		}

		private Scene setupOneLineHandler() {
			howmany.setText("");
            sides.setText("");
            //set these two boxes to have no text in them so the keypress handler works right
            VBox inputs = new VBox();
            VBox labels = new VBox();
            HBox wrapbois = new HBox();
            Text diceinputlabel = new Text("Input your roll in standard format");
            Button btRoll = new Button("Roll those dice my dude!");//make the button to roll the dice
            labels.getChildren().add(diceinputlabel);
            inputs.getChildren().add(oneLineDiceText);//add the input text boxes to their vbox (which is separate from the labels for alignment purposes
            wrapbois.getChildren().add(labels);
            wrapbois.getChildren().add(inputs);
            wrapbois.getChildren().add(btRoll);//add the labels, inputs, and the button to press to roll the dice to the thing that goes in the window
            btRoll.setAlignment(Pos.CENTER);//align the button center because reasons
            btRoll.setOnAction(new oneLineRollHandler());//wire the button for clickies
            oneLineDiceText.setOnKeyPressed(new rollhandlerKey());
            btRoll.setOnKeyPressed(new rollhandlerKey());//wire all the focusable things for to do an allowance of using the enter key
            Scene scene = new Scene(wrapbois,menuSize,menuSizeTwo);
            return scene;
		}
    }

    class multiLineRollHandler implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) {
            HBox aech = new HBox();
            Text results = new Text("yoooo");
            aech.getChildren().add(results);
            String numberHolder = "You Rolled:\n";
            int numdice = 0;
            int numface = 0;
            try{
                rollStage.close();//this fixes W I N D O W V O I D
                numdice = Integer.parseInt(howmany.getText());
                numface = Integer.parseInt(sides.getText());
                if (numdice<=0 || numface <=0)
                {
                    throw new NumberFormatException();
                }
                //get the number of dice being rolled and the number of faces each die has
                for(int i = 0; i <numdice; i++)
                {
                    numberHolder += rand(1,numface);
                    numberHolder += "\n";
                }
                //however many dice are being rolled, pick a number between 1 and the number of faces each die has at random
                //i.e. roll the dice
                //then add the number to a holder
                results.setText(numberHolder);//make the results text part of the display 
                Scene rollScene = new Scene(aech,resSize,resSizeTwo);
                rollStage.setScene(rollScene);//set the scene of the roll display to be the one containing the results
                rollStage.show();//show the results
            }
            catch(NumberFormatException e)
            {
                rollStage.close();
                //if one of the numbers was not a number, tell the user they goofed.
                results.setText("one of those \"numbers\" isn't a number that's on dice. why do you gotta.");
                Scene rollScene = new Scene(aech,menuSize,menuSizeTwo);
                rollStage.setScene(rollScene);
                rollStage.show();
            }
        }
        
    }
    
    class oneLineRollHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle(ActionEvent event) {
            HBox aech = new HBox();
            Text results = new Text("yoooo");
            aech.getChildren().add(results);
            String numberHolder = "You Rolled:\n";
            int numdice = 0;
            int numface = 0;
            int bonus = 0;
            int total = 0;
            try{
                rollStage.close();//this fixes W I N D O W V O I D
                int[] dicedeets = {0,0,0};
                dicedeets = parseOneLineInput();
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
                    int temp = rand(1,numface);
                    numberHolder += temp;
                    numberHolder += "\n";
                    total+=temp;
                }
                //however many dice are being rolled, pick a number between 1 and the number of faces each die has at random
                //i.e. roll the dice
                //then add the number to a holder
                //may change this later to instead add an image of the die face corresponding with the number rolled to the scene
                numberHolder+="Your total is: ";
                if(oneLineDiceText.getText().contains("-"))
                {
                    numberHolder+=(total-bonus);
                }
                else if(oneLineDiceText.getText().contains("+"))
                {
                    numberHolder+=(total+bonus);
                }
                else
                {
                    numberHolder+=(total);
                }
                results.setText(numberHolder);//make the results text part of the display 
                Scene rollScene = new Scene(aech,resSize,resSizeTwo);
                rollStage.setScene(rollScene);//set the scene of the roll display to be the one containing the results
                rollStage.show();//show the results
            }
            catch(NumberFormatException e)
            {
                rollStage.close();
                //if one of the numbers was not a number, tell the user they goofed.
                results.setText("one of those \"numbers\" isn't a number that's on dice. why do you gotta.");
                Scene rollScene = new Scene(aech,menuSize,menuSizeTwo);
                rollStage.setScene(rollScene);
                rollStage.show();
            }
        }
    }
    class rollhandlerKey implements EventHandler<KeyEvent> {
        
        @Override
        public void handle(KeyEvent event) {
            if(event.getCode().equals(KeyCode.ENTER))
            {
                if(!oneLineDiceText.getText().isEmpty())
                {
                    new oneLineRollHandler().handle(new ActionEvent());
                }
                else if(!howmany.getText().isEmpty() && !sides.getText().isEmpty())
                {
                    new multiLineRollHandler().handle(new ActionEvent());
                }
                //basically, if the key pressed was enter, do the stuff needed to roll dice
                //based on which text fields have text
                //otherwise do NOT A DARN THING
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
