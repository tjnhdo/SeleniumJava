package Gru99.Page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import Gru99.Common.CommonAction;

public class HomePage {

	private WebDriver driver;

	public HomePage()
	{
		driver = CommonAction.getDriver();
	}
	
	public void verifyHomePageDisplay(String pageTitle)
	{
		assertTrue(driver.getTitle().contentEquals(pageTitle));
		
	}
}
