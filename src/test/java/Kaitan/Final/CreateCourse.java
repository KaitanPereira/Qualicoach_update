package Kaitan.Final;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pObjects.Login;
import resources.baseClass;

public class CreateCourse extends baseClass {

	public static Logger log = LogManager.getLogger(CreateCourse.class.getName());

	By courses=By.xpath("//ul[@class='nav nav-tabs'] /li[3]");
	By manage=By.xpath("//li/a[contains(text(),'Manage courses and categories')]");
	By createNewuser=By.xpath("//div[@class='listing-actions course-listing-actions'] /a");


@Test
	public void getCreateCours() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		Login lp = new Login(driver);
		lp.getEmail().sendKeys("admin59");
		lp.getPassword().sendKeys("Admin@7011");
		lp.getLogin().click();


		driver.findElement(courses).click();
		driver.findElement(manage).click();
		driver.findElement(createNewuser).click();
		driver.findElement(By.id("id_fullname")).sendKeys("Automation selenium");
		driver.findElement(By.id("id_shortname")).sendKeys("selenium java");
		WebElement drop1=driver.findElement(By.id("id_startdate_day"));
		Select dropdown1 = new Select(drop1);
		dropdown1.selectByValue("6");
		WebElement drop2=driver.findElement(By.id("id_startdate_month"));
		Select dropdown2 = new Select(drop2);
		dropdown2.selectByValue("6");
		WebElement drop3=driver.findElement(By.id("id_startdate_year"));
		Select dropdown3 = new Select(drop3);
		dropdown3.selectByValue("2021");
		driver.findElement(By.cssSelector("input#id_enddate_enabled")).click();
		AssertJUnit.assertTrue(driver.findElement(By.cssSelector("input#id_enddate_enabled")).isEnabled());
		driver.findElement(By.id("id_idnumber")).sendKeys("001");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.cssSelector("div#id_summary_editoreditable")).click();
		driver.findElement(By.cssSelector("div#id_summary_editoreditable")).sendKeys("This course contains Selenium Java courses for Begineer's");
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.cssSelector("input#id_saveanddisplay")).click();
	}

@AfterTest
public void teardown() {
	driver.close();
}

}
