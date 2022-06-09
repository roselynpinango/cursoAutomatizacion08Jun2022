package Edit.EducacionIT04May2022;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;

public class ScrollScreenshot {
	WebDriver driver;
	
	@Test
	public void scrollScreenshotTest() throws Exception {
		System.setProperty("webdriver.chrome.driver", "..\\EducacionIT04May2022\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://www.bbc.com");       
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(s.getImage(),"PNG",new File("..\\EducacionIT04May2022\\Evidencias\\fullPageScreenshot.png"));
		
		driver.close();
	}
	
}
