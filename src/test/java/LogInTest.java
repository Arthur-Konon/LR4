import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import static org.testng.Assert.assertEquals;

public class LogInTest {


    @Test
    public void simpleTest(WebDriver driver) {
        //WebDriver driver = null;


        String expectedTitle = "System Dashboard - Hillel IT School JIRA";
        String actualTitle = "";

        // запустить firefox и перейти по адресу
        driver.get("http://jira.hillel.it:8080");
        // разворачивает окно браузера
        driver.manage().window().maximize();
        // получить значение у тайтла страницы


        driver.findElement(By.xpath("//*[@id=\"login-form-username\"]")).sendKeys("arth.konon");
                    driver.findElement(By.xpath("//*[@id=\"login-form-password\"]")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();

        actualTitle = driver.getTitle();


        // выполняем проверку
       assertEquals(actualTitle, expectedTitle);

    }
}

