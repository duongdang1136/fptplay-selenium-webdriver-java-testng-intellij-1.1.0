package login_signup_logout;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Login {
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
    public void TC_01_Login_withPhoneNumber_Successful(){
        //Login Page Title
        driver.get("https://fptplay.vn/");
        driver.findElement(By.xpath("//a[@id='dang-nhap']")).click();
        driver.findElement(By.xpath("//input[@id='phone-input']")).sendKeys("0968790025");
        driver.findElement(By.xpath("//input[@id='password-input']")).sendKeys("222222");
        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
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
