Feature: Implementation of API of Sporty shoes using Cucumber

  Scenario: Rest API Testing on Sporty shoes
    Given User sends a get request to get list of users and validates status
    Given User send a Post request to create a new shoe and validates status
    Given User sends a get request to get list of shoes and validates status
    Given User sends a Put request to update a shoe and validates status
    Given User sends a delete request to delete shoe and validates status
