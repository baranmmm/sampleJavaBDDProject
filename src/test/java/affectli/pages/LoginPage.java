package affectli.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonPageElements{

    @FindBy(id = "username")
    public WebElement usernameTxtbox;

    @FindBy(id = "password")
    public WebElement passwordTxtbox;

    @FindBy(name = "login")
    public WebElement loginBtn;

    @FindBy(id = "kc-page-title")
    public WebElement loginTxt;

}
