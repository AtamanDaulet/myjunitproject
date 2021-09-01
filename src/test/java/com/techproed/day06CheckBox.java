package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class day06CheckBox {
	/*
	//    Create test method and complete the following task.
//    Go to https://the-internet.herokuapp.com/checkboxes
//    Locate the elements of checkboxes
//    Then click on checkbox1 if box is not selected
//    Then click on checkbox2 if box is not selected
	 */
	WebDriver driver;
	@Before
	public void setUp(){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void checkBox(){
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		WebElement checkbox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		WebElement checkbox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		if (!checkbox1.isSelected()){
			checkbox1.click();
		}
		if (!checkbox2.isSelected()){
			checkbox2.click();
		}
	}
	//Verify checkbox1 is checked
	@After
	public void tearDown(){
		driver.close();
	}

}
