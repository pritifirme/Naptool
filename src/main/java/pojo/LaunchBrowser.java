package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	public static  WebDriver browser(String name) {
		WebDriver driver=null;
		if(name.equalsIgnoreCase("Chrome") )
		{
		 WebDriverManager.chromedriver().setup();
	     driver=new ChromeDriver();
		} 
		else if(name.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
		    driver=new EdgeDriver();
		}
		driver.get("https://www.naaptol.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5000));
		return driver;
	}

}