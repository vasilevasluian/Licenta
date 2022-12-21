# Validate My Profile page

## Verify if My Profile page is integral
Tags: smoke
* Login as "SIMPLE_USER"
* Go to "MY_PROFILE" page
* Verify if my profile page is integral

## Verify LogOut functionality
Tags: smoke
* Login as "SIMPLE_USER"
* Go to "MY_PROFILE" page
* Logout from the app
* Verify if user is logout

## Verify if user can cancel the logout
Tags: smoke
* Login as "SIMPLE_USER"
* Go to "MY_PROFILE" page
* Cancel the logout
* Check if user is logged in

## Login with invalid credentials
Tags: smoke
* Open login page
* Fill the password field with invalid password
* Check if error message appears