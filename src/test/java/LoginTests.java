import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(enabled = true, description = "this is paused until issue fixed")
    public void loginValidEmail() throws InterruptedException {

        navigateUrl();
        provideEmail("akima.gordon@testpro.io");
        providePassword("BabyboiAz1!");
        clickSubmit();
        Thread.sleep(2000);



        WebElement userAvatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(userAvatar.isDisplayed());

    }



    @Test
    public void loginInvalidEmailPassword() throws InterruptedException {
        navigateUrl();
        provideEmail("incorrect@testpro.io");
        providePassword("BabyboiAz1!");
        clickSubmit();
        Thread.sleep(2000);


        WebElement userAvatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        navigateUrl();
        provideEmail("akima.gordon@testpro.io");
        providePassword("");
        clickSubmit();
        Thread.sleep(2000);


        WebElement userAvatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}

