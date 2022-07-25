package com.payroll.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel 
{
	public static FileInputStream f;
	public static XSSFWorkbook w;
	public static XSSFSheet s;
	
	public static String readStringData(int i,int j,String sheetname) throws IOException
	{
		f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		//f=new FileInputStream(path);

		w=new XSSFWorkbook(f);
		s=w.getSheet(sheetname);
		Row r=s.getRow(i);
		Cell c=r.getCell(j);
		
		return c.getStringCellValue();
	}
	public static int readIntegerData(int i,int j,String sheetname,String path) throws IOException
	{
		f=new FileInputStream(path);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheetname);
		Row r=s.getRow(i);
		Cell c=r.getCell(j);
		int a=(int) c.getNumericCellValue();
		
		return a;
	}
}
