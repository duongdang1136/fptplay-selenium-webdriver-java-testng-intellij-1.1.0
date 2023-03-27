package login_signup_logout;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class ChinhsachvaQuydinh {
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
    }
    @Test
    public void TC_01_CSQD_inSignUp(){
        driver.get("https://fptplay.vn/");
        driver.findElement(By.xpath("//a[@id='dang-nhap']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Đăng ký miễn phí')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Chính sách và quy định')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @Test
    public void TC_02_CSQD_inForgetPass(){
        driver.get("https://fptplay.vn/");
        driver.findElement(By.xpath("//a[@id='dang-nhap']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Quên mật khẩu')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Chính sách và quy định')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
