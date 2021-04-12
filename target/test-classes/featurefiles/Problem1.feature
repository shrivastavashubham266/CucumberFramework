Feature: QA Engineer Problem 1

  @chrome
  Scenario: Verify different aspects fo displayed values
    Given : User is on Values Page
    Then : Right count of values appear on screen
    And : Verify the values on the screen are greater than 0 
    And : Verify the total balance is correct based on the values listed on the screen
    And : Verify the values are formatted as currencies
    And : Verify the total balance matches the sum of the values
    
