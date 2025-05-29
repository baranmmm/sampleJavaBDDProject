package projectFolders.uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchItemPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"x-bin-price__content\"]//span[@class=\"ux-textspans\"]")
    public WebElement itemPrice;


    public double getThePriceOfTheProduct(){

        return Double.parseDouble(itemPrice.getText().split(" ")[0].substring(1));
    }

}
