package Edit.EducacionIT04May2022;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio2 {
	String url ="http://automationpractice.com";
	String chromeDriverPath = "..\\EducacionIT04May2022\\Drivers\\chromedriver.exe";
	String firefoxDriverPath = "..\\EducacionIT04May2022\\Drivers\\geckodriver.exe";
	
	@Test
	public void hacerBusquedaEnChrome() {
		// 1) Indicar dónde está el driver a utilizar
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		// 2) Acceder a la página que vamos a probar
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		// Maximizar la pantalla
		driver.manage().window().maximize();
		
		// 3) Escribir la palabra a buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// 4) Hacer la búsqueda
		txtBuscador.sendKeys(Keys.ENTER);
		
		System.out.println("getTitle(): " + driver.getTitle());
		System.out.println("getCurrentUrl(): " + driver.getCurrentUrl());
	}
	
	@Test
	public void hacerBusquedaEnFirefox() {
		// 1) Indicar dónde está el driver a utilizar
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		
		// 2) Acceder a la página que vamos a probar
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		
		// 3) Escribir la palabra a buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// 4) Hacer la búsqueda
		txtBuscador.sendKeys(Keys.ENTER);
	}
}
