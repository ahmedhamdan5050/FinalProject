import Utils.DriverUtils;
import Utils.ExcelUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class automationPractice extends DriverUtils {
    WebDriver driver;

    static final String ExcelFilePath = System.getProperty("user.dir") +"/resources/testData/finalProject.xlsx";

    @DataProvider
            (name = "loadFromData")
    public static Object[][] dataLoad() throws Exception {
        return ExcelUtils.getTableArray(ExcelFilePath);
    }

    @BeforeClass
    void setup() throws InterruptedException {
        driver = getWebDriver();
        driver.get("http://automationpractice.com/");
        driver.manage().window().fullscreen();
        Thread.sleep(5000);
    }

    @Test(dataProvider = "loadFromData")
    void createAnAccount(String FirstName, String LastName, String Email, String Password, String BateOfBirth, String First, String Last,
                         String address, String city,double Phone) throws InterruptedException {
        driver.findElement(By.cssSelector("div.header_user_info > a")).click();
        waitAndClick(driver, By.cssSelector("#email_create"), 6);
        Faker faker=new Faker();
        driver.findElement(By.cssSelector("#email_create")).sendKeys(faker.number().numberBetween(10,100)+"@gmail.com");
        driver.findElement(new By.ByXPath("//*[@id=\"SubmitCreate\"]")).click();
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        waitAndClick(driver, By.cssSelector("div.clearfix > div:nth-child(3) > label"), 15);

      waitAndClick(driver, By.cssSelector("#customer_firstname"),15);
        driver.findElement(By.cssSelector("#customer_firstname")).sendKeys(FirstName);
        driver.findElement(By.cssSelector("#customer_lastname")).sendKeys(LastName);
        driver.findElement(By.cssSelector("#passwd")).sendKeys(Password);
        WebElement day = driver.findElement(By.cssSelector("#days"));
        Select d = new Select(day);
        d.selectByIndex(22);

        WebElement month = driver.findElement(By.cssSelector("#months"));
        Select m = new Select(month);
        m.selectByIndex(5);

        WebElement year = driver.findElement(By.cssSelector("#years"));
        Select y = new Select(year);
        y.selectByIndex(25);
        scroll(driver,By.cssSelector("#address1"));
        driver.findElement(By.cssSelector("#address1")).sendKeys(address);
        driver.findElement(By.cssSelector("#city")).sendKeys(city);
        WebElement state = driver.findElement(By.cssSelector("#id_state"));
        Select s = new Select(state);
        s.selectByIndex(34);
        driver.findElement(By.cssSelector("#postcode")).sendKeys("14211");
        driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("9294039734");
        driver.findElement(new By.ByXPath("//*[@id=\"submitAccount\"]")).click();
        Thread.sleep(10000);

    }

    @AfterClass
    void quit() {
        driver.quit();
    }

}
