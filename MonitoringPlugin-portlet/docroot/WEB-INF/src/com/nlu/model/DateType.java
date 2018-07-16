package com.nlu.model;


public enum DateType {
	TODAY ("today"),
	ONE_DATE_AGO ("one-date-ago"),
	TWO_DATE_AGO ("three-date-ago"),
	THREE_DATE_AGO ("three-date-ago"), 
	FOUR_DATE_AGO ("four-date-ago"),
	FIVE_DATE_AGO ("five-date-ago"),
	SIX_DATE_AGO ("six-date-ago");
	String value;
	DateType(String date){
		this.value=date;
	}
	public String getValue(){
		return value;
	}

}
