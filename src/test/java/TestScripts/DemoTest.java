package TestScripts;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AbstractComponent.JsonReadData;
//import PageComponents.FooterNavigations;
import PageObjects.TravelHomePage;

public class DemoTest extends InitializeBrowser {
	WebDriver driver;	
	TravelHomePage thp;
	@BeforeTest
	public void setup() {
		driver = initiateBrowser("chrome");
		driver.manage().window().maximize();
		thp = new TravelHomePage(driver);	
	}
	
@Test(dataProvider="getData")

public void flightes(HashMap<String,String> origindestination) {
	
	
	thp.goTo("https://rahulshettyacademy.com/dropdownsPractise/");
	
	System.out.println(thp.getFooterNavigations().selectfilgihts());
	System.out.println(thp.getNavigationBar().selectfilgihts());
	System.out.println(thp.getNavigationBar().selecthotel());
	System.out.println(thp.getFooterNavigations().getLinks());
	System.out.println(thp.getNavigationBar().getlinkcountnavigate());
	


	thp.setBooking("Oneway"); 
	thp.checkavai(origindestination);
}



@AfterTest
public void teardown() {
	driver.quit();
}

@DataProvider
public Object[][] getData() throws IOException {

	
	String jsonfilepath = System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\Hashjson.json";
	System.out.println("The file path is "+jsonfilepath);
	
	//List<HashMap<String,String>> l = new ArrayList<HashMap<String, String>>();
	JsonReadData jsondata = new JsonReadData(jsonfilepath);
	
	List<HashMap<String,String>> l = jsondata.getjsondata();
	System.out.println(l.get(0));
	System.out.println(l.get(1));
	return new Object[][] {
		{l.get(0)},{l.get(1)}
	};
}

} // class DemoTest
