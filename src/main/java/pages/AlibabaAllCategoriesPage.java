package pages;

import constants.locators.AlibabaAllCategoriesPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class AlibabaAllCategoriesPage {
    private WebDriver driver;
    private By electronics = By.xpath(AlibabaAllCategoriesPageConstants.ELECTRONICS_BUTTON);
    private By computerHardware = By.xpath(AlibabaAllCategoriesPageConstants.COMPUTER_HARDWARE_BUTTON);
    private By searchFirstOption = By.xpath(AlibabaAllCategoriesPageConstants.FIRST_ITEM_OF_COMPUTER_HARDWARE);

    public AlibabaAllCategoriesPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToElectronics(){
        driver.findElement(electronics).click();
    }

    public void navigateToComputerHardwareCategory(){
        driver.findElement(computerHardware).click();
        //pick the first option that comes from the search
        WebElement el = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(searchFirstOption));
        System.out.println("after el");
        el.click();
        //driver.findElement(searchFirstOption).click();
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(2));
    }

}
