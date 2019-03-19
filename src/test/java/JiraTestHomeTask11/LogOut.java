package JiraTestHomeTask11;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class LogOut extends LogIn {
    protected String expectedmessage = "Log in - Hillel IT School JIRA";
    @Test(priority = 1)
    public void TestMethod1() {
        driver.get(url);
        UsernameSent();
        PasswordSent();
        ButtonLoginClickable();
        AuthirizedPageIsDisplayed();
        ProfileSectionIsClickable();
        LogOutButtonIsClickable();
        LogInAgainButtonIsClickable();
    }

    public void LogInAgainButtonIsClickable() {
        WebElement logInAgain = driver.findElement(By.xpath("//a[text()='Log in again.']"));
        logInAgain.click();
        driver.getCurrentUrl();
        actualmessage = driver.getTitle();
        AssertJUnit.assertEquals(actualmessage, expectedmessage);
    }

    public void LogOutButtonIsClickable() {
        WebElement logoutButton = driver.findElement(By.xpath("//ul [@id = 'system']"));
        logoutButton.click();
        assertTrue(driver.findElement(By.xpath("//strong [text()='You are now logged out. Any automatic login has also been stopped.']"))
                .isDisplayed());
    }


    public void ProfileSectionIsClickable() {
        WebElement profileSection = driver.findElement(By.xpath("//span [@class='aui-avatar-inner']/img"));
        profileSection.click();
        driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS) ;
        profileSection.getAttribute("Profile");
        profileSection.getAttribute("Atlassian Marketplace");
        profileSection.getAttribute( "My JIRA Home");

    }
}



