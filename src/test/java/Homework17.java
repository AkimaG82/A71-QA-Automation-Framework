import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlayList() throws InterruptedException {

        String expectedSongaddedMessage = "Created Playlist \"Test\"";

        navigateUrl();

        provideEmail("akima.gordon@testpro.io");
        providePassword("BabyboiAz1!");
        clickSubmit();
        Thread.sleep(2000);

        searchBox("Episode 2");
        clickSubmit();

        veiwAllButton();
        clickFirstSong();
        clickAddTo();

        createNewPlaylist("Test");
        newPlaylistSaveBtn();

        Assert.assertEquals("Created Playlist \'Test\'");


    }
}
