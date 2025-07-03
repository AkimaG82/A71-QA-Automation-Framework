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

    public void deletePlaylist() {

        @Test(dataProvider = "deletePlaylist", dataProviderClass = TestDataProvider.class)
        public void negativeTesting (String email, String password) throws InterruptedException {
            provideEmail(email);
            providePassword(password);
            clickSubmit();
            Thread.sleep(2000);
        }
    }
}
