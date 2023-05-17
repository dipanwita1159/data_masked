package com.mohs10.ActionDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.mohs10.base.StartBrowser;

public class dataEncrypt_Decrypt2 extends StartBrowser {
	

	

	

	    @Test
	    public static void encryptAndDecryptData(By locator, String excelFilePath, String excelsheet) throws IOException {
	        // Construct the path to the input Excel file
	        File inputFile = new File(excelFilePath);

	        // Open the input Excel file
	        FileInputStream fis = new FileInputStream(inputFile);

	        // Create a Workbook object
	        Workbook workbook = WorkbookFactory.create(fis);

	        // Get the sheet with the data to encrypt
	        Sheet sheet = workbook.getSheet(excelsheet);

	        // Loop through all the rows in the sheet (starting from the 2nd row)
	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            // Get the row
	            Row row = sheet.getRow(i);

	            // Get the cell in the data column
	            Cell cellToEncrypt = row.getCell(1);

	            // Check if the cell is not null and not empty
	            if (cellToEncrypt != null && !cellToEncrypt.getStringCellValue().isEmpty()) {
	                // Get the cell value
	                String dataToEncrypt = cellToEncrypt.getStringCellValue();

	                // Encode the data using URL-safe Base64 encoding
	                byte[] encodedBytes = Base64.getUrlEncoder().encode(dataToEncrypt.getBytes(StandardCharsets.UTF_8));
	                String encryptedData = new String(encodedBytes, StandardCharsets.UTF_8);

	                // Write the encrypted data back to the same row and the first column
	                Cell encryptedDataCell = row.createCell(0);
	                encryptedDataCell.setCellValue(encryptedData);

	                // Set the column header for the encrypted data
	                if (i == 1) {
	                    row.createCell(0).setCellValue("Encrypted Data");
	                }

	                System.out.println(encryptedData);
	            }
	        }

	        // Write the encrypted data to the same Excel file
	        FileOutputStream fos = new FileOutputStream(inputFile);
	        workbook.write(fos);
	        fos.close();

	        // Get the row with the specified index (1 in this case)
	        Row row = sheet.getRow(1);

	        // Get the encrypted data from the first row of the sheet
	        Cell encryptedDataCell = row.getCell(0);
	        String encryptedData = encryptedDataCell.getStringCellValue();

	        // Decode the encrypted data using URL-safe Base64 decoding
	       // byte[] decodedBytes = Base64.getUrlDecoder().decode(encryptedData);
	        byte[] decodedBytes = org.apache.commons.codec.binary.Base64.decodeBase64(encryptedData);

	        String decryptedData = new String(decodedBytes, StandardCharsets.UTF_8);

	        // Perform a sendKeys action on the specified WebElement with the decrypted data
	        WebElement element = driver.findElement(locator);
	        element.sendKeys(decryptedData);

	        System.out.println(decryptedData);
	    }
	}


