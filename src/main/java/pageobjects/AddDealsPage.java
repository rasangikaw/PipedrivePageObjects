package pageobjects;

import base.BasePageObject;
import enums.CurrencyEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;

public class AddDealsPage extends BasePageObject {

    By lblAddDeal = By.xpath("//h3[@title='Add deal']");
    By txtContactPerson = By.xpath("//div[contains(@class,'visible')]//*[@href='#icon-sm-person']/parent::*/preceding-sibling::input");
    By txtOrganization = By.xpath("//div[contains(@class,'visible')]//*[@href='#icon-sm-organization']/parent::*/preceding-sibling::input");
    By txtOrganizationValue = By.xpath("//div[contains(@class,'visible')]//*[@href='#icon-sm-organization']/parent::*/preceding-sibling::input[@value='{1}']");
    By txtValue = By.xpath("//div[text()='Value']/parent::div//input");
    By dropDownCurrency = By.xpath("//div[@data-test-key='value']//span[@aria-label='open menu']");
    By txtCurrenctValue = By.xpath("//div[contains(@id,'downshift')]");
    By lblPipelineStage = By.xpath("(//label[contains(@class,'stage-selector')])[{1}]");
    By txtExpectedCloseDate = By.xpath("//div[text()='Expected close date']/parent::div//input");
    By txtPhone = By.xpath("//div[text()='Phone']/parent::div//input");
    By txtEmail = By.xpath("//div[text()='Email']/parent::div//input");
    By btnSave = By.xpath("//span[contains(@class,'AddModal')]//button/span[contains(text(),'Save')]");
    By btnCancel = By.xpath("//div[contains(@class,'AddModal')]//button/span[contains(text(),'Cancel')]");
    By lblDuplicateSuggesion = By.xpath("//div[contains(@id,'downshift')]//div[contains(@class,'name')]");

    public AddDealsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForAddDealPage() throws Exception {
        try {
            logger.log(Level.INFO, "Start | waitForAddDealPage()");
            waitForElementToBeDisplayed(lblAddDeal);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | waitForAddDealPage()");
            throw e;
        }
    }

    public void enterContactPersonName(String personName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterContactPersonName()");
            driver.findElement(txtContactPerson).sendKeys(personName);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterContactPersonName()");
            throw e;
        }
    }

    public void enterOrganizationName(String organizationName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterOrganizationName()");
            driver.findElement(txtOrganization).sendKeys(organizationName);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterOrganizationName()");
            throw e;
        }
    }

    public void enterValue(String value) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterValue()");
            driver.findElement(txtValue).sendKeys(value);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterValue()");
            throw e;
        }
    }

    public void selectCurrency(CurrencyEnum currency) throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectCurrency()");
            driver.findElement(dropDownCurrency).sendKeys(currency.getCurrency());
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectCurrency()");
            throw e;
        }
    }

    public void clickOnCurrencyValue() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnCurrencyValue()");
            driver.findElement(txtCurrenctValue).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnCurrencyValue()");
            throw e;
        }
    }

    public void clickOnPipelineStage(String pipelineId) throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnPipelineStage()");
            driver.findElement(replaceValues(lblPipelineStage, pipelineId)).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnPipelineStage()");
            throw e;
        }
    }

    public void clickOnExpectedCloseDate() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnExpectedCloseDate()");
            driver.findElement(txtExpectedCloseDate).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnExpectedCloseDate()");
            throw e;
        }
    }

    public void enterPhone(String phone) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterPhone()");
            driver.findElement(txtPhone).sendKeys(phone);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterPhone()");
            throw e;
        }
    }

    public void enterEmail(String email) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterEmail()");
            driver.findElement(txtEmail).sendKeys(email);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterEmail()");
            throw e;
        }
    }

    public void clickOnSave() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnSave()");
            driver.findElement(btnSave).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnSave()");
            throw e;
        }
    }

    public boolean isDuplicateContactDropDownDisplayed() throws Exception {
        try {
            logger.log(Level.INFO, "Start | isDuplicateContactDropDownDisplayed()");
            return isElementDisplayedAfterWaiting(lblDuplicateSuggesion, 3000);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isDuplicateContactDropDownDisplayed()");
            throw e;
        }
    }

    public void clickOnDuplicateItemSuggestion() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnDuplicateItemSuggestion()");
            driver.findElement(lblDuplicateSuggesion).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnDuplicateItemSuggestion()");
            throw e;
        }
    }

    public String getFilledOrganizationName() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getFilledOrganizationName()");
            return driver.findElement(txtOrganization).getAttribute("value");
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getFilledOrganizationName()");
            throw e;
        }
    }

    public String getFilledPhoneNumber() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getFilledPhoneNumber()");
            return driver.findElement(txtPhone).getAttribute("value");
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getFilledPhoneNumber()");
            throw e;
        }
    }

    public String getFilledEmail() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getFilledEmail()");
            return driver.findElement(txtEmail).getAttribute("value");
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getFilledEmail()");
            throw e;
        }
    }

    public void waitTillOrganizationFilled(String organization) throws Exception {
        try {
            logger.log(Level.INFO, "Start | waitTillOrganizationFilled()");
            waitForElementToBeDisplayed(replaceValues(txtOrganizationValue, organization));
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | waitTillOrganizationFilled()");
            throw e;
        }
    }

    public void clickCancelButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickCancelButton()");
            driver.findElement(btnCancel).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickCancelButton()");
            throw e;
        }
    }

    public void waitForAddDealPageToDissapear() throws Exception {
        try {
            logger.log(Level.INFO, "Start | waitForAddDealPageToDissapear()");
            waitForElementToDissapear(lblAddDeal);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | waitForAddDealPageToDissapear()");
            throw e;
        }
    }
}
