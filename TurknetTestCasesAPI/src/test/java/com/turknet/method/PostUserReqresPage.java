package com.turknet.method;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import static com.turknet.base.BasePage.*;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PostUserReqresPage {

    public static File jsonDataInFile = new File("src/data/PostUserDataReqres.json");
    public static String jsonName = null;
    public static String jsonJob = null;

    public static void createUserReqresService(){

        getJsonDataModel();

        Response postUser = (Response) RestAssured
                .given()
                .baseUri(baseUrlReqres + "users")
                .contentType(ContentType.JSON)
                .body(jsonDataInFile)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", equalTo(jsonName))
                .body("job", equalTo(jsonJob))
                .extract().response().body();

        String json = postUser.body().asString();
        System.out.println(json);
    }

    public static void getJsonDataModel() {

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(jsonDataInFile));
            JSONObject jsonObject = (JSONObject) obj;

            jsonName = (String) jsonObject.get("name");
            jsonJob = (String) jsonObject.get("job");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
