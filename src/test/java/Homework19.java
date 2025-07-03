import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.UUID;

import static org.bouncycastle.cms.RecipientId.password;

public class Homework19 extends BaseTest {

    public void deletePlaylist() throws InterruptedException{
        String expectedPlaylistDeleteMessage = "Deleted playlist \"Test Playlist."\";

        provideEmail("akima.gordon@testpro.io");
        providePassword("BabyboiaAz1!");
        clickSubmit();

        openPlaylist();
        clickDeletePlaylist();

    }

    public void openPlaylist() {
        WebElement emptyPlaylist = driver.findElement(By.);
    }
}
