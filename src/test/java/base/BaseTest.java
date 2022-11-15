package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    final private String URL = "https://sabinasaad.github.io/";
    final private String EMAIL = "test@protei.ru";
    final private String PASSWORD = "test";
    private WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }

    protected void openURL() {
        driver.get(URL);
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    @BeforeClass
    void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setupTest() {
        driver = new ChromeDriver();
        openURL();
    }

    @AfterMethod
    void quit() {
        driver.quit();
    }
}
