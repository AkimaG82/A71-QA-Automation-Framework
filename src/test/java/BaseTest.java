import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    public WebDriver driver = null;
    public String url = null;
    WebDriverWait wait;


    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void initiateBrowser(String baseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();//maximizes chrome window
        url = baseURL;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        navigateToPage();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    //The medthods listed below are known as helper methods
    public void navigateToPage(){
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));

        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password){
        WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submit = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();

    }

    public String randomName(){
        //this function generates random string. "-" is replaced by""
        return UUID.randomUUID().toString().replace("-","");
    }

    public void clickAvatarIcon(){
        WebElement avatarIcon = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        avatarIcon.click();
    }

    public void provideCurrentPassword(String password){
        WebElement currentPassword = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public void provideProfileName(String randomName){
        WebElement profileName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public void saveButton(){
        WebElement saveButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-submit")));
        saveButton.click();
    }

    public void searchBox(String song) {
        WebElement search = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
        search.clear();
        search.sendKeys(song);
    }

    public void veiwAllButton() {
        WebElement viewAll = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test='view-all-songs-btn']")));
        viewAll.click();
    }

    public void clickAddTo() {
        WebElement addTo = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-add-to")));
        addTo.click();
    }

    public void createNewPlaylist(String name) {
        WebElement playListName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songsWrapper']//input[@required='required']")));
        playListName.click();
        playListName.sendKeys(name);
    }

    public void newPlaylistSaveBtn() {
        WebElement save = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//button[@title='Save']")));
        save.click();
    }


    public void clickPlay(){
        WebElement playNextButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//si[@data-testid='play-next-btn']")));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));



        playNextButton.click();
        playButton.click();
    }

    public boolean songIsPlaying(){
        WebElement soundBar = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='sound-bar-play']")));
        return soundBar.isDisplayed();
    }

    public void openPlaylist(String playlistName) {
        WebElement emptyPlaylist = wait.until(
                ExpectedConditions.visibilityOfElementLocated( By.xpath("//section[@id='playlists']//a[contains(text(), '" + playlistName + "')]")));
        emptyPlaylist.click();
    }

    public void clickDeletePlaylistBtn(){
        WebElement deletePlaylist = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.fa.fa-times")));//.btn-delete-playlist
        deletePlaylist.click();
        
    }

    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }
}