package fr.kevla;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Strings;

public class Drawer {
	
	public void printTable(List<List<String>> table){
		List<List<Corner>> elements =parseCorners(table);
		adjustWidth(elements);
		printElement(elements);
	}
	private List<List<Corner>>parseCorners(String text){
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

	private List<List<Corner>>parseCorners(List<List<String>> table){
		List<List<Corner>> elements=new ArrayList<List<Corner>>();

		int cornersLength=0;
		int rowsLength=table.size();
		for(int i=0,n=rowsLength;i<=n;i++){
			List<Corner> rowList=new ArrayList<Corner>();


			if(i<rowsLength){
				cornersLength=table.get(i).size();
			}

			for(int j=0,m=cornersLength;j<=m;j++){
				String cornerName;
				if(i==rowsLength||j==cornersLength){
					cornerName="";
				}else{
					cornerName=table.get(i).get(j);
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

	private void adjustWidth(List<List<Corner>> table){
		List<Integer> widths=new ArrayList<Integer>();
		for(int i=0,n=table.size();i<n;i++){
			List<Corner> row =table.get(i);
			for(int j=0,m=row.size();j<m;j++){
				Corner corner=row.get(j);
				int cornerLength=corner.getText().length();
				if(j==widths.size()){
					widths.add(cornerLength);
				}else if (widths.get(j)<cornerLength){
					widths.set(j,cornerLength);
				}
			}
		}
		for(int i=0,n=table.size();i<n;i++){
			List<Corner> row =table.get(i);
			for(int j=0,m=row.size();j<m;j++){
				Corner corner=row.get(j);
				corner.setWidth(widths.get(j));
			}
		}
	}

	private void printElement(List<List<Corner>> elements) {
		
		for(int i=0,n=elements.size();i<n;i++){
			List<Corner> row=elements.get(i);
			StringBuilder table=new StringBuilder();
			StringBuilder top=new StringBuilder();
			StringBuilder middle=new StringBuilder();
			for(int j=0,m=row.size();j<m;j++){
				Corner element=row.get(j);
				top.append(getTop( element));
				middle.append(getMiddle( element));

			}
			table.append(top+"\n");
			table.append(middle);
			System.out.println(table);

		}
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
		top.append(Strings.padEnd(element.getText(), element.getWidth(), ' '));

		return top.toString();
	}

}
