import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {

        navigateToPage();
        provideEmail("akima.gordon@testpro.io");
        providePassword("BabyboiAz1!");
        clickSubmit();

        Assert.assertTrue(songIsPlaying());


        }

}
