package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BasePageObject {

    public WebDriverWait wait;
    public WebDriverWait waitForLessDuration;
    public Logger logger = Logger.getLogger(BasePageObject.class.getName());

    public WebDriver driver;
    private By btnLeftNavItem = By.xpath("//*[@aria-label='{1}']");
    private By icoLoading = By.xpath("//*[@class='cui5-icon cui5-icon--color-primary cui5-icon--size-m cui5-spinner__icon']");

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMillis(80000));
    }

    public void clickOnLeftNavigationItem(String leftNavItem) throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnLeftNavigationItem()");
            waitForElementToBeDisplayed(replaceValues(btnLeftNavItem, leftNavItem));
            driver.findElement(replaceValues(btnLeftNavItem, leftNavItem)).click();
            if (isElementDisplayedAfterWaiting(icoLoading, 4000)) {
                waitForElementToDissapear(icoLoading);
            }
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnLeftNavigationItem()");
            throw e;
        }
    }

    public void waitForLoadingIconToAppearAndDissapear() throws Exception {
        try {
            if (isElementDisplayedAfterWaiting(icoLoading, 4000)) {
                waitForElementToDissapear(icoLoading);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public By replaceValues(By by, String replacement) throws Exception {
        try {
            return By.xpath(by.toString().replace("By.xpath: ", "").replace("{1}", replacement));
        } catch (Exception e) {
            throw e;
        }
    }

    public By replaceValues(By by, String replacement1, String replacement2) throws Exception {
        try {
            return By.xpath(by.toString().replace("By.xpath: ", "").replace("{1}", replacement1).replace("{2}", replacement2));
        } catch (Exception e) {
            throw e;
        }
    }

    public void waitForElementToBeDisplayed(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception ex) {
        }
    }

    public void waitForElementToDissapear(By by) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception ex) {
        }
    }

    public boolean isElementDisplayedAfterWaiting(By by, int timeInMilis) {
        try {
            waitForLessDuration = new WebDriverWait(driver, Duration.ofMillis(timeInMilis));
            waitForLessDuration.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isElementDisplayed(By by) {
        try {
            logger.log(Level.INFO, "Start | isElementDisplayed");
            return driver.findElement(by).isDisplayed();
        } catch (Exception ex) {
            logger.log(Level.INFO, "Fail | isElementDisplayed");
            return false;
        }
    }

    public void dragAndDropElement(WebElement source, WebElement target) {
        try {
            logger.log(Level.INFO, "Start | dragAndDropElement");
            final String java_script =
                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                    "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                    "ction(format,data){this.items[format]=data;this.types.append(for" +
                    "mat);},getData:function(format){return this.items[format];},clea" +
                    "rData:function(format){}};var emit=function(event,target){var ev" +
                    "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                    "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                    "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                    "'drop',tgt);emit('dragend',src);";

            ((JavascriptExecutor) driver).executeScript(java_script, source, target);
        } catch (Exception ex) {
            logger.log(Level.INFO, "Fail | dragAndDropElement");
        }
    }
}
