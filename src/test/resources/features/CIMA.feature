Feature: CIMA Feature

  @VTON-1290
  Scenario: VTON-1290 Creating SARM from CIMA
    Given the user logs in with "mehmet" kumoco user
    And the user navigates to "CIMA" module from App Launcher
    Then verifies that "Information" label is visible
    And the user clicks on "Site" dropdown
    Then verifies that Site list is populated with data
    And the user selects "BUDAPEST-NAP" site from the site dropdown
#    Then verifies that site has correct background color
#    And the user clicks on "RCA Category" dropdown
#    And the user selects "Access" option from "RCA Category" dropdown
#    And clicks on "Start" button
#    Then verifies that "Process started." popup appears on the screen
#    And the user selects a fault start time
#    And the user selects a fault end time
#    And enters "Resolved by automation" text into "Resolution" textarea
#    And clicks on "Save" button
#    Then verifies that "The form data has been saved." popup appears on the screen
#    And clicks on "Close Task" button
#    And clicks on "Yes" button on confirmation popup
#    Then verifies that "The task has been closed." popup appears on the screen
#    And the user navigates to Dashboard page
#    And the user logs out from Affectli

