package com.jbk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(xpath = "//input[@id='password']")
	public WebElement pass;
	 
	@FindBy(xpath = "//button")
	public WebElement button;
	
	@FindBy(xpath = "//div[@id='email_error']")
	public WebElement errorMsg;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    public void correctCredentials() {
    	email.sendKeys("kiran@gmail.com1");
    	pass.sendKeys("123456");
    	button.click();
    }
    public void correctCredential() {
    	email.sendKeys("kiran@gmail.com");
    	pass.sendKeys("123456");
    	button.click();
    }
    public boolean checkError() {
    	String actualErrorMsg = errorMsg.getText();
    	String expErrorMsg = "Please enter email as kiran@gmail.com";
    	if(actualErrorMsg.equals(expErrorMsg)) {
    		System.out.println("Error msg match");
    		return true;
    	}else {
    		System.out.println("Error msg not match");
    		return false;
    	}
    }
    
}
