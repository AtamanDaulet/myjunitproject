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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
	/*
//Create a class name : DropDown
//Go to https://the-internet.herokuapp.com/dropdown
//1.Select and Print Option 1 using index
//2.Select and Print Option 2 by value
//3.Select and Print default value by visible text
//4.Print all dropdown values
//5.Find the size of the dropdown, Print true if there are 4 elements in the dropdown. Print false otherwise.
	 */
	WebDriver driver;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dropdown");
	}

	@Test
	public void selectByIndexText() throws InterruptedException {
		WebElement selectElement = driver.findElement(By.id("dropdown"));
		Select options = new Select(selectElement);
		Thread.sleep(3000);
		options.selectByIndex(1);
		Thread.sleep(3000);
		options.selectByValue("2");
		Thread.sleep(3000);
		options.selectByVisibleText("Option 1");

	}

	//	@Test
//	public void selectByVisibleTextTest() {
//		WebElement selectElement = driver.findElement(By.id("dropdown"));
//		Select options = new Select(selectElement);
//		options.selectByVisibleText("Option 1");
//	}
	//4.Print all dropdown values
	@Test
	public void printAllOptions() {
		WebElement dropDown = driver.findElement(By.id("dropdown"));
		Select options = new Select(dropDown);
		List<WebElement> allOptions = options.getOptions();

		allOptions.stream().forEach(t -> System.out.println(t.getText()));
	}

	@Test
	public void getFirstSelectedOptionTest() {
		WebElement dropDown = driver.findElement(By.id("dropdown"));
		Select options = new Select(dropDown);
		String selectedOp = options.getFirstSelectedOption().getText();
		System.out.println(selectedOp);
	}

	//5.Find the size of the dropdown, Print true if there are 4 elements in the dropdown. Print false otherwise.
	@Test
	public void sizeOfList() {
		WebElement dropDown = driver.findElement(By.id("dropdown"));
		Select options = new Select(dropDown);
		int numOfEl = options.getOptions().size();
		Assert.assertEquals("There are not 4 elements",4, numOfEl);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
