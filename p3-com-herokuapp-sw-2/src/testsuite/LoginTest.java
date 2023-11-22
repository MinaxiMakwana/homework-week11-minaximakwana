package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    static String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //Enter “tomsmith” username
        WebElement login = driver.findElement(By.linkText("Login Page"));
        login.click();

        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("SuperSecretPassword!");
        //login button
        driver.findElement(By.xpath("radius")).click();

        //Verify the text “Secure Area”
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";

        String actualMessage = driver.findElement(By.xpath("subheader")).getText();

        Assert.assertEquals("Error message displayed", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage(){

        WebElement login = driver.findElement(By.linkText("Login Page"));
        login.click();
        //Enter invalid “tomsmith1” username
        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("SuperSecretPassword!");
        //login button
        driver.findElement(By.xpath("radius")).click();

        //verify the error message"your username is invalid"
        String expectedMessage = "Your username is invalid!";

        String actualMessage = driver.findElement(By.xpath("class=\"flash error\"")).getText();

        Assert.assertEquals("Error message displayed", expectedMessage, actualMessage);

    }

    @Test
    public void verifyThePasswordErrorMessage(){

        WebElement login = driver.findElement(By.linkText("Login Page"));
        login.click();
        //Enter “tomsmith” username
        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("tomsmith");
        //Enter invalid “SuperSecretPassword” password
        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("SuperSecret");
        //login button
        driver.findElement(By.xpath("radius")).click();

        //verify the error message"your username is invalid"
        String expectedMessage = "Your password is invalid!";

        String actualMessage = driver.findElement(By.xpath("flash error")).getText();

        Assert.assertEquals("Error message displayed", expectedMessage, actualMessage);
    }

    @After
    public void teeardown(){
        closeBrowser();
    }
}
