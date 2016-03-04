package draw.table;

import java.util.ArrayList;
import java.util.List;

import fr.kevla.Corner;
import fr.kevla.Drawer;

public class TestDraw {
	public static void main(String[] args) {
		List<List<Corner>> elements=new ArrayList<List<Corner>>();
		List<Corner> row1=new ArrayList<Corner>();
		Corner e10=new Corner("element 1",Corner.CORNER_LEFT_UP_D);
		Corner e11=new Corner("element 2",Corner.JOIN_UP_D);
		Corner e12=new Corner("element 3",Corner.JOIN_UP_D);
		Corner e13=new Corner("",Corner.CORNER_RIGHT_UP_D);

		row1.add(e10);
		row1.add(e11);
		row1.add(e12);
		row1.add(e13);

		List<Corner> row2=new ArrayList<Corner>();
		Corner e20=new Corner("element 4",Corner.JOIN_LEFT_D);
		Corner e21=new Corner("element 5",Corner.BOTTUM|Corner.LEFT_D|Corner.TOP_D|Corner.RIGTH_D);
		Corner e22=new Corner("element 6",Corner.BOTTUM|Corner.LEFT_D|Corner.TOP_D|Corner.RIGTH_D);
		Corner e23=new Corner("",Corner.JOIN_RIGHT_D);
		row2.add(e20);
		row2.add(e21);
		row2.add(e22);
		row2.add(e23);

		List<Corner> row3=new ArrayList<Corner>();
		Corner e30=new Corner("element 7",Corner.BOTTUM_D|Corner.RIGTH|Corner.TOP_D);
		Corner e31=new Corner("element 8",Corner.ALL);
		Corner e32=new Corner("element 9",Corner.ALL);
		Corner e33=new Corner("",Corner.BOTTUM_D|Corner.LEFT|Corner.TOP_D);
		row3.add(e30);
		row3.add(e31);
		row3.add(e32);
		row3.add(e33);

		List<Corner> row0=new ArrayList<Corner>();
		Corner e00=new Corner("",Corner.CORNER_LEFT_DOWN_D);
		Corner e01=new Corner("",Corner.JOIN_DOWN_D);
		Corner e02=new Corner("",Corner.JOIN_DOWN_D);
		Corner e03=new Corner("",Corner.CORNER_RIGHT_DOWND_D);

		row0.add(e00);
		row0.add(e01);
		row0.add(e02);
		row0.add(e03);




		elements.add(row1);
		elements.add(row2);
		elements.add(row3);
		elements.add(row0);
		//elements =parseCorners("element 1,element 2,element 3,element 4;element 5,element 6,element 7,element 8;element 9,element 10,element 11,element 12");

		List<String> row1s=new ArrayList<String>();
		row1s.add("element 18888888888888888888888888888");
		row1s.add("element 2");
		row1s.add("element 3");
		List<String> row2s=new ArrayList<String>();
		row2s.add("element 12");
		row2s.add("element 22hhhhhhhh");
		row2s.add("");
		List<String> row3s=new ArrayList<String>();
		row3s.add("element 13");
		row3s.add("element 23");
		row3s.add("element 33mmmmmmmmmmmmmmmmmmmmm");


		List<List<String>> table=new ArrayList<List<String>>();
		table.add(row1s);
		table.add(row2s);
		table.add(row3s);
		Drawer drawer=new Drawer();
		drawer.printTable(table);
	}
}
