package com.glacier.util;

public enum FourSided{
	//TODO: Change from absolute path to resource package path
	ONE_OPTION_ONE("src/resources/1d4 1 option 1.png"),
	ONE_OPTION_TWO("src/resources/1d4 1 option 2.png"), 
	ONE_OPTION_THREE("src/resources/1d4 1 option 3.png"), 
	TWO_OPTION_ONE("src/resources/1d4 2 option 1.png"), 
	TWO_OPTION_TWO("src/resources/1d4 2 option 2.png"), 
	TWO_OPTION_THREE("src/resources/1d4 2 option 3.png"),
	THREE_OPTION_ONE("src/resources/1d4 3 option 1.png"),
	THREE_OPTION_TWO("src/resources/1d4 3 option 2.png"),
	THREE_OPTION_THREE("src/resources/1d4 3 option 3.png"),
	FOUR_OPTION_ONE("src/resources/1d4 4 option 1.png"),
	FOUR_OPTION_TWO("src/resources/1d4 4 option 2.png"),
	FOUR_OPTION_THREE("src/resources/1d4 4 option 3.png");
	
	private String filepath;
	
	FourSided()
	{
		this.filepath = "src/resources/1d4 1 option 1";
	}
	
	FourSided(String filepath)
	{
		this.filepath = filepath;
	}
	
	@Override
	public String toString()
	{
		return filepath;
	}
}
