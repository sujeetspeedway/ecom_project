package com.mystore.testcases;

import java.io.IOException;

//import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreation;
import com.mystore.pageobject.AddressPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.utilities.ReadExcelFile;

public class TC_DataDrivenTest extends BaseClass {

	@Test(dataProvider = "LoginDataProvider")
	public void verifyLogin(String userEmail, String userPwd, String expectedUsername) throws IOException
	{
		IndexPage pg=new IndexPage(driver);
		pg.clickOnSignIn(); 
		logger.info("clicked on signin");
		
		MyAccount myAcpg = new MyAccount(driver);
		myAcpg.enterRegisteredEmail(userEmail);
		myAcpg.enterRegisteredepwd(userPwd);
		myAcpg.clickonRegisteredLogin();
		logger.info("entered registered email and password");
		
        //verify user name is correct or not
		RegisteredUserAccount regAcc=new RegisteredUserAccount (driver);
		String userName=regAcc.verifyAcc();
		if(userName.equals(expectedUsername))
		{
			logger.info("Account verified");	
			Assert.assertTrue(true);
			regAcc.clickOnSignout();
			logger.info("clicked on signout");	
			
		}
		else 
		{
			logger.info("Account not verified");
			captureScreenShot(driver,"verifyLogin");
			
			logger.info("screenshot captured");
			Assert.assertTrue(false);
			
		} 	
		
	}
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}		
}

