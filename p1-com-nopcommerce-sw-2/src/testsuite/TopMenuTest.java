package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {
    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToComputerPageSuccessfully (){
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();
        String expectedText = "Computer";
        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics']")).click();
        String expectedText = "Electronics";
        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToApparelPageSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Apparel']")).click();
        String expectedText = "Electronics";
        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Apparel']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='DigitalDownloads']")).click();
        String expectedText = "DigitalDownloads";
        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='DigitalDownloads']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Books']")).click();
        String expectedText = "Books";
        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Books']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Jewelry']")).click();
        String expectedText = "Jewelry";
        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Jewelry']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='GiftCards']")).click();
        String expectedText = "GiftCards";
        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='GiftCards']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
