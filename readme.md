# Test Project

Testing Project to automate the testing project steps.

## Structure
- src/main/java/common/CommonDefinitions -> here we have commonly used functions
- src/main/java/steps -> here are the steps for every using page objects to represent web pages and their elements as objects in the code
- src/test/java/UI_Tests -> test class where are tests are defined and can be run from here
- pom.xml -> there we have all the dependencies for the project

## Usage and run tests
You can run the tests using the following method:
1. Go to UI_Tests -> select one of the two classes -> right click on the class and select run
2. If you want to run all tests from UI_Tests, write on command line: mvn clean test

## Test Cases Coverage
AddToCart
- Before the test cases, the browser is initiated and the url is accessed
- First test case goes to men's pants sections filters to find a particular type of pants and it's adding to cart the chosen item
- Second test case edits the added to cart selection, from pants info page and it's adding to cart the edited version of the item
- Third test case edits the added to cart selection, directly from dropdown menu and it's adding to cart the edited version of the item
- Forth test case is deleting the cart chosen item, and verifies that the item has been successfully deleted
- After the test cases, the browser is closed and the session is closed as well

CheckoutTest
- Before the test cases, the browser is initiated and the url is accessed
- The test case goes to jackets page, using the dropdown from home page, filters a certain jacket, is added to cart and is successful checked out by the user
- After the test cases, the browser is closed and the session is closed as well


## Project technologies
- Selenium + TestNg + Junit + Java