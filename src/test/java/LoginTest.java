import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class LoginTest extends BaseTest {


    @Test
    public void loginValidEmailPassword(){


        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


//        loginPage.provideEmail("incorrect@testpro.io");
//        loginPage.providePassword("BabyboiAz1!");
//        loginPage.clickSubmit();

        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
//
//
//
//    public void loginValidEmailEmptyPassword() throws InterruptedException {
//        navigateToPage();
//        provideEmail("akima.gordon@testpro.io");
//        providePassword("");
//        clickSubmit();
//
//
//        WebElement userAvatar = driver.findElement(By.cssSelector("img[class='avatar']"));
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//    }
//
//    @Test(dataProvider = "IncorrectLoginData", dataProviderClass = TestDataProvider.class)
//    public void negativeTesting(String email, String password) throws InterruptedException {
//        provideEmail(email);
//        providePassword(password);
//        clickSubmit();
//
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//    }
//

