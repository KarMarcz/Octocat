package pl.github.requestObject.users;

import io.restassured.specification.RequestSpecification;
import pl.github.compositeClasses.users.User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiUserRequest {

    public User getUser(RequestSpecification spec, String userOctocatEndpoint, String login, int id, String type){

        User user = given().
                spec(spec).
                when().
                get(userOctocatEndpoint).
                then().
                assertThat().
                //if test case is simple we can assert here
                        body("login", equalTo(login)).
                        body("id", equalTo(id)).
                        body("type", equalTo(type)).
                        statusCode(200).
                        and().
                        extract().
                        as(User.class);

        return user;
    }

}
