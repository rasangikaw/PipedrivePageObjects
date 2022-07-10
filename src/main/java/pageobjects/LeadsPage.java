package pageobjects;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class LeadsPage extends BasePageObject {

    By chkSelectAll = By.xpath("//div[contains(@class,'head')]//div[@data-test='cui5-table-checkbox-cell']");
    By icoDelete = By.xpath("//*[@href='#icon-sm-trash']/ancestor::button");
    By btnDeleteConfirmation = By.xpath("//div[contains(@class,'visible')]//button[contains(@data-testid,'dialogDeleteButton')]");
    By popUpDeleteConfirmation = By.xpath("//div[contains(@class,'visible')]//div[contains(@class,'dialog__actions')]");
    By lblLead = By.xpath("//div[contains(@class,'FieldText')][text()='{1}']");
    By lblEmptyLeads = By.xpath("//h3[text()='Take your leads to the next level']");

    public LeadsPage(WebDriver driver) {
        super(driver);
    }

    public void clickDeleteIcon() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickDeleteIcon()");
            driver.findElement(icoDelete).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickDeleteIcon()");
            throw e;
        }
    }

    public void clickConfirmationDeleteButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickConfirmationDeleteButton()");
            driver.findElement(btnDeleteConfirmation).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickConfirmationDeleteButton()");
            throw e;
        }
    }
    
    public void waitForDeleteConfirmationToDissapear() throws Exception {
        try {
            logger.log(Level.INFO, "Start | waiteForDeleteConfirmationToDissapear()");
            waitForElementToDissapear(popUpDeleteConfirmation);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | waiteForDeleteConfirmationToDissapear()");
            throw e;
        }
    }

    public boolean isLeadsAreEmpty() throws Exception {
        try {
            logger.log(Level.INFO, "Start | isContactsAreEmpty()");
            return isElementDisplayedAfterWaiting(lblEmptyLeads , 3000);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnAnyElement()");
            throw e;
        }
    }
    
    public void clickOnSelectAllCheckBox() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnSelectAllCheckBox()");
            driver.findElement(chkSelectAll).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnSelectAllCheckBox()");
            throw e;
        }
    }
        
    public boolean isDeleteIconDisplayed() throws Exception {
        try {
            logger.log(Level.INFO, "Start | isDeleteIconDisplayed()");
            return isElementDisplayedAfterWaiting(icoDelete,3000);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isDeleteIconDisplayed()");
            throw e;
        }
    }
    
    public boolean isLeadDisplayed(String leadName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | isLeadDisplayed()");
            return driver.findElement(replaceValues(lblLead, leadName)).isDisplayed();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isLeadDisplayed()");
            throw e;
        }
    }
}
