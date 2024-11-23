package projectFolders.mobileAutomation.screens;

import projectFolders.mobileAutomation.utilities.MobileDriver;

public class PageInitializer extends MobileDriver {

    public static DashboardScreen dashboardScreen;


    public static void initialize(){
        dashboardScreen = new DashboardScreen();
    }
}
