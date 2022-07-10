package pageobjects;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Level;

public class DealsPage extends BasePageObject {

    By btnDeal = By.xpath("//button[@aria-label='Add deal']");
    By btnTriangle = By.xpath("//span[text()='{1}']//ancestor::div[@draggable]//div[contains(@data-test,'activity-status-indicator')]");
    By btnScheduleAnActivity = By.xpath("//div[contains(@class,'popover')]//div[contains(@class,'option')]");
    By pipelineStage = By.xpath("//div[text()='{1}']//ancestor::div[contains(@data-test,'stage')]//div [@data-test='deals-list']/parent::div");
    By lblDealName = By.xpath("//span[text()='{1}']//ancestor::div[@draggable='true']/div");
    By lblDealCreatedMessage = By.xpath("//p[contains(@class,'snackbar__message')]");
    By dealView = By.xpath("//div[@data-test='pipeline-view']");
    By lblDeal = By.xpath("(//div[@data-test='pipeline-deal-tile'])[1]");
    By deleteDealSection = By.xpath("//div[@data-test='deal-actions-delete']");
    By lostDealSection = By.xpath("//div[@data-test='deal-actions-lost']");
    By wonDealSection = By.xpath("//div[@data-test='deal-actions-won']");
    By moveConvertDealSection = By.xpath("//div[@data-test='deal-actions-move']");
    By txtDealOrganizationName = By.xpath("//span[text()='{1}']/following-sibling::div");
    By txtDealValue = By.xpath("//span[text()='{1}']/ancestor::div[1]//div[@data-test='pipeline-deal-value']");
    By txtLostReason = By.xpath("//input[contains(@data-test,'lost-popover')]");
    By btnMarkAsLost = By.xpath("//button/span[text()='Mark as lost']");
    By lostConfirmationPopup = By.xpath("//div[@data-test='deal-actions-lost-popover']//div[text()='Mark as lost']");
    By cmbSaveTo = By.xpath("//div[@role='combobox'][contains(@data-test,'select-target')]");
    By cmbOptionConvertToDeal = By.xpath("//div[@value='lead']/span");
    By btnSaveDealToLeadConvert = By.xpath("//div[@data-test='deal-actions-move-popover']//button/span[contains(text(),'Save')]");
    By cmbFilter = By.xpath("//button[@data-test='filter-menu-button']");
    By cmbFilterOption = By.xpath("//div[contains(@class,'styles__listItem_')]//div[text()='{1}']");
    By btnConvertDeal = By.xpath("//button[@data-testid='ConvertModalConfirm']//span[text()='Convert deal']");
    By btnEditPipeline = By.xpath("//button[@data-coachmark='pipeline-select']");
    By btnDeletePipeline = By.xpath("//button[@data-test='delete-pipeline-button']");
    By txtPipeNewLineName = By.xpath("//div[@data-test='pipeline-view']//input[contains(@value,'{1}')]");
    By btnSavePipeline = By.xpath("//button[@data-coachmark='save-stage']");
    By cmbPipeline = By.xpath("//button[@data-test='pipeline-select']");
    By cmbCreateNewPipeline = By.xpath("//div[@data-test='create-pipeline-settings']");
    By popUpPipeLineDeleteConfirmation = By.xpath("//div[@data-test='delete-pipeline-dialog']");
    By btnDeletePipelineConfirmation = By.xpath("//div[contains(@class,'visible')]//button//span[text()='Delete pipeline']");
    By cmbPipelineOption = By.xpath("//div[contains(@class,'cui5-dropmenu__content')]//div[text()='{1}']");
    By rdbDeleteDeals = By.xpath("//span[contains(@class,'radio')]/following-sibling::span[text()='Delete deals']");
    By btnClose = By.xpath("//span[contains(text(),'Back to Quick Help')]/parent::div//button");
    By btnCancel = By.xpath("//button[@data-test='cancel-edit-pipeline']/span[text()='Cancel']");
    By lnkFilters = By.xpath("//span[text()='Filters']");
    By lblDealInStage = By.xpath("//div[text()='{1}']//ancestor::div[contains(@data-test , 'stage')]//div[@data-test='deals-list']//span[text()='{2}']");
    By lblDealsEmptyMessage = By.xpath("//div[@data-test='no-deals-content']//div[text()='No deals found to match your criteria']");

    public DealsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDealsPageEmpty() throws Exception {
        try {
            logger.log(Level.INFO, "Start | isDealsPageEmpty()");
            return driver.findElement(lblDealsEmptyMessage).isDisplayed();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isDealsPageEmpty()");
            throw e;
        }
    }

    public void waitForDeleteConfirmationToDissapear() throws Exception {
        try {
            logger.log(Level.INFO, "Start | waiteForDeleteConfirmationToDissapear()");
            waitForElementToDissapear(popUpPipeLineDeleteConfirmation);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | waiteForDeleteConfirmationToDissapear()");
            throw e;
        }
    }

    public boolean isDealDisplayedUnderStage(String dealName , String stageName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | isDealDisplayedUnderStage()");
            return driver.findElement(replaceValues(lblDealInStage , stageName ,dealName)).isDisplayed();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isDealDisplayedUnderStage()");
            throw e;
        }
    }

    public void clickOnPipelineDeleteConfirmationButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnPipelineDeleteConfirmationButton()");
            driver.findElement(btnDeletePipelineConfirmation).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnPipelineDeleteConfirmationButton()");
            throw e;
        }
    }

    public void waitForAddDealButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | waitForAddDealButton()");
            waitForElementToBeDisplayed(btnDeal);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | waitForAddDealButton()");
            throw e;
        }
    }

    public void clickOnDeal(String dealName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnDeal()");
            driver.findElement(replaceValues(lblDealName, dealName)).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnDeal()");
            throw e;
        }
    }

    public void clickOnAddDealButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnAddDealButton()");
            driver.findElement(btnDeal).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnAddDealButton()");
            throw e;
        }
    }

    public void waitForTriangleButton(String dealName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | waitForTriangleButton()");
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(replaceValues(btnTriangle, dealName)));
            waitForElementToBeDisplayed((replaceValues(btnTriangle, dealName)));
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | waitForTriangleButton()");
            throw e;
        }
    }

    public void clickOnTriangleButton(String dealName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnTriangleButton()");
            driver.findElement(replaceValues(btnTriangle, dealName)).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnTriangleButton()");
            throw e;
        }
    }

    public void clickOnScheduleAnActivity() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnScheduleAnActivity()");
            driver.findElement(btnScheduleAnActivity).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnScheduleAnActivity()");
            throw e;
        }
    }

    public void dragAndDropDealToStage(String dealName, String stageName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | dragAndDropDealToStage()");
            WebElement source = driver.findElement(replaceValues(btnTriangle, dealName));
            WebElement target = driver.findElement(replaceValues(pipelineStage, stageName));
            dragAndDropElement(source, target);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | dragAndDropDealToStage()");
            throw e;
        }
    }

    public void dragAndDropFirstDealDelete() throws Exception {
        try {
            logger.log(Level.INFO, "Start | dragAndDropFirstDealDelete()");
            WebElement source = driver.findElement(lblDeal);
            WebElement target = driver.findElement(deleteDealSection);
            dragAndDropElement(source, target);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | dragAndDropFirstDealDelete()");
            throw e;
        }
    }

    public String getDealConfirmationMessage() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getDealConfirmationMessage()");
            return driver.findElement(lblDealCreatedMessage).getText();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getDealConfirmationMessage()");
            throw e;
        }
    }

    public int getDealCountInPage() throws Exception {
        try {
            logger.log(Level.INFO, "Start | getDealCountInPage()");
            return driver.findElement(dealView).findElements(By.xpath("//div[@draggable='true']")).size();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getDealCountInPage()");
            throw e;
        }
    }

    public void clickOnFirstDeal() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnFirstDeal()");
            driver.findElement(lblDeal).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnFirstDeal()");
            throw e;
        }
    }

    public boolean isDealsAvailable() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnFirstDeal()");
            return isElementDisplayed(lblDeal);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnFirstDeal()");
            throw e;
        }
    }

    public String getDealOrganizationInCardView(String dealTitle) throws Exception {
        try {
            logger.log(Level.INFO, "Start | getDealOrganizationInCardView()");
            return driver.findElement(replaceValues(txtDealOrganizationName, dealTitle)).getText();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getDealOrganizationInCardView()");
            throw e;
        }
    }

    public String getDealValueInCardView(String dealTitle) throws Exception {
        try {
            logger.log(Level.INFO, "Start | getDealValueInCardView()");
            return driver.findElement(replaceValues(txtDealValue, dealTitle)).getText();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getDealValueInCardView()");
            throw e;
        }
    }

    public void waitForDealCreationMessageToDisplay() throws Exception {
        try {
            logger.log(Level.INFO, "Start | waitForDealCreationMessageToDisplay()");
            waitForElementToBeDisplayed(lblDealCreatedMessage);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | waitForDealCreationMessageToDisplay()");
            throw e;
        }
    }

    public void dragAndDropDealToLost(String dealName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | dragAndDropDealToLost()");
            WebElement source = driver.findElement(replaceValues(lblDealName, dealName));
            WebElement target = driver.findElement(lostDealSection);
            dragAndDropElement(source, target);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | dragAndDropDealToLost()");
            throw e;
        }
    }

    public void dragAndDropDealToWon(String dealName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | dragAndDropDealToWon()");
            WebElement source = driver.findElement(replaceValues(lblDealName, dealName));
            WebElement target = driver.findElement(wonDealSection);
            dragAndDropElement(source, target);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | dragAndDropDealToWon()");
            throw e;
        }
    }

    public void dragAndDropDealToMoveOrconvert(String dealName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | dragAndDropDealToMoveOrconvert()");
            WebElement source = driver.findElement(replaceValues(lblDealName, dealName));
            WebElement target = driver.findElement(moveConvertDealSection);
            dragAndDropElement(source, target);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | dragAndDropDealToMoveOrconvert()");
            throw e;
        }
    }

    public void waitForDealLostPopup() throws Exception {
        try {
            logger.log(Level.INFO, "Start | waitForDealCreationMessageToDisplay()");
            waitForElementToBeDisplayed(lostConfirmationPopup);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | waitForDealCreationMessageToDisplay()");
            throw e;
        }
    }

    public void clickOnDealToLeadConvertDropDown() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnDealToLeadConvertDropDown()");
            driver.findElement(cmbSaveTo).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnDealToLeadConvertDropDown()");
            throw e;
        }
    }

    public void selectConvertDealToLead() throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectConvertDealToLead()");
            driver.findElement(cmbOptionConvertToDeal).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectConvertDealToLead()");
            throw e;
        }
    }

    public void selectSaveForConvertDealToLead() throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectSaveForConvertDealToLead()");
            driver.findElement(btnSaveDealToLeadConvert).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectSaveForConvertDealToLead()");
            throw e;
        }
    }

    public void clickOnDealFilterDropDown() throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectSaveForConvertDealToLead()");
            driver.findElement(cmbFilter).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectSaveForConvertDealToLead()");
            throw e;
        }
    }

    public void clickOnFiltersLink() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnFiltersLink()");
            driver.findElement(lnkFilters).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnFiltersLink()");
            throw e;
        }
    }

    public void selectFilterOption(String filter) throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectSaveForConvertDealToLead()");
            driver.findElement(replaceValues(cmbFilterOption, filter)).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectSaveForConvertDealToLead()");
            throw e;
        }
    }

    public void enterLostReason(String reason) throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectSaveForConvertDealToLead()");
            driver.findElement(txtLostReason).sendKeys(reason);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectSaveForConvertDealToLead()");
            throw e;
        }
    }

    public boolean isDealDisplayed(String dealName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectSaveForConvertDealToLead()");
            return driver.findElement(replaceValues(lblDeal, dealName)).isDisplayed();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectSaveForConvertDealToLead()");
            throw e;
        }
    }

    public void clickMarkAsLostInLostConfirmPopup() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickMarkAsLostInLostConfirmPopup()");
            driver.findElement(btnMarkAsLost).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickMarkAsLostInLostConfirmPopup()");
            throw e;
        }
    }

    public void clickConvertDealConfirmationButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickConvertDealConfirmationButton()");
            driver.findElement(btnConvertDeal).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickConvertDealConfirmationButton()");
            throw e;
        }
    }

    public void clickOnEditPipeLine() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnEditPipeLine()");
            driver.findElement(btnEditPipeline).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnEditPipeLine()");
            throw e;
        }
    }

    public void enterNewPipeLineName(String pipelineName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | enterNewPipeLineName()");
            driver.findElement(replaceValues(txtPipeNewLineName, "New pipeline")).clear();
            driver.findElement(replaceValues(txtPipeNewLineName, "New pipeline")).sendKeys(pipelineName);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | enterNewPipeLineName()");
            throw e;
        }
    }

    public void clickOnSavePipeline() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnSavePipeline()");
            driver.findElement(btnSavePipeline).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnSavePipeline()");
            throw e;
        }
    }

    public void clickOnPipelineDropDown() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnPipelineDropDown()");
            driver.findElement(cmbPipeline).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnPipelineDropDown()");
            throw e;
        }
    }

    public void clickCreateNewPipelineFromDropDown() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickCreateNewPipelineFromDropDown()");
            driver.findElement(cmbCreateNewPipeline).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickCreateNewPipelineFromDropDown()");
            throw e;
        }
    }

    public void clickOnDeletePipeline() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnDeletePipeline()");
            driver.findElement(btnDeletePipeline).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnDeletePipeline()");
            throw e;
        }
    }

    public void selectPipelineFromDropDown(String pipelineName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectPipelineFromDropDown()");
            driver.findElement(replaceValues(cmbPipelineOption, pipelineName)).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectPipelineFromDropDown()");
            throw e;
        }
    }

    public boolean isPipelineDisplayed(String pipelineName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | isPipelineDisplayed()");
            return isElementDisplayed(replaceValues(cmbPipelineOption, pipelineName));
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isPipelineDisplayed()");
            throw e;
        }
    }

    public void selectDeleteDealsRadioButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | selectDeleteDealsRadioButton()");
            driver.findElement(rdbDeleteDeals).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | selectDeleteDealsRadioButton()");
            throw e;
        }
    }

    public boolean isDeleteDealsRadioButtonDisplayed() throws Exception {
        try {
            logger.log(Level.INFO, "Start | isDeleteDealsRadioButtonDisplayed()");
            return isElementDisplayedAfterWaiting(rdbDeleteDeals, 2000);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isDeleteDealsRadioButtonDisplayed()");
            throw e;
        }
    }

    public boolean isCloseButtonDisplayed() throws Exception {
        try {
            logger.log(Level.INFO, "Start | isCloseButtonDisplayed()");
            return isElementDisplayed(btnClose);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | isCloseButtonDisplayed()");
            throw e;
        }
    }

    public void clickOnCloseButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnCloseButton()");
            driver.findElement(btnClose).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnCloseButton()");
            throw e;
        }
    }

    public boolean istPipeLineNameDisplayed(String pipelineName) throws Exception {
        try {
            logger.log(Level.INFO, "Start | getPipeLineName()");
            return isElementDisplayed((replaceValues(txtPipeNewLineName, pipelineName)));
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | getPipeLineName()");
            throw e;
        }
    }

    public void clickOnCancelButton() throws Exception {
        try {
            logger.log(Level.INFO, "Start | clickOnCancelButton()");
            driver.findElement(btnCancel).click();
        } catch (Exception e) {
            logger.log(Level.INFO, "Fail | clickOnCancelButton()");
            throw e;
        }
    }
}
