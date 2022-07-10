package pageobjects;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.logging.Level;

public class ProductsPage extends BasePageObject {

    By btnProduct = By.xpath("//button[@aria-label='Add product']");
    By lblProductNameAndCode = By.xpath("//div[@data-testid='products-list-view']//a[text()='{1}']/ancestor::div[@data-test='cui5-table-row']//div[text()='{2}']");
    By chkSelectAll = By.xpath("//div[contains(@class,'head')]//div[@data-test='cui5-table-checkbox-cell']");
    By icoDelete = By.id("delete");
    By btnDeleteConfirmation = By.xpath("//button/span[text()='Delete']");
    By popUpDeleteConfirmation = By.xpath("//div[contains(@class,'visible')]//div[@data-test='confirmation-dialog']");
    By lblEmptyProducts = By.xpath("//h2[text()='No products added yet']");
    
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForAddProductButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | waitForAddProductButton()");
            waitForElementToBeDisplayed(btnProduct);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | waitForAddProductButton()");
            throw e;
        }
    }
    
    public void clickOnAddProductButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnAddProductButton()");
            driver.findElement(btnProduct).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnAddProductButton()");
            throw e;
        }
    }
    
    public boolean isProductDisplayed(String productName , String productCode) throws Exception {
        try {
            logger.log(Level.INFO, "Start | isProductDisplayed()");
            return driver.findElement(replaceValues(lblProductNameAndCode, productName , productCode)).isDisplayed();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isProductDisplayed()");
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
    
    public boolean isProductsAreEmpty() throws Exception {
        try {
            logger.log(Level.INFO, "Start | isProductsAreEmpty()");
            return isElementDisplayedAfterWaiting(lblEmptyProducts,3000);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isProductsAreEmpty()");
            throw e;
        }
    }
            
}
