package Kaitan.Final;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pObjects.Login;
import resources.baseClass;



public class UserDelete extends baseClass {

	By users=By.xpath("//a[text()='Users']");
	By Browse=By.xpath("//li/a[contains(text(),'Browse list of users')]");
	By textbox=By.cssSelector("input[id='id_realname']");
	By filter=By.cssSelector("input[id='id_addfilter']");
	By delete=By.cssSelector("img[title='Delete']");
	By cnfmDelete=By.cssSelector("input[value='Delete']");

	public static Logger log = LogManager.getLogger(UserDelete.class.getName());

@Test
	public void getDeleteUser() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		Login lp = new Login(driver);
		lp.getEmail().sendKeys("admin71");
		lp.getPassword().sendKeys("Admin@6100");
		lp.getLogin().click();
		log.debug("DeleteUser login Successful");
		driver.findElement(users).click();
		driver.findElement(Browse).click();
		driver.findElement(textbox).sendKeys("Kaitan");
		driver.findElement(filter).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		//driver.findElement(delete).click();
		//driver.findElement(cnfmDelete).click();

		teardown();
	 }

	@AfterTest
	public void teardown() {
		driver.close();
}

}
