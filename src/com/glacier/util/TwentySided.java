package com.glacier.util;

public enum TwentySided {
	ONE("src/resources/1d20 1.png"),
	TWO("src/resources/1d20 2.png"),
	THREE("src/resources/1d20 3.png"),
	FOUR("src/resources/1d20 4.png"),
	FIVE("src/resources/1d20 5.png"),
	SIX("src/resources/1d20 6.png"),
	SEVEN("src/resources/1d20 7.png"),
	EIGHT("src/resources/1d20 8.png"),
	NINE("src/resources/1d20 9.png"),
	TEN("src/resources/1d20 10.png"),
	ELEVEN("src/resources/1d20 11.png"),
	TWELVE("src/resources/1d20 12.png"),
	THIRTEEN("src/resources/1d20 13.png"),
	FOURTEEN("src/resources/1d20 14.png"),
	FIFTEEN("src/resources/1d20 15.png"),
	SIXTEEN("src/resources/1d20 16.png"),
	SEVENTEEN("src/resources/1d20 17.png"),
	EIGHTEEN("src/resources/1d20 18.png"),
	NINETEEN("src/resources/1d20 19.png"),
	TWENTY("src/resources/1d20 20.png");
	
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
