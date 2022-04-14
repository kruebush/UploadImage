Feature: feature to test upload image functionality


@UploadImageSteps
  Scenario: check upload is successfull
    Given browser is open
    And user is on login page
    When user enters username and password
    And user clicks on login button
    Then user is navigated to the postfeed page
    When user clicks profile
    Then user is navigated to editprofile
    When user clicks on pencil icon
