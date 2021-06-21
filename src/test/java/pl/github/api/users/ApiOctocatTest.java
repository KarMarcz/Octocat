package pl.github.api.users;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import pl.github.dataProviders.users.UserDataProvider;
import pl.github.requestObject.users.ApiUserRequest;
import pl.github.compositeClasses.users.User;
import org.testng.annotations.Test;
import pl.github.utils.EndpointProvider;
import pl.github.utils.PropertiesProvider;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiOctocatTest {

    private RequestSpecification spec;
    private EndpointProvider endpointProvider;

    @BeforeClass
    public void setUp(){
        if(System.getProperty("baseURL") == null){
            new PropertiesProvider().setSystemProperties("src/test/resources/properties/api.properties");
            spec = new RequestSpecBuilder().setBaseUri(System.getProperty("baseURL")).build();
        }else {
            spec = new RequestSpecBuilder().setBaseUri(System.getProperty("baseURL")).build();
        }
        endpointProvider = new EndpointProvider();
    }

//    If there are more cases of saved pl.github.users like we could use DDT
    @Test(dataProvider = "getDataForUserTest", dataProviderClass = UserDataProvider.class)
    public void getOctocat(String login, int id, String type){
        User user = new ApiUserRequest().getUser(spec, endpointProvider.getUserOctocatEndpoint(), login, id, type);

        //example of using assertJ(for me this is more readable assertion)
        assertThat(user.getLogin()).isEqualTo(login).as("Login is incorrect");
        assertThat(user.getId()).isEqualTo(id).as("Id is incorrect");
        assertThat(user.getType()).isEqualTo(type).as("Type is incorrect");
    }
}
