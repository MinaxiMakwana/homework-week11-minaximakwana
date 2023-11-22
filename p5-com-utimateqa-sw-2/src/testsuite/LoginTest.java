package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

   @Test
   public void userShouldNavigateToLoginPageSuccessfully(){

        //click on the ‘Sign In’ link
       WebElement login = driver.findElement(By.xpath(  "href=\"/users/sign_in\""));
       login.click();

       //Verify the text ‘Welcome Back!’
       driver.findElement(By.xpath("page__heading")).click();
   }
    @Test
   public void verifyTheErrorMessage(){

       WebElement login = driver.findElement(By.linkText("Sign In"));
       login.click();
       //enter invalid user name
       WebElement email = driver.findElement(By.id("username"));
       email.sendKeys("mm@gmail.com");
       //Enter invalid password
       WebElement password = driver.findElement(By.name("Password"));
       password.sendKeys("123Abcd!");
       //login button
       driver.findElement(By.xpath("class=\"button button-primary g-recaptcha\"")).click();

       //Verify the error message ‘Invalid email or password.’
       String expectedMessage = "Invalid email or password.";

       String actualMessage = driver.findElement(By.xpath("class=\"form-error__list-item\"")).getText();

       Assert.assertEquals("Wrong error message", expectedMessage, actualMessage);
   }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
