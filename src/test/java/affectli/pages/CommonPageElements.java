package affectli.pages;

import affectli.utilities.CommonSteps;
import affectli.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import affectli.utilities.Driver;

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
        CommonSteps.waitForClickability(driver.findElement(By.xpath("//label[contains(text(),'"+textareaLabel+"')]//..//div")), 10);
        driver.findElement(By.xpath("//label[contains(text(),'"+textareaLabel+"')]//..//div")).click();
        CommonSteps.waitFor(1);
        driver.findElement(By.xpath("//label[contains(text(),'"+textareaLabel+"')]//..//textarea")).sendKeys(textToEnter);
    }

}
