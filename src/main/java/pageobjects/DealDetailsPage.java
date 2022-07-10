package pageobjects;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;

public class DealDetailsPage extends BasePageObject {

    By btnDealOptions = By.xpath("//div[contains(@id,'mainview')][not(@style)]//span[@class='input selectSettings']/button[contains(@id,'pipeButton')]");
    By btnOptionInDeal = By.xpath("//span[@class='action'][text()='{1}']");
    By lnkAddProducts = By.linkText("Add products");
    By lnkProductCount = By.xpath("//span[@class='productCount']");

    public DealDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnDealOptionButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnDealOptionButton()");
            driver.findElement(btnDealOptions).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnDealOptionButton()");
            throw e;
        }
    }

    public void clickOnOptioninDealOptionsDropDown(String dealOption) throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnOptioninDealOptionsDropDown()");
            driver.findElement(replaceValues(btnOptionInDeal, dealOption)).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnOptioninDealOptionsDropDown()");
            throw e;
        }
    }

    public void clickAddProductLink() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickAddProductLink()");
            driver.findElement(lnkAddProducts).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickAddProductLink()");
            throw e;
        }
    }

    public String getAddedProductCount() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getAddedProductCount()");
            waitForElementToBeDisplayed(lnkProductCount);
            return driver.findElement(lnkProductCount).getText();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getAddedProductCount()");
            throw e;
        }
    }

}
