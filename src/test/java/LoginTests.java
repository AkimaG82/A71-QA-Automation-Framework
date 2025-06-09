import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {


    @Test
    public void loginValidEmail(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    //Opening a browser
        WebDriver driver = new ChromeDriver(options);

        String Url = "https://qa.koel.app/";

        //Steps
        //Step 1: Navigate to Koels app
        driver.get(Url);
        //Step 2: Enter username
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.sendKeys("akima.gordon@testpro.io");
        //Step 3: enter password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("BabyboiAz1!");
        //Step 4: click on submit
        WebElement submitButton = driver.findElement(By.cssSelector("butto[type='submit']"));
        submitButton.click();
        //Step 5: Verify user logged in
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());

    }
}