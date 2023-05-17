package com.mohs10.ActionDriver;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.sym.Name;
import com.mohs10.base.StartBrowser;

public class dataMasking2 extends StartBrowser {
 
	public static void maskEmail(By locator, String email, String excelfile, String excelsheet, int columnIndex, int rowIndex) throws Exception {
	    // Load Excel file
	    FileInputStream file = new FileInputStream(excelfile);
	    Workbook workbook = WorkbookFactory.create(file);
	    Sheet sheet = workbook.getSheet(excelsheet);

	    // Find the row with the matching email address
	    Row targetRow = sheet.getRow(rowIndex);
	    if (targetRow != null) {
	        Cell emailCell = targetRow.getCell(columnIndex);

	        if (emailCell != null) {
	            String rowEmail = emailCell.getStringCellValue();
	            if (rowEmail.equals(email)) {
	                // Mask the email address
	                String[] emailParts = email.split("@");
	                String username = emailParts[0];
	                String domain = emailParts[1];
	                String maskedUsername = "";
	                for (int i = 0; i < username.length() - 1; i++) {
	                    maskedUsername += "*";
	                }
	                maskedUsername += username.charAt(username.length() - 1);
	                String maskedEmail = maskedUsername + "@" + domain;

	                // Pass the masked email to the field
	                System.out.println(maskedEmail);
	                WebElement ele = StartBrowser.driver.findElement(locator);
	                ele.sendKeys(maskedEmail);
	            }
	        }
	    }

	    file.close();
	}





	
	public static void maskPassword(By locator, String password, String excelfile, String excelsheet, int columnIndex, int rowIndex) throws Exception {
	    System.out.println("Inserted in block");
	    FileInputStream fi = new FileInputStream(excelfile);
	    Workbook wb = WorkbookFactory.create(fi);
	    Sheet ws = wb.getSheet(excelsheet);

	    // Find the row with the matching password
	    Row targetRow = ws.getRow(rowIndex);
	    if (targetRow != null) {
	        Cell passwordCell = targetRow.getCell(columnIndex);

	        if (passwordCell != null) {
	            String rowPassword = passwordCell.getStringCellValue();
	            if (rowPassword.equals(password)) {
	                // Mask the password
	                String maskedPassword = maskData(password);

	                // Pass the masked password to the field
	                System.out.println(maskedPassword);
	                WebElement ele = StartBrowser.driver.findElement(locator);
	                ele.sendKeys(maskedPassword);
	            }
	        }
	    }

	    System.out.println("Closed in block");
	    fi.close();
	}

	public static String maskData(String data) {
	    // Replace characters with asterisks
	    StringBuilder masked = new StringBuilder();
	    int length = data.length();
	    for (int j = 0; j < length; j++) {
	        masked.append("*");
	    }
	    return masked.toString();
	}

	public static void maskFirstName(By locator, String firstName, String excelfile, String excelsheet,int columnIndex, int rowIndex) throws Exception {
	    // Load Excel file
		 FileInputStream  fi = new FileInputStream(excelfile);
	     Workbook wb = WorkbookFactory.create(fi);
	    Sheet ws = wb.getSheet(excelsheet);

	    // Find the row with the matching first name
	    for (Row row : ws) {
	        Cell firstNameCell = row.getCell(0);
	        if (firstNameCell == null) {
	            continue;
	        }
	        String rowFirstName = firstNameCell.getStringCellValue();
	        if (rowFirstName.equals(firstName)) {
	            // Replace characters with asterisks except for the last character
	            String maskedFirstName = "";
	            int length = firstName.length();
	            for (int j = 0; j < length - 1; j++) {
	                maskedFirstName += "*";
	            }
	            maskedFirstName += firstName.charAt(length - 1);

	            // Pass the masked first name to the field
	            System.out.println(maskedFirstName);
	            WebElement ele = StartBrowser.driver.findElement(locator);
	            ele.sendKeys(maskedFirstName);
	            break;
	        }
	    }

	    fi.close();
	}
	public static void maskLastName(By locator, String lastName, String excelfile, String excelsheet,int columnIndex, int rowIndex) throws Exception {
	    // Load Excel file
		 FileInputStream  fi = new FileInputStream(excelfile);
	     Workbook wb = WorkbookFactory.create(fi);
	    Sheet ws = wb.getSheet(excelsheet);
	    // Find the row with the matching first name
	    for (Row row : ws) {
	        Cell lastNameCell = row.getCell(0);
	        if (lastNameCell == null) {
	            continue;
	        }
	        String rowFirstName = lastNameCell.getStringCellValue();
	        if (rowFirstName.equals(lastName)) {
	            // Replace characters with asterisks except for the last character
	            String maskedlastName = "";
	            int length = lastName.length();
	            for (int j = 0; j < length - 1; j++) {
	                maskedlastName += "*";
	            }
	            maskedlastName += lastName.charAt(length - 1);

	            // Pass the masked first name to the field
	            System.out.println(maskedlastName);
	            WebElement ele = StartBrowser.driver.findElement(locator);
	            ele.sendKeys(maskedlastName);
	            break;
	        }
	    }

	    fi.close();
	}

	public static void maskOccupation(By locator, String occoName, String excelfile, String excelsheet,int columnIndex, int rowIndex) throws Exception {
		 // Load Excel file
	    FileInputStream file = new FileInputStream(excelfile);
	    Workbook workbook = WorkbookFactory.create(file);
	    Sheet sheet = workbook.getSheet(excelsheet);

	    // Find the row with the matching first name
	    Row targetRow = sheet.getRow(rowIndex);
	    if (targetRow != null) {
	        Cell firstNameCell = targetRow.getCell(columnIndex);

	        if (firstNameCell != null) {
	            String rowFirstName = firstNameCell.getStringCellValue();
	            if (rowFirstName.equals(occoName)) {
	                // Replace characters with asterisks except for the last character
	                String maskedFirstName = "";
	                int length = occoName.length();
	                for (int j = 0; j < length - 1; j++) {
	                    maskedFirstName += "*";
	                }
	                maskedFirstName += occoName.charAt(length - 1);

	                // Pass the masked first name to the field
	                System.out.println(maskedFirstName);
	                WebElement ele = StartBrowser.driver.findElement(locator);
	                ele.sendKeys(maskedFirstName);
	            }
	        }
	    }

	    file.close();
	}
	public static void maskreligion(By locator, String Name, String excelfile, String excelsheet, int columnIndex, int rowIndex) throws Exception {
	    // Load Excel file
	    FileInputStream file = new FileInputStream(excelfile);
	    Workbook workbook = WorkbookFactory.create(file);
	    Sheet sheet = workbook.getSheet(excelsheet);

	    // Find the row with the matching first name
	    Row targetRow = sheet.getRow(rowIndex);
	    if (targetRow != null) {
	        Cell firstNameCell = targetRow.getCell(columnIndex);

	        if (firstNameCell != null) {
	            String rowFirstName = firstNameCell.getStringCellValue();
	            if (rowFirstName.equals(Name)) {
	                // Replace characters with asterisks except for the last character
	                String maskedFirstName = "";
	                int length = Name.length();
	                for (int j = 0; j < length - 1; j++) {
	                    maskedFirstName += "*";
	                }
	                maskedFirstName += Name.charAt(length - 1);

	                // Pass the masked first name to the field
	                System.out.println(maskedFirstName);
	                WebElement ele = StartBrowser.driver.findElement(locator);
	                ele.sendKeys(maskedFirstName);
	            }
	        }
	    }

	    file.close();
	}
	public static void maskMobileNumber(By locator, String mobile_number, String excelfile, String excelsheet,int columnIndex, int rowIndex) throws Exception {
	    // Load Excel file
	    FileInputStream file = new FileInputStream(excelfile);
	    Workbook workbook = WorkbookFactory.create(file);
	    Sheet sheet = workbook.getSheet(excelsheet);

	    // Find the row with the matching first name
	    for (Row row : sheet) {
	        Cell firstNameCell = row.getCell(0);
	        if (firstNameCell == null) {
	            continue;
	        }
	        String rowFirstName = firstNameCell.getStringCellValue();
	        if (rowFirstName.equals(mobile_number)) {
	            // Replace characters with asterisks except for the first two and last three characters
	            Cell mobileCell = row.getCell(1);
	            if (mobileCell == null) {
	                continue;
	            }
	            String mobileNumber = mobileCell.getStringCellValue();
	            if (mobileNumber.length() < 5) {
	                continue;
	            }
	            int length = mobileNumber.length();
	            String maskedMobileNumber = mobileNumber.substring(0, 2);
	            for (int j = 2; j < length - 3; j++) {
	                maskedMobileNumber += "*";
	            }
	            maskedMobileNumber += mobileNumber.substring(length - 3);

	            // Pass the masked mobile number to the field
	            System.out.println(maskedMobileNumber);
	            WebElement ele = StartBrowser.driver.findElement(locator);
	            ele.sendKeys(maskedMobileNumber);
	            break;
	        }
	    }

	    file.close();
	}

	

	public static void maskAge(By locator, String age, String excelfile, String excelsheet, int columnIndex, int rowIndex) throws Exception {
	    FileInputStream file = new FileInputStream(excelfile);
	    Workbook workbook = WorkbookFactory.create(file);
	    Sheet sheet = workbook.getSheet(excelsheet);

	    // Find the row with the matching age
	    Row targetRow = sheet.getRow(rowIndex);
	    if (targetRow != null) {
	        Cell ageCell = targetRow.getCell(columnIndex);

	        if (ageCell != null) {
	            String rowAge;
	            if (ageCell.getCellType() == CellType.STRING) {
	                rowAge = ageCell.getStringCellValue();
	            } else if (ageCell.getCellType() == CellType.NUMERIC) {
	                rowAge = String.valueOf((int) ageCell.getNumericCellValue());
	            } else {
	                throw new IllegalStateException("Invalid cell type for age");
	            }

	            if (rowAge.equals(age)) {
	                // Mask the age value
	                String maskedAge = "";
	                int length = age.length();
	                for (int j = 0; j < length - 1; j++) {
	                    maskedAge += "*";
	                }
	                maskedAge += age.charAt(length - 1);

	                // Pass the masked age to the field
	                System.out.println(maskedAge);
	                WebElement ele = StartBrowser.driver.findElement(locator);
	                ele.sendKeys(maskedAge);
	                file.close();
	            }
	        }
	    }
	            }
	        
	    

	  
	        
	

	
	public static void maskname(By locator, String Name, String excelfile, String excelsheet, int columnIndex, int rowIndex) throws Exception {
	    // Load Excel file
	    FileInputStream file = new FileInputStream(excelfile);
	    Workbook workbook = WorkbookFactory.create(file);
	    Sheet sheet = workbook.getSheet(excelsheet);

	    // Find the row with the matching first name
	    Row targetRow = sheet.getRow(rowIndex);
	    if (targetRow != null) {
	        Cell firstNameCell = targetRow.getCell(columnIndex);

	        if (firstNameCell != null) {
	            String rowFirstName = firstNameCell.getStringCellValue();
	            if (rowFirstName.equals(Name)) {
	                // Replace characters with asterisks except for the last character
	                String maskedFirstName = "";
	                int length = Name.length();
	                for (int j = 0; j < length - 1; j++) {
	                    maskedFirstName += "*";
	                }
	                maskedFirstName += Name.charAt(length - 1);

	                // Pass the masked first name to the field
	                System.out.println(maskedFirstName);
	                WebElement ele = StartBrowser.driver.findElement(locator);
	                ele.sendKeys(maskedFirstName);
	            }
	        }
	    }

	    file.close();
	}


	public static void maskexpectchar(By locator, String firstName, String excelfile, String excelsheet) throws Exception {
	    // Load Excel file
	    FileInputStream file = new FileInputStream(excelfile);
	    Workbook workbook = WorkbookFactory.create(file);
	    Sheet sheet = workbook.getSheet(excelsheet);

	    // Find the row with the matching first name
	    for (Row row : sheet) {
	        Cell firstNameCell = row.getCell(1);
	        if (firstNameCell == null) {
	            continue;
	        }
	        String rowFirstName = firstNameCell.getStringCellValue();
	        if (rowFirstName.equals(firstName)) {
	            // Replace characters with asterisks except for the first and last character
	            String maskedFirstName = firstName.charAt(0) + "";
	            int length = firstName.length();
	            for (int j = 1; j < length - 2; j++) {
	                maskedFirstName += "*";
	            }
	            maskedFirstName += firstName.charAt(length - 2);

	            // Pass the masked first name to the field
	            System.out.println(maskedFirstName);
	            WebElement ele = StartBrowser.driver.findElement(locator);
	            ele.sendKeys(maskedFirstName);
	            break;
	        }
	    }

	    file.close();
	}
	
}

	


