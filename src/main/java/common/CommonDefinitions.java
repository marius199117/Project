package common;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;

public class CommonDefinitions {

    public static WebDriver driver = null;

    public void waitAndClick(By xpath) {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        WebElement element = waiter.until(ExpectedConditions.elementToBeClickable(xpath));
        Assert.assertTrue("Element should be clickable", element.isDisplayed() && element.isEnabled());
        driver.findElement(xpath).click();
    }

    public void waitAndClickUsingJavascriptExecutor(By xpath) {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        WebElement element = waiter.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        Assert.assertTrue("Element should be visible", element.isDisplayed());
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", element);
    }

    public void elementIsDisplayed(By xpath) {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        waiter.until(ExpectedConditions.presenceOfElementLocated(xpath));
        WebElement element = driver.findElement(xpath);
        Assert.assertNotNull("Element not found with locator: " + xpath, element);
    }

    public void insertKeywoardIntoField(By locator, String keyword) {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        waiter.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement field = driver.findElement(locator);
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(Keys.BACK_SPACE);
        field.sendKeys(keyword);
    }

    public void selectItemFromList(String title, By itemList, String itemName, String itemType, String locatorType) {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        WebElement field = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-role='title' and @class='filter-options-title' and text()='" + title + "']")));
        Assert.assertTrue("Element should be visible", field.isDisplayed());
        field.click();

        String xpathExpression;
        switch (locatorType.toLowerCase()) {
            case "text":
                xpathExpression = "//li[@class='item']//a[contains(.,'" + itemName + "')]";
                break;
            case "option-label":
                xpathExpression = "//div[@class='swatch-attribute swatch-layered " + itemType + "']//div[@option-label='" + itemName + "']";
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type provided");
        }

        WebElement itemLink = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(itemList))
                .findElement(By.xpath(xpathExpression));

        Assert.assertTrue("Element should be visible", itemLink.isDisplayed());
        itemLink.click();
    }

    public void scrollAndClick(WebDriver driver, By element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        WebElement field = waiter.until(ExpectedConditions.elementToBeClickable(element));
        Assert.assertTrue("Element should be clickable", field.isEnabled());
        field.click();
    }

    public void hoverAndSelectSubOption(By menuLocator, String subOption) {
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(menuLocator);
        actions.moveToElement(menu).perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement subOptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(subOption)));
        Assert.assertTrue("Sub-option is not displayed after hover", subOptionElement.isDisplayed());
        subOptionElement.click();
    }

    public void hoverAndSelectElement(By hoverElem, By element) {
        WebElement hoverElement = driver.findElement(hoverElem);
        WebElement button = driver.findElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        Assert.assertTrue("Element should be clickable", button.isEnabled());
        button.click();
    }

    public static String generateRandomCredentialsForEmail() {
        Random random = new Random();
        StringBuilder credential = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            credential.append(randomChar);
        }
        for (int i = 0; i < 3; i++) {
            int randomNumber = random.nextInt(10);
            credential.append(randomNumber);
        }
        credential.append("@test.com");
        return credential.toString();
    }

    public static String getRandomCity() {
        List<String> cities = List.of("Cluj Napoca", "Bucuresti", "Constanta", "Craiova", "Caracal", "Timisoara");
        Random random = new Random();
        int randomIndex = random.nextInt(cities.size());
        return cities.get(randomIndex);
    }

    public static String generateRandomNumber() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1 + random.nextInt(9));
        for (int i = 0; i < 9; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    public static String generateRandomCredentials() {
        Random random = new Random();
        StringBuilder credential = new StringBuilder();

        char firstLetter = (char) (random.nextInt(26) + 'A');
        credential.append(firstLetter);

        for (int i = 0; i < 9; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            credential.append(randomChar);
        }
        return credential.toString();
    }

    public void selectItemFromDropdown(By elementName, String value) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(elementName));
        WebElement dropdownElement = driver.findElement(elementName);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }
}

