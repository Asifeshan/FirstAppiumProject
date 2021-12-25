package page_objects;

import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class Login {
    private static final Logger LOGGER = LogManager.getLogger(Login.class);

    private static final  String UserNameLocator = "test-Username";
    private static final  String PasswordLocator = "test-Password";
    private static final  String LoginLocator = "test-LOGIN";
    private static final  String ErrorText = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView";
    private static final  String ProductHeader = "//android.view.ViewGroup[@content-desc='test-Cart drop zone']/android.view.ViewGroup/android.widget.TextView";

    private AppiumDriver driver;

    public Login(AppiumDriver driver) {
        this.driver = driver;
    }
    public Login enterUserName(String value) {
        driver.findElementByAccessibilityId(UserNameLocator).clear();
        driver.findElementByAccessibilityId(UserNameLocator).sendKeys(value);
        LOGGER.debug("Entered User Name is: " + value);
        return this;
    }

    public Login enterPassword(String value) {
        driver.findElementByAccessibilityId(PasswordLocator).clear();
        driver.findElementByAccessibilityId(PasswordLocator).sendKeys(value);
        LOGGER.debug("Entered Password  is: " + value);
        return this;
    }
    public Login clickOnLoginButton() {
        driver.findElementByAccessibilityId(LoginLocator).click();
        LOGGER.debug("Clicked on Login Button");
        return this;
    }
    public Login unsuccessfulLoginError(String expectedErrorText) {
        String actualErrorText = driver.findElementByXPath(ErrorText).getText();
        LOGGER.debug("Validating login attempt is unsuccessful with invalid credentials");
        Assert.assertEquals(expectedErrorText, actualErrorText);
        return this;
    }
    public Login loginIsSuccessful(String expectedText){
        String actualText = driver.findElementByXPath(ProductHeader).getText();
        LOGGER.debug("Validating login attempt is successful with valid credentials");
        Assert.assertEquals(expectedText, actualText);
        return this;
    }
}
