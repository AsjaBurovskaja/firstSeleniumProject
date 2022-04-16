import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TopUpMobileTest {

    @Test
    public void topUpMobile() {
        System.setProperty("webdriver.chrome.driver" , "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        By phoneCodeDropdown = By.xpath("//button[@data-qa-node=\"phone-code\"]");
        By phoneCodeInput = By.xpath("//div[@data-qa-node=\"phone-code-list\"]//input");
        By phoneCodeOption = By.xpath("//button[@data-qa-node=\"phone-code-option\"]");
        By phoneNumberInput = By.xpath("//input[@data-qa-node=\"phone-number\"]");
        By sumInput = By.xpath("//input[@data-qa-node=\"amount\"]");
        By cardNumber = By.xpath("//input[@data-qa-node=\"numberdebitSource\"]");
        By cardExpirationDate = By.xpath("//input[@data-qa-node=\"expiredebitSource\"]");
        By cardCvvCode = By.xpath("//input[@data-qa-node=\"cvvdebitSource\"]");
        By cardFirstName = By.xpath("//input[@data-qa-node=\"firstNamedebitSource\"]");
        By cardLastName = By.xpath("//input[@data-qa-node=\"lastNamedebitSource\"]");
        By submit = By.xpath("//button[@data-qa-node=\"submit\" ]");
        By actualCardFrom = By.xpath("//td[@data-qa-node=\"card\"]");

        driver.get("https://next.privat24.ua/mobile");
        driver.findElement(phoneCodeDropdown).click();
        driver.findElement(phoneCodeInput).sendKeys("+380");
        driver.findElement(phoneCodeOption).click();
        driver.findElement(phoneNumberInput).sendKeys("934130549");
        driver.findElement(sumInput).sendKeys("30");
        driver.findElement(cardNumber).sendKeys("4004159115449003");
        driver.findElement(cardExpirationDate).sendKeys("1123");
        driver.findElement(cardCvvCode).sendKeys("123");
        driver.findElement(cardFirstName).sendKeys("TARAS");
        driver.findElement(cardLastName).sendKeys("SHEVCHENKO");
        driver.findElement(submit).click();

        Assert.assertEquals("4004 **** **** 9003" , driver.findElement(actualCardFrom).getText());

        //negative
        //Assert.assertEquals("4004 **** **** 9000" , driver.findElement(actualCardFrom).getText());

        driver.close();
    }
}
