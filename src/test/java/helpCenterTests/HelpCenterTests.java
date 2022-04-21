package helpCenterTests;

import static org.testng.Assert.*;

import base.BaseTest;
import constants.locators.AlibabaHelpCenterPageConstants;
import constants.locators.AlibabaHelpCenterSearchPageConstants;
import constants.messages.ErrorMessages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AlibabaHelpCenterPage;
import pages.AlibabaHelpCenterSearchPage;
import pages.AlibabaHomePage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HelpCenterTests extends BaseTest {
    private String wrongSearchText;
    private String rightSearchText;
    private By thirdOptionTitle = By.xpath(AlibabaHelpCenterSearchPageConstants.THIRD_HELP_OPTION_CONFIRMATION_TEXT);
    private By alibabaAppConfirm = By.xpath(AlibabaHelpCenterPageConstants.APP_DOWNLOAD_CONFIRMATION);

    @Test
    public void testGetApp(){
        AlibabaHomePage homePage = goHome();
        AlibabaHelpCenterPage helpCenter = homePage.navigateToHelpCenterPage();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        helpCenter.getTheApp();
        switchToTab("Alibaba.com Download");
        assertTrue(driver.findElement(alibabaAppConfirm).getText().contains("App"), ErrorMessages.DOWNLOAD_APP_PAGE_NOT_FOUND_MESSAGE);
    }

    @Test
    public void searchHelp(){
        wrongSearchText = "passwowd";
        rightSearchText = "password";
        AlibabaHomePage homePage = goHome();
        AlibabaHelpCenterPage helpCenter = homePage.navigateToHelpCenterPage();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("test");
        AlibabaHelpCenterSearchPage helpCenterSearch = helpCenter.search(wrongSearchText);
        helpCenterSearch.changeSearch(rightSearchText);
        helpCenterSearch.pickThirdSearchResult();
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(2));
        assertTrue(driver.findElement(thirdOptionTitle).getText().contains(rightSearchText), ErrorMessages.HELP_CENTER_SEARCH_MESSAGE);
    }
}
