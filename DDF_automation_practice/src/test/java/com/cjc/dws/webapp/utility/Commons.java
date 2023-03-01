package com.cjc.dws.webapp.utility;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Appender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Commons {
        
	   public static WebDriver driver;
	   public static Logger log;
	   public static Layout l=new PatternLayout();
	   public static Appender ap;
	   public static FileInputStream fis;
	   public static HSSFWorkbook workbook;
	   public static HSSFSheet sheet;
	   public static HSSFRow row;
	   public static HSSFCell column;
	   public static Properties pro=new Properties();
	   
	   public static String fn_excel() throws IOException
	   {
		   fis=new FileInputStream("src//test//resources//excel//ddf.xls");
		   workbook=new HSSFWorkbook(fis);
		   sheet=workbook.getSheet("Sheet1");
		   row=sheet.getRow(1);
		   column=row.getCell(0);
		   String firstName=column.getStringCellValue();
		   return firstName;
	   }
	   
	   public static String ln_excel() throws IOException
	   {
		   fis=new FileInputStream("src//test//resources//excel//ddf.xls");
		   workbook=new HSSFWorkbook(fis);
		   sheet=workbook.getSheet("Sheet1");
		   row=sheet.getRow(1);
		   column=row.getCell(1);
		   String lastName=column.getStringCellValue();
		   return lastName;
	   }
	   
	   public static String email_excel() throws IOException
	   {
		   fis=new FileInputStream("src//test//resources//excel//ddf.xls");
		   workbook=new HSSFWorkbook(fis);
		   sheet=workbook.getSheet("Sheet1");
		   row=sheet.getRow(1);
		   column=row.getCell(2);
		   String email=column.getStringCellValue();
		   return email;
	   }
	   
	   public static String pw_excel() throws IOException
	   {
		   fis=new FileInputStream("src//test//resources//excel//ddf.xls");
		   workbook=new HSSFWorkbook(fis);
		   sheet=workbook.getSheet("Sheet1");
		   row=sheet.getRow(1);
		   column=row.getCell(3);
		   String pw=column.getStringCellValue();
		   return pw;
	   }
	   
	   public static String cpw_excel() throws IOException
	   {
		   fis=new FileInputStream("src//test//resources//excel//ddf.xls");
		   workbook=new HSSFWorkbook(fis);
		   sheet=workbook.getSheet("Sheet1");
		   row=sheet.getRow(1);
		   column=row.getCell(4);
		   String cpw=column.getStringCellValue();
		   return cpw;
	   }
}
