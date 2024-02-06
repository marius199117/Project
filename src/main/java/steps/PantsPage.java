package steps;

import common.CommonDefinitions;
import org.openqa.selenium.By;

public class PantsPage {
    CommonDefinitions commonDefinitions = new CommonDefinitions();
    public By portiaCapriPants = By.xpath("//img[@src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/w/p/wp13-orange_main_1.jpg']");
    public By itemList = By.xpath("//div[@data-role='content' and @class='filter-options-content' and preceding-sibling::div[@class='filter-options-title']]//li");
    public By secondItemList = By.xpath("//div[@class='swatch-option text']");


    public void verifyThatElementIsDisplayed(By element) {
        commonDefinitions.elementIsDisplayed(element);
    }

    public void selectItemFromListPantsPage(String title, By itemList, String itemName, String itemType, String locatorType) {
        commonDefinitions.selectItemFromList(title, itemList, itemName, itemType, locatorType);
    }
}
