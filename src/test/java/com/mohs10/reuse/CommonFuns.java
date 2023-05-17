package com.mohs10.reuse;
	

import org.openqa.selenium.WebDriver;


import com.mohs10.base.StartBrowser;
import com.mohs10.ActionDriver.Action;
import com.mohs10.ActionDriver.dataEncryptDecrypt;
import com.mohs10.ActionDriver.dataMasking2;

import com.mohs10.or.HomePage;

	public class CommonFuns extends Action {
		dataEncryptDecrypt data =new dataEncryptDecrypt();
		
		public static Action aDriver;
		public WebDriver driver;
		
		public CommonFuns()
		{
			aDriver = new Action();
			driver = StartBrowser.driver;
		}
		
			  
				
              
			 
		/*
		 * public void datePicker(String url,String value1,String value2) throws
		 * Exception {
		 * StartBrowser.childTest=StartBrowser.parentTest.createNode("login");
		 * aDriver.navigateToApplication(url); Thread.sleep(2000); JavascriptExecutor
		 * je=(JavascriptExecutor)driver;//Instance of js executor
		 * je.executeScript("window.scroll(0,600)\r\n");
		 * aDriver.selectDropDown(HomePage.datepick,"value", value2);
		 * 
		 * 
		 * }
		 */
		public void dataEncrypt_decrypt(String Userid) throws Exception{
			
				StartBrowser.childTest=StartBrowser.parentTest.createNode("login");
				
				aDriver.navigateToApplication("http://database-env.eba-g23r6gbb.ap-south-1.elasticbeanstalk.com/login");
				aDriver.type(HomePage.loginemail, Userid,"user id enterd");
				//aDriver.type(HomePage.loginpwd,Pwd, "password entered");
				//dataEncryptDecrypt.getDecryptedPassword(HomePage.loginpwd,  Password);
				
				//dataEncryptDecrypt.encryptData( HomePage.loginpwd,Userid, Password);
				//aDriver.type(HomePage.loginpwd, Userid, data2);
				aDriver.click(HomePage.clickLoginButton, "lohin button clicked");
				
				
				
			
		}
		
		  public void getmaskedData(String userid, String pwd, String name,String rel,String occ,String pName,String excelfile,String excelsheet) throws Exception {
		  StartBrowser.childTest=StartBrowser.parentTest.createNode("maked data");
		  System.out.println("hi");
		  aDriver.navigateToApplication("http://database-env.eba-g23r6gbb.ap-south-1.elasticbeanstalk.com/login");
		// datamasking.test( HomePage.loginemail,excelfile,excelsheet);
		// datamasking.test(HomePage.loginpwd, excelfile, excelsheet);
		 aDriver.type(HomePage.loginid, userid, "excelsheet");
		
		// dataMasking2.maskEmail(HomePage.loginid, userid,excelfile, excelsheet, 0,1);
		// dataMasking2.maskPassword(HomePage.pwd, pwd, excelfile, excelsheet,1,1);
		 aDriver.type(HomePage.pwd, pwd, "excelsheet");
		
		 aDriver.click(HomePage.LoginButton, "button for login clicked");
		 aDriver.click(HomePage.gyno,"Gynology buton clicked");
		dataMasking2.maskname(HomePage.Name, name, excelfile, excelsheet, 7,1);
			
			dataMasking2.maskname(HomePage.phcName, pName, excelfile, excelsheet, 6,1);
		
		 dataMasking2.maskOccupation(HomePage.Occupation, occ, excelfile, excelsheet,2,1);
		  dataMasking2.maskreligion(HomePage.Relegion, rel, excelfile, excelsheet, 3, 1);
		  }
		  
		  public void credential_joysta(String distict, String education, String country,String pEdu,String pName,String family,String earningmem) throws Exception {
			  StartBrowser.childTest=StartBrowser.parentTest.createNode("maked data");
			 
			  
		  
		  
		  aDriver.type(HomePage.distict, distict,"excelfile");
		  aDriver.type(HomePage.education,education,"enter data on eucation");
		  aDriver.type(HomePage.country, country,"enter country name" );
		  aDriver.type(HomePage.P_Education, pEdu, "enter patner education");
		  aDriver.type(HomePage.p_name, pName, "enter patner Name");
		  aDriver.type(HomePage.fmem, family,"enter family member");
		  aDriver.type(HomePage.e_mem, earningmem, " enter earning member");
		 // dataMasking2.maskAge(HomePage.age, age, excelfile, excelsheet, 5, 1);
		 // dataMasking2.maskMobileNumber(HomePage.contactnumber, contact, excelfile,excelsheet);
		 
			 
						 
		  Thread.sleep(5000);
		  
		  
		  }
		  public void credential_joystna2(String city, String education, String country,String pEdu,String pName,String family,String earningmem) throws Exception {
			  StartBrowser.childTest=StartBrowser.parentTest.createNode("maked data");
			 
			  
		  
		  
		  aDriver.type(HomePage.city, city,"enter city name");
		  aDriver.type(HomePage.education,education,"enter data on eucation");
		  aDriver.type(HomePage.country, country,"enter country name" );
		  aDriver.type(HomePage.P_Education, pEdu, "enter patner education");
		  aDriver.type(HomePage.p_name, pName, "enter patner Name");
		 // aDriver.selectDropDown(HomePage.fmem, "clicked on f mwm",family);
		 // aDriver.type(HomePage.fmem, family,"enter family member");
		 // aDriver.click(HomePage.e_mem, "clicked on earning member");
		 // aDriver.selectDropDown(HomePage.e_mem, earningmem, " enter earning member");
		  Thread.sleep(5000);
		  }
		  public void credential_joystna3(String dist, String state, String age,String contact,String excelfile,String excelsheet) throws Exception {
			  StartBrowser.childTest=StartBrowser.parentTest.createNode("maked data");
			  aDriver.type(HomePage.distict, dist,"enter distict name");
			  aDriver.type(HomePage.state,state,"enter state");
			  //dataMasking2.maskAge(HomePage.age, age,"enter age", age, 5, 1 );
			  //dataMasking2.maskMobileNumber(HomePage.contactnumber, contact, excelfile, excelsheet, 4, 1);
			 // aDriver.type(HomePage.contactnumber, contact, "enter contact");
			 // aDriver.type(HomePage.submit,submit, "enter patner Name");
			// aDriver.click(HomePage.submit, "submit button clicked");
			 aDriver.click(HomePage.logout, "log out button clicked");
			 aDriver.click(HomePage.songout, "sing out button clicked");
			 Thread.sleep(5000);
		  }
		  
			 
	}
			  
			  
			  
	
	
			  
			  
			  
			  
			  
			 