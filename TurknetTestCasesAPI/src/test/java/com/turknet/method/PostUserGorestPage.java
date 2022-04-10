package com.turknet.method;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static com.turknet.base.BasePage.*;
import static org.hamcrest.Matchers.equalTo;

public class PostUserGorestPage {

    public static File jsonDataInFile = new File("src/data/PostUserDataGorest.json");
    public static String jsonName = null;
    public static String jsonEmail = null;
    public static String jsonGender = null;
    public static String jsonStatus = null;

    public static void createUserGorestService(){

        getJsonDataModel();

        Response postUser = (Response) RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(jsonDataInFile)
                .headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .post(baseUrlGorest)
                .then()
                .assertThat()
                .statusCode(201)
                .body("data.name", equalTo(jsonName))
                .body("data.email", equalTo(jsonEmail))
                .body("data.gender", equalTo(jsonGender))
                .body("data.status", equalTo(jsonStatus))
                .extract().response().body();

        String json = postUser.body().asString();
        System.out.println(json);
    }

    public static void getJsonDataModel(){

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(jsonDataInFile));
            JSONObject jsonObject =  (JSONObject) obj;

            jsonName = String.valueOf(jsonObject.get("name"));  //Post edilen datanın name bilgisi
            jsonEmail = String.valueOf(jsonObject.get("email")); //Post edilen datanın email bilgisi
            jsonGender = String.valueOf(jsonObject.get("gender")); //Post edilen datanın gender bilgisi
            jsonStatus = String.valueOf(jsonObject.get("status")); //Post edilen datanın status bilgisi

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
