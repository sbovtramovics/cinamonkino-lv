Feature:
  Background:
    Given I go to the main page: "https://cinamonkino.lv/"

  #Preparing:
  #Web: cinamonkino.lv
  #Register account in cinamonkino.lv using www.mailinator.com (free emails). Name and Surname, must be: Neo and Tech
  #User/Pass - should be incl. in test


    @MyMainTest
  Scenario:
    When I sign in
    And I enter the email: "sbovtramovics@mailinator.com"
    And I enter the password: "zxcvasdf"
    And I press submit button
    And I check that the Name is "Neo"
    And I check the the Surname is "Tech"
    And I select the film from the list
    And I choose the time from the list
    And I press booking button
    And I add 2 tickets
    And I store the sum
    And I type random text in coupon field
    And I press validate button
    And I check that validation works
    And I press Next
    And I check two random at the last row
    And I store the seat numbers
    And I press Next again
    And I check stored sum
    And I check stored seats


  #  1. Sign in
  #  2. Open User Profile
  #  3. Check existed Name and Surname (Neo & Tech)
  #  4. Choose one movie with random date and time(+5 days from current date) in Cinema: Cinamon Alfa Riga
  #  5. Ticket confirmation steps:
  #  5.1 Add 2 tickets
  #  5.2 Add random text in coupon field and check validation
  #  5.3 Store Sum for 2 tickets(will be needed to validation in last step)
  #  5.3 Move to next step
  #  5.4 Check random seats from row: 5 or 6 (if availabe). If not then choose any random seats
  #  5.5 Store selected seats
  #  5.5 Move to next step
  #  5.6 Check stored sum from step 1 in Ticket Confirmation Steps.
  #  5.7 Check stored seats from step 2 in Ticket Confirmation Steps.
  #  5.8 Change the Order
  #  5.9 Select 1 ticket
  #  5.10 Store sum for 1 ticket -> Move to step 2 in Ticket Confirmation Steps
  #  5.11 Leave randomly selected seat -> Move to step 3 in Ticket Confirmation Steps
  #  5.12 Check stored sum from step 1 in Ticket Confirmation Steps.
  #  5.13 Check availability of 5 payment methods(do not select).
  #  5.14 Logout