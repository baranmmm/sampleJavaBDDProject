package affectli.pages;

import affectli.utilities.CommonSteps;
import com.tigervnc.rdr.Exception;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

public class NIMAPage extends CommonPageElements{

    @FindBy(css = "[name=\"place_select\"]")
    public WebElement siteDropdown;

    @FindBy(css = "[placeholder=\"Select a site...\"]")
    public WebElement siteTxtbox;

    @FindBy(name = "start_fault_time")
    public WebElement faultStartTime;

    @FindBy(name = "end_fault_time")
    public WebElement faultEndTime;

    @FindBy(xpath = "//span[contains(text(),'OK')]//..")
    public WebElement calendarOKbutton;

    @FindBy(name = "resolution")
    public WebElement resolutionTextarea;

    public void selectASiteFromSiteDropdown(String siteNameOrId){
        siteTxtbox.sendKeys(siteNameOrId);
        driver.findElement(By.xpath("//div[contains(.,'"+siteNameOrId+"')][@role=\"menuitem\"]")).click();
    }

    public void isSiteBackgroundColorCorrect(){
        //TODO All priority color codes need to be added
        String outerHTML = driver.findElement(By.xpath("//*[contains(text(),'Site Details')]//..")).getAttribute("outerHTML");
        String[] splittedHTML = outerHTML.split("background-color:");
        String color = splittedHTML[1].substring(0, 7);
        String incidentPriority = driver.findElement(By.xpath("(//*[contains(text(),'Site Details')]//..//b)[2]")).getText();
        if(incidentPriority.equalsIgnoreCase("P1")){
            Assert.assertTrue(color.equalsIgnoreCase("#c62828"));
        }else if(incidentPriority.equalsIgnoreCase("P2")){
            Assert.assertTrue(color.equalsIgnoreCase(""));
        }else if(incidentPriority.equalsIgnoreCase("P3")){
            Assert.assertTrue(color.equalsIgnoreCase("#fdd835"));
        }else if(incidentPriority.equalsIgnoreCase("P4")){
            Assert.assertTrue(color.equalsIgnoreCase("#ff8f00"));
        }else if(incidentPriority.equalsIgnoreCase("P5")){
            Assert.assertTrue(color.equalsIgnoreCase("#0d47a1"));
        }else{
            throw new Exception("Color code is not correct or cannot be retrieved");
        }
    }

    public void selectAnOptionFromADropdown(String dropdownLabel, String option){
        driver.findElement(By.xpath("//label[contains(text(),'"+dropdownLabel+"')]//..//input")).click();
        CommonSteps.scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'"+option+"')]")));
        driver.findElement(By.xpath("//div[contains(text(),'"+option+"')]")).click();
    }
}


