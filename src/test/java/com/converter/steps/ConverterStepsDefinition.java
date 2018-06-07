package com.converter.steps;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class ConverterStepsDefinition {

	WebDriver driver = null;
	
	@Given("^I wan to convert (\\d+) degree to Fahrenheit$")
	public void i_wan_to_convert_degree_to_Fahrenheit(int arg1) throws Throwable {
		System.setProperty("webdriver.gecko.driver", "C:\\geckoDrive\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    String url = "http://127.0.0.1:51054/index.html#/home";
	    driver.get(url);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^I input the value of (\\d+) in text box$")
	public void i_input_the_value_of_in_text_box(int arg1) throws Throwable {
		WebElement degreeCelesius = driver.findElement(By.id("temperature"));
	    WebElement converterButton = driver.findElement(By.id("converter"));
	    degreeCelesius.sendKeys("37");
	    converterButton.click();
	}

	@Then("^It should be display (\\d+)\\.(\\d+) degree Fahrenheit$")
	public void it_should_be_display_degree_Fahrenheit(int arg1, int arg2) throws Throwable {
		DecimalFormat df = new DecimalFormat ( ) ; 
		df.setMaximumFractionDigits ( 2 ) ; 
		df.setMinimumFractionDigits ( 2 ) ; 
		df.setDecimalSeparatorAlwaysShown ( true ) ;
	    double expectedValue = 37 * 1.8 + 32;
	    WebElement degreeFahrenheit = driver.findElement(By.id("resultTemperature"));
		Assert.assertEquals(df.format(expectedValue), df.format(Double.parseDouble(degreeFahrenheit.getText())));
//	    driver.quit();
	}
}
