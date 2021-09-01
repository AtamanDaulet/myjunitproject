package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleHomepageTest {
	WebDriver driver;

	@Before
	public void setUp(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	@Test
	public void titleTest(){
		String actualGoogleTitle = driver.getTitle();
		String expectedGoogleTitle = "Google";

		Assert.assertEquals(expectedGoogleTitle, actualGoogleTitle);
	}

	@Test
	public void imageTest(){
		WebElement imageGoogle = driver.findElement(By.xpath("//img[@alt='Google']"));
		Assert.assertTrue(imageGoogle.isDisplayed());
	}

	@Test
	public void gmailLinkTest(){
		WebElement gmailLink = driver.findElement(By.xpath("//a[@class='gb_g']"));
		Assert.assertTrue(gmailLink.isDisplayed());
	}

	@After
	public void quit(){
		driver.quit();
	}
}
