package pageobjects;

import base.BasePageObject;
import enums.CurrencyEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;

public class AddProductsToDealPage extends BasePageObject {

    By lblAddProductsToDeal = By.xpath("//div[contains(@class,'visible')]//h3[contains(@title,'Add products to deal')]");
    By productSearchTextBox = By.xpath("//span[text()='Start typing to search...']");
    By txtProductName = By.xpath("//span[text()='Start typing to search...']");
    By productNameInDropDown = By.xpath("//span[text()='{1} : {2}']");
    By btnSave = By.xpath("//div[contains(@class,'visible')]//span[text()='Save']");
	By dropDownCurrency = By.xpath("//div[contains(@class,'visible')]//div[@id='currency-select']");
    By txtCurrenctValue = By.xpath("//div[contains(@id,'downshift')]/span[text()='{1}']");

    public AddProductsToDealPage(WebDriver driver) {
        super(driver);
    }

    public void waitForAddProductsToDealPage() throws Exception {
        try {
            logger.log(Level.INFO, "Start | waitForAddProductsToDealPage()");
            waitForElementToBeDisplayed(lblAddProductsToDeal);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | waitForAddProductsToDealPage()");
            throw e;
        }
    }
    
    public void clickOnProductSearchTextBox() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnProductSearchTextBox()");
            driver.findElement(productSearchTextBox).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnProductSearchTextBox()");
            throw e;
        }
    }
    
    public void selectProductFromDropDown(String productName , String productCode) throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectProductFromDropDown()");
            driver.findElement(replaceValues(productNameInDropDown, productName , productCode)).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectProductFromDropDown()");
            throw e;
        }
    }

    public void clickSaveButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickSaveButton()");
            driver.findElement(btnSave).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickSaveButton()");
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
   
    
}
