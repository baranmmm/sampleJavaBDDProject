package affectli.pages;

import affectli.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends CommonPageElements{

    public void clickOnViewAllButtonOfTasks(String section){
        driver.findElement(By.xpath("//h3[.='Tasks']//..//h4[.='"+section+"']//..//..//a[contains(text(),'VIEW ALL')]")).click();
        Log.info("Viewed all \""+section+"\" tasks.");
    }

    public void clickOnViewAllButtonOfProcesses(String section){
        driver.findElement(By.xpath("//h3[.='Processes']//..//h4[.='"+section+"']//..//..//a[contains(text(),'VIEW ALL')]")).click();
        Log.info("Viewed all \""+section+"\" processes.");
    }
}
