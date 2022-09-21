package Gru99.Common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
public class CommonAction {

	private static WebDriver driver;
	static String expectedTitleebay ="Guru99 Test Demo Automation java Selenium TestNG";
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	String testResult;
	protected ExtentTest extentTest;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void Setup()
	{
		htmlReporter = new ExtentSparkReporter("extentReport.html");
		//create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		  
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--lang=en");
		//options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.navigate().to("http://www.demo.guru99.com/V4/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);		
		
	}
	@AfterClass
	public void CleanEnvi() {
		
		driver.quit();
		//write results into the file
		  extent.flush();
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public ExtentTest createTestReport(String name, String description)
	{
		return extent.createTest(name, description);
	}
	
	@AfterMethod
	public void testStatus(ITestResult result) throws Exception{
		if (result.getStatus() == ITestResult.FAILURE) {

	        testResult = "Test Fail :" + result.getName();
	        extentTest.fail(MarkupHelper.createLabel(testResult, ExtentColor.RED));
	        testResult = "Details of Fail Testcase:" + result.getThrowable();
	        //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method.
            String screenshotPath = CommonAction.getScreenshot(driver, result.getName());
            extentTest.log(Status.INFO, screenshotPath);
            //To add it in the extent report
            //extentTest.log(extentTest.getStatus(), (Markup) extentTest.addScreenCaptureFromPath(screenshotPath));
            extentTest.addScreenCaptureFromPath(screenshotPath);
	        extent.flush();
	    }
		else
		{
			testResult = "Test Pass :" + result.getName();
	        extentTest.pass(MarkupHelper.createLabel(testResult, ExtentColor.GREEN));
            String screenshotPath = CommonAction.getScreenshot(driver, result.getName());
            extentTest.log(Status.INFO, screenshotPath);
            extentTest.addScreenCaptureFromPath(screenshotPath);
	        extent.flush();
		}
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
        //below line is just to append the date format with the screenshot name to avoid duplicate names
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        //Returns the captured file path
        return destination;
}
	
}
