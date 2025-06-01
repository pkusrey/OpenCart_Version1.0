package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	protected WebDriver driver;
	public Logger logger;
	public Properties p; 
	@BeforeClass(groups = "sanity")
	@Parameters({"os", "browser"})
	public void setup(String os , String br) throws IOException {
		FileReader file = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
			
		logger = LogManager.getLogger(this.getClass());
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac")) 
			{
				cap.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("Not matching os");
				return;
			}
//			browser
			switch(br.toLowerCase()) {
			case "chrome" :cap.setBrowserName("chrome");break;
			case "edge" : cap.setBrowserName("edge");break;
			}
			
			driver = new RemoteWebDriver(new URL("http://192.168.1.16:4444/wd/hub"),cap);
			
		}
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(br.toLowerCase()) {
			case "chrome" :driver = new ChromeDriver(); break;
			case "edge" : driver = new EdgeDriver();break;
			default : System.out.println("invalid browser"); return;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get(p.getProperty("appURL"));
		driver.get("https://tutorialsninja.com/demo/");
	}
	public String randomstring() {
		String generatestring = RandomStringUtils.randomAlphabetic(5);
		return generatestring;
	}
	public String randomnumber() {
		String generatenumber = RandomStringUtils.randomNumeric(10);
		return generatenumber;
	}
	public String randomalphanumbericpass() {
		String generatestringpassword = RandomStringUtils.randomAlphanumeric(10);
		return generatestringpassword;
	}
	@AfterClass(groups = "sanity")
	public void tearDown() {
		driver.quit();
	}
}
