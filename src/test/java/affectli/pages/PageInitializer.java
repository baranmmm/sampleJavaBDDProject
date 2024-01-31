package affectli.pages;

import affectli.utilities.Driver;

public class PageInitializer extends Driver {

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static NIMAPage nimaPage;

    public static void initialize(){
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        nimaPage = new NIMAPage();
    }
}
