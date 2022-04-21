package pages;

import constants.locators.AlibabaLoggedInUserHomePageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlibabaLoggedInUserHomePage {
    private WebDriver driver;
    private By myAccount = By.xpath(AlibabaLoggedInUserHomePageConstants.MY_ACCOUNT);

    AlibabaLoggedInUserHomePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean loggedInConfirmation(){
        return driver.findElements(myAccount).size() != 0;
    }

}
