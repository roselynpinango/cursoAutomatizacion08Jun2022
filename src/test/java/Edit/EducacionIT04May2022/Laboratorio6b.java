package Edit.EducacionIT04May2022;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;

public class Laboratorio6b {
	String url = "http://automationpractice.com/index.php";
	String driverPath = "..\\EducacionIT04May2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	String dirEvidencias = "..\\EducacionIT04May2022\\Evidencias\\";
	String nombreDocumento = "DocEvidenciasAutomationPractice.docx";
	File pantalla;

	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1, description="Validar el buscador de la página")
	public void buscarPalabraConImagenes() throws IOException {
		// Capturar pantalla inicial
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "01_pantalla_inicial.jpg"));
		
		WebElement txtBuscador = driver.findElement(By.cssSelector("#search_query_top"));
		txtBuscador.sendKeys("shirt");
		
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "02_palabra_a_buscar.jpg"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "03_resultados_busqueda.jpg"));
		
		// Validación de resultado esperado
		String urlEsperada = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=shirt&submit_search=";
		String tituloEsperado = "Search - My Store";
		
		Assert.assertEquals(urlEsperada, driver.getCurrentUrl());
		Assert.assertEquals(tituloEsperado, driver.getTitle());
	}
	
	@Test(priority=1, description="Validar el buscador de la página")
	public void buscarPalabraConDocumentoEvidencias() throws IOException, InvalidFormatException, InterruptedException {
		CapturaEvidencia.escribirTituloEnDocumento(dirEvidencias + nombreDocumento, "Documento de Evidencias - AutomationPractice", 18);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Paso 1 - Pantalla Inicial");
		
		WebElement txtBuscador = driver.findElement(By.cssSelector("#search_query_top"));
		txtBuscador.sendKeys("shirt");
	
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Paso 2 - Palabra a Buscar");
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Resultado Obtenido");
		
		// Validación de resultado esperado
		String urlEsperada = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=shirt&submit_search=";
		String tituloEsperado = "Search - My Store";
		
		Assert.assertEquals(urlEsperada, driver.getCurrentUrl());
		Assert.assertEquals(tituloEsperado, driver.getTitle());
	}
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close();
	}
}
