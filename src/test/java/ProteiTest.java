import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class ProteiTest {

    WebDriver driver;
    final String URL = "https://sabinasaad.github.io/";

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

    @Test
    public void testLoginHappyPath() {
        driver.get(URL);
        driver.findElement(By.id("loginEmail")).sendKeys("test@protei.ru");
        driver.findElement(By.id("loginPassword")).sendKeys("test");
        driver.findElement(By.xpath("//div[@id='authPage']//div/button")).click();
        WebElement element = driver.findElement(By.xpath("//div[@id='inputsPage']//div/button"));
        boolean actualResult = element.isDisplayed();

        Assert.assertTrue(actualResult);
    }
}
