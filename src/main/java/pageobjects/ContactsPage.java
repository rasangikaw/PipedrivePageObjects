package pageobjects;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class ContactsPage extends BasePageObject {

    By btnPeople = By.xpath("//a[@href='/persons/list']");
    By btnOrganizations = By.xpath("//a[@href='/organizations/list']");
    By btnContactTimelines = By.xpath("//a[@href='/persons/timeline']");
    By lblPeopleName = By.xpath("//td[@data-field='name']//a[text()='{1}']");
    By lblOrganizationName = By.xpath("//td[@data-field='org_id']//a[text()='{1}']");
    By chkAllItems = By.xpath("//thead//label[contains(@class,'selectAll')])[1]");
    By chkAllItemsAlternative = By.xpath("//div[contains(@id,'mainview')][not(@style)]//label[contains(@class,'selectAll')]/parent::div");
    By chkAllItemsAlternative2 = By.xpath("//th[contains(@class,'selectAll')]");
    By icoDelete = By.id("delete");
    By btnDeleteConfirmation = By.xpath("//button/span[text()='Delete']");
    By lblEmptyContacts = By.xpath("//h1[text()='No people added yet']");
    By lblEmptyOrganizations = By.xpath("//h1[text()='No organizations added yet']");
    By popUpDeleteConfirmation = By.xpath("//div[contains(@class,'visible')]//div[@data-test='confirmation-dialog']");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnPeopleButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnPeopleButton()");
            driver.findElement(btnPeople).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnPeopleButton()");
            throw e;
        }
    }

    public void clickOnOrganizationsButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnCOrganizationsButton()");
            driver.findElement(btnOrganizations).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnCOrganizationsButton()");
            throw e;
        }
    }

    public boolean isContactNameDisplayed(String contactName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | isContactNameDisplayed()");
            return isElementDisplayed(replaceValues(lblPeopleName,contactName));
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isContactNameDisplayed()");
            throw e;
        }
    }

    public boolean isOrganizationNameDisplayed(String organizationName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | isOrganizationNameDisplayed()");
            return isElementDisplayed(replaceValues(lblOrganizationName,organizationName));
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isOrganizationNameDisplayed()");
            throw e;
        }
    }

    public boolean deleteAllPeople(String organizationName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | deleteAllPeople()");
            return isElementDisplayed(replaceValues(lblOrganizationName,organizationName));
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | deleteAllPeople()");
            throw e;
        }
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

    public boolean isContactsAreEmpty() throws Exception {
        try {
            logger.log(Level.INFO, "Start | isContactsAreEmpty()");
            return isElementDisplayedAfterWaiting(lblEmptyContacts,3000);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnAnyElement()");
            throw e;
        }
    }
    
    public boolean isOrganizationsAreEmpty() throws Exception {
        try {
            logger.log(Level.INFO, "Start | isOrganizationsAreEmpty()");
            return isElementDisplayedAfterWaiting(lblEmptyOrganizations , 3000);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isOrganizationsAreEmpty()");
            throw e;
        }
    }
    
    public List<By> getAllSelectCheckBoxElementList() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getAllSelectCheckBoxElementList()");
            return Arrays.asList(chkAllItems , chkAllItemsAlternative , chkAllItemsAlternative2);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getAllSelectCheckBoxElementList()");
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
    
    public void clickOnAnyElement(By by) throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnAnyElement()");
            driver.findElement(by).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isOrganizationsAreEmpty()");
            throw e;
        }
    }
}
