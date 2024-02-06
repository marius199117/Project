package UI_Tests;

import common.CommonDefinitions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.AddToCartPage;
import steps.CheckoutPage;
import steps.HomePage;
import steps.JacketsPage;

public class CheckoutTest extends CommonDefinitions {
    HomePage homePage = new HomePage();
    JacketsPage jacketsPage = new JacketsPage();
    AddToCartPage addToCartPage = new AddToCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void successfulCheckout() {
        homePage.hoverAndSelectWithOptions(homePage.menDropdownOption, "Jackets");
        jacketsPage.verifyThatElementIsDisplayed(jacketsPage.proteusJacket);
        jacketsPage.selectItemFromListJacketsPage("Style", jacketsPage.itemList, "Insulated", "", "text");
        jacketsPage.selectItemFromListJacketsPage("Size", jacketsPage.secondItemList, "L", "size", "option-label");
        jacketsPage.selectItemFromListJacketsPage("Price", jacketsPage.itemList, "$40.00 - $49.99", "", "text");
        jacketsPage.selectItemFromListJacketsPage("Color", jacketsPage.secondItemList, "Blue", "color", "option-label");
        jacketsPage.selectItemFromListJacketsPage("Material", jacketsPage.itemList, "Fleece", "", "text");
        jacketsPage.selectItemFromListJacketsPage("Eco Collection", jacketsPage.itemList, "Yes", "", "text");
        jacketsPage.hoverAndSelectElement(jacketsPage.hoverItem, jacketsPage.selectAddToCart);
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.oneItemHasAddedToCart);
        addToCartPage.selectElement(addToCartPage.oneItemHasAddedToCart);
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.priceValueJacket);
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.qtyValuePants);
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.proceedToCheckoutButton);
        addToCartPage.selectElement(addToCartPage.proceedToCheckoutButton);
        checkoutPage.verifyThatElementIsDisplayed(checkoutPage.shippingIcon);
        checkoutPage.verifyThatElementIsDisplayed(checkoutPage.emailAddress);
        checkoutPage.insertValueToField(checkoutPage.emailAddress, generateRandomCredentialsForEmail());
        checkoutPage.insertValueToField(checkoutPage.firstName, generateRandomCredentials());;
        checkoutPage.insertValueToField(checkoutPage.lastName, generateRandomCredentials());
        checkoutPage.insertValueToField(checkoutPage.company, generateRandomCredentials());
        checkoutPage.insertValueToField(checkoutPage.streetAddress, generateRandomCredentials());
        checkoutPage.insertValueToField(checkoutPage.city, getRandomCity());
        checkoutPage.selectItemFromDropdown(checkoutPage.stateProvidence, "12");
        checkoutPage.insertValueToField(checkoutPage.zipPostalCode, generateRandomNumber());
        checkoutPage.selectItemFromDropdown(checkoutPage.country, "US");
        checkoutPage.insertValueToField(checkoutPage.phoneNumber, generateRandomNumber());
        checkoutPage.selectElement(checkoutPage.radioButton);
        checkoutPage.selectElement(checkoutPage.nextButton);
        checkoutPage.verifyThatElementIsDisplayed(checkoutPage.placeOrderButton);
        checkoutPage.selectElement(checkoutPage.placeOrderButton);
        checkoutPage.verifyThatElementIsDisplayed(checkoutPage.purchaseConfirmationMessage);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
