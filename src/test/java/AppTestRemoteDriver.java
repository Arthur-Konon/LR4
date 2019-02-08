import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class AppTestRemoteDriver {

    protected WebDriver driver;

    @Test
    public void simpleTest() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                    DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        String expectedTitle = "Meet Guru99 - Free Training Tutorials & Video for IT Courses";
        String actualTitle = "";

        // запустить firefox и перейти по адресу
        driver.get("http://www.guru99.com/");
        // разворачивает окно браузера
        driver.manage().window().maximize();
        // получить значение у тайтла страницы
        actualTitle = driver.getTitle();

        // выполняем проверку
        assertEquals(actualTitle, expectedTitle);

        // закрываем окно браузера
        driver.close();
    }
}