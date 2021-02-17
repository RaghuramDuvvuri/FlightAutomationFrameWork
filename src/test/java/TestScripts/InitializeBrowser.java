package TestScripts;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InitializeBrowser {
	WebDriver driver;
	
	public  WebDriver initiateBrowser(String Browsertype) {
		
		
		if (Browsertype.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\PythonTraining\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-popup-blocking");
			driver = new ChromeDriver(options);
			
		}
		if (Browsertype.equalsIgnoreCase("firefox")){
			  System.setProperty("webdriver.gecko.driver", "D:\\Gecko Driver\\geckodriver.exe");
				FirefoxOptions options = new FirefoxOptions();
				FirefoxProfile profile = new FirefoxProfile();
				profile.setAcceptUntrustedCertificates(true);
				profile.setAssumeUntrustedCertificateIssuer(false);
				profile.setPreference("network.proxy.type", 0);
				//options.setCapability(FirefoxDriver.PROFILE, profile);
				options.setProfile(profile);
				driver = new FirefoxDriver(options);
		}
		return driver;
		
		
	}
	
	
/*public List<HashMap<String,String>> getjsondata(String jsonfile) throws IOException {
		
		String jsonString = FileUtils.readFileToString(new File(jsonfile), StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		// Type reference is used to marshal and unmarshall json string to hashmap list 	
		List<HashMap<String,String>> data  = mapper.readValue(jsonString, new TypeReference<List<HashMap<String,String>>>(){});
	
		 return data;
		
	}*/
}
