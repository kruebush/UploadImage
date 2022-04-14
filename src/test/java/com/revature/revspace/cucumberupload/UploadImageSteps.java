package com.revature.revspace.cucumberupload;

import static org.junit.jupiter.api.Assertions.assertTrue;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class UploadImageSteps {

	String browserName = "edge";
	WebDriver driver;
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("#Step - browser is open");
		if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}}
	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("#Step - user is on login page");
		driver.get("http://localhost:4200/");
		assertTrue(driver.findElement(By.id("email")).isDisplayed());
	}
	@When("user enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("#Step - user enters username and password");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("atano@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Atano123");
	}
	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		System.out.println("#Step - user clicks on login button");
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();		
	}

	@Then("user is navigated to the postfeed page")
	public void user_is_navigated_to_the_postfeed_page() {
		assertTrue(driver.findElement(By.id("contents_wrapper")).isDisplayed());
		System.out.println("#Step - user is navigated to postfee page");
	}
	@When("user clicks Hello Ahsoka Tano")
	public void user_press_Hello_Ahsoka_Tano() {
		System.out.println("#Step - user clicks on Hello Ahsoka Tano ");
		driver.findElement(By.xpath("//*[@id=\"dropdownMenuButton1\"]")).click();
	}

	@When("user clicks profile")
	public void user_clicks_profile() {
		System.out.println("#Step - user clicks on profile ");
		driver.findElement(By.xpath("//*[@id=\"profile\"]")).click();
	}
	@Then("user is navigated to editprofile")
	public void user_is_navigated_to_editprofile() {
		assertTrue(driver.findElement(By.id("edit")).isDisplayed());
		System.out.println("#Step - user is navigated to editprofile");
	}
	
	@When("user clicks on pencil icon")
	public void user_clicks_on_pencil_icon() {
		System.out.println("#Step - user clicks on pencil icon");
		driver.findElement(By.xpath("//*[@id=\"edit_profile\"]")).click();		
	}


	/*
	@Then("user clicks on update image ")
	public void user_clicks_on_update_image() {
		System.out.println("#Step - user clicks on update image");
		driver.findElement(By.xpath("//*[@id=\"edit-user-image-input\"]")).sendKeys("https://i.ibb.co/SnvkWCd/a.jpg"");
		driver.findElement(By.name("edit-user-accept-changes-button")).click();
	}
	*/
	
}
