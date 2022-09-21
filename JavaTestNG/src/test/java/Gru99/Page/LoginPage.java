package Gru99.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Gru99.Common.CommonAction;

public class LoginPage {

	private WebDriver driver;
	
	public void loginGru99(String userName, String passWord)
	{
		driver.findElement(By.name("uid")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(passWord);
		driver.findElement(By.name("btnLogin")).click();
	}
	
	public LoginPage()
	{
		driver = CommonAction.getDriver();
	}
}
