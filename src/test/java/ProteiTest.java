import base.BaseTest;
import model.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProteiTest extends BaseTest {


    @Test
    public void testLoginHappyPath() {
        boolean actualResult =
                openURL()
                        .fillLoginEmailField(getEMAIL())
                        .fillPasswordField(getPASSWORD())
                        .clickLogInButton()
                        .isInputSubmitButtonDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testLogInNegativeUpperCasePassword() {
        boolean actualResult =
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
                        .logIn(getEMAIL(), "wrongPass")
                        .clickLogInButton()
                        .getInvalidDataMessageText();

        Assert.assertEquals(actualErrorMessage, "Неверный E-Mail или пароль");
    }

    @Test
    public void verifyLogInErrorMessageNoData() {
        String actualErrorMessage =
                openURL()
                        .clickLogInButton()
                        .getEmailFormatErrorText();

        Assert.assertEquals(actualErrorMessage, "Неверный формат E-Mail");
    }


    @Test
    public void testFormE2EHappyPath() {
        openURL()
                .logIn(getEMAIL(), getPASSWORD())
                .fillDataEmailField("youshould@hire.me")
                .fillNameField("Sabina")
                .selectFromDropdown("Женский")
                .clickCheckBox11()
                .clickCheckBox12()
                .clickSelect22()
                .clickInputSubmitButton()
                .waitSuccessMessageToBeVisible(getWait5());


        Assert.assertEquals(new MainPage(getDriver()).getSuccessMessageText(), "Данные добавлены.");

    }

    @Test
    public void verifyEmptyFormErrorMessage() {
        openURL()
                .logIn(getEMAIL(),getPASSWORD())
                .clickInputSubmitButton();

        Assert.assertEquals(new MainPage(getDriver()).getEmailFormatErrorText(), "Неверный формат E-Mail");
    }
}
