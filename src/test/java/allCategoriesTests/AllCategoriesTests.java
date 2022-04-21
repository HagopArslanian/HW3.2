package allCategoriesTests;

import static org.testng.Assert.*;

import base.BaseTest;
import constants.locators.AlibabaAllCategoriesPageConstants;
import constants.messages.ErrorMessages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AlibabaAllCategoriesPage;
import pages.AlibabaHomePage;

public class AllCategoriesTests extends BaseTest {

    private By claimNow = By.linkText(AlibabaAllCategoriesPageConstants.FIRST_ITEM_CLAIMABILITY_CONFIRMATION);

    @Test
    public void computerCategoryFirstOption(){
        AlibabaAllCategoriesPage categories = goHome().navigateToAllCategoriesPage();
        categories.goToElectronics();
        categories.navigateToComputerHardwareCategory();
        assertTrue(driver.findElements(claimNow).size() != 0, ErrorMessages.ITEM_CLAIMABILITY_NOT_FOUND_MESSAGE);
    }
}
