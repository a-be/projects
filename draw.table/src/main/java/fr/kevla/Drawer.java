package fr.kevla;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Strings;

public class Drawer {

	public static void main(String[] args) {

		//System.out.println("╔════════════════════╦══════════════════╗");

		new Drawer().dummyElements();

	}
	public void dummyElements() {
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
		elements =parseCorners("element 1,element 2,element 3,element 4;element 5,element 6,element 7,element 8;element 9,element 10,element 11,element 12");
		printElement(elements);
	}

	public List<List<Corner>>parseCorners(String text){
		List<List<Corner>> elements=new ArrayList<List<Corner>>();
		
		int cornersLength=0;
		String[] rows=text.split(";");
		int rowsLength=rows.length;
		for(int i=0,n=rowsLength;i<=n;i++){
			List<Corner> rowList=new ArrayList<Corner>();
			String[] corners=null;
			
			if(i<rowsLength){
				corners=rows[i].split("\\,");
				cornersLength=corners.length;
			}
			
			
			for(int j=0,m=cornersLength;j<=m;j++){
				String cornerName;
				if(i==rowsLength||j==cornersLength){
					cornerName="";
				}else{
					cornerName=corners[j];
				}
				
				Corner corner;
				
				if(i==0&&j==0){
					corner=new Corner(cornerName,Corner.CORNER_LEFT_UP);
				}else if(i==0&&j==cornersLength){
					corner=new Corner(cornerName,Corner.CORNER_RIGHT_UP);
				}else if(i==rowsLength&&j==0){
					corner=new Corner(cornerName,Corner.CORNER_LEFT_DOWN);
				}else if(i==rowsLength&&j==cornersLength){
					corner=new Corner(cornerName,Corner.CORNER_RIGHT_DOWND);
				}else if(i==0){
					corner=new Corner(cornerName,Corner.JOIN_UP);
				}else if(i==rowsLength){
					corner=new Corner(cornerName,Corner.JOIN_DOWN);
				}else if(j==0){
					corner=new Corner(cornerName,Corner.JOIN_LEFT);
				}else if(j==cornersLength){
					corner=new Corner(cornerName,Corner.JOIN_RIGHT);
				}else{
					corner=new Corner(cornerName,Corner.ALL);
				}
				rowList.add(corner);
			}
			elements.add(rowList);
			
		}
		return elements;
	}

	public void printElement(List<List<Corner>> elements) {
		StringBuilder table=new StringBuilder();
		for(int i=0,n=elements.size();i<n;i++){
			List<Corner> row=elements.get(i);
			StringBuilder top=new StringBuilder();
			StringBuilder middle=new StringBuilder();
			for(int j=0,m=row.size();j<m;j++){
				Corner element=row.get(j);
				top.append(getTop( element));
				middle.append(getMiddle( element));

			}
			table.append(top+"\n");
			table.append(middle+"\n");

		}
		System.out.println(table);
	}
	private String getTop(Corner element){

		StringBuilder top=new StringBuilder();
		top.append(TableChar.resolveJoinChar(element));
		top.append(TableChar.resolveTopChar(element));

		return top.toString();
	}

	private String getMiddle(Corner element){
		StringBuilder top=new StringBuilder();

		top.append(TableChar.resolveLeftChar(element));
		top.append(Strings.padEnd(element.getText(), 15, ' '));

		return top.toString();
	}


	public void run() {

		String csvFile = "/Users/mkyong/Downloads/GeoIPCountryWhois.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] country = line.split(cvsSplitBy);

				System.out.println("Country [code= " + country[4] 
						+ " , name=" + country[5] + "]");

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	}







}
