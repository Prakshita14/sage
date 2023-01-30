package sage_inteview;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	
	public BaseClass() throws IOException {
		FileInputStream propertiesPath = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\sage_inteview\\config.properties");
		prop = new Properties();
		prop.load(propertiesPath);
	}

	public WebDriver initialization() {
		switch (prop.getProperty("browser")) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			driver = null;
		}
		//driver.get(prop.getProperty("url"));
		driver.get("https://us.sagepub.com/en-us/nam/home");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		return driver;

	}

}
