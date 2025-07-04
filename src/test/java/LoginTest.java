import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void loginValidEmail() throws InterruptedException {

        navigateToPage();
        provideEmail("akima.gordon@testpro.io");
        providePassword("BabyboiAz1!");
        clickSubmit();



        WebElement userAvatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(userAvatar.isDisplayed());

    }



    public void loginInvalidEmailPassword() throws InterruptedException {
        navigateToPage();
        provideEmail("incorrect@testpro.io");
        providePassword("BabyboiAz1!");
        clickSubmit();


        WebElement userAvatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }



    public void loginValidEmailEmptyPassword() throws InterruptedException {
        navigateToPage();
        provideEmail("akima.gordon@testpro.io");
        providePassword("");
        clickSubmit();


        WebElement userAvatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test(dataProvider = "IncorrectLoginData", dataProviderClass = TestDataProvider.class)
    public void negativeTesting(String email, String password) throws InterruptedException {
        provideEmail(email);
        providePassword(password);
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}

