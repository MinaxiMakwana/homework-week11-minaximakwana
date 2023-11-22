package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //set browser
        WebElement login = driver.findElement(By.linkText("Log in"));
        login.click();
        String expectedText = "Welcome, Please Sign in!";
        //finding actual element
        WebElement actualTextElement = driver.findElement(By.xpath("//h1"));
        String actualText = actualTextElement.getText();
        //identifying assertion
        Assert.assertEquals("Not redirected to login page", expectedText, actualText);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //login page
        WebElement login = driver.findElement(By.linkText("Log in"));
        login.click();

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("mm@gmail.com");

        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("123Abc");

       // driver.findElements(By.xpath("//button[@class='button-1 login-button']")).click(); - this method was giving me an error
        WebElement logInButton = driver.findElement(By.className("login-button"));
        logInButton.click();

        String expectedMessage = "Log out";

        String actualMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();

        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);

      }
      @Test
      public void verifyTheErrorMessage (){
          WebElement login = driver.findElement(By.linkText("Log in"));
          login.click();

          WebElement email = driver.findElement(By.id("Email"));
          email.sendKeys("m@gmail.com");

          WebElement password = driver.findElement(By.name("Password"));
          password.sendKeys("123Ab");

          driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();

          String expectedMessage = "Login was unsuccessful. Please correct the errors and try again. \n " +
                                    "No customer account found";

          String actualMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();

          Assert.assertEquals("Error message displayed", expectedMessage, actualMessage);

      }

      @After
    public void tearDown(){
        closeBrowser();
      }
}
