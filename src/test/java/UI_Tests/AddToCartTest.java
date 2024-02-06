package UI_Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import common.CommonDefinitions;
import steps.AddToCartPage;
import steps.HomePage;
import steps.PantsPage;

public class AddToCartTest extends CommonDefinitions {
    HomePage homePage = new HomePage();
    PantsPage pantsPage = new PantsPage();
    AddToCartPage addToCartPage = new AddToCartPage();

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com");
        driver.manage().deleteAllCookies();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void filterAndAddToCartPants() {
        homePage.scrollAndSelectElement(homePage.shopPants);
        pantsPage.verifyThatElementIsDisplayed(pantsPage.portiaCapriPants);
        pantsPage.selectItemFromListPantsPage("Style", pantsPage.itemList, "Capri", "", "text");
        pantsPage.selectItemFromListPantsPage("Size", pantsPage.secondItemList, "28", "size", "option-label");
        pantsPage.selectItemFromListPantsPage("Price", pantsPage.itemList, "$30.00 - $39.99", "", "text");
        pantsPage.selectItemFromListPantsPage("Color", pantsPage.secondItemList, "Blue", "color", "option-label");
        pantsPage.selectItemFromListPantsPage("Material", pantsPage.itemList, "Microfiber", "", "text");
        pantsPage.selectItemFromListPantsPage("Eco Collection", pantsPage.itemList, "No", "", "text");
        pantsPage.selectItemFromListPantsPage("Performance Fabric", pantsPage.itemList, "Yes", "", "text");
        pantsPage.selectItemFromListPantsPage("Erin Recommends", pantsPage.itemList, "No", "", "text");
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.aeronCapriPants);
        addToCartPage.selectElement(addToCartPage.aeronCapriPants);
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.aeronCapriPantsAddToCartItem);
        addToCartPage.selectElement(addToCartPage.size28);
        addToCartPage.selectElement(addToCartPage.colorBlue);
        addToCartPage.selectElement(addToCartPage.addToCartButton);
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.oneItemHasAddedToCart);
        addToCartPage.selectElement(addToCartPage.oneItemHasAddedToCart);
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.priceValuePants);
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.qtyValuePants);
    }

    @Test(priority = 2)
    public void editAddToCartPants() {
        addToCartPage.selectElement(addToCartPage.editButton);
        addToCartPage.selectElement(addToCartPage.size29);
        addToCartPage.selectElement(addToCartPage.colorBlack);
        addToCartPage.insertValueToField(addToCartPage.quantity, "2");
        addToCartPage.selectElement(addToCartPage.updateCart);
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.updatedItemsHasBeenAddedToCart);
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.editConfirmationMessage);
        addToCartPage.selectElement(addToCartPage.updatedItemsHasBeenAddedToCart);
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.updatedItemsHasBeenAddedToCart);
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.updatedQtyValuePants);
    }

    @Test(priority = 3)
    public void editAddToCartPantsFromDropdown() {
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.quantityButton);
        addToCartPage.insertValueToField(addToCartPage.quantityButton, "1");
        addToCartPage.selectElement(addToCartPage.updateButton);
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.priceValuePants);
    }

    @Test(priority = 4)
    public void deleteAddToCartPants() {
        addToCartPage.selectElement(addToCartPage.deleteButton);
        addToCartPage.selectElement(addToCartPage.okButton);
        addToCartPage.verifyThatElementIsDisplayed(addToCartPage.successfullyDeleted);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

