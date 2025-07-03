import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider extends BaseTest {
    @DataProvider(name = "IncorrectLoginData")
    public static Object[][] negativeTestData() {
        return new Object[][]{
                {"Invalid@testpro.io", "InvalidPassword"},
                {"wron@testpro.io", "wrpngPassword"},
                {"Invalid@testpro.io", "BabyboiAz1"},
                {"", "BabyboiAz1!"},
                {"", ""}
        };
    }
    @DataProvider(name="deletePlaylist")
    public static Object[][]positiveTestingData(){
        return new Object[][]{
                {"akima.gordon@testpro.io", "BabyboiAz1!"}
        };
    }
}

