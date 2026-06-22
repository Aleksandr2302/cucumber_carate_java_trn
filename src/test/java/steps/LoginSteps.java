package steps;

import context.TestContext;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;

public class LoginSteps {

    private final TestContext context;

    public LoginSteps(TestContext context) {
        this.context = context;
    }

    @Given("user opens the site")
    public void openSite() {
        context.driver.get("https://practicesoftwaretesting.com/");
    }

    @Then("page is loaded")
    public void pageLoaded() {
        Assert.assertTrue(
                context.driver.findElement(By.cssSelector("body")).isDisplayed()
        );
    }
}

//    By signInButton = By.cssSelector("[data-test='nav-sign-in']");
//
//    @When("user navigates to login page")
//    public void openLogin() {
//        context.wait.until(
//                ExpectedConditions.elementToBeClickable(signInButton)
//        ).click();
//    }
//
//    @When("user enters valid credentials")
//    public void validLogin() {
//        context.wait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                        By.cssSelector("[data-test='email']")
//                )
//        ).sendKeys("ttt@gmail.com");
//        context.wait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                        By.cssSelector("[data-test='password']")
//                )
//        ).sendKeys("Aaaaaaa!23@@@@@@@11");
//    }
//
//    @When("user clicks login button")
//    public void submitForm() {
//        context.driver.findElement(
//                By.cssSelector("[data-test='login-submit']")
//        ).click();
//    }
//
//    @Then("Account is displayed")
//    public void accountIsDisplayed() {
//        WebElement title = context.wait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                        By.cssSelector("[data-test='page-title']")
//                )
//        );
//        Assert.assertEquals("My account", title.getText());
//    }
//}