package testsuite;

import browserfactory.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){

        WebElement login = driver.findElement(By.linkText("Login"));
        login.click();

        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("admin123");

        driver.findElement(By.xpath("oxd-button oxd-button--medium oxd-button--main orangehrm-login-button")).click();
    }
}
