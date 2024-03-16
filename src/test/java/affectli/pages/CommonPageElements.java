package affectli.pages;

import affectli.utilities.CommonSteps;
import affectli.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import affectli.utilities.Driver;

import java.util.List;
import java.util.Random;

public abstract class CommonPageElements extends Driver {
    public CommonPageElements(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-tut=\"reactour__profile\"]")
    public WebElement profileBtn;

    @FindBy(xpath = "//span[.='Logout']")
    public WebElement logoutBtn;

    @FindBy(css = "[data-tut=\"reactour__launcher\"]")
    public WebElement appLauncherBtn;

    @FindBy(css = "[data-tut=\"reactour__help\"]")
    public WebElement helpBtn;

    @FindBy(css = "[data-tut=\"reactour__navbar\"]")
    public WebElement hamburgerMenuBtn;

    @FindBy(css = "[data-tut=\"reactour__magicplus\"]")
    public WebElement createNewBtn;

    @FindBy(css = "[data-tut=\"reactour__home\"]")
    public WebElement homeBtn;

    @FindBy(css = "[href=\"#/entities\"]")
    public WebElement entitiesBtn;

    @FindBy(css = "[href=\"#/related-entities\"]")
    public WebElement relatedEntitiesBtn;

    @FindBy(css = "[href=\"#/abox/background-jobs\"]")
    public WebElement backgroundJobsBtn;

    @FindBy(css = "[href=\"https://affectli.com\"]")
    public WebElement goToAffectliComBtn;

    @FindBy(id = "notistack-snackbar")
    public WebElement popupLocator;

    @FindBy(xpath = "//div[@id=\"notistack-snackbar\"]//..//span[@class=\"MuiIconButton-label\"]")
    public WebElement popupCloseButton;

    @FindBy(xpath = "//span[contains(text(),'Yes')]//..")
    public WebElement confirmationPopupYesButton;

    @FindBy(xpath = "//span[contains(text(),'No')]//..")
    public WebElement confirmationPopupNoButton;

    @FindBy(xpath = "//*[@id='menu-list-grow']//div[contains(@class,'MuiListItem-root')]")
    public List<WebElement> listOfDropdownItemsAfterClickingDropdown;

    public void goToAModuleFromAppLauncher(String moduleName){
        appLauncherBtn.click();
        driver.findElement(By.xpath("//h6[contains(.,'"+moduleName+"')]//..//i")).click();
        Log.info("Navigated to the \""+moduleName+"\" module from App Launcher.");
    }

    public void goToDashboard(){
        homeBtn.click();
        Log.info("Navigated to the \"Dashboard\".");
    }

    public void goToModuleFromDashboardTopNavBar(String module){
        driver.findElement(By.xpath("(//div[contains(@title,'"+module+"')])[2]")).click();
        Log.info("Navigated to the \""+module+"\" module from dashboard top navigation bar.");
    }

    public boolean isLabelVisible(String label){
        return driver.findElement(By.xpath("//label[contains(text(),'"+label+"')]")).isDisplayed();
    }

    public void clickOnDropdownByLabel(String dropdownLabel){
        CommonSteps.waitFor(1);
        driver.findElement(By.xpath("//label[text()='"+dropdownLabel+"']//..//input")).click();
    }

    public void clickOnAButton(String buttonText){
        driver.findElement(By.xpath("//span[contains(text(),'"+buttonText+"')]//..//..//button")).click();
    }

    public String getPopupMessage(){
        CommonSteps.waitForVisibility(popupLocator, 10);
        String popupMessage = popupLocator.getText();
        Log.info("\""+popupMessage+"\" popup message appeared.");
        return popupMessage;
    }

    public void enterATextIntoATextarea(String textareaLabel, String textToEnter){
        clickOnCloseButtonOfAnArea("Resolution");
        CommonSteps.waitFor(1);
        CommonSteps.waitForClickability(driver.findElement(By.xpath("//label[contains(text(),'"+textareaLabel+"')]//..//div")), 10);
        driver.findElement(By.xpath("//label[contains(text(),'"+textareaLabel+"')]//..//div")).click();
        CommonSteps.waitFor(1);
        driver.findElement(By.xpath("//label[contains(text(),'"+textareaLabel+"')]//..//textarea")).sendKeys(textToEnter);
    }
    public void selectAnItemInADropdown(String itemSelected, String dropdownLabel){
        String currentlySelectedItemInDropdown = getCurrentlySelectedItemInDropdown(dropdownLabel);
        if(!currentlySelectedItemInDropdown.equalsIgnoreCase(itemSelected)){
            CommonSteps.clickWithJS(driver.findElement(By.xpath("//div[@role='tooltip']//*[contains(.,'"+itemSelected+"')][contains(@class,'MuiButtonBase')]")));
        }
    }

    public void selectARandomItemInDropdown(){
        int sizeOfElements = listOfDropdownItemsAfterClickingDropdown.size();
        Random random = new Random();
        int randomElement = random.nextInt(sizeOfElements);
        CommonSteps.waitForClickability(listOfDropdownItemsAfterClickingDropdown.get(randomElement),5);
        System.out.println(listOfDropdownItemsAfterClickingDropdown.get(randomElement).getText());
        CommonSteps.clickWithJS(listOfDropdownItemsAfterClickingDropdown.get(randomElement));
    }

    public String getCurrentlySelectedItemInDropdown(String dropdownLabel){
        return driver.findElement(By.xpath("//label[contains(.,'"+dropdownLabel+"')]//..//input")).getAttribute("value");
    }

    public void clickOnCloseButtonOfAnArea(String areaLabel){
        if(driver.findElements(By.xpath("//label[contains(text(),'"+areaLabel+"')]//..//span[contains(@class,'mdi-close')]")).size()>0){
            driver.findElement(By.xpath("//label[contains(text(),'"+areaLabel+"')]//..//span[contains(@class,'mdi-close')]")).click();
        }
    }


}
