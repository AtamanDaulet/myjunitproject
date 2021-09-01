package com.techproed;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class JavaFakerDemo {
	/*
	1. Create a class: JavaFakerDemo
2. Complete the setup
3. Create a chrome driver
4. Create a faker object
5. Create fake names
	 */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		Faker faker = new Faker();


		WebElement searchInput = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		searchInput.sendKeys(faker.name().fullName() + Keys.ENTER);


//		driver.quit();

	}
}
