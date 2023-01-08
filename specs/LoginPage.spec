# Validate Login page

## Verify if Login page is integral
Tags: smoke
* Open login page
* Verify if login page is integral

## Verifi if user can login as simple user
Tags: smoke
* Open login page
* Login as "SIMPLE_USER"
* Verify if user is logged

## Verifi if user can login as problem user
Tags: smoke
* Open login page
* Login as "PROBLEM_USER"
* Verify if user is logged

## Verifi if user can login as problem glitch user
Tags: smoke
* Open login page
* Login as "PROBLEM_GLITCH_USER"
* Verify if user is logged

## Verifi if user can not login as locked out user
Tags: smoke
* Open login page
* Login as "LOCKED_OUT_USER"
* Verify if error message for locked user appeared

## Verifi if user can not login with wrong password
Tags: smoke
* Open login page
* Login as "WRONG_PASSWORD"
* Verify if error message for wrong username/password appeared

## Verifi if user can not login with wrong username
Tags: smoke
* Open login page
* Login as "WRONG_USERNAME"
* Verify if error message for wrong username/password appeared
