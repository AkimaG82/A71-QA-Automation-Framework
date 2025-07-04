import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest{
    @Test
    public void changeProfileName() throws InterruptedException{
        navigateToPage();

        provideEmail("akima.gordon@testpro.io");
        providePassword("BabyboiAz1!");
        clickSubmit();

        String randomName = randomName();

        clickAvatarIcon();
        provideCurrentPassword("BabyboiAz1!");
        provideProfileName(randomName);
        saveButton();

       wait.until(
                ExpectedConditions.textToBe(By.cssSelector("span[class='name']"), randomName));
        WebElement actualProfileName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='name']")));
      // Assert.assertEquals(actualProfileName.getText(), randomName);
    }

}
