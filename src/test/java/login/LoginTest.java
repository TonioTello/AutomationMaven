package login;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends BaseTests {


    @Test
    public void testSucessfullLogin(){
        LoginPage loginPage=  homePage.clickFormAuthentication();
        loginPage.setUsernameField("tomsmith");
        loginPage.setPasswordField("SuperSecretPassword!!");
        SecureAreaPage secureAreaPage =  loginPage.clickLoginButton();
        //assertEquals(secureAreaPage.getAlertText(),"You logged into a secure area!", "Alert text is incorrect");
        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"), "Alert text is incorrect");
    }

}

