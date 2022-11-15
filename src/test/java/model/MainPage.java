package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy (id = "loginEmail")
    private WebElement loginEmailField;

    @FindBy (id = "loginPassword")
    private WebElement loginPasswordField;

    @FindBy (xpath = "//div[@id='authPage']//div/button")
    private WebElement authSubmitButton;

    @FindBy (id = "invalidEmailPassword")
    private WebElement invalidDataErrorMessage;

    @FindBy (id = "emailFormatError")
    private WebElement emailFormatErrorMessage;

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
