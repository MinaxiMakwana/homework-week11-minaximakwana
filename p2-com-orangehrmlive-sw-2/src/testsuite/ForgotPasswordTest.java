package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ForgotPasswordTest extends BaseTest {

    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfuly(){

        //click on the ‘Forgot your password’ link
        driver.findElement(By.xpath("oxd-text oxd-text--p orangehrm-login-forgot-header")).click();
        //Verify the text ‘Reset Password’
        driver.findElement(By.xpath("oxd-button oxd-button--large oxd-button--secondary orangehrm-forgot-password-button orangehrm-forgot-password-button--reset")).click();

        String expectedMessage = "Reset Password link sent successfully";

        String actualMessage = driver.findElement(By.xpath("orangehrm-card-container")).getText();

        Assert.assertEquals("Error message displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown(){

        closeBrowser();
    }
}

