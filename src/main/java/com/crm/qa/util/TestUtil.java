package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static Workbook book;
	public static Sheet sheet;
	public static String TEST_DATA_SHEET_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\excel\\FreeCRMTestData.xlsx";
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
public static Object [][] getTestData(String sheetName){
		
		
		FileInputStream fis = null;
		 try {
			fis = new FileInputStream(TEST_DATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		 try {
				book = WorkbookFactory.create(fis);
		 }catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (EncryptedDocumentException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			Object [][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i = 0 ; i<sheet.getLastRowNum();i++){
				for(int k = 0 ; k<sheet.getRow(0).getLastCellNum(); k++){
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				}
			}
			return data;
		
	}
         
public static void takeScreenShotAtEndOfTest() throws IOException {
	       File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"/screnShots/" + System.currentTimeMillis()+ ".png"));
}



	
}
