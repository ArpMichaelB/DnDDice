package com.glacier.util;

public enum TwentySided {
	ONE("C:/Users/Michael/Pictures/dice photos/1d20 1 waifu.png"),
	TWO("C:/Users/Michael/Pictures/dice photos/1d20 2 waifu.png"),
	THREE("C:/Users/Michael/Pictures/dice photos/1d20 3 waifu.png"),
	FOUR("C:/Users/Michael/Pictures/dice photos/1d20 4 waifu.png"),
	FIVE("C:/Users/Michael/Pictures/dice photos/1d20 5 waifu.png"),
	SIX("C:/Users/Michael/Pictures/dice photos/1d20 6 waifu.png"),
	SEVEN("C:/Users/Michael/Pictures/dice photos/1d20 7 waifu.png"),
	EIGHT("C:/Users/Michael/Pictures/dice photos/1d20 8 waifu.png"),
	NINE("C:/Users/Michael/Pictures/dice photos/1d20 9 waifu.png"),
	TEN("C:/Users/Michael/Pictures/dice photos/1d20 10 waifu.png"),
	ELEVEN("C:/Users/Michael/Pictures/dice photos/1d20 11 waifu.png"),
	TWELVE("C:/Users/Michael/Pictures/dice photos/1d20 12 waifu.png"),
	THIRTEEN("C:/Users/Michael/Pictures/dice photos/1d20 13 waifu.png"),
	FOURTEEN("C:/Users/Michael/Pictures/dice photos/1d20 14 waifu.png"),
	FIFTEEN("C:/Users/Michael/Pictures/dice photos/1d20 15 waifu.png"),
	SIXTEEN("C:/Users/Michael/Pictures/dice photos/1d20 16 waifu.png"),
	SEVENTEEN("C:/Users/Michael/Pictures/dice photos/1d20 17 waifu.png"),
	EIGHTEEN("C:/Users/Michael/Pictures/dice photos/1d20 18 waifu.png"),
	NINETEEN("C:/Users/Michael/Pictures/dice photos/1d20 19 waifu.png"),
	TWENTY("C:/Users/Michael/Pictures/dice photos/1d20 20 waifu.png");
	
	private String filename;
	
	TwentySided(String filename)
	{
		this.filename = filename;
	}
	
	@Override
	public String toString()
	{
		return filename;
	}
}
