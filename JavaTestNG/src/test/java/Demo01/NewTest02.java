package Demo01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest02 {
	
	@Test(priority = 0)
	public void TestAllCaps()
	{
		String originalWord = "Testing is fun";
		String convertedString = originalWord.toUpperCase();
		String expected = "TESTING IS FUN";
		
		Assert.assertEquals(convertedString, expected);
	}
	
	@Test(priority = 1)
	public void TestToLowerCase()
	{
		String originalWord = "TESTING IS FUN";
		String convertedString = originalWord.toLowerCase();
		String expected = "testing is fun";
		
		Assert.assertEquals(convertedString, expected);
	}
	
	@Test(priority = 2)
	public void TestSubstring() 
	{
		String originalText = "Isuru Uyanage";
		String substringText = originalText.substring(2, 5);
		String expected = "uru";
		
		Assert.assertEquals(substringText, expected);
	}


}