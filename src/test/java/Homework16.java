import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework16 extends BaseTest{

    @Test
    public void navigationToRegistrationPage(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        //navigate to url
        driver.get(url);
        //step1: find and click registration button
        WebElement registrationField = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationField.click();
        //step2:assert that text"You will receive an eamil with your new credentials" appears
        WebElement text = driver.findElement(By.cssSelector("span[class='small']"));
        Assert.assertTrue(text.isDisplayed());
        driver.quit();

    }
}
