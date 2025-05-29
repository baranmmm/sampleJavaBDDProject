package projectFolders.uiAutomation.pages;

import projectFolders.uiAutomation.utilities.Utility;

public class PageInitializer extends Utility {

    public static HomePage homePage;
    public static SearchResultsPage searchResultsPage;
    public static SearchItemPage searchItemPage;

    public static void initialize(){
        homePage = new HomePage();
        searchResultsPage = new SearchResultsPage();
        searchItemPage = new SearchItemPage();
    }
}
