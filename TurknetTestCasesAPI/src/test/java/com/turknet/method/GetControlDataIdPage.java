package com.turknet.method;

import com.turknet.base.BasePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static com.turknet.base.BasePage.logger;
import static io.restassured.RestAssured.given;

public class GetControlDataIdPage {

    public static void getControlDataIdService(){

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

        List<Map<String, String>> itemResponseBody = response.jsonPath().getList("data.id");
        List idList = new ArrayList<String>();

        for (int i=0; i<itemResponseBody.size(); i++){

            String dataId = String.valueOf(itemResponseBody.get(i));
            logger.info("*** 4 basamaklı olan id'ler kontrol ediliyor. ***");

            if(dataId.length() == 4) {
                idList.add(dataId);
                logger.info("*** 4 basamaklı olan id'ler listeye eklendi. ***");
            }
        }
    }
}
