package pageobjects;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.logging.Level;

public class ScheduleAnActivityPage extends BasePageObject {

    By txtActivitySubject = By.xpath("//input[@data-test='activity-subject']");
    By btnMeeting = By.xpath("(//div[contains(@class,'ActivityType')]//*[@href='#icon-sm-ac-meeting']/ancestor::button)[1]");
    By txtPickAEndDate = By.xpath("//span[@data-test='activity-end-date']//input");
    By txtPickAStartDate = By.xpath("//span[@data-test='activity-due-date']//input");
    By txtDueTime = By.xpath("//span[@data-test='activity-due-time']//input");
    By icoTxtDueTimeClear = By.xpath("//span[@data-test='activity-due-time']//*[contains(@class,'icon')]");
    By txtEndTime = By.xpath("//span[@data-test='activity-end-time']//input");
    By icoTxtEndTimeClear = By.xpath("//span[@data-test='activity-end-time']//*[contains(@class,'icon')]");
    By txtAreaNotes = By.xpath("//div[@data-test='activity-note']");
    By btnSave = By.xpath("//div[contains(@class,'visible')]//button/span[contains(text(),'Save')]");

    public ScheduleAnActivityPage(WebDriver driver) {
        super(driver);
    }

    public void enterActivitySubject(String subject) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterActivitySubject()");
            driver.findElement(txtActivitySubject).sendKeys(subject);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterActivitySubject()");
            throw e;
        }
    }

    public void clickOnMeetingButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnMeetingButton()");
            driver.findElement(btnMeeting).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnMeetingButton()");
            throw e;
        }
    }

    public void clickOnEndDateField() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnDateField()");
            Actions actions = new Actions(driver);
            actions.doubleClick(driver.findElement(txtPickAEndDate)).perform();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnDateField()");
            throw e;
        }
    }
    
    public void enterDueTime(String dueTime) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterDueTime()");
            driver.findElement(txtDueTime).click();
            driver.findElement(icoTxtDueTimeClear).click();
            driver.findElement(txtDueTime).sendKeys(dueTime);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterDueTime()");
            throw e;
        }
    }

    public void enterEndTime(String endTime) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterEndTime()");
            driver.findElement(txtEndTime).click();
            driver.findElement(icoTxtEndTimeClear).click();
            driver.findElement(txtEndTime).sendKeys(endTime);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterEndTime()");
            throw e;
        }
    }

    public void enterNote(String note) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterNote()");
            driver.findElement(txtAreaNotes).sendKeys(note);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterNote()");
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
}
