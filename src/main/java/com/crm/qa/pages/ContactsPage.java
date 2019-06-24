package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BrowserFactory;
import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	//WebDriver driver;

	@FindBy(xpath = "//a[@href='/contacts/new']/button")
	WebElement newContact;

	@FindBy(xpath = "//div[text()='Create New Contact']")
	WebElement newContactHeader;

	@FindBy(xpath = "//label[text()='First Name']/following::input")
	@CacheLookup
	WebElement firstName;

	@FindBy(xpath = "//label[text()='Last Name']/following::input")
	@CacheLookup
	WebElement lastName;

	@FindBy(xpath = "//label[text()='Social Channels']/following::i[@class='dropdown icon']")
	@CacheLookup
	WebElement socialChannel;
	//
	@FindBy(xpath = "//label[text()='Company']/following::input")
	@CacheLookup
	WebElement addCompany;
	
	@FindBy(xpath = "//label[text()='Description']/following::textarea")
	@CacheLookup
	WebElement addDescription;

	//

	public ContactsPage() {
		driver=BrowserFactory.getInstance().getDriver();
		PageFactory.initElements(this.driver, this);
		
	}

	public boolean verifyContactPage() {
		return newContact.isDisplayed();
	}

	public boolean createNewContactLink() {
		newContact.click();
		return newContactHeader.isSelected();
	}

	public void enterDetailsOfNewContact(String fname,String lName, String company, String socialAcct, String description) {
		
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lName);
		addCompany.click();
		addCompany.sendKeys(company);
		driver.findElement(By.xpath("//label[text()='Company']/following::div[@role='option']//b[contains(text(),'"+company+"')]")).click();;
		socialChannel.click();
		driver.findElement(By.xpath("(//label[text()='Social Channels']/following::div[@role='option']/following::span[text()='"+socialAcct+"'])[1]")).click();
		addDescription.sendKeys(description);
		
			
		
	}

}
