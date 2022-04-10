Proje de **Selenium**,**TestNg**, **log4j** ve **Allure Report** kullanılmıştır.

Proje çalıştırmak için terminal kısmına 
 **mvn clean test**  komutu yazılmalıdır.

Test sonucunda oluşan raporu görüntülemek için terminal kısmına
**mvn io.qameta.allure:allure-maven:serve**  komutu yazılmalıdır.

**NOT:** Proje docker ile çalıştırılmak isteniyorsa; ilgili makine de **_docker_**, **_selenium-hub_**, 
**_selenium/node-chrome_**, **_selenium/node-firefox_**, **_selenium/node-edge_** nodeları kurulu olmalıdır.

Bu işlemler yapıldıktan sonra; 
**docker-compose up** diyerek proje docker üzerinde çalıştırılabilir.
Detayları görebilmek için; http://localhost:4444/ adresine gidilir.
