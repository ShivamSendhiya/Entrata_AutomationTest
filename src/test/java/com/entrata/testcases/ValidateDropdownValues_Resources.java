package com.entrata.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.entrata.base.EntrataBase;
import com.entrata.pages.HomePage;
import com.entrata.pages.RegistrationPage;
import com.entrata.pages.SummitPage;
import com.entrata.util.TestUtil;

public class ValidateDropdownValues_Resources extends EntrataBase{
	public ValidateDropdownValues_Resources(){
		super();
	}
	
	HomePage hpo;

	@BeforeMethod
	public void setUp(){
		initialization();
		hpo = new HomePage();
		
	}
	
	
	@Test
	public void errorRegistrationValidatiom(){
		
		hpo.verifyDropDown_Resources();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	} 
	
}
