package resources;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class checkAllProduct extends BaseURL{
    @Test(priority = 1, description = "Tüm ürünleri kontrol et")
    public void checkAllProduct(){
        Response response = given()
                .get(baseURI)
                .then()
                .statusCode(200)
                .extract().response();
        Assert.assertNotNull(response.getBody().jsonPath().getList("id").get(0));
        System.out.println("Tüm ürünler : "+response.asString());
    }

}
