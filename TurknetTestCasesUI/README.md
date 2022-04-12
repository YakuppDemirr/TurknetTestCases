Proje de **Selenium**,**TestNg**, **log4j** ve **Allure Report** kullanılmıştır.

Proje çalıştırmak için terminal kısmına 
 **mvn clean test** komutu yazılmalıdır.

Test sonucunda oluşan raporu görüntülemek için terminal kısmına
**mvn io.qameta.allure:allure-maven:serve**  komutu yazılmalıdır.

**NOT:** Proje docker ile çalıştırılmak isteniyorsa; ilgili makine de **_docker_**, **_selenium-hub_**, 
**_selenium/node-chrome_**, **_selenium/node-firefox_**, nodeları kurulu olmalıdır.

Bu işlemler yapıldıktan sonra, proje içerisinden terminal açılarak
**docker-compose up** komutuyla proje docker üzerinde çalıştırılabilir.
Detayları görebilmek için; http://localhost:4444/ adresine gidilir.

<img width="900" alt="Screenshot at Apr 11 12-07-05" src="https://user-images.githubusercontent.com/46319524/162703575-4d018bbd-b4ba-4157-9a34-9d09998f7a77.png">

<img width="900" alt="selenium-docker" src="https://user-images.githubusercontent.com/46319524/162702893-6d9f14e2-1c18-42c7-b3ed-d20008e201e7.png">
