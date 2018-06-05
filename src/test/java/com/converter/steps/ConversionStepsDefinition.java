package com.converter.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class ConversionStepsDefinition {

	WebDriver driver = null;
	
	@Given("^I wantt to convert (\\d+)\\.(\\d+) degree toFahrenheit$")
	public void i_wantt_to_convert_degree_toFahrenheit(int arg1, int arg2) throws Throwable {
		System.setProperty("webdriver.gecko.driver", "C:\\geckoDrive\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    String url = "https://www.google.fr/search?ei=oXAWW7XvK4feU5iThagL&q=temperature+converter&oq=temp&gs_l=psy-ab.3.0.35i39k1l2j0i67k1l2j0i131i67k1j0i131k1l2j0l2j0i67k1.4271587.4272126.0.4273194.4.4.0.0.0.0.122.346.0j3.3.0....0...1.1.64.psy-ab..1.3.345....0.89Ex4yaVGIk";
	    driver.get(url);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^I input the value of (\\d+)\\.(\\d+) in text box$")
	public void i_input_the_value_of_in_text_box(int arg1, int arg2) throws Throwable {
	    WebElement inputTemperatureCelisius = driver.findElement(By.cssSelector("input"));
	    inputTemperatureCelisius.sendKeys("37");
	}

	@Then("^It should be converted to celsius to (\\d+) dgree$")
	public void it_should_be_converted_to_celsius_to_dgree(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    Assert.assertEquals(actual);
	}
}
