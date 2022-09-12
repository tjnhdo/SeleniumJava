package Demo01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {
	
	@Test
	public void TestAddition() {
		int a = 5;
		int b = 4;
		int actual = a+b;
		int expected = 9;
		
		Assert.assertEquals(actual, expected);	
	}
	
	@Test
	public void TestSubstraction() {
		int a = 5;
		int b = 4;
		int actual = a-b;
		int expected = 1;
		
		Assert.assertEquals(actual, expected);	
	}
	
	@Test
	public void TesMultiplication() {
		int a = 5;
		int b = 4;
		int actual = a*b;
		int expected = 20;
		
		Assert.assertEquals(actual, expected);	
	}
	
}