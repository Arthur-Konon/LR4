public class Main {
    public static void main(String[] args) {
        LogInTest login = new LogInTest();
        login.simpleTest(Utils.initWebDriver());

        LogOutTest logout = new LogOutTest();
        logout.simpleTest(Utils.getDriver());
        Utils.closeDriver();

    }
}

