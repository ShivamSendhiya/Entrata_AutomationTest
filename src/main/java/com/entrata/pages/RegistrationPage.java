package com.entrata.pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.entrata.base.EntrataBase;
import com.entrata.util.TestUtil;

public class RegistrationPage extends EntrataBase {

	////a//div[text()='First Name is required.']
	//Page Factory - OR:
	@FindBy(xpath="//button[text()='Next']")
	public WebElement nextButton;
	
	@FindBy(xpath="//div/input[@aria-label='First Name']//parent::div/following-sibling::div/div[@data-cvent-id='error-message']")
	public WebElement fNameError;
	
	@FindBy(xpath="//div/input[@aria-label='Email Address']//parent::div/following-sibling::div/div[@data-cvent-id='error-message']") 
	public WebElement emailError;
	
	@FindBy(xpath="//*[@aria-label='Email Address']")
	public WebElement textBoxEmail;
	
	//Initializing the Page Objects:
	public RegistrationPage(){
		PageFactory.initElements(driver, this);
	}
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
	
	
	//Actions:
		public void validatePageTitle(){
	
			String title = driver.getTitle();
			Assert.assertEquals(title, "Personal Information - Summit 2024");

		}

	public void verifyFirstNameFieldsError(){
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(nextButton)); 
		nextButton.click();
		
		String fNameMessage = fNameError.getText();
		System.out.println(fNameMessage);
		Assert.assertEquals("First Name is required.", fNameMessage,"Verfified error message for First Name");

			}
	
	public void verifyEmailFieldsError(String email){
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		textBoxEmail.sendKeys(email);
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(nextButton)); 
		nextButton.click();
		
		String emailErrorMessage = emailError.getText();
		System.out.println(emailErrorMessage);
		Assert.assertEquals("Enter a valid email address", emailErrorMessage,"Verified error message for Email");

			}
}
