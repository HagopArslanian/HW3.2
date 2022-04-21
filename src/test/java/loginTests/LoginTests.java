package loginTests;

import static org.testng.Assert.*;

import base.BaseTest;
import constants.messages.ErrorMessages;
import org.testng.annotations.Test;
import pages.AlibabaHomePage;
import pages.AlibabaLoggedInUserHomePage;
import pages.AlibabaSignInPage;

public class LoginTests extends BaseTest {

    @Test
    public void testFailedLogin(){
        AlibabaHomePage homePage = goHome();
        AlibabaSignInPage alibabaSignInPage = homePage.navigateToSignInPage();
        alibabaSignInPage.setAccount("invalid_gmail");
        alibabaSignInPage.setPassword("invalid_password");
        alibabaSignInPage.setStaySignedInCheckBox(false);//by default
        AlibabaLoggedInUserHomePage loggedInUserHomePage = alibabaSignInPage.clickSignInButton();
        assertTrue(loggedInUserHomePage.loggedInConfirmation(), ErrorMessages.LOGIN_FAILED_MESSAGE);
    }
}
