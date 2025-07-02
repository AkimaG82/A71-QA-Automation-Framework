import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest{
    @Test
    public void changeProfileName() throws InterruptedException{
        navigateUrl();

        provideEmail("akima.gordon@testpro.io");
        providePassword("BabyboiAz1!");
        clickSubmit();

        String randomName = randomName();
        Thread.sleep(2000);

        clickAvatarIcon();
        provideCurrentPassword("BabyboiAz1!");
        provideProfileName(randomName);
        saveButton();
        Thread.sleep(2000);

        WebElement actualProfileName = driver.findElement(By.cssSelector("span[class='name']"));
        Assert.assertEquals(actualProfileName.getText(), randomName);
    }

}
