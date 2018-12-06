package com.glacier.util;

public enum HundredsPlace {
	ZERO("C:/Users/Michael/Pictures/dice photos/1d100 00 waifu.png"),
	TEN("C:/Users/Michael/Pictures/dice photos/1d100 10 waifu.png"),
	TWENTY("C:/Users/Michael/Pictures/dice photos/1d100 20 waifu.png"),
	THIRTY("C:/Users/Michael/Pictures/dice photos/1d100 30 waifu.png"),
	FORTY("C:/Users/Michael/Pictures/dice photos/1d100 40 waifu.png"),
	FIFTY("C:/Users/Michael/Pictures/dice photos/1d100 50 waifu.png"),
	SIXTY("C:/Users/Michael/Pictures/dice photos/1d100 60 waifu.png"),
	SEVENTY("C:/Users/Michael/Pictures/dice photos/1d100 70 waifu.png"),
	EIGHTY("C:/Users/Michael/Pictures/dice photos/1d100 80 waifu.png"),
	NINETY("C:/Users/Michael/Pictures/dice photos/1d100 90 waifu.png");
	
	String filename;
	
	HundredsPlace(String filename)
	{
		this.filename = filename;
	}
	
	@Override
	public String toString()
	{
		return filename;
	}
}
