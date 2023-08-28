package resources;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.baseURI;

public class BaseURL {
    @BeforeMethod
    public void setUpBaseURL(){
        baseURI = "http://localhost:3000/productss";
    }
}
