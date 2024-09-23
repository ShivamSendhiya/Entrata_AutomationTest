package com.entrata.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.entrata.base.EntrataBase;
import com.entrata.pages.HomePage;
import com.entrata.pages.SummitPage;

public class Verify_Navigation_UI_SummitPage extends EntrataBase  {

	
	public Verify_Navigation_UI_SummitPage(){
		super();
	}
	
	HomePage hpo;
	SummitPage sp;
	
	@BeforeMethod
	public void setUp(){
		initialization();
		hpo = new HomePage();
		sp = new SummitPage();
	}

	
	
	@Test
	public void summitPageValidatiom(){
		
		hpo.clickSummit();
		sp.validateSummitPageUi();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	} 
	

}
