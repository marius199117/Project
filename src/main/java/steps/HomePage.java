package steps;

import common.CommonDefinitions;
import org.openqa.selenium.By;

import static common.CommonDefinitions.driver;

public class HomePage {
    CommonDefinitions commonDefinitions = new CommonDefinitions();
    public By shopPants = By.xpath("//img[@src='https://magento.softwaretestingboard.com/pub/media/wysiwyg/home/home-pants.jpg']");
    public By menDropdownOption = By.linkText("Men");

    public void scrollAndSelectElement(By element) {
        commonDefinitions.scrollAndClick(driver, element);
    }

    public void hoverAndSelectWithOptions(By menuLocator, String subOption) {
        driver.get("https://magento.softwaretestingboard.com/men.html");
        commonDefinitions.hoverAndSelectSubOption(menuLocator, subOption);
    }
}
