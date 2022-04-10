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
import static io.restassured.RestAssured.given;
import static io.restassured.config.DecoderConfig.decoderConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static com.turknet.base.BasePage.*;

public class CheckEmailPage {

    public static void checkEmailValueService(){

        RequestSpecification requestSpecification = RestAssured.given();

        Response response = (Response) requestSpecification
                .contentType(ContentType.JSON)
                .queryParam("page", "2")
                .when()
                .get(BasePage.baseUrlReqres + "users")
                .body();

        int getStatusCodeSubject = given()
                .contentType(ContentType.JSON)
                .queryParam("page", "2")
                .when()
                .get(BasePage.baseUrlReqres + "users")
                .getStatusCode();

        System.out.println("Response Code: " + getStatusCodeSubject);
        Assert.assertEquals(getStatusCodeSubject,200);

        List<Map<String, String>> itemResponseBody = response.jsonPath().getList("data.email");
        List emailList = new ArrayList<String>();
        String endWith = ".jpg";
        String endWith2 = ".in";

        //data.email listesinde .jpg ile bitenlerin listesi
        for (int i=0; i<itemResponseBody.size(); i++){
            String dataEmail = String.valueOf(itemResponseBody.get(i));
            logger.info("*** Sonu .jpg ile biten email kontrol ediliyor. ***");
            if(dataEmail.endsWith(endWith)) {
                emailList.add(dataEmail);
                logger.info("*** Sonu .jpg ile emailler listeye eklendi. ***");
            }
        }

        //data.email listesinde .in ile bitenlerin listesi
        for (int j=0; j<itemResponseBody.size(); j++){
            String dataEmail = String.valueOf(itemResponseBody.get(j));
            logger.info("*** Sonu .in ile biten email kontrol ediliyor. ***");
            if(dataEmail.endsWith(endWith2)) {
                emailList.add(dataEmail);
                logger.info("*** Sonu .in ile biten emailler listeye eklendi. ***");
            }
        }
    }
}
