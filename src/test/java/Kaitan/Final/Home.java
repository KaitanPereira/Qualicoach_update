package Kaitan.Final;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pObjects.Login;
import resources.baseClass;


public class Home extends baseClass{

	public WebDriver driver;

	public static Logger log = LogManager.getLogger(Home.class.getName());

	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password) throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is Initialized");

		driver.get(prop.getProperty("url"));

		//creating object of LandinPage class and invoking methods of it
		Login lp = new Login(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();
		log.debug("login details entered successfully");

		driver.close();

	}

	//Parameterization and Data driving can be achieved by DataProvider annotaion of Testng
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//coloumn stands for how many values per test
		Object[][] data = new Object[4][2];
		//0th row
		//username and password both are correct
		data[0][0]="admin55";
		data[0][1]="Admin@6155";

		//1st row
		//correct username, but wrong password
		data[1][0]="admin99";
		data[1][1]="Admin@123";


		//3rd row
		//wrong username, but correct password
		data[2][0]="admin";
		data[2][1]="Admin@6102";

		//4th row
		//leave both fields empty
		data[3][0]=" ";
		data[3][1]=" ";

		return data;

	}


}
