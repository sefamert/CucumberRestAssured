Feature: User create hotel reservation

  Scenario: User create hotel reservation and delete this reservation
    Given User create a new reservation
    And User give information for hotel reservation
    When User create hotel reservation
    Then Reservation create succesfull
    And User would delete that crated reservation