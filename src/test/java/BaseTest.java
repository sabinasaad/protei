import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    final String URL = "https://sabinasaad.github.io/";
    final String EMAIL = "test@protei.ru";
    final String PASSWORD = "test";
    WebDriver driver;

    @BeforeClass
    void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    void quit() {
        driver.quit();
    }

    public WebElement getElement(By by) {
        return driver.findElement(by);

    }

    public String getElementText(By by) {

        return getElement(by).getText();

    }

    public void logIn(String url, String email, String password) {
        driver.get(url);
        driver.findElement(By.id("loginEmail")).sendKeys(email);
        driver.findElement(By.id("loginPassword")).sendKeys(password);
        clickAuthButton();
    }

    public void logIn() {
        logIn(URL, EMAIL, PASSWORD);
    }

    public WebElement getAuthButton() {
        return getElement(By.xpath("//div[@id='authPage']//div/button"));
    }

    public void clickAuthButton() {
        getAuthButton().click();
    }

    public WebElement getSubmitInputButton() {
        return getElement(By.xpath("//div[@id='inputsPage']//div/button"));
    }

    public void clickSubmitInputButton() {
        getSubmitInputButton().click();
    }
}
