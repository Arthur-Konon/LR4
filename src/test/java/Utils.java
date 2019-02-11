import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;



public class Utils {

    private  static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver initWebDriver() {
        //WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                    DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.close();
    }
}
