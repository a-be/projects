package fr.kevla;


public class Corner {

	public static  final int LEFT=0b00000001;
	public static  final int RIGTH=0b00000010;
	public static  final int TOP=0b00000100;
	public static  final int BOTTUM=0b00001000;
	
	public static  final int LEFT_D=0b00010000;
	public static  final int RIGTH_D=0b00100000;
	public static  final int TOP_D=0b01000000;
	public static  final int BOTTUM_D=0b10000000;
	
	public static  final int ALL=0b00001111;
	public static  final int ALL_D=0b11110000;
	
	
	public static  final int CORNER_LEFT_UP_D=Corner.RIGTH_D|Corner.BOTTUM_D;
	public static  final int CORNER_RIGHT_UP_D=Corner.BOTTUM_D|Corner.LEFT_D;
	public static  final int CORNER_LEFT_DOWN_D=Corner.TOP_D|Corner.RIGTH_D;
	public static  final int CORNER_RIGHT_DOWND_D=Corner.LEFT_D|Corner.TOP_D;
	
	public static  final int CORNER_LEFT_UP=Corner.RIGTH|Corner.BOTTUM;
	public static  final int CORNER_RIGHT_UP=Corner.BOTTUM|Corner.LEFT;
	public static  final int CORNER_LEFT_DOWN=Corner.TOP|Corner.RIGTH;
	public static  final int CORNER_RIGHT_DOWND=Corner.LEFT|Corner.TOP;
	
	public static  final int JOIN_UP_D=Corner.BOTTUM_D|Corner.RIGTH_D|Corner.LEFT_D;
	public static  final int JOIN_DOWN_D=Corner.TOP|Corner.RIGTH_D|Corner.LEFT_D;
	public static  final int JOIN_LEFT_D=Corner.BOTTUM_D|Corner.RIGTH_D|Corner.TOP_D;
	public static  final int JOIN_RIGHT_D=Corner.BOTTUM_D|Corner.LEFT_D|Corner.TOP_D;
	
	public static  final int JOIN_UP=Corner.BOTTUM|Corner.RIGTH|Corner.LEFT;
	public static  final int JOIN_DOWN=Corner.TOP|Corner.RIGTH|Corner.LEFT;
	public static  final int JOIN_LEFT=Corner.BOTTUM|Corner.RIGTH|Corner.TOP;
	public static  final int JOIN_RIGHT=Corner.BOTTUM|Corner.LEFT|Corner.TOP;
	
	public static  final int IGNORE=0;



	private String text;
	private int style;
	
	private int width;
	
	
	

	public Corner(String text, int style) {
		super();
		this.text = text;
		this.style = style;
	}
	
	
	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getStyle() {
		return style;
	}
	public void setStyle(int style) {
		this.style = style;
	}
	
	public void addStyle(int style) {
		this.style |= style;
	}
	
	

	public  boolean checkStyle(int style){
		return (this.getStyle()&style)==style;
	}
	
	

}
