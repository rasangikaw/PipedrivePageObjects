package utils;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Level;

public class CalendarUtil extends BasePageObject {

    By txtPickADate = By.xpath("//span[@data-test='activity-end-date']//input");
    By txtPickAStartDate = By.xpath("//span[@data-test='activity-due-date']//input");
    By txtMonth = By.xpath("//select[contains(@class,'DatePicker-header__month')] | //select[@class='pika-select pika-select-month']");
    By txtYear = By.xpath("//select[contains(@class,'DatePicker-header__year')] | //select[@class='pika-select pika-select-year']");
    By txtDate1 = By.xpath("//div[@aria-label='day-{1}']");
    By txtDate2 = By.xpath("//button[@data-pika-day='{1}']");
    By calenderPopup = By.xpath("//div[@class='pika-single is-bound left-aligned bottom-aligned'] | //div[contains(@class,'react-datepicker-popper')]");

    public CalendarUtil(WebDriver driver) {
        super(driver);
    }

    public void selectMonth(String month) throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectMonth()");
            Select select = new Select(driver.findElement(txtMonth));
            select.selectByVisibleText(month);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectMonth()");
            throw e;
        }
    }

    public void selectYear(String year) throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectYear()");
            Select select = new Select(driver.findElement(txtYear));
            select.selectByVisibleText(year);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectYear()");
            throw e;
        }
    }

    public void clickOnDate(String date) throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnDate()");
            if (isElementDisplayed(replaceValues(txtDate1, date))) {
                driver.findElement(replaceValues(txtDate1, date)).click();
            } else
                driver.findElement(replaceValues(txtDate2, date)).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnDate()");
            throw e;
        }
    }

    public void clickOnDateField() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnDateField()");
            Actions actions = new Actions(driver);
            actions.doubleClick(driver.findElement(txtPickADate)).perform();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnDateField()");
            throw e;
        }
    }

    public boolean isCalenderPopupDisplayed() throws Exception {
        try {
            logger.log(Level.INFO, "Start | isCalenderPopupDissapeared()");
            return isElementDisplayed(calenderPopup);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isCalenderPopupDissapeared()");
            throw e;
        }
    }

    public void clickOnStartDateField() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnStartDateField()");
            Actions actions = new Actions(driver);
            actions.doubleClick(driver.findElement(txtPickAStartDate)).perform();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnStartDateField()");
            throw e;
        }
    }
}
