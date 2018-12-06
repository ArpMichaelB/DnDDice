package com.glacier.util;

public enum SixSided {
	ONE("C:/Users/Michael/Pictures/dice photos/1d6 1 waifu.png"),
	TWO("C:/Users/Michael/Pictures/dice photos/1d6 2 waifu.png"),
	THREE("C:/Users/Michael/Pictures/dice photos/1d6 3 waifu.png"),
	FOUR("C:/Users/Michael/Pictures/dice photos/1d6 4 waifu.png"),
	FIVE("C:/Users/Michael/Pictures/dice photos/1d6 5 waifu.png"),
	SIX("C:/Users/Michael/Pictures/dice photos/1d6 6 waifu.png");
	
	private String filename;
	
	SixSided(String filename)
	{
		this.filename = filename;
	}
	
	@Override
	public String toString()
	{
		return filename;
	}
}
