package com.mohs10.ActionDriver;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import com.mohs10.base.StartBrowser;



public class dataEncryptDecrypt extends StartBrowser{
	
	/*
	 * public static WebDriver driver; public void beforeClass() { //
	 * WebDriverManager.chromedriver().setup(); // ChromeOptions options = new
	 * ChromeOptions(); // options.
	 * setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"
	 * ); WebDriverManager.firefoxdriver().setup(); //
	 * WebDriverManager.edgedriver().setup(); // driver = new ChromeDriver(options);
	 * driver= new FirefoxDriver(); //driver= new EdgeDriver();
	 * 
	 * driver.manage().window().maximize(); }
	 */
	@Test
	public  static String encryptData( String excelFilePath,String excelsheet) throws IOException {
        // Construct the path to the input Excel file
        File inputFile = new File(excelFilePath);

        // Open the input Excel file
        FileInputStream fis = new FileInputStream(inputFile);

        // Create a Workbook object
        Workbook workbook = WorkbookFactory.create(fis);

        // Get the sheet with the data to encrypt
        Sheet sheet = workbook.getSheet(excelsheet);

        // Loop through all the rows in the sheet
        for (Row row : sheet) {
            // Get the cell in the data column
            Cell cellToEncrypt = row.getCell(0);

            // Check if the cell is not null and not empty
            if (cellToEncrypt != null && !cellToEncrypt.getStringCellValue().isEmpty()) {
                // Get the cell value
                String dataToEncrypt = cellToEncrypt.getStringCellValue();
                System.out.print(dataToEncrypt);

                // Encode the data using URL-safe Base64 encoding
                byte[] encodedBytes = Base64.getUrlEncoder().encode(dataToEncrypt.getBytes(StandardCharsets.UTF_8));
                String encryptedData = new String(encodedBytes, StandardCharsets.UTF_8);

                // Write the encrypted data back to the same cell
               cellToEncrypt.setCellValue(encryptedData);

                // Set the column header for the encrypted data
                if (row.getRowNum() == 0) {
                    sheet.getRow(0).createCell(0).setCellValue("Encrypted Data");
                }
                //WebElement ele =driver.findElement(locator);
                //ele.sendKeys(encryptedData);
                System.out.println(encryptedData);
            }
        }
		return excelsheet;
 }
@Test
public static  String getDecryptedPassword( By locator,String excelFilePath,String excelsheet ) throws IOException {
    // Construct the path to the input Excel file
    File inputFile = new File(excelFilePath);

    // Open the input Excel file
    FileInputStream fis = new FileInputStream(inputFile);

    // Create a Workbook object
    Workbook workbook = WorkbookFactory.create(fis);

    // Get the sheet with the user credentials
    Sheet sheet = workbook.getSheet(excelsheet);

    // Get the row with the specified index
    Row row = sheet.getRow(1);

    // Get the encrypted password from the row
  // Cell userIdCell = row.getCell(0);
    //String userId = userIdCell.getStringCellValue();
    Cell encryptedPasswordCell = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

    // Check if the cell is not null and not empty
    if (encryptedPasswordCell != null && !encryptedPasswordCell.getStringCellValue().isEmpty()) {
        // Get the encrypted password
        String encryptedData = encryptedPasswordCell.getStringCellValue();

        // Decode the encrypted password using URL-safe Base64 decoding
       byte[] decodedBytes = org.apache.commons.codec.binary.Base64.decodeBase64(encryptedData);

        //byte[] decodedBytes = Base64.getUrlDecoder().decode(encryptedData);
        String decryptedPassword = new String(decodedBytes, StandardCharsets.UTF_8);

            

    WebElement ele =driver.findElement(locator);
    ele.sendKeys(decryptedPassword);
    System.out.println(decryptedPassword);
    }
    return excelsheet;
}
		
		}
            
        

        
    
