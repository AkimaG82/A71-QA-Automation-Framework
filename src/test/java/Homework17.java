import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlayList() {

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.sendKeys("akima.gordon@testpro.io");

        WebElement PasswordField = driver.findElement(By.cssSelector("input[type='password']"));
        PasswordField.click();
        PasswordField.sendKeys("BabyboiAz1!");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        WebElement search = driver.findElement(By.cssSelector("input[type='search']"));
        Assert.assertTrue(search.isDisplayed());
        search.click();
        search.sendKeys("Episode 2");

        WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAll.click();

        WebElement firstSong = driver.findElement(By.xpath("//table[class='items]/tr/td[contains(text(),'Episode 2')]"));
        firstSong.click();

        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        addTo.click();

        WebElement playListName = driver.findElement(By.cssSelector("input[required='required']"));
        playListName.click();
        playListName.sendKeys("First Playlist");

        WebElement save = driver.findElement(By.cssSelector("button[type='submit']"));

        WebElement test = driver.findElement(By.cssSelector("a[class='active']"));
        test.click();

      //  Assert.assertTrue();
    }
}
