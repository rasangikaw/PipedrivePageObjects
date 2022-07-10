package pageobjects;

import org.openqa.selenium.By;
import base.BasePageObject;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;

public class LandingPage extends BasePageObject {

    By linkLogin = By.xpath("//span[contains(text(), 'Log in')]");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLink() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnLoginLink()");
            driver.findElement(linkLogin).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnLoginLink()");
            throw e;
        }
    }
}
