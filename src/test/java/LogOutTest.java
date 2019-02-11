import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogOutTest {

    @Test
    public void simpleTest(WebDriver driver) {
        //WebDriver driver = null;


        String expectedTitle = "System Dashboard - Hillel IT School JIRA";
        String actualTitle = "";



       // driver.findElement(By.xpath("//*[@id=\"log_out\"]")).click();

        driver.manage().window().maximize();

        actualTitle = driver.getTitle();


        // выполняем проверку
        assertEquals(actualTitle, expectedTitle);

    }
}
