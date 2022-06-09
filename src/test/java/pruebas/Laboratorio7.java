package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio7 {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT04May2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite 
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		// Paso 1: hacer clic en Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		// Paso 2: Ingresar las credenciales
		PaginaLogin login = new PaginaLogin(driver);
		login.completarEmail("correo01@mailinator.com");
		login.completarContrasenia("1q2w3e4r5t");
		
		// Paso 3: Hacer clic en el botón
		login.hacerClicEnLogin();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabra("skirt");
		inicio.hacerBusqueda();
	}
}
