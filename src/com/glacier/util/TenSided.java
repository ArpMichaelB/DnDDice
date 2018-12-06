package com.glacier.util;

public enum TenSided {
	ONE("C:/Users/Michael/Pictures/dice photos/1d10 1 waifu.png"),
	TWO("C:/Users/Michael/Pictures/dice photos/1d10 2 waifu.png"),
	THREE("C:/Users/Michael/Pictures/dice photos/1d10 3 waifu.png"),
	FOUR("C:/Users/Michael/Pictures/dice photos/1d10 4 waifu.png"),
	FIVE("C:/Users/Michael/Pictures/dice photos/1d10 5 waifu.png"),
	SIX("C:/Users/Michael/Pictures/dice photos/1d10 6 waifu.png"),
	SEVEN("C:/Users/Michael/Pictures/dice photos/1d10 7 waifu.png"),
	EIGHT("C:/Users/Michael/Pictures/dice photos/1d10 8 waifu.png"),
	NINE("C:/Users/Michael/Pictures/dice photos/1d10 9 waifu.png"),
	TEN("C:/Users/Michael/Pictures/dice photos/1d10 10 waifu.png");
	
	private String filename;
	
	TenSided(String filename)
	{
		this.filename = filename;
	}
	
	@Override
	public String toString()
	{
		return filename;
	}
}
