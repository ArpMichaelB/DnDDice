

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

    TextField dicetext = new TextField();//the fields is global so the button handler can see what I've typed
    Stage rollStage = new Stage();
    //this stage is global because it keeps the W I N D O W V O I D from happening 
    //since it being global lets the methods close the window before starting so the windows don't layer 
    int resSize = 250;
    int resSizeTwo = 400;//the size of the results screen, so I don't have to change it in a bunch of places
    int menuSize = 600;
    int menuSizeTwo = 105;//the size of the menu, in case I need to point it out more than once (I shouldn't)
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox inputs = new VBox();
        VBox labels = new VBox();
        HBox wrapbois = new HBox();
        Text howmanylabel = new Text("How many dice are we rolling?");
        Text sideslabel = new Text("How many sides on the dice?");//make the labels for the text boxes
        Button btRoll = new Button("Roll those dice my dude!");//make the button to roll the dice
        labels.getChildren().add(howmanylabel);
        labels.getChildren().add(sideslabel);//add the labels to their vbox
        inputs.getChildren().add(dicetext);//add the input text boxes to their vbox (which is separate from the labels for alignment purposes
        wrapbois.getChildren().add(labels);
        wrapbois.getChildren().add(inputs);
        wrapbois.getChildren().add(btRoll);//add the labels, inputs, and the button to press to roll the dice to the thing that goes in the window
        btRoll.setAlignment(Pos.CENTER);//align the button center because reasons
        btRoll.setOnAction(new rollhandler());//wire the button for clickies
        dicetext.setOnKeyPressed(new rollhandlerKey());
        btRoll.setOnKeyPressed(new rollhandlerKey());//wire all the focusable things for to do an allowance of using the enter key
        Scene primscene = new Scene(wrapbois,menuSize,menuSizeTwo);
        primaryStage.setScene(primscene);//make the scene and set it to the menu window
        primaryStage.show();//show the menu window
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
    
    public int[] parseInput()
    {
        int[] ret = {0,0};
        
        return ret;
    }

    class rollhandler implements EventHandler<ActionEvent> {
        
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
                int[] dicedeets = {0,0};
                dicedeets = parseInput();
                numdice = dicedeets[0];
                numface = dicedeets[1];
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
                //may change this later to instead add an image of the die face corresponding with the number rolled to the scene
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
                new rollhandler().handle(new ActionEvent());
                //basically, if the key pressed was enter, do the stuff needed to roll dice like they've clicked the button
                //otherwise do NOT A DARN THING
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
