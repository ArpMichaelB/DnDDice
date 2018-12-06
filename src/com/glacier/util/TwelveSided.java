package com.glacier.util;

public enum TwelveSided {
	ONE("C:/Users/Michael/Pictures/dice photos/1d12 1 waifu.png"),
	TWO("C:/Users/Michael/Pictures/dice photos/1d12 2 waifu.png"),
	THREE("C:/Users/Michael/Pictures/dice photos/1d12 3 waifu.png"),
	FOUR("C:/Users/Michael/Pictures/dice photos/1d12 4 waifu.png"),
	FIVE("C:/Users/Michael/Pictures/dice photos/1d12 5 waifu.png"),
	SIX("C:/Users/Michael/Pictures/dice photos/1d12 6 waifu.png"),
	SEVEN("C:/Users/Michael/Pictures/dice photos/1d12 7 waifu.png"),
	EIGHT("C:/Users/Michael/Pictures/dice photos/1d12 8 waifu.png"),
	NINE("C:/Users/Michael/Pictures/dice photos/1d12 9 waifu.png"),
	TEN("C:/Users/Michael/Pictures/dice photos/1d12 10 waifu.png"),
	ELEVEN("C:/Users/Michael/Pictures/dice photos/1d12 11 waifu.png"),
	TWELVE("C:/Users/Michael/Pictures/dice photos/1d12 12 waifu.png");
	
	private String filename;
	
	TwelveSided(String filename)
	{
		this.filename = filename;
	}
	
	@Override
	public String toString()
	{
		return filename;
	}
}
