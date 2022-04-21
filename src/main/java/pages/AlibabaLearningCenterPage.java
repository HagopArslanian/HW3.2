package pages;

import constants.locators.AlibabaHomePageConstants;
import constants.locators.AlibabaLearningCenterPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlibabaLearningCenterPage {
    private WebDriver driver;
    private By pricing = By.xpath(AlibabaLearningCenterPageConstants.PRICING);
    private By startSelling = By.xpath(AlibabaLearningCenterPageConstants.START_SELLING);
    private By signIn = By.linkText(AlibabaHomePageConstants.SIGNIN_BUTTON);

    public AlibabaLearningCenterPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToPricing(){
        driver.findElement(pricing).click();
        //start selling to see if the form will pop up
        driver.findElement(startSelling).click();
    }

    public AlibabaSignInPage signInFromLearningCenter(){
        driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/nav[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]")).click();
        return new AlibabaSignInPage(driver);
    }

}
