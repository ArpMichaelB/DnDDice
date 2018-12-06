package com.glacier.util;

public enum TwelveSided {
	ONE("src/resources/1d12 1.png"),
	TWO("src/resources/1d12 2.png"),
	THREE("src/resources/1d12 3.png"),
	FOUR("src/resources/1d12 4.png"),
	FIVE("src/resources/1d12 5.png"),
	SIX("src/resources/1d12 6.png"),
	SEVEN("src/resources/1d12 7.png"),
	EIGHT("src/resources/1d12 8.png"),
	NINE("src/resources/1d12 9.png"),
	TEN("src/resources/1d12 10.png"),
	ELEVEN("src/resources/1d12 11.png"),
	TWELVE("src/resources/1d12 12.png");
	
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
