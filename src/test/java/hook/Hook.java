package hook;

import Factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hook {

    private WebDriver driver;

    @Before
    public void abrirDriver() {
        driver = DriverFactory.initializeDriver();
    }

    @After
    public void fecharDriver() {
        if (driver != null) {
            driver.quit();
        }

    }
}
