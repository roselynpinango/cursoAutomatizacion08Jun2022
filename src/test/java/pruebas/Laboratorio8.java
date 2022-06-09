package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio8 {
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
	
	@Test(dataProvider="Obtener Datos Excel del Login")
	public void login(String email, String password) {
		// Paso 1: hacer clic en Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		// Paso 2: Ingresar las credenciales
		PaginaLogin login = new PaginaLogin(driver);
		login.completarEmail(email);
		login.completarContrasenia(password);
		
		// Paso 3: Hacer clic en el botón
		login.hacerClicEnLogin();
		
		// Comprobación de si el usuario pudo iniciar sesión
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
		
		// Si el usuario pudo iniciar sesión, la cerramos para dejar la prueba en el punto inicial
		login.hacerClicEnSignOut();
	}
	
	@DataProvider(name="Obtener Datos Excel del Login")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionIT04May2022\\Datos\\DatosLogin.xlsx", "Hoja1");
	}
	
	@DataProvider(name="Datos del Login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[3][2];
		
		// Completar las combinaciones de datos para probar el login
		datos[0][0] = "abc@correo.com";
		datos[0][1] = "1234";
		
		datos[1][0] = "def@correo.com";
		datos[1][1] = "1q2w3e4r5t";
		
		datos[2][0] = "ghi@correo.com";
		datos[2][1] = "$#&$%&$#$";
		
		return datos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
