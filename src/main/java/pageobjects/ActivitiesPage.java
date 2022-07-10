package pageobjects;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class ActivitiesPage extends BasePageObject {

    By subjectNameAndTime = By.xpath("//td[@data-field='subject']//a[text()='{1}']/ancestor::tr//div[text()='{2}']");
    By chkAllActivities = By.xpath("//thead//label[contains(@class,'selectAll')])[1]");
    By chkAllActivitiesAlternative = By.xpath("//div[contains(@id,'mainview')][not(@style)]//label[contains(@class,'selectAll')]/parent::div");
    By icoDelete = By.id("delete");
    By btnDeleteConfirmation = By.xpath("//button/span[text()='Delete']");
    By popUpDeleteConfirmation = By.xpath("//div[contains(@class,'visible')]//div[@data-test='confirmation-dialog']");
    By lblEmptyActivities = By.xpath("//h1[text()='No activities found']");
    
    public ActivitiesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSheduleActivityTimeDisplayed(String subjectName , String subjectDueDate) throws Exception {
        try {
            logger.log(Level.INFO, "Start | isSheduleActivityTimeDIsplayed()");
            return isElementDisplayed(replaceValues(subjectNameAndTime , subjectName , subjectDueDate ));
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isSheduleActivityTimeDIsplayed()");
            throw e;
        }
    }
    
    public void selectAllEntriesInSubjectsTable() throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectAllEntriesInSubjectsTable()");
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(chkAllActivities));
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectAllEntriesInSubjectsTable()");
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
    
    public boolean isDeleteIconDisplayed() throws Exception {
        try {
            logger.log(Level.INFO, "Start | isDeleteIconDisplayed()");
            return isElementDisplayedAfterWaiting(icoDelete , 2000);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isDeleteIconDisplayed()");
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
    
    public void waitForDeleteConfirmationToDisappear() throws Exception {
        try {
            logger.log(Level.INFO, "Start | waitForDeleteConfirmationToDisappear()");
            waitForElementToDissapear(popUpDeleteConfirmation);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | waitForDeleteConfirmationToDisappear()");
            throw e;
        }
    }
    
    public boolean isActivitiesAreEmpty() throws Exception {
        try {
            logger.log(Level.INFO, "Start | isActivitiesAreEmpty()");
            return isElementDisplayedAfterWaiting(lblEmptyActivities , 3000);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isActivitiesAreEmpty()");
            throw e;
        }
    }
    
    public void clickOnAnyElement(By by) throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnAnyElement()");
            driver.findElement(by).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnAnyElement()");
            throw e;
        }
    }
    
    public List<By> getAllSelectCheckBoxElementList() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getAllSelectCheckBoxElementList()");
            return Arrays.asList(chkAllActivities , chkAllActivitiesAlternative);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getAllSelectCheckBoxElementList()");
            throw e;
        }
    }
    

}
