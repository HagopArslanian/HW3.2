package learningCenterTests;

import static org.testng.Assert.*;

import base.BaseTest;
import constants.locators.AlibabaLearningCenterPageConstants;
import constants.locators.AlibabaSignInPageConstants;
import constants.messages.ErrorMessages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AlibabaLearningCenterPage;
import pages.AlibabaSignInPage;

import java.util.concurrent.TimeUnit;

public class LearningCenterTests extends BaseTest {

    private By startSellingForm = By.className(AlibabaLearningCenterPageConstants.START_SELLING_FORM_CONFIRMATION);
    private By signInButton = By.id(AlibabaSignInPageConstants.SIGNIN_BUTTON);

    @Test
    public void testGoToPricingStartSellingForm(){
        AlibabaLearningCenterPage learningCenter = goHome().navigateToLearningCenterPage();
        learningCenter.goToPricing();
        assertTrue(driver.findElements(startSellingForm).size() != 0, ErrorMessages.START_SELLING_FORM_NOT_FOUND_MESSAGE);
    }

    @Test
    public void testGoToSignInPageFromLearningCenter(){
        AlibabaLearningCenterPage learningCenter = goHome().navigateToLearningCenterPage();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        learningCenter.signInFromLearningCenter();
        assertTrue(driver.findElements(signInButton).size() != 0, ErrorMessages.SIGNIN_PAGE_NOT_FOUND_FROM_LEARNING_CENTER_MESSAGE);
    }
}
