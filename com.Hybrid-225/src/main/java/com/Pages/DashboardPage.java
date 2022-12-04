package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver=null;
@FindBy(xpath="//b[text()=\"Java By Kiran\"]")
WebElement header;
@FindBy(xpath="//span[text()=\"Users\"]")
WebElement userBtn;
DashboardPage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public String getHeader() {
	return header.getText();
}
public userPage clickUser(){
	userBtn.click();
	return new userPage(driver);
	
}
}
