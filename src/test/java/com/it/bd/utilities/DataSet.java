package com.it.bd.utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
	
	@DataProvider(name = "invalidCredentials")
	public static Object invlidLoginData() {
		Object[][] objects = {{"admin1", "admin123"}, {"admin", "admin12"}, {"admin34", "admin17"}};
		return objects;
	}
	
	
	@DataProvider(name = "invalidCredentialsFromExcel")
	public static Object invlidLoginDataFromExcel() {
		ExcelReader excelReader = new ExcelReader("src\\invalidCredentials.xlsx", 0);
		return excelReader.getAllDataAsObjects();
	}

}
