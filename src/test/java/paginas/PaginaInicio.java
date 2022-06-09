package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	@FindBy(linkText="Sign in")
	WebElement lnkSignIn; 			// Representa el elemento de la página 
	
	@FindBy(id="search_query_top")
	WebElement txtBuscador;
	
	@FindBy(name="submit_search")
	WebElement btnBuscar;
	
	// Definir el constructor de la página
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Método que representa la acción que se puede hacer con el elemento de la página
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void escribirPalabra(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerBusqueda() {
		btnBuscar.click();
	}
}
