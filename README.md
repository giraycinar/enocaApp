# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.5/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.5/gradle-plugin/packaging-oci-image.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.3.5/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/3.3.5/reference/web/servlet.html)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/3.3.5/reference/data/nosql.html#data.nosql.mongodb)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)


Bu `README.md` bölümü, yapılandırma ayarlarını ve kullanım bilgilerini açıklamak için tasarlanmıştır. -->

### Sunucu Ayarları (ÖNEMLİ)
-  [Port: Uygulama, 9090 numaralı portta dinlemektedir. Tarayıcınızda http://localhost:9090 adresine giderek uygulamayı görüntüleyebilirsiniz.]

### MongoDB Ayarları-->

-  Veritabanı: enocaAppDB adıyla MongoDB veritabanı kullanılmaktadır.
-  Host: Veritabanı sunucusu, localhost üzerinde çalışmaktadır.
-  Port: MongoDB sunucusu, 27017 numaralı portta dinlemektedir.
-  Kullanıcı Adı: MongoDB'ye bağlanmak için ( enocaApp ) kullanıcı adı kullanılmaktadır.
-  Şifre: MongoDB'ye erişim için kullanılan şifre ( enocaApp* ) olarak belirlenmiştir.


### Bağımlılıklar--> 

  -  Spring Boot Starter Data MongoDB: MongoDB ile veri etkileşimi.
  -  Spring Boot Starter Web: Web uygulaması geliştirme desteği.
  -  Lombok: Java'da boilerplate kodu azaltma.
  -  H2 Database: Geliştirme ve test için hafif bir veritabanı.
  -  MapStruct: Nesne dönüştürme işlemleri için.
  -  Springdoc OpenAPI: API dokümantasyonu için.



### (ÖNEMLİ) --> İlk 4 Proje com.giray->ilkDortSoru Klasörünün içerisinedir.


### Proje Açıklaması------> 
    Proje Yapısı
    Bu proje, Product, Customer, Cart ve Order tablolarını içeren bir e-ticaret uygulamasıdır. Aşağıdaki özelliklere sahiptir:

    Müşteri (Customer): Müşterilerin kayıt ve yönetimi.
    Ürün (Product): Ürünlerin oluşturulması, güncellenmesi ve silinmesi.
    Sepet (Cart): Müşterilerin sepete ürün ekleyip çıkarabilmesi.
    Sipariş (Order): Müşterilerin sipariş oluşturabilmesi ve geçmiş siparişlerin görüntülenmesi.

### Servisler---> 
    AddCustomer
    GetProduct
    CreateProduct
    UpdateProduct
    DeleteProduct
    GetCart
    UpdateCart
    EmptyCart
    PlaceOrder
    GetOrderForCode
    GetAllOrdersForCustomer
    AddProductToCart
    RemoveProductFromCart

### Uygulama Kurulumu---> 
    MongoDB ve Spring Boot uygulamanızı kurun.
    Gerekli bağımlılıkları ekleyin (MongoDB, Spring Web vb.).
    Uygulamayı başlatın ve API uç noktalarına erişin.

### Uygulamanın Çalışır Haldeki Resimleri Aşağıdadır.

    Resimlerin Yolu Şu Şekildedir.

    my-project
    ├── src
    │   └── main
    │       ├── java
    │       └── resources
    │           └── images
    │               └── resimler
    └── README.md


![Resim Açıklaması](https://raw.githubusercontent.com/giraycinar/enocaApp/main/src/main/resources/images/1.png)
![Resim Açıklaması](https://raw.githubusercontent.com/giraycinar/enocaApp/main/src/main/resources/images/2.png)
![Resim Açıklaması](https://raw.githubusercontent.com/giraycinar/enocaApp/main/src/main/resources/images/3.png)
![Resim Açıklaması](https://raw.githubusercontent.com/giraycinar/enocaApp/main/src/main/resources/images/4.png)
![Resim Açıklaması](https://raw.githubusercontent.com/giraycinar/enocaApp/main/src/main/resources/images/5.png)
![Resim Açıklaması](https://raw.githubusercontent.com/giraycinar/enocaApp/main/src/main/resources/images/6.png)
![Resim Açıklaması](https://raw.githubusercontent.com/giraycinar/enocaApp/main/src/main/resources/images/7.png)
![Resim Açıklaması](https://raw.githubusercontent.com/giraycinar/enocaApp/main/src/main/resources/images/8.png)
![Resim Açıklaması](https://raw.githubusercontent.com/giraycinar/enocaApp/main/src/main/resources/images/9.png)
![Resim Açıklaması](https://raw.githubusercontent.com/giraycinar/enocaApp/main/src/main/resources/images/10.png)
![Resim Açıklaması](https://raw.githubusercontent.com/giraycinar/enocaApp/main/src/main/resources/images/11.png)
![Resim Açıklaması](https://raw.githubusercontent.com/giraycinar/enocaApp/main/src/main/resources/images/12.png)



