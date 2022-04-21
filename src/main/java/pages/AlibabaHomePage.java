package pages;

import constants.locators.AlibabaHomePageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AlibabaHomePage {

    private WebDriver driver;
    private By homePageButton = By.linkText(AlibabaHomePageConstants.HOME_BUTTON);
    private By searchField = By.name(AlibabaHomePageConstants.SEARCH_FIELD);
    private By signInButton = By.linkText(AlibabaHomePageConstants.SIGNIN_BUTTON);
    private By helpCenterButton = By.linkText(AlibabaHomePageConstants.HELP_CENTER_BUTTON);
    private By allCategoriesButton = By.xpath(AlibabaHomePageConstants.ALL_CATEGORIES_BUTTON);
    private By learningCenterButton = By.linkText(AlibabaHomePageConstants.LEARNING_CENTER_BUTTON);

    public AlibabaHomePage(WebDriver driver){
        this.driver = driver;
    }

    public void GoToHomePage(){
        driver.findElement(homePageButton).click();
    }

    public AlibabaSignInPage navigateToSignInPage(){
        driver.findElement(signInButton).click();
        return new AlibabaSignInPage(driver);
    }

    public void search(String searchText){
        driver.findElement(searchField).sendKeys(searchText + Keys.ENTER);
    }

    public AlibabaHelpCenterPage navigateToHelpCenterPage(){
        driver.findElement(helpCenterButton).click();
        switchToTab(driver.findElement(helpCenterButton).getText());
        return new AlibabaHelpCenterPage(driver);
    }

    public AlibabaAllCategoriesPage navigateToAllCategoriesPage(){
        driver.findElement(allCategoriesButton).click();
        switchToTab("Manufacturers, Suppliers and Exporters Directory on Alibaba.com");
        return new AlibabaAllCategoriesPage(driver);
    }

    public AlibabaLearningCenterPage navigateToLearningCenterPage(){
        driver.findElement(learningCenterButton).click();
        switchToTab("Alibaba.com Seller Central | How to start selling on Alibaba.com");
        return new AlibabaLearningCenterPage(driver);
    }

    public void switchToTab(String tabTitle){
        var windows = driver.getWindowHandles();

        System.out.println("Number of tabs: " + windows.size());

        System.out.println("Window handles:");
        windows.forEach(System.out::println);

        for (String window: windows){
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);

            System.out.println("Current window title: " + driver.getTitle());

            if(tabTitle.equals(driver.getTitle())){
                break;
            }
        }
    }

}
