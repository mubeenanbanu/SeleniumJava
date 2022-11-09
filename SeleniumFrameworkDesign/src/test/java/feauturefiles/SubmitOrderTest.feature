
@tag
Feature: Purchasing the order and verfying message
  I want to use this template for my feature file
  
	Background:
	Given the lets shop app for login
  

  @tag1
  Scenario Outline: Submit the purchase order
    Given I enter the <username> and <password> and click on submit
    When I add product <productName> to cart 
    And Verify the <productName> in cart and checkout
    And Place the order with <cvv> <name><country>
    Then I validate the message "THANKYOU FOR THE ORDER." is displayed

    Examples: 
      | username  | password | productName|cvv|name|country
      | mubeenabanu6125@gmail.com |     Mubina@12 | ZARA COAT 3|456|mubeena|India
     
