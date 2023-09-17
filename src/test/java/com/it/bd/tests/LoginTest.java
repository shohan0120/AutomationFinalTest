package com.it.bd.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.it.bd.drivers.BaseDriver;
import com.it.bd.drivers.PageDriver;
import com.it.bd.pages.LoginPage;
import com.it.bd.utilities.DataSet;
import com.it.bd.utilities.ExtentFactory;

public class LoginTest extends BaseDriver {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;

	@BeforeClass
	public void openUrl() {
		PageDriver.getCurrentDriver().manage().window().maximize();
		PageDriver.getCurrentDriver().get(url);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>ORANGE HRM</b></p>")
				.assignAuthor("QA TEAM").assignDevice("Windows");
	}

	@Test(priority = 0)
	public void loginTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>LOGIN TEST</b></p>");
		LoginPage loginPage = new LoginPage(childTest);
		loginPage.login("admin", "admin123");
	}
	
	@Test(priority = 1)
	public void loginTestwithInvalidcredential1() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>LOGIN TEST</b></p>");
		LoginPage loginPage = new LoginPage(childTest);
		loginPage.login("admin1", "admin123");
	}
	
	@Test(priority = 2)
	public void loginTestwithInvalidcredential2() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>LOGIN TEST</b></p>");
		LoginPage loginPage = new LoginPage(childTest);
		loginPage.login("admin", "admin1234");
	}
	
	
	@Test(priority = 3, dataProvider = "invalidCredentials", dataProviderClass = DataSet.class)
	public void loginTestwithInvalidcredentials(String username, String password) throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>LOGIN TEST</b></p>");
		LoginPage loginPage = new LoginPage(childTest);
		loginPage.login(username, password);
	}
	
	@Test(priority = 4, dataProvider = "invalidCredentialsFromExcel", dataProviderClass = DataSet.class)
	public void loginTestwithInvalidcredentialsFromExcel(String username, String password) throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>LOGIN TEST</b></p>");
		LoginPage loginPage = new LoginPage(childTest);
		loginPage.login(username, password);
	}


	@AfterClass
	public void afterClass() {
		report.flush();
	}

}
