package steps;

import context.TestContext;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;
import pages.RegistrationPage;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.RandomStringUtils;


public class RegisterSteps {


    private final TestContext context;

    public RegisterSteps(TestContext context) {
        this.context = context;
    }

    By signInButton = By.cssSelector("[data-test='nav-sign-in']");

    By registerButton = By.cssSelector("[data-test='register-link']");

    @When("user navigates to login page")
    public void openLogin() {
        context.wait.until(
                ExpectedConditions.elementToBeClickable(signInButton)
        ).click();
    }

    @And("user click register button")
    public void clickRegisterButton(){
        context.wait.until(
                ExpectedConditions.elementToBeClickable(registerButton)
        ).click();
    }

    RegistrationPage registrationPage = new RegistrationPage();



    @And("user fill first name")
    public void fillFirstName() {

        context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        registrationPage.firstNameField
                )
        ).sendKeys("ttt");

    }

    @And("user fill last name")

    public void fillLastName() {

        context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        registrationPage.lastNameField
                )
        ).sendKeys("RRR");

    }

    @And("user fill dob")

    public void fillDob() {

        context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        registrationPage.dobField
                )
        ).sendKeys("2002-02-05");

    }

    @And("user select country")

    public void seletCountry() {

        WebElement countryElement = context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        registrationPage.countryField
                )
        );
        Select select = new Select(countryElement);
        select.selectByVisibleText("Albania");

    }

    @And("user fill postalCode")

    public void seletPostalCode() {

         context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        registrationPage.postalCodeField)
                ).sendKeys("11");
    }


    @And("user fill houseNumber")

    public void fillHouse() {

        context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        registrationPage.houseNumberField)
        ).sendKeys("11");
    }

    @And("user fill street")

    public void fillStreet() {

        context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        registrationPage.streetField)
        ).sendKeys("Street");
    }

    @And("user fill city")

    public void fillCity() {

        context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        registrationPage.cityField)
        ).sendKeys("City");
    }

    @And("user fill state")

    public void fillState() {

        context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        registrationPage.stateField)
        ).sendKeys("Statee");
    }

    @And("user fill phone")

    public void fillPhoneNum() {

        context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        registrationPage.phoneField)
        ).sendKeys("1555555");
    }

    int randomNumber = ThreadLocalRandom.current().nextInt(1000, 10000);
    String randomString = RandomStringUtils.randomAlphabetic(3);
    String  emailAddress = RandomStringUtils.randomAlphabetic(3) + randomNumber + "@gmail.com" ;

    @And("user fill email")
    public void fillEmail() {

        context.email = RandomStringUtils.randomAlphabetic(3)
                + ThreadLocalRandom.current().nextInt(1000, 10000)
                + "@gmail.com";

        WebElement emailInput = context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        registrationPage.emailField
                )
        );

        emailInput.sendKeys(context.email);
    }

    String  password = "Aaaa!!!"+ randomNumber;

    @And("user fill password")
    public void fillPassword() {

        context.password = "Aaaa!!!"
                + RandomStringUtils.randomAlphabetic(3)
                + ThreadLocalRandom.current().nextInt(1000, 10000);

        WebElement passwordInput = context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        registrationPage.passwordField
                )
        );

        passwordInput.sendKeys(context.password);
    }

    @And("user click finish register button")

    public void clickRegisterBtn() {

        context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        registrationPage.registerBtn)
        ).click();
    }

    @And("user enters valid credentials")
    public void validLogin() {

        context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h3[normalize-space()='Login']")
                )
        );

        context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='email']")
                )
        ).sendKeys(context.email);
        context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='password']")
                )
        ).sendKeys(context.password);
    }

    @And("user clicks login button")
    public void submitForm() {

        context.wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("[data-test='login-submit']")
                )
        ).click();
    }

    @Then("my account page is displayed")
    public void loginPageLoaded() {

        WebElement myAccountHeading = context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='page-title']")
                )
        );

        Assert.assertTrue(myAccountHeading.isDisplayed());
    }

}