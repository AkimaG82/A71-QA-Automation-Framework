import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(enabled = true, priority = 0, description = "Login with invalid email and valid password")
    public void loginValidEmail() throws InterruptedException {

        navigateUrl();
        provideEmail("akima.gordon@testpro.io");
        providePassword("BabyboiAz1!");
        clickSubmit();
        Thread.sleep(2000);



        WebElement userAvatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(userAvatar.isDisplayed());

    }


    @Test(enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginInvalidEmailPassword() throws InterruptedException {
        navigateUrl();
        provideEmail("incorrect@testpro.io");
        providePassword("BabyboiAz1!");
        clickSubmit();
        Thread.sleep(2000);


        WebElement userAvatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


    @Test(enabled = true, priority = 3, description = "Login with valid email and empty password")
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

