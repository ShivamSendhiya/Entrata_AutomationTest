package com.entrata.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.entrata.base.EntrataBase;

public class WatchDemoPage extends EntrataBase{

	
	HomePage hpo = new HomePage();
	
	
	
	//Page Factory - OR:
			@FindBy(id="FirstName")
			public WebElement firstName;
			
			@FindBy(id="LastName")
			public WebElement lastName;
			
			@FindBy(id="Email")
			public WebElement email;
			
			@FindBy(id="Phone")
			public WebElement phone;
			
			@FindBy(xpath="//button[text()='WATCH DEMO']")
			public WebElement submitWatchDemoBtn;
			
			
			
			//Initializing the Page Objects:
			public WatchDemoPage(){
				PageFactory.initElements(driver, this);
			}
			
			//Actions:
				public String validateLoginPageTitle(){
					return driver.getTitle();
					
				}
				
				
				public void verifyUiEnterFieldsWatchDemo(String fname,String lname, String mail, String mobile) {
										
					String wTitle = driver.getTitle();
					
					
					Assert.assertEquals(wTitle, "Entrata | Optimize Property Management with One Platform","Verified Watch Demo Title");
				
					//Enter Fields value:-
					firstName.sendKeys(fname);
					
					lastName.sendKeys(lname);
					
					email.sendKeys(mail);
					
					phone.sendKeys(mobile);
					
					//Verify submit button
					boolean flag = submitWatchDemoBtn.isDisplayed();
					
					Assert.assertTrue(flag, "Submit Watch Demo Btn Displayed");
					
					
				}
}
