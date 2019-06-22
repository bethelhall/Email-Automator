import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.List;
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
        driver.get("https://www.google.com/gmail/");

        //gmail login
        driver.findElement(By.id("identifierId")).sendKeys("boscodilla@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        driver.findElement(By.name("password")).sendKeys("clickdb@123GOD");
        driver.findElement(By.id("passwordNext")).click();


        //reach the gmail
        driver.findElement(By.xpath("//*[@title='Google apps']")).click();
        driver.findElement(By.id("gb23")).click();

        // now talking un-read email form inbox into a list
        List<WebElement> unreademeil = driver.findElements(By.xpath("//*[@class='zF']"));
        String MyMailer = "Meetup";
        for (int i = 0; i < unreademeil.size(); i++) {
            if (unreademeil.get(i).isDisplayed() == true) {
                // now verify if you have got mail form a specific mailer (Note Un-read mails)
                // for read mails xpath loactor will change but logic will remain same
                if (unreademeil.get(i).getText().equals(MyMailer)) {
                    System.out.println("Yes we have got mail form " + MyMailer);
                    // also you can perform more actions here
                    // like if you want to open email form the mailer
                    break;
                } else {
                    System.out.println("No mail form " + MyMailer);
                }
            }

            //
//Wait for 5000 Sec
            Thread.sleep(5);
// Close the drivers
            driver.quit();
        }
    }
}

