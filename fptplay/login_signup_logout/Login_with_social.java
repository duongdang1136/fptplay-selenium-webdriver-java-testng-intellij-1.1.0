package login_signup_logout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Login_with_social {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public  void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Login_withFacebook_secondtime(){
        //Login Page Title
        driver.get("https://vi-vn.facebook.com/");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("0911002100");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("duong3590013A.");
        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();
        driver.get("https://fptplay.vn/");
        driver.findElement(By.xpath("//a[@id='dang-nhap']")).click();
        driver.findElement(By.xpath("//img[contains(@alt,'login facebook')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Tiếp tục')]")).click();
        driver.findElement(By.xpath("//a[@id='trang-ca-nhan']")).click();
        String getCurrentUrl = driver.getCurrentUrl();
        Assert.assertEquals(getCurrentUrl,"https://fptplay.vn/tai-khoan/thong-tin-ca-nhan");
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
