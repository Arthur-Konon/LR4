import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class AutotestAuthorization {
        private WebDriver driver;
        private String url;
        private String keyword;
        private String actualmessage;
        private String expectedmessage = "Welcome to Hillel IT School JIRA";
        private boolean ac;
        private String resultcheckmark;



        @Before
        public void BeforeMethod() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            url = "http://jira.hillel.it:8080/login.jsp";}


        @Test
        public void TestMethod1() {
            driver.get(url);
            actualmessage = driver.findElement(By.xpath("/html/body/div/section/div/div/section/header/div/div/h1")).getText();
            Assert.assertEquals(expectedmessage, actualmessage);
            System.out.println("Test passed");

            driver.findElement(By.xpath("//*[@id=\"login-form-cancel\"]")).click();
            driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"forgot-login-cancel\"]")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"jira\"]")).isDisplayed());
            WebElement loginElement = driver.findElement(By.cssSelector("#login-form-username"));
            loginElement.sendKeys("keityfly1992");
            Assert.assertTrue("Verified", loginElement.isEnabled());

            WebElement passwordElement = driver.findElement(By.cssSelector("#login-form-password"));
            passwordElement.sendKeys("keityfly92");
            Assert.assertTrue("Verified", passwordElement.isEnabled());

            WebElement resultcheckmark = driver.findElement(By.id("login-form-remember-me"));
            resultcheckmark.click();
            Assert.assertTrue(resultcheckmark.isSelected());

            WebElement buttonLogin = driver.findElement(By.xpath("//*[@id=\"login\"]"));
            buttonLogin.click();
            WebElement mainPage = driver.findElement(By.xpath("//*[@id=\"jira\"]"));
            Assert.assertTrue("The authorization process was successfully completed", mainPage.isDisplayed());}


        @Test
        public void TestMethod2(){
            driver.get(url);
            WebElement loginElement = driver.findElement(By.cssSelector("#login-form-username"));
            loginElement.sendKeys("keityfly1992");
            Assert.assertTrue("Verified", loginElement.isEnabled());

            WebElement passwordElement = driver.findElement(By.cssSelector("#login-form-password"));
            passwordElement.sendKeys("keityfly92");
            Assert.assertTrue("Verified", passwordElement.isEnabled());

            WebElement resultcheckmark = driver.findElement(By.id("login-form-remember-me"));
            resultcheckmark.click();
            Assert.assertTrue(resultcheckmark.isSelected());

            WebElement buttonLogin = driver.findElement(By.xpath("//*[@id=\"login-form-submit\"]"));
            buttonLogin.click();
            WebElement mainPage = driver.findElement(By.xpath("//*[@id=\"jira\"]"));
            Assert.assertTrue("The authorization process was successfully completed", mainPage.isDisplayed());
        }






    @After
        public void AfterMethod () {
            //driver.quit();
        }
    }


