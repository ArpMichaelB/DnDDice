package com.glacier.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Utility {
	public static int RESULTS_SIZE = 250;
    public static int RESULTS_SIZE_TWO = 400;//the size of the results screen
    public static int MENU_SIZE = 600;
    public static int MENU_SIZE_TWO = 105;//the size of the menu
    public static String ONE_LINE_PLACEHOLDER = "Only one line currently is in use, so keep that in mind, please";//a placeholder value for the rollhandlerKey, which I've made excessively verbose for safety
    public static String NEGATIVE_DICE_ERROR = "The user tried to roll negative dice at ";//What we show when the dice are negative, since that's a bad
    private static Random ran = new Random(System.nanoTime());
    private static int[] pictureDice = {4,6,8,10,12,20,100};
    /**
     * because I'm too lazy to type math.random and remember how to get what I want out of it
     * @param min the smallest number you want from the function
     * @param max the high end of the range of random numbers
     * @return random number from min to max.
     */
    public static int rand(int min, int max)
    {
        int r = ran.nextInt(max)+min;
        ran.setSeed(ran.nextLong());
        return r;
    }
    
    /**
     * Based upon the input the method has been handed, return how many dice to roll and how many sides they have
     * @param howManySides how many sides the dice have
     * @param howManyDice how many dice there are to roll
     * @return an array of two integers: the number of dice, and number of sides.
     */
    public static int[] parseMultiLineInput(String howManySides, String howManyDice) {
		int[] temp = {0,0};
		temp[0] = Integer.parseInt(howManyDice);
		temp[1] = Integer.parseInt(howManySides);
		return temp;
	}
    
    
    /**
     * Based upon what this method has been handed, return a set of 3 numbers
     * @return an array of three numbers: the number of dice, number of faces, and bonus. Bonus is 0 if not applicable.
     */
    public static int[] parseOneLineInput(String oneLineDiceText)
    {
        int[] ret = {0,0,0};
        String input = oneLineDiceText;
        String numberOfDice = "";
        String numberOfFaces = "";
        String bonus = "";
        if(!input.contains("d") && !input.contains("D"))
        {
        	throw new NumberFormatException("Error in One Line Dice Formatting at " + getCurrentTimestamp());
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
    
    /**
     * Gets the current timestamp for the purposes of logging errors.
     * @return the current time, in format mm/dd/yyyy hh:mm:ss
     */
    public static String getCurrentTimestamp()
    {
    	return DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(LocalDateTime.now());
    }
    
    /**
     * Sets the system.err output to a file, so if something new goes wrong, (i.e. the program crashes) the user can email me a log, and find out why!
     */
    public static void setupFileError()
    {
    	try {
    		String baseDrive = File.listRoots()[0].getPath();
			File logFolder = new File(baseDrive + "/Glacier Nester/logs/");
			File file = null;
			if (!logFolder.exists()) 
			{
				logFolder.setWritable(true);
				if (logFolder.mkdirs()) 
				{
					file = new File(logFolder.getAbsolutePath()+"/DiceErrors.log");
				}
			} 
			else 
			{
				file = new File(logFolder.getAbsolutePath()+"/DiceErrors.log");
			}
			FileOutputStream fos = new FileOutputStream(file);

			PrintStream ps = new PrintStream(fos);
			System.setErr(ps);
			System.err.println("Started DND Dice at "
					+ Utility.getCurrentTimestamp());
		}
    	catch (FileNotFoundException e)
    	{
    		System.err.println("File error in error log setup, yike");
			e.printStackTrace();
		}
    }
    /**
     * Sets the system.err output to a file, so if something new goes wrong, (i.e. the program crashes) the user can email me a log, and find out why!
     */
    public static void setupFileOut()
    {
    	try {
    		String baseDrive = File.listRoots()[0].getPath();
			File logFolder = new File(baseDrive + "/Glacier Nester/logs/");
			File file = null;
			if (!logFolder.exists()) 
			{
				logFolder.setWritable(true);
				if (logFolder.mkdirs()) 
				{
					file = new File(logFolder.getAbsolutePath()+"/Dice.log");
				}
			} 
			else 
			{
				file = new File(logFolder.getAbsolutePath()+"/Dice.log");
			}
			FileOutputStream fos = new FileOutputStream(file);

			PrintStream ps = new PrintStream(fos);
			System.setOut(ps);
			System.out.println("Started DND Dice at "
					+ Utility.getCurrentTimestamp());
		} catch (FileNotFoundException e)
    	{
			System.err.println("File error in output log setup, yike");
			e.printStackTrace();
		}
    }

	public static Scene getResult(int[] dicedeets,String oneLineDiceText) throws URISyntaxException{
		VBox imageHolder = new VBox();
		Text results = new Text("yoooo");
        ScrollPane scrolledBar = new ScrollPane();
        scrolledBar.setContent(imageHolder);
        scrolledBar.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrolledBar.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrolledBar.setMinHeight(Utility.RESULTS_SIZE_TWO);
        scrolledBar.setMinWidth(Utility.RESULTS_SIZE);
		String numberHolder = "You Rolled:\n";
        int numdice = dicedeets[0];
        int numface = dicedeets[1];
        int bonus = 0;
        if(dicedeets.length >2)
        {
        	bonus = dicedeets[2];
        }
        int total = 0;
        Arrays.sort(pictureDice);
        if(Arrays.binarySearch(pictureDice,numface) < 0)
        {
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
	        imageHolder.getChildren().add(results);
		}
        //if it's not a number with photos, just spit out the numbers straight up and down
        else if(numface == 4)
        {
        	for(int i = 0; i <numdice; i++)
	        {
        		ImageView imgV = new ImageView();
        		imgV.setFitWidth(100);
        		imgV.setFitHeight(100);
	            int temp = Utility.rand(1,numface);
	            //if option 1
	            if(Utility.rand(1,3) == 1)
	            {
	            	switch(temp)
	            	{
	            	case 1:
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.ONE_OPTION_ONE.toString()).toURI().toString()));
	            		break;
	            	case 2:
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.TWO_OPTION_ONE.toString()).toURI().toString()));
	            		break;
	            	case 3: 
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.THREE_OPTION_ONE.toString()).toURI().toString()));
	            		break;
	            	case 4:
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.FOUR_OPTION_ONE.toString()).toURI().toString()));
	            		break;
	            	}
	            }
	            //if option 2
	            else if(Utility.rand(1,3) == 2)
	            {
	            	switch(temp)
	            	{
	            	case 1:
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.ONE_OPTION_TWO.toString()).toURI().toString()));
	            		break;
	            	case 2:
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.TWO_OPTION_TWO.toString()).toURI().toString()));
	            		break;
	            	case 3: 
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.THREE_OPTION_TWO.toString()).toURI().toString()));
	            		break;
	            	case 4:
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.FOUR_OPTION_TWO.toString()).toURI().toString()));
	            		break;
	            	}
	            }
	            //if option 3
	            else if(Utility.rand(1,3) == 3)
	            {
	            	switch(temp)
	            	{
	            	case 1:
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.ONE_OPTION_THREE.toString()).toURI().toString()));
	            		break;
	            	case 2:
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.TWO_OPTION_THREE.toString()).toURI().toString()));
	            		break;
	            	case 3: 
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.THREE_OPTION_THREE.toString()).toURI().toString()));
	            		break;
	            	case 4:
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.FOUR_OPTION_THREE.toString()).toURI().toString()));
	            		break;
	            	}
	            }
	            else
	            {
	            	switch(temp)
	            	{
	            	case 1:
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.ONE_OPTION_ONE.toString()).toURI().toString()));
	            		break;
	            	case 2:
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.TWO_OPTION_ONE.toString()).toURI().toString()));
	            		break;
	            	case 3: 
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.THREE_OPTION_ONE.toString()).toURI().toString()));
	            		break;
	            	case 4:
	            		imgV.setImage(new Image(Object.class.getResource(FourSided.FOUR_OPTION_ONE.toString()).toURI().toString()));
	            		break;
	            	}
	            }
	            //for some reason this last option is necessary, i seem to have hecked up
	            //oh well, so it'll pick option one a bit more often, nbd
	            imageHolder.getChildren().add(imgV);
	            total+=temp;
	        }
        	if(oneLineDiceText.contains("-"))
	        {
	            total-=bonus;
	        }
	        else if(oneLineDiceText.contains("+"))
	        {
	            total+=bonus;
	        }
	        else
	        {
	        	//I know this is surpremely redundant
	        	//but I don't want that else if to be hanging
	        	total+=0;
	        }
        	results.setText("Your total is: " + total);
        	imageHolder.getChildren().add(results);
        }
        //if it's a d4, pick from one of three options for each roll 1-4 for the image
        else if(numface == 6)
        {
        	for(int i = 0; i <numdice; i++)
	        {
        		ImageView imgV = new ImageView();
        		imgV.setFitWidth(100);
        		imgV.setFitHeight(100);
	            int temp = Utility.rand(1,numface);
	            imgV.setImage(new Image(Object.class.getResource(SixSided.values()[temp-1].toString()).toURI().toString()));
	            imageHolder.getChildren().add(imgV);
	            total+=temp;
	        }
        	if(oneLineDiceText.contains("-"))
	        {
	            total-=bonus;
	        }
	        else if(oneLineDiceText.contains("+"))
	        {
	            total+=bonus;
	        }
	        else
	        {
	        	total+=0;
	        }
        	results.setText("Your total is: " + total);
        	imageHolder.getChildren().add(results);
        }
        else if(numface == 8)
        {
        	for(int i = 0; i <numdice; i++)
	        {
        		ImageView imgV = new ImageView();
        		imgV.setFitWidth(100);
        		imgV.setFitHeight(100);
	            int temp = Utility.rand(1,numface);
	            imgV.setImage(new Image(Object.class.getResource(EightSided.values()[temp-1].toString()).toURI().toString()));
	            imageHolder.getChildren().add(imgV);
	            total+=temp;
	        }
        	if(oneLineDiceText.contains("-"))
	        {
	            total-=bonus;
	        }
	        else if(oneLineDiceText.contains("+"))
	        {
	            total+=bonus;
	        }
	        else
	        {
	        	total+=0;
	        }
        	results.setText("Your total is: " + total);
        	imageHolder.getChildren().add(results);
        }
        else if(numface == 10)
        {
        	for(int i = 0; i <numdice; i++)
	        {
        		ImageView imgV = new ImageView();
        		imgV.setFitWidth(100);
        		imgV.setFitHeight(100);
	            int temp = Utility.rand(1,numface);
	            imgV.setImage(new Image(Object.class.getResource(TenSided.values()[temp-1].toString()).toURI().toString()));
	            imageHolder.getChildren().add(imgV);
	            total+=temp;
	        }
        	if(oneLineDiceText.contains("-"))
	        {
	            total-=bonus;
	        }
	        else if(oneLineDiceText.contains("+"))
	        {
	            total+=bonus;
	        }
	        else
	        {
	        	total+=0;
	        }
        	results.setText("Your total is: " + total);
        	imageHolder.getChildren().add(results);
        }
        else if(numface == 12)
        {
        	for(int i = 0; i <numdice; i++)
	        {
        		ImageView imgV = new ImageView();
        		imgV.setFitWidth(100);
        		imgV.setFitHeight(100);
	            int temp = Utility.rand(1,numface);
	            imgV.setImage(new Image(Object.class.getResource(TwelveSided.values()[temp-1].toString()).toURI().toString()));
	            imageHolder.getChildren().add(imgV);
	            total+=temp;
	        }
        	if(oneLineDiceText.contains("-"))
	        {
	            total-=bonus;
	        }
	        else if(oneLineDiceText.contains("+"))
	        {
	            total+=bonus;
	        }
	        else
	        {
	        	total+=0;
	        }
        	results.setText("Your total is: " + total);
        	imageHolder.getChildren().add(results);
        }
        else if(numface == 20)
        {
        	for(int i = 0; i <numdice; i++)
	        {
        		ImageView imgV = new ImageView();
        		imgV.setFitWidth(100);
        		imgV.setFitHeight(100);
	            int temp = Utility.rand(1,numface);
	            imgV.setImage(new Image(Object.class.getResource(TwentySided.values()[temp-1].toString()).toURI().toString()));
	            imageHolder.getChildren().add(imgV);
	            total+=temp;
	        }
        	if(oneLineDiceText.contains("-"))
	        {
	            total-=bonus;
	        }
	        else if(oneLineDiceText.contains("+"))
	        {
	            total+=bonus;
	        }
	        else
	        {
	        	total+=0;
	        }
        	results.setText("Your total is: " + total);
        	imageHolder.getChildren().add(results);
        }
        //if it's a d6, d8, d10, d12, or d20, show the corresponding image
        else if(numface == 100)
        {
        	for(int i = 0; i<numdice;i++)
        	{
        		HBox aech = new HBox();
        		ImageView imgV = new ImageView();
        		imgV.setFitWidth(100);
        		imgV.setFitHeight(100);
	            ImageView imgVTwo = new ImageView();
	            imgVTwo.setFitHeight(100);
	            imgVTwo.setFitWidth(100);
        		int temp = Utility.rand(1,numface);
        		if(temp == 100)
        		{
        			imgV.setImage(new Image(new File(HundredsPlace.ZERO.toString()).toURI().toString()));
        			imgVTwo.setImage(new Image(new File(TenSided.ONE.toString()).toURI().toString()));
        		}
        		else
        		{
		            //since we know integer division truncates, we can just divide temp by 10 to get the first half of the percentile
        			imgV.setImage(new Image(Object.class.getResource(HundredsPlace.values()[temp/10].toString()).toURI().toString()));
        			imgVTwo.setImage(new Image(Object.class.getResource(TenSided.values()[temp%10].toString()).toURI().toString()));
        		}
        		aech.getChildren().addAll(imgV,imgVTwo);
	            imageHolder.getChildren().add(aech);
        		total+=temp;
	            aech = new HBox();
	            imgV = new ImageView();
	            imgVTwo = new ImageView();
        	}
        	if(oneLineDiceText.contains("-"))
	        {
	            total-=bonus;
	        }
	        else if(oneLineDiceText.contains("+"))
	        {
	            total+=bonus;
	        }
	        else
	        {
	        	total+=0;
	        }
        	imageHolder.getChildren().add(new Text("Your total is: " + total));
        }
        //if it's a d100, show the two corresponding d10s
        return new Scene(scrolledBar,Utility.RESULTS_SIZE,Utility.RESULTS_SIZE_TWO);
	}
}
