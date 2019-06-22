import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Autotest {
    public static void main(String[] args) throws InterruptedException {
// Create a new instance of the Firefox driver
        File gecko = new File("G:\\seleniumLab\\chromedriver.exe");
        System.setProperty("driver.gecko.driver", gecko.getAbsolutePath());
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.accounts.google.com/ServiceLogin?");

        //gmail login
        driver.findElement(By.id("Email")).sendKeys("boscodilla@gmail.com");
        driver.findElement(By.id("next")).click();
        driver.findElement(By.id("Passwd")).sendKeys("clickdb@123GOD");
        driver.findElement(By.id("signIn")).click();


        //
//Wait for 5000 Sec
        Thread.sleep(5);
// Close the drivers
        driver.quit();
    }
}

