import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Locale;
import java.util.UUID;

public class ActionsTest extends BaseTest {

    @Test
    public void playSongTest() throws InterruptedException {

        Actions actions = new Actions(driver);
//This is the code used to right-click and play song. Remember to copy it from selenium actions site
        provideEmail("akima.gordon@testpro.io");
        providePassword("BabyboiAz1!");
        clickSubmit();
        driver.findElement(By.cssSelector(".music .song")).click();
        WebElement song = driver.findElement((By.cssSelector(".song-list-wrsp .scroller .items .title")));
        actions
                .contextClick(song)
                .perform();
        driver.findElement(By.cssSelector("li.playback")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.id("[data-testid='toggle-visualizer-btn']]")).isDisplayed());

//This is the code to hover over the play button and click to get the song to play
        WebElement footerPlayBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        Thread.sleep(2000);
        footerPlayBtn.click();
        actions.moveToElement(footerPlayBtn).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector("li.playback")).isDisplayed();
    }
/*The Faker objected can be used to generate random data
    public String generateRandomName(){
    Faker faker = new Faker(new Locale("en-US"));
    String newName = faker.
    }

 */


}
