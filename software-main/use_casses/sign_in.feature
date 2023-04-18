Feature: sign_in

Scenario: user can Login
Given that the user not logged in
And the password is "correct password "
Then the user login sucssed
And the user logged in

Scenario: user have wrong password
Given that the user not logged in
And the password is "wrong password "
Then the user login failed
And the user not logged in
 
 
