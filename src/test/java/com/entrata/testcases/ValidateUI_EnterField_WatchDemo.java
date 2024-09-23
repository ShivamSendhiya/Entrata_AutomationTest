package com.entrata.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.entrata.base.EntrataBase;
import com.entrata.pages.HomePage;
import com.entrata.pages.WatchDemoPage;

public class ValidateUI_EnterField_WatchDemo extends EntrataBase {

	
	public ValidateUI_EnterField_WatchDemo(){
		super();
	}
	
	HomePage hpo;
	WatchDemoPage wdp;
	
	@BeforeMethod
	public void setUp(){
		initialization();
		hpo = new HomePage();
		wdp = new WatchDemoPage();
	}

	
	
	@Test (dataProvider = "data-provider")
	public void enterFieldsWatchDemo(String fname,String lname, String mail, String mobile){
		
		hpo.clickOnWatchDemo();
		wdp.verifyUiEnterFieldsWatchDemo(fname, lname, mail, mobile);
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	} 
	
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		return new Object[][] {{"Shivam", "Sendhiya" , "ssendhiya@gmail.com","9960155497"}};
	}


}
