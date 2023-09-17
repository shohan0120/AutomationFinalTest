package com.it.bd.tests;

import org.testng.annotations.Test;
import com.it.bd.drivers.BaseDriver;
import com.it.bd.pages.DashboardPage;


public class DashboradTest extends BaseDriver{
	
	@Test(priority = 0)
	public void dashBoardTest() throws InterruptedException {
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.checkDashboard();
		dashboardPage.clickAdmin();
	}
	
}
