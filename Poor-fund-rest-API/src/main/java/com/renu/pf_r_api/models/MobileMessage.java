package com.renu.pf_r_api.models;

public class MobileMessage {
private String sourceNumber;
private String destinationNumber;
private String message;
public MobileMessage() {}
public String getSourceNumber() {
	return sourceNumber;
}
public void setSourceNumber(String sourceNumber) {
	this.sourceNumber = sourceNumber;
}
public String getDestinationNumber() {
	return destinationNumber;
}
public void setDestinationNumber(String destinationNumber) {
	this.destinationNumber = destinationNumber;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}




}
