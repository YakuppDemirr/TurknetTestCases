package com.turknet.test;

import org.testng.annotations.*;
import static com.turknet.method.CheckEmailPage.*;
import static com.turknet.method.GetControlDataIdPage.*;
import static com.turknet.method.PostSameEmailPage.*;
import static com.turknet.method.PostUserGorestPage.*;
import static com.turknet.method.PostUserReqresPage.*;
import static com.turknet.base.BasePage.*;

public class TurknetApiTest {

    @Test(priority=1)
    public void getCheckEmailDataValues (){
        checkEmailValueService();
        logger.info("*** .jpg ile biten email bilgileri başarılı bir şekilde kontrol edildi. ***");
    }

    @Test(priority=2)
    public void postUserReqrest(){
        createUserReqresService();
        logger.info("*** Reqres servisinde oluşturulan user işlemi başarılı bir şekilde tamamlandı. ***");
    }

    @Test(priority=3)
    public void getDataId(){
        getControlDataIdService();
        logger.info("*** 4 basamaklı olan ID bilgileri başarılı bir şekilde kontrol edildi. ***");
    }

    @Test(priority=4)
    public void postUserGorest(){
        createUserGorestService();
        logger.info("*** Gorest servisinde oluşturulan user işlemi başarılı bir şekilde tamamlandı. ***");
    }

    @Test(priority=5)
    public void postSameEmailGorest(){
        createSameEmailService();
        logger.info("*** Gorest servisine aynı email ile yeni kullanıcı oluşturulamaması işlemi kontrol edildi. ***");
    }
}
