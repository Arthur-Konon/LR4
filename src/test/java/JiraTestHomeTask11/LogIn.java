package JiraTestHomeTask11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.close;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LogIn {
    protected WebDriver driver;
    protected String url;
    protected String actualmessage;
    protected String expectedmessage = "Log in - Hillel IT School JIRA";


    @BeforeClass
    public void BeforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        url = "http://jira.hillel.it:8080/login.jsp";
    }


    @Test(priority = 1)
    public void TestMethod1() {
        driver.get(url);
        actualmessage = driver.getTitle();
        assertEquals(actualmessage, expectedmessage);

        UsernameSent();
        PasswordSent();
        RememberButtonClickable();
        ButtonLoginClickable();
        AuthirizedPageIsDisplayed();
    }

    @Test(priority = 2)
    public void TestMethod2() {
        driver.get(url);
        ForgotAccountButtonClickable();
        ForgotFormIsDisplayed();
        CancelButtonClickableDashBoardPageIsDisplayed();
    }


    public void CancelButtonClickableDashBoardPageIsDisplayed() {
        driver.findElement(By.xpath("//*[@id=\"forgot-login-cancel\"]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"jira\"]")).isDisplayed());
    }

    public void ForgotFormIsDisplayed() {
        WebElement forgotAccountForm = driver.findElement(By.xpath("//p"));
        assertTrue(forgotAccountForm.isDisplayed());
    }

    public void ForgotAccountButtonClickable() {
        WebElement forgotAccountButton = driver.findElement(By.cssSelector("#login-form-cancel"));
        forgotAccountButton.click();
    }
    public void AuthirizedPageIsDisplayed() {
        WebElement authorizedPage = driver.findElement(By.xpath("//*[@id=\"jira\"]"));
        Assert.assertTrue(authorizedPage.isDisplayed());
    }

    public void ButtonLoginClickable() {
        WebElement buttonLogin = driver.findElement(By.xpath("//*[@id=\"login-form-submit\"]"));
        buttonLogin.click();
    }

    public void  RememberButtonClickable() {
        WebElement resultcheckmark = driver.findElement(By.cssSelector(".checkbox"));
        assertTrue(resultcheckmark.isEnabled());
    }

    public void PasswordSent() {
        WebElement passwordElement = driver.findElement(By.cssSelector("#login-form-password"));
        passwordElement.sendKeys("keityfly92");
    }

    public void UsernameSent() {
        WebElement loginElement = driver.findElement(By.cssSelector("#login-form-username"));
        loginElement.sendKeys("keityfly1992");
    }
    @AfterClass
    public void tearDown (){
        close();
    }
}