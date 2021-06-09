package levunguyen.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LazadaSearchTest {

    private WebDriver driver;



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.lazada.vn/");

    }

    @Test
    public void searchMacBookPro2019() {
        WebElement search = driver.findElement(By.id("q"));
        search.sendKeys("macbook pro 2019");

        WebElement searchBnt = driver.findElement(By.xpath("//button[contains(text(),'SEARCH')]"));
        searchBnt.click();

        WebElement result = driver.findElement(By.xpath("//a[contains(text(),'[Trả góp 0%]MacBook Pro 13-inch 2019 (MUHP2) 256G')]"));

        Assert.assertEquals("[Trả góp 0%]MacBook Pro 13-inch 2019 (MUHP2) 256G Gray",result.getText());
        //https://selenium-python.readthedocs.io/locating-elements.html
    }

   /* @Test
    public void buyProduct() {
        List<WebElement> search =  driver.findElements (By.tagName("img"));
        WebElement image = search.get(3);
        image.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }*/


    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
