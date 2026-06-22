package pages;
import org.openqa.selenium.By;

public class RegistrationPage {

    public By firstNameField = By.cssSelector("[data-test='first-name']");
    public By lastNameField = By.cssSelector("[data-test='last-name']");
    public By dobField = By.cssSelector("[data-test='dob']");
    public By countryField = By.cssSelector("[data-test='country']");
    public By postalCodeField = By.cssSelector("[data-test='postal_code']");
    public By houseNumberField = By.cssSelector("[data-test='house_number']");
    public By streetField = By.cssSelector("[data-test='street']");
    public By cityField = By.cssSelector("[data-test='city']");
    public By stateField = By.cssSelector("[data-test='state']");
    public By phoneField = By.cssSelector("[data-test='phone']");
    public By emailField = By.cssSelector("[data-test='email']");
    public By passwordField = By.cssSelector("[data-test='password']");
    public By registerBtn = By.cssSelector("[data-test='register-submit']");

    public By loginBtn = By.cssSelector("[data-test='login-submit']");
}