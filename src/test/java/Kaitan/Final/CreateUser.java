package Kaitan.Final;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pObjects.Login;
import resources.baseClass;



public class CreateUser extends baseClass {

	By users=By.xpath("//a[contains(text(),'Users')]");
	By adduser = By.xpath("//li/a[contains(text(),'Add a new user')]");
	By username = By.xpath("//input[@id='id_username']");
	By firstname = By.id("id_firstname");
	By lastname = By.id("id_lastname");
	By email = By.id("id_email");
	By submit = By.id("id_submitbutton");
	By pass = By.xpath("//em[contains(text(),'Click to enter text')]");
	By enterpass = By.xpath("//input[@id='id_newpassword']");

	public static Logger log = LogManager.getLogger(CreateUser.class.getName());


	@Test
	public void addingUser() throws IOException, InterruptedException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		Login lp = new Login(driver);
		lp.getEmail().sendKeys("admin71");
		lp.getPassword().sendKeys("Admin@6100");
		lp.getLogin().click();
		log.debug("CreateNewUser login Successful");

		driver.findElement(users).click();
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(adduser);
		a.moveToElement(move).click().build().perform();

		driver.findElement(username).sendKeys("kaitan");
		WebElement passclick = driver.findElement(pass);
		a.moveToElement(passclick).click().build().perform();
		//driver.findElement(pass).click();
		Thread.sleep(2000);
		driver.findElement(enterpass).sendKeys("kaitan@123");
		driver.findElement(firstname).sendKeys("pereira");
		log.info("firstname entered");
		driver.findElement(lastname).sendKeys("k");
		log.info("lastname entered");
		driver.findElement(email).sendKeys("pereira@qualitest.com");
		log.info("email entered");
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebElement create = driver.findElement(submit);
		a.moveToElement(create).click().build().perform();
		log.info("New User Created");

		driver.close();
	}


}
