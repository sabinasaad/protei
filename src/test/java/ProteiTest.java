import base.BaseTest;
import model.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProteiTest extends BaseTest {

    @Test
    public void testLoginHappyPath() {
        MainPage mainPage = new MainPage(getDriver())
                .fillLoginEmailField(getEMAIL())
                .fillPasswordField(getPASSWORD())
                .clickLogInButton();

        Assert.assertTrue(mainPage.isInputSubmitButtonDisplayed());
    }


//    @Test
//    public void testLogInNegativeUpperCasePassword() {
//
//        logIn(URL, EMAIL, PASSWORD.toUpperCase());
//
//        boolean actualResult = getSubmitInputButton().isDisplayed();
//
//        Assert.assertFalse(actualResult);
//    }
//
//    @Test
//    public void verifyLogInErrorMessageWrongPassword() {
//        final String expectedErrorMessage = "Неверный E-Mail или пароль";
//
//        logIn(URL, EMAIL, "wrongpass");
//        String actualErrorMessage = getElementText(id("invalidEmailPassword"));
//
//        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
//    }
//
//    @Test
//    public void verifyLogInErrorMessageNoData() {
//        final String expectedErrorMessage = "Неверный формат E-Mail";//тут можно было бы прописать другое сообщение
//
//        logIn(URL, "", "");
//        String actualErrorMessage = getElementText(id("emailFormatError"));
//
//        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
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
