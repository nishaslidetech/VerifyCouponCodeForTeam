@verify_Delete40%Coupon
Feature: verify the Delete40% coupon 



@for_new_User
  Scenario: verify the Delete40% coupon 
  Given User is on Home Page then click on Signup button
  Then Creates a new ueser
  Then Click on account botton 
  Then Click on delete button 
  Then select one of radio button and clcik on delete profile
  Then copy the discount coupon code
  Then User will go to the pricing page
  Then Click on Join Now option
  Then Apply the Discount coupon code
  Then Verify the Price
  Then Delete the user Account 
  
@for_Existing_User
Scenario: verify the Delete40% coupon for existing user
  Given user is on home page click on Sign in button
  Then enter Username "nishadhiman0027@gmail.com" and Password "Qwerty@1"
  Then User should go to the Pricing page
  Then click on Join Now  option
  Then Apply the discount Coupon Code 
  Then verify The Price
  Then Signout from the application