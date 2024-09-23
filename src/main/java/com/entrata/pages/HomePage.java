package com.entrata.pages;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.entrata.base.EntrataBase;

public class HomePage extends EntrataBase{
	
		//Page Factory - OR:
		@FindBy(linkText="Sign In")
		public WebElement signInBtn;
		
		@FindBy(xpath="//a//div[text()='Register Now!']")
		public WebElement registerBtn;
		
		@FindBy(xpath="//a[contains(@href,'go.entrata.com')]")
		public WebElement watchDemoBtn;
			
		@FindBy(xpath="//a[@class='nav-link black-text last w-nav-link']")
		public WebElement submitSummitBtn;
		
		@FindBy(xpath="//a[text()='Register Now']")
		public WebElement btnRegister;
		
		WebElement resourcesLink=driver.findElement(By.xpath("//div[@aria-controls='w-dropdown-list-6' and @role='button']"));
		
		SoftAssert softAssert = new SoftAssert();
		
		//Initializing the Page Objects:
		public HomePage(){
			PageFactory.initElements(driver, this);
		}
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		
		//Actions:
			public String validateLoginPageTitle(){
				return driver.getTitle();
			}
			
			public boolean validateHomePageUi(){
				
				boolean flag =  signInBtn.isDisplayed();
				return flag;	
			}

			
			public void clickOnWatchDemo(){
				
			    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(watchDemoBtn));
				watchDemoBtn.click();
			}
			
			public void clickSummit() {

				submitSummitBtn.click();
				String currHandle=driver.getWindowHandle();
				
				Object[] windowHandles=driver.getWindowHandles().toArray();
				driver.switchTo().window((String) windowHandles[1]);
						
				try {
									Thread.sleep(100);
				} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
				}
		}
			public void clickResgisterbtn() {
				registerBtn.click();
			}
			
			public void verifyDropDown_Resources() {
				
				WebElement hoverable = resourcesLink;
		        new Actions(driver)
		                .moveToElement(hoverable)
		                .perform();
		        String[] expected = {"Guides", "Webinars","Resident Experts","Blog"};

				
				List<WebElement> allOptions = driver.findElements(By.xpath("//nav[@id='w-dropdown-list-6']/div/a[@class='sub-menu black']"));
		     
				// make sure you found the right number of elements
				if (expected.length != allOptions.size()) {
				    System.out.println("fail, wrong number of elements found");
				}
				// make sure that the value of every element equals the expected value
				for (int i = 0; i < expected.length; i++) {
				    String optionValue = allOptions.get(i).getText();
				    if (optionValue.equals(expected[i])) {
				        System.out.println("passed on: " + optionValue);
				        softAssert.assertTrue(true,optionValue);
				    } else {
				        System.out.println("failed on: " + optionValue);
				        softAssert.assertTrue(false,optionValue);
				}
			}
}
}