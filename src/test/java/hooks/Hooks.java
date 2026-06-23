package hooks;

import context.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    private final TestContext context;

    public Hooks(TestContext context) {  // PicoContainer сам передаст
        this.context = context;
    }

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("autofill.profile_enabled", false);

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        options.setExperimentalOption("prefs", prefs);

        context.driver = new ChromeDriver(options);
        context.wait = new WebDriverWait(context.driver, Duration.ofSeconds(20));
    }

    @After
    public void teardown(Scenario scenario) {

//        if (scenario.isFailed()) {
//
//            byte[] screenshot = ((TakesScreenshot) context.driver)
//                    .getScreenshotAs(OutputType.BYTES);
//
//            scenario.attach(screenshot, "image/png", "failed screenshot");
//        }

        if (context.driver != null) {
            context.driver.quit();
        }
    }
}