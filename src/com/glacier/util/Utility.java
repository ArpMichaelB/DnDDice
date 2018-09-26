package com.glacier.util;

public class Utility {
	public static int RESULTS_SIZE = 250;
    public static int RESULTS_SIZE_TWO = 400;//the size of the results screen
    public static int MENU_SIZE = 600;
    public static int MENU_SIZE_TWO = 105;//the size of the menu
    public static String ONE_LINE_PLACEHOLDER = "Only one line currently is in use, so keep that in mind, please";//a placeholder value for the rollhandlerKey, which I've made excessively verbose for safety
    
    /**
     * because I'm too lazy to type math.random and remember how to get what I want out of it
     * @param min the smallest number you want from the function
     * @param max the high end of the range of random numbers
     * @return random number from min to max.
     */
    public static int rand(int min, int max)
    {
        int r = (int) (Math.random()*max+min);
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
}
