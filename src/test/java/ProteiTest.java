import base.BaseTest;
import model.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProteiTest extends BaseTest {


    @Test
    public void testLoginHappyPath() {
        Boolean actualResult =
                openURL()
                        .fillLoginEmailField(getEMAIL())
                        .fillPasswordField(getPASSWORD())
                        .clickLogInButton()
                        .isInputSubmitButtonDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testLogInNegativeUpperCasePassword() {
        Boolean actualResult =
                openURL()
                        .fillLoginEmailField(getEMAIL())
                        .fillPasswordField(getPASSWORD().toUpperCase())
                        .clickLogInButton()
                        .isInputSubmitButtonDisplayed();

        Assert.assertFalse(actualResult);
    }


    @Test
    public void verifyLogInErrorMessageWrongPassword() {
        String actualErrorMessage =
                openURL()
                        .logIn(getEMAIL(),"wrongPass")
                        .clickLogInButton()
                        .getInvalidDataMessageText();

        Assert.assertEquals(actualErrorMessage, "Неверный E-Mail или пароль");
    }

//    @Test
//    public void verifyLogInErrorMessageNoData() {
//        String actualErrorMessage =
//                openURL()
//                        .clickLogInButton()
//                        .getInvalidDataMessageText(); wrong locator here
//
//        Assert.assertEquals(actualErrorMessage,"Неверный формат E-Mail");
//    }

//
//    @Test
//    public void testFormE2EHappyPath() {
//        final String expectedSuccessMessage = "Данные добавлены.";
//
//        logIn();
//
//        getElement(id("dataEmail")).sendKeys("youshould@hire.me");
//        getElement(id("dataName")).sendKeys("Sabina");
//
//        Select select = new Select(getElement(id("dataGender")));
//        select.selectByVisibleText("Женский");
//
//        getElement(id("dataCheck11")).click();
//        getElement(id("dataCheck12")).click();
//
//        getElement(id("dataSelect23")).click();
//
//        clickSubmitInputButton();
//
//        WebElement successMessage = new WebDriverWait(driver, Duration.ofMillis(2000))
//                .until(ExpectedConditions
//                        .visibilityOfElementLocated(
//                                xpath("//div[@class='uk-margin uk-modal-content']")));
//
//        String actualSuccessMessage = successMessage.getText();
//
//        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
//    }
//
//    @Test
//    public void verifyEmptyFormErrorMessage() {
//        final String expectedEmptyFormErrorMessage = "Неверный формат E-Mail";
//
//        logIn();
//        clickSubmitInputButton();
//
//        Assert.assertEquals(getElementText(id("emailFormatError")), expectedEmptyFormErrorMessage);
//    }


}
