package StudentCheck;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pObjects.Login2;
import resources.baseClass;


public class StudentVerify extends baseClass{

	By selectCourse = By.xpath("//p[contains(text(),'UFT Beginners')]");//courseEnroll
	By enrollMe = By.xpath("//input[@id='id_submitbutton']");//courseEnroll
	By quizActivitylink = By.xpath("//div[contains(text(),'Module 1 Quiz')]");//Quiz
	By attemptQuiz = By.xpath("//input[@value='Re-attempt quiz']");//Quiz
	By startAttempt = By.xpath("//*[@value='Start attempt']");//Quiz
	By selectCoursePy = By.xpath("//div[@cat-id='3'] /a /p[text()='Python Beginners']");//BadgeAndFeedback
	By BadgeFeed = By.xpath("//a[contains(text(),'Badge & Feedback')]");//BadgeAndFeedback
	By CourseFeed = By.xpath("//div[contains(text(),'Course Feedback Form')]");//BadgeAndFeedback
	By selectRest = By.xpath("//p[contains(text(),'API Automation using REST Assured (Beginners)')]");


	public static Logger log = LogManager.getLogger(StudentVerify.class.getName());
@Test
	public void courseEnroll() throws InterruptedException, IOException {


		driver = initializeDriver();
		driver.get(prop.getProperty("url3"));

		Login2 lp2 = new Login2(driver);
		lp2.getEmail().sendKeys("user91");
		lp2.getPassword().sendKeys("User@7014");
		lp2.getLogin().click();

		log.info("Student login successful");

		// after login attempting quiz
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(selectCourse);
		a.moveToElement(move).click().build().perform();
		//driver.findElement(enrollMe).click();

		log.info("Course Enroll Successful");


		driver.close();
	}



	@Test
	public void Quiz() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url3"));

		Login2 lp2 = new Login2(driver);
		lp2.getEmail().sendKeys("user91");
		lp2.getPassword().sendKeys("User@7014");
		lp2.getLogin().click();
		log.debug("Quiz login Successful");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(selectRest);
		a.moveToElement(move).click().build().perform();

		driver.findElement(quizActivitylink).click();
		log.debug("Quiz activity link clicked");
		//driver.findElement(attemptQuiz).click();
		//driver.findElement(startAttempt).click();

		log.info("Quiz attempted Successfully");


		driver.close();
	}



	@Test
	public void BadgeAndFeedback() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url3"));

		Login2 lp2 = new Login2(driver);
		lp2.getEmail().sendKeys("user91");
		lp2.getPassword().sendKeys("User@7014");
		lp2.getLogin().click();

		log.debug("Badge and Feedback login Successful");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		Actions a = new Actions(driver);
		WebElement movePy = driver.findElement(selectCoursePy);
		a.moveToElement(movePy).click().build().perform();
		// click on badge and course feedback
		driver.findElement(BadgeFeed).click();
		WebElement CourseFeedSelect = driver.findElement(CourseFeed);

		a.moveToElement(CourseFeedSelect).click().build().perform();
		driver.findElement(By.linkText("Answer the questions")).click();

		log.info("Badge feedback attempt Successfully");



		driver.close();
		}


}
