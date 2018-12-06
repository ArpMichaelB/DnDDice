package com.glacier.util;

public enum FourSided{
	//TODO: Change from absolute path to resource package path
	ONE_OPTION_ONE("C:/Users/Michael/Pictures/dice photos/1d4 1 option 1 waifu"), 
	ONE_OPTION_TWO("C:/Users/Michael/Pictures/dice photos/1d4 1 option 2 waifu"), 
	ONE_OPTION_THREE("C:/Users/Michael/Pictures/dice photos/1d4 1 option 3 waifu"), 
	TWO_OPTION_ONE("C:/Users/Michael/Pictures/dice photos/1d4 2 option 1 waifu"), 
	TWO_OPTION_TWO("C:/Users/Michael/Pictures/dice photos/1d4 2 option 2 waifu"), 
	TWO_OPTION_THREE("C:/Users/Michael/Pictures/dice photos/1d4 2 option 3 waifu"),
	THREE_OPTION_ONE("C:/Users/Michael/Pictures/dice photos/1d4 3 option 1 waifu"),
	THREE_OPTION_TWO("C:/Users/Michael/Pictures/dice photos/1d4 3 option 2 waifu"),
	THREE_OPTION_THREE("C:/Users/Michael/Pictures/dice photos/1d4 3 option 3 waifu"),
	FOUR_OPTION_ONE("C:/Users/Michael/Pictures/dice photos/1d4 4 option 1 waifu"),
	FOUR_OPTION_TWO("C:/Users/Michael/Pictures/dice photos/1d4 4 option 2 waifu"),
	FOUR_OPTION_THREE("C:/Users/Michael/Pictures/dice photos/1d4 4 option 3 waifu");
	
	private String filepath;
	
	FourSided()
	{
		this.filepath = "C:/Users/Michael/Pictures/dice photos/1d4 1 option 1 waifu";
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
