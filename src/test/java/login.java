import Utils.DriverUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static Utils.DriverUtils.getWebDriver;
import static Utils.DriverUtils.waitAndClick;

public class login {
    WebDriver driver;
    logInOOP oop = new logInOOP();

    @BeforeClass
    void setup() throws InterruptedException {
        driver = getWebDriver();
        driver.get("http://automationpractice.com/");
        driver.manage().window().fullscreen();
        Thread.sleep(5000);
    }

    @Test
    void logInFromProperties() throws InterruptedException {
        driver.findElement((oop.SignIn)).click();
        DriverUtils.waitAndClick(driver, (oop.email), 15);
        WebElement usernameEl = driver.findElement((oop.email));
        String email = DriverUtils.initializeProperties().getProperty("email");
        usernameEl.sendKeys(email);
        DriverUtils.waitAndClick(driver, (oop.password), 15);
        WebElement userpassEl = driver.findElement((oop.password));
        String password = DriverUtils.initializeProperties().getProperty("password");
        userpassEl.sendKeys(password);
        DriverUtils.waitAndClick(driver, (oop.loginButton), 15);
        DriverUtils.waitAndClick(driver, (oop.WomenTab), 15);
        driver.manage().window().fullscreen();
        DriverUtils.waitAndClick(driver, (oop.Catagory), 15);
        DriverUtils.waitAndClick(driver, (oop.Size), 15);

        List<WebElement> el = driver.findElements(oop.SelectItems);
        Faker f = new Faker();
        int randomnum = f.random().nextInt(0, el.size() - 1);
        el.get(randomnum).click();
        Thread.sleep(5000);
        DriverUtils.waitAndClick(driver, (oop.AddToCartButton), 15);
        DriverUtils.waitAndClick(driver, (oop.ContinueShoppingButton), 15);
        String quantity = driver.findElement(oop.QuantityBox).getText();

        int counter = 1;
        Assert.assertTrue(quantity.contains(String.valueOf(counter++)));
        waitAndClick(driver, oop.WomenTab, 15);
        waitAndClick(driver, oop.Tops, 15);
        DriverUtils.waitAndClick(driver, (oop.TopsSize), 15);
        List<WebElement> ele = driver.findElements(oop.TopsItemBox);
        for (int i = 0; i < ele.size(); i++) {
            DriverUtils.clickUsingJS(driver, ele.get(i));
            String quantity2 = driver.findElement(oop.QuantityBox).getText();
            int count = 1;
            Assert.assertTrue(quantity2.contains(String.valueOf(count++)));
        }
        waitAndClick(driver, (oop.Cart), 15);
        waitAndClick(driver, (oop.ProccedToCheckoutButton), 15);
        waitAndClick(driver, (oop.addressProccedToCheckout), 15);
        waitAndClick(driver, (oop.termsAndConditon), 15);
        waitAndClick(driver, (oop.ShippingProccedToCheckout), 15);
        Thread.sleep(5000);
        String TotalProductPrice = (driver.findElement(By.cssSelector("#total_product"))).getText();
        TotalProductPrice = TotalProductPrice.replace("$", "");
        String ShippingPrice = driver.findElement(By.cssSelector("#total_shipping")).getText();
        ShippingPrice = ShippingPrice.replace("$", "");
        String total = ((driver.findElement(By.cssSelector("#total_price_container"))).getText());
        Double assartPrice = (Double.valueOf(TotalProductPrice) + Double.valueOf(ShippingPrice));
        Assert.assertTrue(total.contains(String.valueOf(assartPrice)));
    }
    @AfterClass
    void quit() {
        driver.quit();
    }
}

