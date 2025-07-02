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
    public void loginValidEmail() throws InterruptedException {
        //Allows for remote connections from intelliJ to chrome without interruptions, while options opend chrome with the specified settings
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-originis=*");

        //Open's browser while passings options as the settings for the webdriver
        WebDriver driver = new ChromeDriver(options);
        String url = "https://qa.koel.app/";

        //Steps
        //Step1: navigate to Koel app
        driver.get(url);
        //Step2: Enter username
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.sendKeys("akima.gordon@testpro.io");
        //Step3: Enter password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("BabyboiAz1!");
        //Step4: click submit buton
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);
        //Step5:Verify if user is logged in
        WebElement userAvatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(userAvatar.isDisplayed());
        //closing browser
        driver.quit();
    }
}