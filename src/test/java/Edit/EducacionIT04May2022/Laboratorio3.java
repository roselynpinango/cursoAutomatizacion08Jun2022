package Edit.EducacionIT04May2022;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio3 {
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EducacionIT04May2022\\Drivers\\chromedriver.exe";
	
	@Test
	public void registrarUsuario() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		/*
		 * Argumentos de ChromeOptions
		 * 1) incognito
		 * 2) start-maximized
		 * 3) disable-extensions
		 * 4) disable-popup-blocking
		 * 5) headless
		 * */
		
		WebDriver driver = new ChromeDriver(options);
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
		// Completar el correo y hacer clic en el boton
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='email_create']"));
		txtEmail.sendKeys("correo" + Math.random() + "@mailinator.com");
		
		driver.findElement(By.cssSelector("#SubmitCreate")).click();
		
		// Espera - Cambio de Pagina
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		// LLenar el formulario - Información Personal
		driver.findElement(By.id("id_gender1")).click();
		
		driver.findElement(By.id("customer_firstname")).sendKeys("Horacio");
		driver.findElement(By.name("customer_lastname")).sendKeys("Gonzalez");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("1q2w3e4r5t");
		
		Select days = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		days.selectByValue("18");
		
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByVisibleText("June ");
		
		(new Select(driver.findElement(By.name("years")))).selectByIndex(30);
		
		driver.findElement(By.name("newsletter")).click(); 
		driver.findElement(By.xpath("//input[@id='optin']")).click();
		
		// Llenar el formulario - Dirección
		driver.findElement(By.cssSelector("#company")).sendKeys("MiEmpresa C.A.");
		driver.findElement(By.id("address1")).sendKeys("MiCalle 4567 3B");
		driver.findElement(By.name("address2")).sendKeys("entre Calle A y B");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Buenos Aires");
		
		Select states = new Select(driver.findElement(By.id("id_state")));
		states.selectByVisibleText("California");
		
		driver.findElement(By.id("postcode")).sendKeys("90210");
		driver.findElement(By.name("other")).sendKeys("Usuario registrado por medio de un script");
		
		driver.findElement(By.cssSelector("#phone")).sendKeys("34545654");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("1546576857");
		
		driver.findElement(By.name("alias")).clear();
		driver.findElement(By.name("alias")).sendKeys("Mi Casa");
		
		driver.findElement(By.id("submitAccount")).click();
	}
}
