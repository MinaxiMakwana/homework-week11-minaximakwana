package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {

    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Register']")).click();
        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Register']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        //click on the ‘Register’ link
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Register']")).click();
        //Select gender radio button
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        //Enter First name
        driver.findElement(By.id("FirstName")).sendKeys("Mina");
        //Enter Last name
        driver.findElement(By.id("LastName")).sendKeys("Makwana");

        //Select Day Month and Year
        //day
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("01");
        //Month
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("01");
        //Year
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("2000");

        //email
        driver.findElement(By.id("Email")).sendKeys("mnm@gmail.com");
        //password
        driver.findElement(By.id("Password")).sendKeys("123Abc");
        //confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123Abc");
        //Click on register button
        driver.findElement(By.id("register-button"));

        //Verify the text 'Your registration completed’
        String expectedMessage = "Your registration completed";

        String actualMessage = driver.findElement(By.xpath("//div[@text()='your registration completed']")).getText();

        Assert.assertEquals("Your registration not completed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}

