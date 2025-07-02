import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    public WebDriver driver = null;
    String url = "https://qa.koel.app/";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void initiateBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();//maximizes chrome window
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    //The medthods listed below are known as helper methods
    public void navigateUrl(){
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() throws InterruptedException {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

    }

    public String randomName(){
        //this function generates random string. "-" is replaced by""
        return UUID.randomUUID().toString().replace("-","");
    }

    public void clickAvatarIcon(){
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    public void provideCurrentPassword(String password){
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public void provideProfileName(String randomName){
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public void saveButton(){
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public void searchSong(String song) throws InterruptedException {
        WebElement search = driver.findElement(By.cssSelector("input[type='search']"));
        search.clear();
        search.sendKeys(song);
        Thread.sleep(2000);
    }

    public void clickVeiwAllBtn() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.cssSelector("input[type='search']"));
        viewAll.click();
        Thread.sleep(2000);
    }

    public void clickFirstSong() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//td[contains(text(),'Episode 2')]"));
        firstSong.click();
    }

    public void clickAddTo() {
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        addTo.click();
    }

    public void createNewPlaylist(String name) {
        WebElement playListName = driver.findElement(By.cssSelector("//section[@id='songsWrapper']//input[@required='required']"));
        playListName.click();
        playListName.sendKeys(name);
    }

    public void newPlaylistSaveBtn() {
        WebElement save = driver.findElement(By.cssSelector("//section[@id='songResultsWrapper']//button[@title='Save']"));
        save.click();
    }
}