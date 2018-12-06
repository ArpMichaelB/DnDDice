package com.glacier.util;

public enum SixSided {
	ONE("src/resources/1d6 1.png"),
	TWO("src/resources/1d6 2.png"),
	THREE("src/resources/1d6 3.png"),
	FOUR("src/resources/1d6 4.png"),
	FIVE("src/resources/1d6 5.png"),
	SIX("src/resources/1d6 6.png");
	
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
