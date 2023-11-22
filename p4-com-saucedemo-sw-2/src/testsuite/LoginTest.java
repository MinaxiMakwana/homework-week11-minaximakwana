package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){

       //Enter “standard_user” username
        WebElement login = driver.findElement(By.name("Swag Labs"));
        login.click();

        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("standard_user");
        //Enter “secret_sauce” password
        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("secret_sauce");
        //login button
        driver.findElement(By.xpath("submit-button btn_action")).click();

        //Verify the text “PRODUCTS”
        String expectedHeading = "Products";

        String actualMessage = driver.findElement(By.xpath("class=\"title\"")).getText();

        Assert.assertEquals("Wrong Heading", expectedHeading, actualMessage);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        WebElement login = driver.findElement(By.name("Swag Labs"));
        login.click();

        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("standard_user");
        //Enter “secret_sauce” password
        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("secret_sauce");
        //login button
        driver.findElement(By.xpath("submit-button btn_action")).click();

        //Verify that six products are displayed on page
        List<WebElement> products = driver.findElements(By.id("id=\"inventory_container\""));
        //declaring variable
        String expectedList = "productList";
        Assert.assertTrue("six products are not displayed on page", products.size()==6);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
