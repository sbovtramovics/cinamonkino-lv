@addNewAlbum
Feature: Scenarios containing user story: Add New Album

  @NewPubishedAlbumTests
  Scenario:  New published Album test
    Given Log in as admin
    And Click on Photo Gallery button
    When Click on Albums button
    And click on Add New button
    And User input Album name: "Album1"
    And User input Slug name: "Fun album"
    And User input short description: "Short description"
    When User choses published option: "Yes"
    When User clicks on preview image
    And User adds chosen picture




