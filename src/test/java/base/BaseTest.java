package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import model.MainPage;
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

    public WebDriver getDriver() {
        return driver;
    }

    public MainPage openURL() {
        driver.get(URL);

        return new MainPage(getDriver());
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

}
