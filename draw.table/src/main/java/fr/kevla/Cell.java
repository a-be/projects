package fr.kevla;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cell {
	private Corner upLeft;
	private Corner upRight;
	private Corner downLeft;
	private Corner downRight;
	private String text;
	
	
	public Cell(Corner upLeft, Corner upRight, Corner downLeft,
			Corner downRight, String text) {
		super();
		this.upLeft = upLeft;
		this.upRight = upRight;
		this.downLeft = downLeft;
		this.downRight = downRight;
		this.text = text;
		
		Pattern datePatt = Pattern.compile("^([\\[\\]_\\-]{0,4})\\..+");
		Matcher m = datePatt.matcher(text);
		if (m.matches()) {
		  String style   = m.group(1);
		  if (style.contains("[")){
			  this.upLeft.addStyle(Corner.BOTTUM);
		  }else if (style.contains("]")){
			  
		  }else if (style.contains("-")){
			  
		  }else if (style.contains("_")){
			  
		  }
		 
		}
	}
	public Corner getUpLeft() {
		return upLeft;
	}
	public void setUpLeft(Corner upLeft) {
		this.upLeft = upLeft;
	}
	public Corner getUpRight() {
		return upRight;
	}
	public void setUpRight(Corner upRight) {
		this.upRight = upRight;
	}
	public Corner getDownLeft() {
		return downLeft;
	}
	public void setDownLeft(Corner downLeft) {
		this.downLeft = downLeft;
	}
	public Corner getDownRight() {
		return downRight;
	}
	public void setDownRight(Corner downRight) {
		this.downRight = downRight;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
