import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        LogInTest login = new LogInTest();
        login.simpleTest(Utils.initWebDriver());

        LogOutTest logout = new LogOutTest();
        System.out.println("Running Logout Test");
        logout.simpleTest(Utils.getDriver());
        Utils.closeDriver();
    }
}

