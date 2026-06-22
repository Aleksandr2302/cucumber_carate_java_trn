package context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestContext {
    public WebDriver driver;
    public WebDriverWait wait;

    public String email;
    public String password;
}