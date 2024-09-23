package com.entrata.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.entrata.base.EntrataBase;
import com.entrata.pages.HomePage;

public class ValidateUI_HomePageTest extends EntrataBase{

	public ValidateUI_HomePageTest(){
		super();
	}
	
	HomePage hpo;
	
	@BeforeMethod
	public void setUp(){
		initialization();
		hpo = new HomePage();
	}
	
	
	@Test(priority=1)
	public void homenPageTitleTest(){
		String title = hpo.validateLoginPageTitle();
		Assert.assertEquals(title, "Property Management Software | Entrata");
		
		//Validate Homepage UI
		boolean flag = hpo.validateHomePageUi();
		Assert.assertTrue(flag,"Verfied Signin Button");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}