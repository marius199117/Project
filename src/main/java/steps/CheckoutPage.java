package steps;

import common.CommonDefinitions;
import org.openqa.selenium.By;

public class CheckoutPage {
    CommonDefinitions commonDefinitions = new CommonDefinitions();

    public By shippingIcon = By.xpath("//span[text()='Shipping']");
    public By emailAddress = By.xpath("//div[@class='control _with-tooltip']//input[@id='customer-email']");
    public By firstName = By.xpath("//input[@name='firstname']");
    public By lastName = By.xpath("//input[@name='lastname']");
    public By company = By.xpath("//input[@name='company']");
    public By streetAddress = By.xpath("//input[@name='street[0]']");
    public By city = By.xpath("//input[@name='city']");
    public By stateProvidence = By.name("region_id");
    public By zipPostalCode = By.xpath("//input[@name='postcode']");
    public By country = By.name("country_id");
    public By phoneNumber = By.xpath("//input[@name='telephone']");
    public By radioButton = By.xpath("//input[@name='ko_unique_1']");
    public By nextButton = By.xpath("//button[@type='submit' and contains(@class, 'button')]");
    public By placeOrderButton = By.xpath("//button[@title='Place Order']");
    public By purchaseConfirmationMessage = By.xpath("//span[text()='Thank you for your purchase!']");


    public void verifyThatElementIsDisplayed(By element) {
        commonDefinitions.elementIsDisplayed(element);
    }

    public void insertValueToField(By element, String value) {
        commonDefinitions.insertKeywoardIntoField(element, value);
    }

    public void selectItemFromDropdown(By elementName, String value) {
        commonDefinitions.selectItemFromDropdown(elementName, value);
    }

    public void selectElement(By elementName) {
        commonDefinitions.waitAndClickUsingJavascriptExecutor(elementName);
    }
}
