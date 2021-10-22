package Kaitan.Final;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pObjects.Login;
import resources.baseClass;


public class UserEdit extends baseClass{

	By users=By.xpath("//a[text()='Users']");
	By Browse=By.xpath("//li/a[contains(text(),'Browse list of users')]");
	By textbox=By.cssSelector("input[id='id_realname']");
	By filter=By.cssSelector("input[id='id_addfilter']");
	By settingLogo=By.xpath("//*[@class='lastrow'] /td[6] /a[3]");
	By updateBtn=By.cssSelector("input[value='Update profile']");

	public static Logger log = LogManager.getLogger(UserEdit.class.getName());

@Test
	public void getEditUser() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		Login lp = new Login(driver);
		lp.getEmail().sendKeys("admin60");
		lp.getPassword().sendKeys("Admin@4801");
		lp.getLogin().click();
		log.debug("EditUser login successful");
		driver.findElement(users).click();
		driver.findElement(Browse).click();
		driver.findElement(textbox).sendKeys("Demo User");
		driver.findElement(filter).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(settingLogo).click();
		js.executeScript("window.scrollBy(0,1000)");
		WebElement drop=driver.findElement(By.id("id_country"));
		Select dropdown = new Select(drop);
		dropdown.selectByValue("IN");
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(updateBtn).click();
		log.info("User edited");


	}

	@AfterTest
	public void teardown() {
		driver.close();
	}


}
