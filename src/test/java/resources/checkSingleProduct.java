package resources;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class checkSingleProduct extends BaseURL {
    @Test(priority = 0, description = "Tek bir ürünün varlığını kontrol et")
    public void checkProduct() {
        String product = "Ceket";
        int price = 199;
        int stock = 44;

                RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("name", product)
                .when()
                .get(baseURI)
                .then()
                .statusCode(200)
                .body("stock[0]", equalTo(stock))
                .body("price[0]", equalTo(price))
                .extract();
                System.out.println("Urun bulundu!");
//        RestAssured.get(baseURI);
//        Response response = given()
//                .contentType(ContentType.JSON)
//                .queryParam("name", product)
//                .when()
//                .get(baseURI);
//            System.out.println("Urun => \n"+rs().asString());

    }
}

