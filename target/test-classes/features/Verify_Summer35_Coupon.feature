@verify_summer35_Coupon
Feature: verify the Summer35 coupon 



@for_new_User
  Scenario: verify the Summer35 coupon 
  Given User is on Home Page and click on Signup button
  Then Create a new ueser
  Then Click on free ppt and download one ppt
  Then Again download the another ppt 
  Then Copy and Paste the cpupon code and verify the code
  Then User will go the pricing page 
  Then Click on join now option
  Then Apply the discount coupon code
  Then Verify the price
  Then Delete the user account 
  
@for_Existing_User
Scenario: verify the Summer35 coupon for existing user
  Given user is on home page click on sign in button
  Then Enter Username "nishadhiman0027@gmail.com" and Password "Qwerty@1"
  Then User should go to the pricing page
  Then click on join Now option
  Then Apply the discount coupon code "summer35"
  Then verify the Price
  Then signout from the application