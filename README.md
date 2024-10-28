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

  -  Constructorlar yerine lombok anatasyonları ile hazırlanmıştır. RestApiURL ile yollar belirtilmiştir.


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


###   Minimum Sistem Gereksinimleri
    Java:

-    Java JDK 21: Proje, Java 21 kullanmaktadır. JDK'nın en son sürümünü Oracle veya OpenJDK üzerinden indirip kurabilirsiniz.
    Spring Boot:

-    Spring Boot 3.3.5: Projede kullanılan Spring Boot sürümü 3.3.5. Bu sürüm, gerekli kütüphaneleri ve özellikleri sağlayacaktır.
    Veritabanı:

-    MongoDB: Proje, MongoDB ile çalışmakta ve en az 4.0 sürümünü gerektirir. MongoDB'yi sisteminize kurmalısınız.
    H2 Database: Geliştirme ve test amaçları için H2 veritabanı kullanılmaktadır.
    Bağımlılıklar:

-    Maven: Projeyi yönetmek için Maven kullanılmaktadır. Maven'ı Maven Resmi Sitesinden indirip kurabilirsiniz.
-    Lombok: Otomatik getter, setter gibi metodları oluşturmak için Lombok kullanılmaktadır. IDE'nizde Lombok desteğini etkinleştirmeniz gerekebilir.
-    MapStruct: Java nesneleri arasında dönüşüm yapmak için kullanılmaktadır.
-    SpringDoc: API dokümantasyonu için OpenAPI desteği sunmaktadır.
-    IDE:

-    IntelliJ IDEA veya Eclipse: Java ve Spring Boot projeleri geliştirmek için tercih edebileceğiniz IDE'lerdir. IntelliJ IDEA'nın en son sürümünü JetBrains resmi web sitesinden indirebilirsiniz.
-    Önerilen Donanım Gereksinimleri
    RAM: Minimum 4 GB (Önerilen 8 GB veya daha fazla)
    İşlemci: Çok çekirdekli işlemci (Intel i5 veya eşdeğeri)
    Disk Alanı: Minimum 2 GB boş alan (Proje ve bağımlılıklar için)
    Notlar
    Geliştirme sırasında bilgisayarınızın yeterli bellek ve işlemci gücüne sahip olması, performansı artıracaktır.
    Projeyi çalıştırmadan önce, gerekli tüm bağımlılıkların kurulu olduğundan emin olun.
