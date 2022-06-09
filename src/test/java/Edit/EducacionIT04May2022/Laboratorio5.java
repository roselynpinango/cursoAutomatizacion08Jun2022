package Edit.EducacionIT04May2022;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio5 {
	String url = "http://automationpractice.com/index.php";
	String driverPath = "..\\EducacionIT04May2022\\Drivers\\chromedriver.exe";
	WebDriver driver;

	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1, description="Validar el buscador de la página")
	public void buscarPalabra() {
		WebElement txtBuscador = driver.findElement(By.cssSelector("#search_query_top"));
		txtBuscador.sendKeys("shirt");
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Validación de resultado esperado
		String urlEsperada = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=shirt&submit_search=";
		String tituloEsperado = "Search - My Store";
		
		Assert.assertEquals(urlEsperada, driver.getCurrentUrl());
		Assert.assertEquals(tituloEsperado, driver.getTitle());
		
		/*
		 * assertNotEquals(1, 2);
		 * assertTrue();
		 * assertFalse();
		 * assertNull();
		 * assertNotNull();
		 * */
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
		driver.close();
	}
}
