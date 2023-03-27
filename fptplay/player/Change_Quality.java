package player;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class Change_Quality {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public  void beforeClass(){
        if (osName.contains("Windows")){
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        }else{
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://fptplay.vn/");
        driver.findElement(By.xpath("//a[@id='dang-nhap']")).click();
        driver.findElement(By.xpath("//input[@id='phone-input']")).sendKeys("0968790025");
        driver.findElement(By.xpath("//input[@id='password-input']")).sendKeys("222222");
        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Tiếp tục')]")).click();
    }

    @Test
    public void TC_01_ChangeProfile_1080p_NonDRM(){
        driver.get("https://fptplay.vn/xem-video/giao-uoc-tu-hai-the-gioi-641d073cfe957cc7da653828");
        driver.findElement(By.xpath("//button[contains(@class,'resolution-switcher')]")).click();
        driver.findElement(By.xpath("//div[@id='1080p']")).click();
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @Test
    public void TC_02_ChangeProfile_720p_NonDRM(){
        driver.get("https://fptplay.vn/xem-video/giao-uoc-tu-hai-the-gioi-641d073cfe957cc7da653828");
        driver.findElement(By.xpath("//button[contains(@class,'resolution-switcher')]")).click();
        driver.findElement(By.xpath("//div[@id='720p']")).click();
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @Test
    public void TC_03_ChangeProfile_480p_NonDRM(){
        driver.get("https://fptplay.vn/xem-video/giao-uoc-tu-hai-the-gioi-641d073cfe957cc7da653828");
        driver.findElement(By.xpath("//button[contains(@class,'resolution-switcher')]")).click();
        driver.findElement(By.xpath("//div[@id='480p']")).click();
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @Test
    public void TC_04_ChangeProfile_360p_NonDRM(){
        driver.get("https://fptplay.vn/xem-video/giao-uoc-tu-hai-the-gioi-641d073cfe957cc7da653828");
        driver.findElement(By.xpath("//button[contains(@class,'resolution-switcher')]")).click();
        driver.findElement(By.xpath("//div[@id='360p']")).click();
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void TC_05_SaveProfile_whenNextMovie_NonDRM(){
        driver.get("https://fptplay.vn/xem-video/giao-uoc-tu-hai-the-gioi-641d073cfe957cc7da653828");
        driver.findElement(By.xpath("//button[contains(@class,'resolution-switcher')]")).click();
        driver.findElement(By.xpath("//div[@id='360p']")).click();
        driver.get("https://fptplay.vn/xem-video/dua-voi-tinh-yeu-63576b8c32dcafcc2907f9c2");
        driver.findElement(By.xpath("//button[contains(@class,'resolution-switcher')]")).click();
        boolean isTheTextPresent = driver.getPageSource().contains("//button[contains(@class,'resolution-item selected')]");
        Assert.assertTrue(isTheTextPresent);
    }
    @Test
    public void TC_06_SaveProfile_whenNextChapter_NonDRM(){
        driver.get("https://fptplay.vn/xem-video/giao-uoc-tu-hai-the-gioi-641d073cfe957cc7da653828");
        driver.findElement(By.xpath("//button[contains(@class,'resolution-switcher')]")).click();
        driver.findElement(By.xpath("//div[@id='360p']")).click();
        driver.findElement(By.xpath("//button[@id='next-video-button']")).click();
        driver.findElement(By.xpath("//button[contains(@class,'resolution-switcher')]")).click();
        String PageSource = driver.getPageSource();
        System.out.println("Page Source is : " + PageSource);
    }

        @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
