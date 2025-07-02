import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlayList() throws InterruptedException {

        String expectedSongaddedMessage = "Added 1 song into \"Test.\"";

        navigateUrl();

        provideEmail("akima.gordon@testpro.io");
        providePassword("BabyboiAz1!");
        clickSubmit();
        Thread.sleep(2000);

        searchSong("Episode 2");
        clickSubmit();

        clickVeiwAllBtn();
        clickFirstSong();
        clickAddTo();

        selectPlaylist("Test");


        Assert.assertEquals(getAddToPlayListSuccessmsg(), expectedSongaddedMessage);


    }
}
