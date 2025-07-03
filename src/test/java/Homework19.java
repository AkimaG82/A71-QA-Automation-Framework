import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException{
        String expectedPlaylistDeleteMessage = "Deleted playlist \"Test Playlist.\"";

        provideEmail("akima.gordon@testpro.io");
        providePassword("BabyboiaAz1!");
        clickSubmit();

        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeleteMessage);

    }


}
