package com.glacier.util;

public enum EightSided {

	ONE("C:/Users/Michael/Pictures/dice photos/1d8 1 waifu.png"),
	TWO("C:/Users/Michael/Pictures/dice photos/1d8 2 waifu.png"),
	THREE("C:/Users/Michael/Pictures/dice photos/1d8 3 waifu.png"),
	FOUR("C:/Users/Michael/Pictures/dice photos/1d8 4 waifu.png"),
	FIVE("C:/Users/Michael/Pictures/dice photos/1d8 5 waifu.png"),
	SIX("C:/Users/Michael/Pictures/dice photos/1d8 6 waifu.png"),
	SEVEN("C:/Users/Michael/Pictures/dice photos/1d8 7 waifu.png"),
	EIGHT("C:/Users/Michael/Pictures/dice photos/1d8 8 waifu.png");
	
	private String filename;
	
	EightSided(String filename)
	{
		this.filename = filename;
	}
	
	@Override
	public String toString()
	{
		return filename;
	}
	
}
