Proje **Rest Assured** ile geliştirildi. Loglama için **log4j** kullanıldı.

Proje çalıştırmak için;

**1.yol;** **src --> test --> java --> com.turknet --> test --> TurknetApiTest** 
classına sağ tıklayıp run edilebilir yada class içerisine girip ilgili methodlar
ayrı ayrı run edilebilir.

**2.yol;** proje altında bulunan testng.xml dosyasına sağ tıklayıp run edilebilir.

**NOT1:** **_createUserGorestService()_** methodunun başarılı bir şekilde çalışması için
src --> data --> PostUserDataGorest.json dosyasında bulunan email alanı rastgele
bir mail adresi ile değiştirilmelidir.

**NOT2:** **_createSameEmailService()_** methodunun başarılı bir şekilde çalışması için
https://gorest.co.in/public/v1/users servisinden dönen emaillerden birinin alınıp
**src --> data --> PostSameEmailDataGorest.json** dosyasında bulunan email alanına 
yazılması gerekmektedir.
