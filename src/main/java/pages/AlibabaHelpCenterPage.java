package pages;

import constants.locators.AlibabaHelpCenterPageConstants;
import constants.locators.AlibabaHomePageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlibabaHelpCenterPage {
    private WebDriver driver;
    private By searchField = By.xpath(AlibabaHelpCenterPageConstants.SEARCH_FIELD);
    private By appButton = By.xpath(AlibabaHelpCenterPageConstants.GET_THE_APP);

    public AlibabaHelpCenterPage(WebDriver driver){
        this.driver = driver;
    }

    public AlibabaHelpCenterSearchPage search(String searchText){
        WebElement el = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(searchField));
        System.out.println("after el");
        el.sendKeys(searchText + Keys.ENTER);
        return new AlibabaHelpCenterSearchPage(driver);
    }

    public void getTheApp(){
        System.out.println("testing");
        //driver.findElement(appButton).click();
        WebElement el = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(appButton));
        System.out.println("after el");
        el.click();
    }
}
