package fr.kevla;

import java.util.Hashtable;
import java.util.Map;

import com.google.common.base.Strings;

public class TableChar {


	private final String LIGHT_HORIZONTAL="─";
	private final String LIGHT_VERTICAL="│";
	private final String LIGHT_DOWN_RIGHT="┌";
	private final String LIGHT_DOWN_LEFT="┐";
	private final String LIGHT_UP_RIGHT="└";
	private final String LIGHT_UP_LEFT="┘";
	private final String LIGHT_VERTICAL_RIGHT="├";
	private final String LIGHT_VERTICAL_LEFT="┤";
	private final String LIGHT_DOWN_HORIZONTAL="┬";
	private final String LIGHT_UP_HORIZONTAL="┴";
	private final String LIGHT_VERTICAL_HORIZONTAL="┼";
	private final String DOUBLE_HORIZONTAL="═";
	private final String DOUBLE_VERTICAL="║";
	private final String DOWN_SINGLE_RIGHT_DOUBLE="╒";
	private final String DOWN_DOUBLE_RIGHT_SINGLE="╓";
	private final String DOUBLE_DOWN_RIGHT="╔";
	private final String DOWN_SINGLE_LEFT_DOUBLE="╕";
	private final String DOWN_DOUBLE_LEFT_SINGLE="╖";
	private final String DOUBLE_DOWN_LEFT="╗";
	private final String UP_SINGLE_RIGHT_DOUBLE="╘";
	private final String UP_DOUBLE_RIGHT_SINGLE="╙";
	private final String DOUBLE_UP_RIGHT="╚";
	private final String UP_SINGLE_LEFT_DOUBLE="╛";
	private final String UP_DOUBLE_LEFT_SINGLE="╜";
	private final String DOUBLE_UP_LEFT="╝";
	private final String VERTICAL_SINGLE_RIGHT_DOUBLE="╞";
	private final String VERTICAL_DOUBLE_RIGHT_SINGLE="╟";
	private final String DOUBLE_VERTICAL_RIGHT="╠";
	private final String VERTICAL_SINGLE_LEFT_DOUBLE="╡";
	private final String VERTICAL_DOUBLE_LEFT_SINGLE="╢";
	private final String DOUBLE_VERTICAL_LEFT="╣";
	private final String DOWN_SINGLE_HORIZONTAL_DOUBLE="╤";
	private final String DOWN_DOUBLE_HORIZONTAL_SINGLE="╥";
	private final String DOUBLE_DOWN_HORIZONTAL="╦";
	private final String UP_SINGLE_HORIZONTAL_DOUBLE="╧";
	private final String UP_DOUBLE_HORIZONTAL_SINGLE="╨";
	private final String DOUBLE_UP_HORIZONTAL="╩";
	private final String VERTICAL_SINGLE_HORIZONTAL_DOUBLE="╪";
	private final String VERTICAL_DOUBLE_HORIZONTAL_SINGLE="╫";
	private final String DOUBLE_VERTICAL_HORIZONTAL="╬";

	private Map<Integer,String> map;

	private  TableChar() {
		map=new Hashtable<Integer,String>();
		//Double
		map.put(Corner.RIGTH_D|Corner.BOTTUM_D,DOUBLE_DOWN_RIGHT);

		map.put(Corner.LEFT_D|Corner.BOTTUM_D,DOUBLE_DOWN_LEFT);

		map.put(Corner.RIGTH_D|Corner.TOP_D,DOUBLE_UP_RIGHT);

		map.put(Corner.LEFT_D|Corner.TOP_D,DOUBLE_UP_LEFT);

		map.put(Corner.RIGTH_D|Corner.LEFT_D|Corner.BOTTUM_D,DOUBLE_DOWN_HORIZONTAL);

		map.put(Corner.RIGTH_D|Corner.LEFT_D|Corner.TOP_D,DOUBLE_UP_HORIZONTAL);

		map.put(Corner.ALL_D,DOUBLE_VERTICAL_HORIZONTAL);
		
		map.put(Corner.RIGTH_D|Corner.LEFT_D|Corner.TOP_D|Corner.BOTTUM,DOUBLE_VERTICAL_HORIZONTAL);

		map.put(Corner.TOP_D|Corner.BOTTUM_D|Corner.RIGTH_D,DOUBLE_VERTICAL_RIGHT);

		map.put(Corner.TOP_D|Corner.BOTTUM_D|Corner.LEFT_D,DOUBLE_VERTICAL_LEFT);

		map.put(Corner.RIGTH_D|Corner.LEFT_D,DOUBLE_HORIZONTAL);

		map.put(Corner.TOP_D|Corner.BOTTUM_D,DOUBLE_VERTICAL);

		//Simple	
		map.put(Corner.RIGTH|Corner.BOTTUM,LIGHT_DOWN_RIGHT);

		map.put(Corner.LEFT|Corner.BOTTUM,LIGHT_DOWN_LEFT);

		map.put(Corner.RIGTH|Corner.TOP,LIGHT_UP_RIGHT);

		map.put(Corner.LEFT|Corner.TOP,LIGHT_UP_LEFT);

		map.put(Corner.RIGTH|Corner.LEFT|Corner.BOTTUM,LIGHT_DOWN_HORIZONTAL);

		map.put(Corner.RIGTH|Corner.LEFT|Corner.TOP,LIGHT_UP_HORIZONTAL);

		map.put(Corner.ALL,LIGHT_VERTICAL_HORIZONTAL);

		map.put(Corner.TOP|Corner.BOTTUM|Corner.RIGTH,LIGHT_VERTICAL_RIGHT);

		map.put(Corner.TOP|Corner.BOTTUM|Corner.LEFT,LIGHT_VERTICAL_LEFT);

		map.put(Corner.RIGTH|Corner.LEFT,LIGHT_HORIZONTAL);

		map.put(Corner.TOP|Corner.BOTTUM,LIGHT_VERTICAL);

		//Simple Double

		map.put(Corner.RIGTH_D|Corner.BOTTUM,DOWN_SINGLE_RIGHT_DOUBLE);

		map.put(Corner.LEFT_D|Corner.BOTTUM,DOWN_SINGLE_LEFT_DOUBLE);

		map.put(Corner.RIGTH_D|Corner.TOP,UP_SINGLE_RIGHT_DOUBLE);

		map.put(Corner.LEFT_D|Corner.TOP,UP_SINGLE_LEFT_DOUBLE);

		map.put(Corner.RIGTH|Corner.BOTTUM_D,DOWN_DOUBLE_RIGHT_SINGLE);

		map.put(Corner.LEFT|Corner.BOTTUM_D,DOWN_DOUBLE_LEFT_SINGLE);

		map.put(Corner.RIGTH|Corner.TOP_D,UP_DOUBLE_RIGHT_SINGLE);

		map.put(Corner.LEFT|Corner.TOP_D,UP_DOUBLE_LEFT_SINGLE);


		map.put(Corner.RIGTH_D|Corner.LEFT_D|Corner.BOTTUM,DOWN_SINGLE_HORIZONTAL_DOUBLE);

		map.put(Corner.RIGTH_D|Corner.LEFT_D|Corner.TOP,UP_SINGLE_HORIZONTAL_DOUBLE);

		map.put(Corner.RIGTH_D|Corner.LEFT_D|Corner.TOP|Corner.BOTTUM,VERTICAL_SINGLE_HORIZONTAL_DOUBLE);

		map.put(Corner.TOP_D|Corner.BOTTUM_D|Corner.RIGTH,VERTICAL_DOUBLE_RIGHT_SINGLE);

		map.put(Corner.TOP_D|Corner.BOTTUM_D|Corner.LEFT,VERTICAL_DOUBLE_LEFT_SINGLE);


		map.put(Corner.RIGTH|Corner.LEFT|Corner.BOTTUM_D,DOWN_DOUBLE_HORIZONTAL_SINGLE);

		map.put(Corner.RIGTH|Corner.LEFT|Corner.TOP_D,UP_DOUBLE_HORIZONTAL_SINGLE);

		map.put(Corner.RIGTH|Corner.LEFT|Corner.TOP_D|Corner.BOTTUM_D,VERTICAL_DOUBLE_HORIZONTAL_SINGLE);

		map.put(Corner.TOP|Corner.BOTTUM|Corner.RIGTH_D,VERTICAL_SINGLE_RIGHT_DOUBLE);

		map.put(Corner.TOP|Corner.BOTTUM|Corner.LEFT_D,VERTICAL_SINGLE_LEFT_DOUBLE);

	}

	private static TableChar instance=new TableChar();



	private  Map<Integer, String> getMap() {
		return map;
	}



	public static String resolveJoinChar(Corner corner) {
		if(instance.getMap().containsKey(corner.getStyle()))
			return instance.getMap().get(corner.getStyle());
		else return " ";
	}

	public static String resolveTopChar(Corner corner) {
		String topChar=" ";
		if(corner.checkStyle(Corner.RIGTH_D)){
			topChar= instance.DOUBLE_HORIZONTAL;
		}else if(corner.checkStyle(Corner.RIGTH)){
			topChar= instance.LIGHT_HORIZONTAL;
		}

		return Strings.repeat(topChar, 15);


	}
	public static String resolveLeftChar(Corner corner) {
		if(corner.checkStyle(Corner.BOTTUM_D)){
			return instance.DOUBLE_VERTICAL;
		}else if(corner.checkStyle(Corner.BOTTUM)){
			return instance.LIGHT_VERTICAL;
		}else{
			return " ";

		}
	}







}
