package steps;

import common.CommonDefinitions;
import org.openqa.selenium.By;

public class AddToCartPage {
    CommonDefinitions commonDefinitions = new CommonDefinitions();

    public By aeronCapriPants = By.xpath("//img[@alt='Aeon Capri-28-Blue']");
    public By aeronCapriPantsAddToCartItem = By.xpath("//img[@alt='Aeon Capri']");
    public By size29 = By.xpath("//div[@option-label='29']");
    public By size28 = By.xpath("//div[@option-label='28']");
    public By colorBlack = By.xpath("//div[@option-label='Black']");
    public By colorBlue = By.xpath("//div[@option-label='Blue']");
    public By quantity = By.xpath("//input[@id='qty']");
    public By addToCartButton = By.xpath("//button[@title='Add to Cart']");
    public By updateCart = By.xpath("//button[@title='Update Cart']");
    public By oneItemHasAddedToCart = By.xpath("//span[@class='counter-number' and text()='1']");
    public By updatedItemsHasBeenAddedToCart = By.xpath("//span[@class='counter-number' and text()='2']");
    public By priceValuePants = By.xpath("//div[@class='price-container']//span[@class='price'][.='$48.00']");
    public By priceValueJacket = By.xpath("//div[@class='price-container']//span[@class='price'][.='$47.00']");
    public By qtyValuePants = By.xpath("//input[@class='item-qty cart-item-qty'][@data-item-qty='1']");
    public By updatedQtyValuePants = By.xpath("//input[@class='item-qty cart-item-qty'][@data-item-qty='2']");
    public By quantityButton = By.xpath("//input[@class='item-qty cart-item-qty']");
    public By editButton = By.xpath("//a[@class='action edit']");
    public By updateButton = By.xpath("//button[@title='Update']");
    public By deleteButton = By.xpath("//a[@class='action delete']");
    public By proceedToCheckoutButton = By.xpath("//button[@id='top-cart-btn-checkout']");
    public By editConfirmationMessage = By.xpath("//div[contains(text(), 'Aeon Capri was updated in your shopping cart.')]");
    public By okButton = By.xpath("//span[text()='OK']");
    public By successfullyDeleted = By.xpath("//strong[@class='subtitle empty' and text()='You have no items in your shopping cart.']");


    public void selectElement(By element) {
        commonDefinitions.waitAndClick(element);
    }

    public void verifyThatElementIsDisplayed(By element) {
        commonDefinitions.elementIsDisplayed(element);
    }

    public void insertValueToField(By element, String value) {
        commonDefinitions.insertKeywoardIntoField(element, value);
    }
}
