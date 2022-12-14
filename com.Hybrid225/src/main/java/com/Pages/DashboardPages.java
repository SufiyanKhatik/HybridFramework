package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPages {

	@FindBy(xpath = "//h1[contains(text(),'Dash')]")
	public WebElement heading;

	public DashboardPages(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	public boolean checkHeading() {
		String actHeading = heading.getText();
		System.out.println("Actual Heading: " + actHeading);
		String expHeading = "Dashboard Courses Offered";
		if(actHeading.equals(expHeading)) {
			System.out.println("Heading matched");
			return true;
		}else {
			System.out.println("Heading not matched");
			return false;
		}
	}
	
}
