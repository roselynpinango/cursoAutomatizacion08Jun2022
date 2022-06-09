package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	// Elementos de la página
	@FindBy(css="#email")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement txtContrasenia;
	
	@FindBy(name="SubmitLogin")
	WebElement btnLogin;
	
	@FindBy(linkText="Sign out")
	WebElement lnkSignOut;
	
	// Constructor de la página
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones sobre los elementos
	public void completarEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void completarContrasenia(String contrasenia) {
		txtContrasenia.sendKeys(contrasenia);
	}
	
	public void hacerClicEnLogin() {
		btnLogin.click();
	}
	
	public void completarCredenciales(String email, String contrasenia) {
		txtEmail.sendKeys(email);
		txtContrasenia.sendKeys(contrasenia);
		btnLogin.click();
	}
	
	public void hacerClicEnSignOut() {
		lnkSignOut.click();
	}
}
