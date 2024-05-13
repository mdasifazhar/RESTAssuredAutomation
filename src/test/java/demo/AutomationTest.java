package demo;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AutomationTest {
	WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			//driver= new ChromeDriver();
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName(browser);
			try {
				driver = new RemoteWebDriver(new URL("http://3.142.153.83:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		} else if (browser.equalsIgnoreCase("firefox")) {
			//driver= new FirefoxDriver();
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName(browser);
			try {
				driver = new RemoteWebDriver(new URL("http://3.142.153.83:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.freshworks.com/");

	}
	
	@Test
	public void getFreshworkTitleInfo() {
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(),"Innovative Software for Business Needs | Freshworks");
	}
	
	@Test
	public void getFreshworkFooterInfo() {
		List<WebElement> elts=driver.findElements(By.xpath("//ul/li[contains(@class,'sc-6293d692-0 eNMhGa')]"));
		for(WebElement elt:elts) {
			System.out.println(elt.getText());
		}
		assertEquals(elts.size(),38);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
