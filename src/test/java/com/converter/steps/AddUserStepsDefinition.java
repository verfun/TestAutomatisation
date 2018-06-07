package com.converter.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AddUserStepsDefinition {
	
	WebDriver driver = null;

	@Given("^I to add a new user$")
	public void i_to_add_a_new_user() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "C:\\geckoDrive\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://127.0.0.1:51054/index.html#/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^I input the user data$")
	public void i_input_the_user_data() throws Throwable {
		WebElement fName = driver.findElement(By.id("exampleInputFName"));
		WebElement lName = driver.findElement(By.id("exampleInputLName"));
		WebElement email = driver.findElement(By.id("exampleInputEmail1"));
		WebElement pwd = driver.findElement(By.id("exampleInputPassword1"));
		WebElement btn = driver.findElement(By.id("button"));
		
		fName.sendKeys("lahcen");
		lName.sendKeys("rizki");
		email.sendKeys("lahcen.rizki@capgemini.com");
		pwd.sendKeys("dferdd");
		btn.click();
	}

	@Then("^It add to my list of users$")
	public void it_add_to_my_list_of_users() throws Throwable {
		WebElement btn = driver.findElement(By.id("nbrUsers"));
		Assert.assertEquals(Integer.parseInt(btn.getText()), 4);
	}


}
