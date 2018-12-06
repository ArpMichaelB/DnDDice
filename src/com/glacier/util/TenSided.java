package com.glacier.util;

public enum TenSided {
	ONE("src/resources/1d10 1.png"),
	TWO("src/resources/1d10 2.png"),
	THREE("src/resources/1d10 3.png"),
	FOUR("src/resources/1d10 4.png"),
	FIVE("src/resources/1d10 5.png"),
	SIX("src/resources/1d10 6.png"),
	SEVEN("src/resources/1d10 7.png"),
	EIGHT("src/resources/1d10 8.png"),
	NINE("src/resources/1d10 9.png"),
	TEN("src/resources/1d10 10.png");
	
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
