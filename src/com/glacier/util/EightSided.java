package com.glacier.util;

public enum EightSided {

	ONE("src/resources/1d8 1.png"),
	TWO("src/resources/1d8 2.png"),
	THREE("src/resources/1d8 3.png"),
	FOUR("src/resources/1d8 4.png"),
	FIVE("src/resources/1d8 5.png"),
	SIX("src/resources/1d8 6.png"),
	SEVEN("src/resources/1d8 7.png"),
	EIGHT("src/resources/1d8 8.png");
	
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
