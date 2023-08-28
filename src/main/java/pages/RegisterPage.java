// Le concept de Page Object Model
// Cette classe va contenir tout nos elements a tester dans cette page
// On va par exemple creer une page pour : Login (a partir de 'my account')
// Une autre pour : Register (a partir de 'my account')

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	// Le consol de Page Object Model
	WebDriver driver;

	// Creer le constructeur de cette methode pour initialiser la variable 'driver'
	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		// La classe 'PageFactory' va mettre tout les webs elements a jour (les
		// reenitialise)
		PageFactory.initElements(driver, this);
	}

	// Creer des web elements privés qui constitue notre page (Register)
	// Utiliser la classe 'FindBy'pour ajouter leurs emplacements
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "error-firstname")
	private WebElement errorFirstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "error-lastname")
	private WebElement errorLastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "error-email")
	private WebElement errorEmailField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "error-password")
	private WebElement errorPasswordField;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyField;

	@FindBy(css = ".btn-primary")
	private WebElement continueButton;

	@FindBy(id = "input-newsletter")
	private WebElement suscribeNewsletter;

	@FindBy(id = "alert")
	private WebElement policyWarning;
	
	@FindBy(xpath="//a[text()='login page']")
	private WebElement loginPageRedirectionLink;

	// On va creer les methodes ci-dessous:
	// (En utilisant le web element déja localisé plus haut)
	public void enterFirstName(String fname) {
		firstNameField.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastNameField.sendKeys(lname);
	}

	public void entrerEmail(String email) {
		emailField.sendKeys(email);
	}

	public void entrerPassword(String passw) {
		passwordField.sendKeys(passw);
	}

	public void selectSubscribe() {
		suscribeNewsletter.click();
	}

	public void agreePolicy() {
		privacyPolicyField.click();
	}

	public void clickOnContinuButton() {
		continueButton.click();
	}
// Ecrire les methodes d'accé aux messages d'erreurs:
	// Recuperer les textes

	public String getFirstNameError() {
		// String firstNameError = errorFirstNameField.getText();
		// return firstNameError;
		// -- 2 eme facon pour ecrire les 2 lignes dessus --
		return errorFirstNameField.getText();
	}

	public String getLaststNameError() {
		return errorLastNameField.getText();

	}

	public String getEmailError() {
		return errorEmailField.getText();

	}

	public String getPasswordError() {
		return errorPasswordField.getText();

	}

	public String getPrivatePolicyError() {
		return policyWarning.getText();

	}
	// Creer une methode (preparation de test) pour la saisie de touts les champs
	// obligatoire de la page

	public void registerWithRequiredFields(String firstname, String lastname, String email, String password) {
		firstNameField.sendKeys(firstname);
		lastNameField.sendKeys(lastname);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		policyWarning.click();
		continueButton.click();

	}

	public void registerWithAlldFields(String firstname, String lastname, String email, String password) {
		firstNameField.sendKeys(firstname);
		lastNameField.sendKeys(lastname);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		suscribeNewsletter.click();
		policyWarning.click();
		continueButton.click();

	}
	public void navigateToLoginPage() {
		
		loginPageRedirectionLink.click();
		
	}
}
