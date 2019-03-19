package JiraTestHomeTask11;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sun.print.SunMinMaxPage;
import java.util.concurrent.TimeUnit;
import java.sql.Time;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class CreateNewIssue extends LogIn{
    @Test(priority = 1)
    public void TestMethod1() {
        driver.get(url);
        UsernameSent();PasswordSent();ButtonLoginClickable();AuthirizedPageIsDisplayed();
        CreateIssueButtonIsClickable();
        ProjectFieldIsClickable();
        DropDownProjectIsDisplayed();
        IssueTypeIsClickable();
        IssueTypeOptionsDropDown();
        SummaryInputText();
        DescriptionSentKeys256Characters();
        SubmitButton();
    }

    public void SubmitButton() {
        WebElement submitButton = driver.findElement(By.cssSelector("#create-issue-submit"));
        submitButton.click();
        assertTrue(driver.findElement(By.xpath("//*[@id='activity-stream']")).isEnabled());
    }

    public void DescriptionSentKeys256Characters() {
        WebElement textTab = driver.findElement(By.cssSelector("#aui-uid-1"));
        textTab.click();
        WebElement description = driver.findElement(By.xpath("//*[@id='description']"));
        description.sendKeys("?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#@%^&?&^%$#");

    }

    public void SummaryInputText() {
        WebElement summary = driver.findElement(By.cssSelector("#summary"));
        summary.sendKeys("Authorization Jira");
    }

    public void IssueTypeOptionsDropDown() {
        WebElement issueTypeOptions=driver.findElement(By.xpath("//*[@id='issuetype-options']"));
        issueTypeOptions.getAttribute("data-suggestions");
        assertTrue( issueTypeOptions.getAttribute("data-suggestions").contains("Test"));
        assertTrue( issueTypeOptions.getAttribute("data-suggestions").contains("Story"));
        assertTrue( issueTypeOptions.getAttribute("data-suggestions").contains("Bug"));
        assertTrue( issueTypeOptions.getAttribute("data-suggestions").contains("User Story"));
        assertTrue( issueTypeOptions.getAttribute("data-suggestions").contains("Task"));
    }

    public void  IssueTypeIsClickable() {
        driver.manage().timeouts().implicitlyWait(9000,TimeUnit.SECONDS) ;
        WebElement IssueTypeIsClickable = driver.findElement(By.xpath("//label[@for='issuetype-field']"));
        IssueTypeIsClickable.click();
    }

    public void DropDownProjectIsDisplayed() {
        WebElement projectOptions = driver.findElement(By.cssSelector("#project-options"));
        projectOptions.isEnabled();
        projectOptions.getAttribute("data-suggestions");
        assertTrue(projectOptions.getAttribute("data-suggestions").contains("Recent Projects"));
        assertTrue(projectOptions.getAttribute("data-suggestions").contains("All Projects"));}

    public void ProjectFieldIsClickable() {
        WebElement projectField = driver.findElement(By.cssSelector("#project-field"));
        projectField.click();

    }
    public void CreateIssueButtonIsClickable() {
        WebElement createButton = driver.findElement(By.xpath("//*[@id='create_link']"));
        createButton.click();
        driver.manage().timeouts().implicitlyWait(8000,TimeUnit.SECONDS) ;
        WebElement createIssueForm = driver.findElement(By.cssSelector(".jira-dialog-heading"));
        assertTrue(createIssueForm.isDisplayed());
    }

}
