package pageobjects;

import base.BasePageObject;
import enums.CurrencyEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;

public class AddProductsPage extends BasePageObject {

	By dropDownCurrency = By.xpath("//div[text()='Unit prices']/parent::div//span[@aria-label='open menu']");
    By lblAddProduct = By.xpath("//h3[@title='Add product']");
    By lblCategoryName = By.xpath("//span[text()='{1}']");
    By txtProductName = By.xpath("//div[text()='Name']/parent::div//input");
    By txtProductCode = By.xpath("//div[text()='Product code']/parent::div//input");
    By cmbProductCategory = By.xpath("//span[text()='Select category']/parent::span");
    By txtProductCategory = By.xpath("//span[text()='Select category']/parent::span/preceding-sibling::div//input");
    By txtUnit = By.xpath("//div[text()='Unit']/parent::div//input");
    By txtUnitPrices = By.xpath("//div[text()='Unit prices']/parent::div//input");
    By txtCurrenctValue = By.xpath("//div[contains(@id,'downshift')]/span[text()='{1}']");
    By txtProducttax = By.xpath("//div[text()='Tax %']/parent::div//input");
    By btnSave = By.xpath("//span[contains(@class,'AddModal')]//button/span[contains(text(),'Save')]");
    By btnCancel = By.xpath("//div[contains(@class,'AddModal')]//button/span[contains(text(),'Cancel')]");

    public AddProductsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForAddProductPage() throws Exception {
        try {
            logger.log(Level.INFO, "Start | waitForAddProductPage()");
            waitForElementToBeDisplayed(lblAddProduct);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | waitForAddProductPage()");
            throw e;
        }
    }
   
    public void enterProductName(String productName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterProductName()");
            driver.findElement(txtProductName).sendKeys(productName);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterProductName()");
            throw e;
        }
    }

    public void enterProductCode(String productCode) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterProductCode()");
            driver.findElement(txtProductCode).sendKeys(productCode);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterProductCode()");
            throw e;
        }
    }
    
    public void clickOnCategoryDropDown() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnCategoryDropDown()");
            driver.findElement(cmbProductCategory).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnCategoryDropDown()");
            throw e;
        }
    }
    
    public void enterCategory(String categoryName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterCategory()");
            driver.findElement(txtProductCategory).sendKeys(categoryName);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterCategory()");
            throw e;
        }
    }
    
    public void clickOnCategoryNameInDropDown(String categoryName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickAddCategoryAsNewCategory()");
            driver.findElement(replaceValues(lblCategoryName, categoryName)).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickAddCategoryAsNewCategory()");
            throw e;
        }
    }
    
    public void clickAddCategory() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickAddCategory()");
            
            driver.findElement(cmbProductCategory).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickAddCategory()");
            throw e;
        }
    }

    public void enterUnitsCount(String unitCount) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterUnitsCount()");
            driver.findElement(txtUnit).sendKeys(unitCount);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterUnitsCount()");
            throw e;
        }
    }
    
    public void enterUnitPrice(String unitPrice) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterUnitPrice()");
            driver.findElement(txtUnitPrices).sendKeys(unitPrice);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterUnitPrice()");
            throw e;
        }
    }

    public void selectCurrency(CurrencyEnum currency) throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectCurrency()");
            driver.findElement(replaceValues(txtCurrenctValue, currency.getCurrency())).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectCurrency()");
            throw e;
        }
    }

    public void clickOnCurrencyDropDown() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnCurrencyValue()");
            driver.findElement(dropDownCurrency).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnCurrencyValue()");
            throw e;
        }
    }
    
    public void enterTax(String tax) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterTax()");
            driver.findElement(txtProducttax).sendKeys(tax);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterTax()");
            throw e;
        }
    }
    
    public void clickOnSave() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnSave");
            driver.findElement(btnSave).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnSave()");
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
    
}
