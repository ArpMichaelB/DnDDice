package com.glacier.util;

public enum HundredsPlace {
	ZERO("src/resources/1d100 00.png"),
	TEN("src/resources/1d100 10.png"),
	TWENTY("src/resources/1d100 20.png"),
	THIRTY("src/resources/1d100 30.png"),
	FORTY("src/resources/1d100 40.png"),
	FIFTY("src/resources/1d100 50.png"),
	SIXTY("src/resources/1d100 60.png"),
	SEVENTY("src/resources/1d100 70.png"),
	EIGHTY("src/resources/1d100 80.png"),
	NINETY("src/resources/1d100 90.png");
	
	String filename;
	
	HundredsPlace(String filename)
	{
		this.filename = filename;
	}
	
	@Override
	public String toString()
	{
		return filename;
	}
}
