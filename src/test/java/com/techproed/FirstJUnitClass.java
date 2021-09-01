package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstJUnitClass {

	@Before
	public void setUp(){
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		System.out.println("0 - This is before method");
	}

	@Test
	public void test1(){
		System.out.println("1 - JUnit class");
	}
	@Ignore
	@Test
	public void test2(){
		System.out.println("2 - JUnit class");
	}
	@Test
	public void test6(){
		System.out.println("6 - JUnit class");
	}
	@Test
	public void test4(){
		System.out.println("4 - JUnit class");
	}

	@After
	public void tearDown(){
		System.out.println("-1 - This is AFTER method");
	}

	@Test
	public  void assertion(){
		Assert.assertTrue(3 != 6); //pass
//		Assert.assertTrue(3 == 6);

		Assert.assertFalse(3==6); //pass

		Assert.assertEquals("Daulet", "Daulet");

	}

}
