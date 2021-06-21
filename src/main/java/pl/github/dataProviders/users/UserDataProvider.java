package pl.github.dataProviders.users;

import org.testng.annotations.DataProvider;

public class UserDataProvider {

    @DataProvider(name = "getDataForUserTest")
    public static Object[][] getDataForUserTest() {
        return new Object[][] {
                {"octocat", 583231, "User"}
        };
    }
}
