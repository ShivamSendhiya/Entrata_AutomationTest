package com.entrata.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.entrata.base.EntrataBase;
import com.entrata.pages.HomePage;
import com.entrata.pages.RegistrationPage;
import com.entrata.pages.SummitPage;

public class Validate_FieldError_FirstName_Email_RegistrationPage extends EntrataBase{
	
	public Validate_FieldError_FirstName_Email_RegistrationPage(){
		super();
	}
	
	HomePage hpo;
	RegistrationPage rp;
	SummitPage sp;
	@BeforeMethod
	public void setUp(){
		initialization();
		hpo = new HomePage();
		rp = new RegistrationPage();
		sp = new SummitPage();
	}

	@Test(priority = 1, dataProvider = "data-provider")
	public void errorRegistrationValidatiom(String emailInvalid){
		
		
		sp.clickRegistrationButton();
		
		//VerfiyFirstNameError
		rp.verifyFirstNameFieldsError();
		//VerfiyEmailError
		rp.verifyEmailFieldsError(emailInvalid);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	} 
	
	
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		return new Object[][] {{"abc123"}};
	}
}
