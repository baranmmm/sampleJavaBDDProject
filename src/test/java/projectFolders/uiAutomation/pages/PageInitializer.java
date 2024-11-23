package projectFolders.uiAutomation.pages;

import projectFolders.uiAutomation.utilities.Driver;

public class PageInitializer extends Driver {

    public static DashboardPage dashboardPage;
    public static HomePage homePage;

    public static void initialize(){
        dashboardPage = new DashboardPage();
        homePage = new HomePage();
    }
}
