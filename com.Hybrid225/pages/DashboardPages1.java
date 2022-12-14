package com.jbk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPages1 {

	public WebDriver driver;

	@FindBy(xpath = "//b[text()='Java By Kiran']")
	WebElement header;

	@FindBy(xpath = "//span[text()='Users']")
	WebElement userBtn;

	public DashboardPages1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public  Userpage clickuser() {

		userBtn.click();
		return new Userpage(driver);
	}
	public String getHeader() {

		return header.getText();
	}


}
