package com.turknet.method;

import com.turknet.base.BasePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.turknet.base.BasePage.*;
import static io.restassured.RestAssured.given;

public class PostSameEmailPage {

    public static File jsonDataInFile = new File("src/data/PostSameEmailDataGorest.json");
    public static String jsonEmail = null;

    public static void createSameEmailService(){

        RequestSpecification requestSpecification = RestAssured.given();

        Response response = (Response) requestSpecification
                .contentType(ContentType.JSON)
                .when()
                .get(BasePage.baseUrlGorest)
                .body();

        int getStatusCodeSubject = given()
                .contentType(ContentType.JSON)
                .when()
                .get(BasePage.baseUrlGorest)
                .getStatusCode();

        System.out.println("Response Code: " + getStatusCodeSubject);
        Assert.assertEquals(getStatusCodeSubject, 200);

        List<Map<String, String>> itemResponseBody = response.jsonPath().getList("data.email");
        List dataEmailList = new ArrayList<String>();
        List sameEmailList = new ArrayList<String>();

        //Servisten dönen tüm emailler listeleye eklendi.
        for (int i=0; i<itemResponseBody.size(); i++){
            String dataEmail = String.valueOf(itemResponseBody.get(i));
            dataEmailList.add(dataEmail);
        }

        //Post edilen email, servisten dönen tüm emailler ile karşılaştırılıyor aynı olan emailler listeye eklendi.
        for (int j=0; j<dataEmailList.size(); j++)
        {
            String sameEmailControl = String.valueOf(dataEmailList.get(j));
            if(sameEmailControl.contains(getJsonDataEmail())) {
                sameEmailList.add(sameEmailControl);
            }
        }

        String getEmailText = sameEmailList.toString();
        String getLastEmailText = getEmailText.replace("]", "").replace("[", "");

        Response postUser = (Response) RestAssured
                .given()
                .headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(jsonDataInFile)
                .when()
                .post(baseUrlGorest)
                .then()
                .assertThat()
                .statusCode(422)
                //.body("data.email", equalTo(getLastEmailText))
                .extract().response().body();

        String json = postUser.body().asString();
        logger.info("***" +  json + "***");
    }

    public static String getJsonDataEmail(){

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(jsonDataInFile));
            JSONObject jsonObject =  (JSONObject) obj;

            jsonEmail = String.valueOf(jsonObject.get("email")); //Post edilen datanın email bilgisi

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonEmail;
    }
}

