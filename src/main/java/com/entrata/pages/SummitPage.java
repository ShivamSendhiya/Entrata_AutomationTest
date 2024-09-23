package com.entrata.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.entrata.base.EntrataBase;

public class SummitPage extends EntrataBase {
			
	HomePage hpo = new HomePage();
			//Page Factory - OR:
			@FindBy(xpath="//a[contains(@href,'cvent.me')]")
			public WebElement agendaText;
			
			@FindBy(xpath="//a[contains(@href,'overview')]")
			public WebElement overviewText;
			
			@FindBy(xpath="//a[text()='Register Now']")
			public WebElement btnRegister;
			
			//Initializing the Page Objects:
			public SummitPage(){
				PageFactory.initElements(driver, this);
			}
			
			//Actions:
				public String validateLoginPageTitle(){
					return driver.getTitle();
					
				}
	
				
			public void validateSummitPageUi(){
					
						 
			boolean flag =  agendaText.isDisplayed();
			Assert.assertTrue(flag,"Verfied Buttons");
					      
					      
			boolean flag1 = overviewText.isDisplayed();
			Assert.assertTrue(flag1,"Verfied Buttons");
					      
					}
			
			public void clickRegistrationButton() {
				hpo.clickResgisterbtn();
				String currHandle=driver.getWindowHandle();
				btnRegister.click();
				Object[] windowHandles=driver.getWindowHandles().toArray();
				driver.switchTo().window((String) windowHandles[1]);	
				try {
									Thread.sleep(100);
				} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
				}
			
			}
			
						
}