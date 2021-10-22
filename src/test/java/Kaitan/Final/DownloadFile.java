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


public class DownloadFile extends baseClass{

	public static Logger log = LogManager.getLogger(DownloadFile.class.getName());

	@Test
	public void getDownload() throws IOException{

		driver = initializeDriver();
		driver.get(prop.getProperty("url2"));

		Login lp = new Login(driver);
		lp.getEmail().sendKeys("admin55");
		lp.getPassword().sendKeys("Admin@6155");
		lp.getLogin().click();

		log.debug("Download page login successful");


		driver.findElement(By.xpath("//a[contains(text(),'Names of resources completed')]")).click();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//div[@class='centerpara'] /a /img[@alt='csv']")).click();



		}

	 @AfterTest
		public void teardown() {
			driver.close();
		}

}
