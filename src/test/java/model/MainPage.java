package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    //auth page
    @FindBy(id = "loginEmail")
    private WebElement loginEmailField;

    @FindBy(id = "loginPassword")
    private WebElement loginPasswordField;

    @FindBy(xpath = "//div[@id='authPage']//button")
    private WebElement authSubmitButton;

    @FindBy(id = "invalidEmailPassword")
    private WebElement invalidDataErrorMessage;

    @FindBy(id = "emailFormatError")
    private WebElement emailFormatErrorMessage;

    //inputs page
    @FindBy(id = "dataEmail")
    private WebElement dataEmailField;

    @FindBy(id = "dataName")
    private WebElement dataNameField;

    @FindBy(id = "dataCheck11")
    private WebElement checkBox11;

    @FindBy(id = "dataCheck12")
    private WebElement checkBox12;

    @FindBy(id = "dataSelect21")
    private WebElement select21;

    @FindBy(id = "dataSelect22")
    private WebElement select22;

    @FindBy(id = "dataSelect23")
    private WebElement select23;

    @FindBy(xpath = "//div[@id='inputsPage']//button")
    private WebElement inputSubmitButton;

    @FindBy(xpath = "//div[@class='uk-margin uk-modal-content']")
    private WebElement successMessage;


    public MainPage(WebDriver driver) {
        super(driver);
    }
}
