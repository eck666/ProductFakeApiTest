package resources;

import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class createNewProduct extends BaseURL{
    JSONObject request = new JSONObject();

    @Test(priority = 2,description = "Yeni ürün oluştur.")
    public void postNewProduct(){
        int id = 6;
        String name = "Mont";
        int price = 699;
        String color = "Kırmızı";
        String size = "XL";
        int stock = 17;


        request.put("id",id);
        request.put("name",name);
        request.put("price",price);
        request.put("color",color);
        request.put("size",size);
        request.put("stock",stock);
        given()
                .header("Content-type", "application/json")
                .and()
                .body(request.toJSONString())
                .when()
                .post(baseURI)
                .then()
                .statusCode(201);
    System.out.println("Urun olusturuldu => \n"+ request.toJSONString());
    }
}
