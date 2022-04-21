package pages;

import constants.locators.AlibabaHelpCenterSearchPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlibabaHelpCenterSearchPage {
    private WebDriver driver;
    private By searchField = By.xpath(AlibabaHelpCenterSearchPageConstants.SEARCH_FIELD);
    private By thirdOption = By.xpath(AlibabaHelpCenterSearchPageConstants.THIRD_HELP_LINK);

    public AlibabaHelpCenterSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void changeSearch(String searchText){
        Actions action = new Actions(driver);
        WebElement nonEmptySearchField = driver.findElement(searchField);
        action.doubleClick(nonEmptySearchField).sendKeys(searchText + Keys.ENTER).perform();
    }

    public void pickThirdSearchResult(){
        WebElement el = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(thirdOption));
        System.out.println("after el");
        el.click();
    }
}
