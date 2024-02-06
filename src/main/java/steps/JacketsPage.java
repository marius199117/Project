package steps;

import common.CommonDefinitions;
import org.openqa.selenium.By;

public class JacketsPage {
    CommonDefinitions commonDefinitions = new CommonDefinitions();

    public By proteusJacket = By.xpath("//img[@alt='Proteus Fitness Jackshirt']");
    public By itemList = By.xpath("//div[@data-role='content' and @class='filter-options-content' and preceding-sibling::div[@class='filter-options-title']]//li");
    public By secondItemList = By.xpath("//div[@class='swatch-option text']");
    public By hoverItem = By.cssSelector(".product-item-info");
    public By selectAddToCart = By.cssSelector("form[data-role='tocart-form'] button[type='submit']");


    public void selectItemFromListJacketsPage(String title, By itemList, String itemName, String itemType, String locatorType) {
        commonDefinitions.selectItemFromList(title, itemList, itemName, itemType, locatorType);

    }

    public void hoverAndSelectElement(By hoverElement, By selectAddToCart) {
        commonDefinitions.hoverAndSelectElement(hoverElement, selectAddToCart);
    }

    public void verifyThatElementIsDisplayed(By element) {
        commonDefinitions.elementIsDisplayed(element);
    }
}
