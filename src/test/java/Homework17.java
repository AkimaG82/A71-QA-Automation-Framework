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
    public void addSongToPlayList() throws InterruptedException {

        navigateUrl();

        provideEmail("akima.gordon@testpro.io");
        providePassword("BabyboiAz1!");
        clickSubmit();
        Thread.sleep(2000);

        searchBox("Episode 2");
        clickSubmit();

        veiwAllButton();
        clickFirstSong();

        clickAddTo();



        WebElement save = driver.findElement(By.cssSelector("button[type='submit']"));

        WebElement test = driver.findElement(By.cssSelector("a[class='active']"));
        test.click();

      //  Assert.assertTrue();
    }
    public void searchBox(String song) {
        WebElement search = driver.findElement(By.cssSelector("input[type='search']");
        search.clear();
        search.sendKeys(song);
    }
    public void veiwAllButton() {
        WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAll.click();
    }
    public void clickFirstSong() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//td[contains(text(),\" 2'')]"));
        firstSong.click();
    }
    public void clickAddTo() {
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        addTo.click();
    }
    public void createNewPlaylist() {
        WebElement playListName = driver.findElement(By.cssSelector("//section[@id='songsWrapper']//input[@required='required']"));
        playListName.click();
        playListName.sendKeys("First Playlist");
    }
}
