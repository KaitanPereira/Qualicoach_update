package StudentCheck;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pObjects.Login2;
import resources.baseClass;



public class StudentHome extends baseClass{

	@Test(dataProvider="getStudentData")
	public void studentNavigation(String Username,String Password) throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url3"));

		Login2 lp2 = new Login2(driver) ;
		lp2.getEmail().sendKeys(Username);
		lp2.getPassword().sendKeys(Password);
		lp2.getLogin().click();
		System.out.println("Student login details entered succesfully");
		
		driver.close();
	}

	

	@DataProvider
	public Object[][] getStudentData()
	{
		Object[][] data = new Object[1][2];

		data[0][0]="user94";
		data[0][1]="User@7014";


		return data;

	}


}
