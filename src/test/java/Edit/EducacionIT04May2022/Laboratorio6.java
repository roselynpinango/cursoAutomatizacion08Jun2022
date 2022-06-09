package Edit.EducacionIT04May2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Laboratorio6 {
	String url = "http://automationpractice.com/index.php";
	String driverPath = "..\\EducacionIT04May2022\\Drivers\\chromedriver.exe";
	String firefoxDriverPath = "..\\EducacionIT04May2022\\Drivers\\geckodriver.exe";
	WebDriver driver;

	@BeforeTest
	@Parameters("navegador")
	public void abrirPagina(String navegador) {
		if (navegador.equalsIgnoreCase("Chrome")) {
			// acciones propias de Chrome
			System.setProperty("webdriver.chrome.driver", driverPath);
			
			driver = new ChromeDriver();
		} else if (navegador.equalsIgnoreCase("Firefox")) {
			// acciones propias de Firefox
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(priority=0, description="Validar el formulario de Contáctanos")
	public void irAContactanos() {
		driver.findElement(By.linkText("Contact us")).click();
		
		Select selSubject = new Select(driver.findElement(By.id("id_contact")));
		selSubject.selectByVisibleText("Webmaster");
		
		driver.findElement(By.name("from")).sendKeys("micorreo@mailinator.com");
		driver.findElement(By.id("fileUpload")).sendKeys("C:\\addIntegerData.txt");
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Comentario");
		
		driver.findElement(By.id("submitMessage")).click();
	}
	
	@AfterSuite
	public void cerrarPagina() {
		//driver.close();
	}
}
