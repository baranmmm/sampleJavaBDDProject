Feature: NIMA Feature

  @VTON-1289
  Scenario Outline: VTON-1289 Creating SARM from Manually logged NIMA
    Given the user logs in with "mehmet" kumoco user
    And the user navigates to "NIMA" module from App Launcher
    Then verifies that "Site Information" label is visible
    And the user clicks on "Site" dropdown
    Then verifies that Site list is populated with data
#    And the user selects "BUDAPEST-NAP" site from the site dropdown
#    Then verifies that site has correct background color
#    And the user clicks on "Incident Priority" dropdown
#    And the user selects "P1" option from "Incident Priority" dropdown
#    And checks and opens if there is an ongoing task available
#    And the user enters "<RCA Category>", "<RCA Type>", "<RCA Actual Cause>", "<Impact>", "<Fault Start Time>", "<Fault End Time>", "<Resolution>"
#    And claims the ticket if not claimed before
#    And dispatches the ticket if not dispatched before
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
    Examples:
      | RCA Category | RCA Type | RCA Actual Cause                  | Impact | Fault Start Time | Fault End Time | Resolution                                          |
      | Random       | Random   | Random                            | Random | Now              | Now            | Randomly selected RCA values resolved by automation |
      | Access       | Landlord | Access Issue - Disputed Ownership | Minor  | Now              | Now            | Resolved by automation                              |


