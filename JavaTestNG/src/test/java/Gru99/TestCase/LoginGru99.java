package Gru99.TestCase;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Gru99.Common.CommonAction;
import Gru99.Page.HomePage;
import Gru99.Page.LoginPage;

public class LoginGru99  extends CommonAction{

	@Test
	public void testCaseLoginWithValiduser()
	{
		//creates a toggle for the given test, add all log events under it
		extentTest = createTestReport("Login Guru99 with Valid Account","Verify Login Successfully");
		extentTest.log(Status.INFO, "Starting test case");
		LoginPage loginPage = new LoginPage();
		loginPage.loginGru99("mngr441712", "tEbaban");
		HomePage homePage = new HomePage();
		homePage.verifyHomePageDisplay("Guru99 Bank Manager HomePage");
	}
}
