package edu.orangecoastcollege.cs272.ic14.model;

public class Position {
	public static final String CASHIER = "CASHIER";
	public static final String JANITOR = "JANITOR";
	public static final String ASSISTANT = "ASSISTANT";
	public Position() {};
	public String[] getPosition() 
	{
		String[] p = {CASHIER, JANITOR, ASSISTANT};
		return p;
	
	};

}
