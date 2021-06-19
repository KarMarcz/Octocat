package users;


import github.compositeClasses.users.User;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class ApiOctocatTest {

    @Test
    public void getOctocat(){


        User user = given().
                when().
                        get("https://api.github.com/users/octocat").
                then().
                        statusCode(200).
                        extract().
                        as(User.class);

        System.out.println(user.toString());
    }
}
