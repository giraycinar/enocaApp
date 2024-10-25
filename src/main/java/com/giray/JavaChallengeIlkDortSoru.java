package com.giray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaChallengeIlkDortSoru {
    /**
     *
     * 1--> SAP Commerce (Hybris) nedir?
     * Ýfademiz bulut tabanlý bir omni-channel e-ticaret sistemidir.Buradaki omni-channel terimi bütünleþik çok kanalý temsil eder.
     * Amaç çevrim içi ve çevrim dýþý tüm iletiþim kanallarýnýn, bütünleþmiþ olarak tek odak noktasýný müþteri deneyimi kýlmaktýr.
     * Satýþ ve pazarlama kanallarý entegre olarak çalýþýr.
     * Geliþmiþ B2B(Business to Business), B2C(Business to Consumer), B2B2C kullaným seneryolarýna sahip büyük iþletmeler için oluþturulmuþ bir e-ticaret sistemidir.
     * Birde multi-channel e-ticaret sistemi vardýr. Ýkisi arasýndaki fark multi-channelin satýþ ve pazarlama kanallarý baðýmsýz bir þekilde çalýþýr.
     * Þimdilerde adý SAP Commerce CLoud olarak kullanýlmaktadýr.
     * Müþterilerin Özel gereksinimlerine göre hazýrlanabilen þekli tekil bir müþteri deneyimi yaþanmasýný hedefler.
     * Özetlemek gerekirse yýllardýr geçmiþi olan omni-channel bir yapý olarak kendini kanýtlamýþ
     * bir Java Spring tabanlý e-ticaret sistemidir.
     *
     *
     *
     * Hangi amaçlarla kullanýlmýþtýr?
     * Kullaným amacý e-ticaret iþlemlerini basitleþtirmesidir.
     * -Hizmet verimliliðini arttýrmasý,
     * -Müþteri ile etkileþim tarihçesinin takip edilmesine imkan vermesi,
     * -Müþterinin hangi ürünlere sahip olduðu ve bunlar ile ilgili tüm bilgileri göstermesi,
     * -Kurulan alarmlar ile ilgili farkýndalýðý arttýrmasý kullaným amaçlarý arasýndadýr.
     * Çok kanallý ticaretin uygulanmasýný olanak kýlar. Web sitesi, mobil uygulama, sosyal medya, maðazalar gibi satýþ kanallarýný tek noktada toplar.
     * Ürün sipariþ ve bu ürünlerin yönetilmelerindede fiyatlandýrmanýn, envanterin tek yerden yönetilmesini saðlar.
     * Kiþiselleþtirilebilir bir müþteri deneyimi saðlar.
     *
     *
     * Kullanýldýðý teknolojiler nelerdir?
     * Java-------------------------------> Java ile yazýlýr.
     * Spring Framework-------------------> Spring framework ile esneklik ve geniþletilebilirlik saðlar.
     * MySQL, Oracle, HANA----------------> Veritabaný iþlemleri için kullanýlýr.
     * Apache Tomcat----------------------> Apache Tomcat ile web sunucusunda çalýþýr.
     * REST Web Servisleri----------------> Web servislerine entegrasyon saðlar.
     * Solr-------------------------------> Güçlü bir arama motorunu kullanýr.
     * Assisted Service Module------------> Müþterinin satýn alma ile ilgili takýldýðý noktalara çaðrý merkezi olarak müdahale eder.
     * Microservis ve SAP Cloud Platform--> Mikroservisler mimarisi ile esneklik saðlar. SAP ile entegre çalýþabilir.
     *
     *----------------------------------------------------------------------------------------------------------------
     *
     * 2--> Birbirinden baðýmsýz iki platformun birbiriyle haberleþmesi nasýl saðlanabilir?
     *      3 þekilde inceleyebiliriz.
     *
     *      1----> Web üzerinden RESTful API'ler ile iletiþim saðlayabiliriz. Bu durumda bir platform REST API saðlar ve diðer
     *      platform bu API'leri çaðýrýr. Bu durumda iki platform birbiriyle iyi bir haberleþme yapabilir.
     *      Güvenlik aþamasýnda HTTPS þifrelemesi saðlanabilir.Kimlik için JWT'lar kullanýlabilir.
     *      2----> Mesajlaþma Sistemleri üzerinden iletiþim saðlarýz.
     *      Apache Kafka veya RabbitMQ gibi mesajlaþma sistemleri mesajlarý kuyrukta tutar ve veri kaybýný önler.
     *      Java ile RabbitMQ mesajý göndeririz ve C# ile kuyruðu dinleriz.
     *      3----> gRPC(Google Remote Procedure Call) ile iletisim kurarýz.
     *      Java üzerinden gRPC sunucusu kurulur. Diðer platformdan bu sunucuya baðlanarak iletiþim saðlayabiliriz.
     *      gRPC sunucusu binary veri transferi yapar ve bu JSON/XML formatýna nazaran daha hýzlý gerçekleþir.
     *
     *
     *----------------------------------------------------------------------------------------------------------------
     *
     * 3--> SOLR nedir? Kullaným alanlarý ve kullaným örneði?
     *
     *      SOLR--> Büyük miktarda veriyi hýzlý bir biçimde aramak için kullanýlan, açýk kaynaklý Java tabanlý bir veri arama motorudur.
     *      Büyük veri tabanlý sistemlerde karmaþýk filtreleme iþlemlerini hýzlýca yapabilecek bir sistemdir.
     *      Apache Lucene üzerine inþa edilmiþtir. Bu nedenle zengin bir sorgu dili saðlar. Bunlar sonuç sýralama, filtreleme,
     *      metin aramalarý vb þeklindedir.
     *      Büyük veriyi hýzlý bir þekilde kontrol saðladýðýndan E-Ticaret, Kurumsal içerik yönetimleri, Web siteleri vb þekillerde çokça kullanýlýr.
     *
     *      1----> Yaygýn þekilde kullanýldýðýndan bir E-Ticaret örneði verebilirim.
     *      Bir müþteri alacaðý ürün ile alakalý marka, fiyat, renk, niþ bir özellik gibi filtreleme yaparken, SOLR hýzlý bir þekilde
     *      sonuçlarý süzer ve uygun olanlarý listeler. Ayný zamanda kullanýcýnýn bir önceki arama geçmiþlerini görüntüleyerek
     *      müþteriye uygun ve özelleþtirilmiþ ürünleride önüne getirir.
     *
     *      2----> Ýkinci örneði sigorta alanýndan vereceðim.
     *      Müþteri aracýna ve evine kasko yaptýrmak istiyor. Hasarsýzlýk indirimlerinden, yýllarca ayný yerde sigortasýný yaptýrdýðýndan
     *      ona özel fiyat almak istiyor. Buna istinaden Solr müþteri bilgileri, Hasar ve taleplerin yönetimi, Veri analitiði, müþterinin
     *      kiþisellerþtirilmiþ teklifleri içerisinden ve daha önce yapmýþ olduðu kasko tekliflerinden verileri çekebilir.Ve
     *      müþteriye en uygun teklifi sunabilir.
     *
     *
     *
     *
     */


    /**
     * 4 Eksik eleman bulma. ------>
     *  ? Java'da 100 adet random sayýya sahip bir liste oluþturun.
     *  ? Dahasonra bu listenin bir kopyasýný oluþturun.
     *  ? 0ile100 arasýnda rastgele bir sayý üretin.
     *  ? Kopyalistedeki bu random sayýnýn olduðu indisteski deðeri silin.
     *  ? Þimdi elinizde iki adet liste var ve kopya listede orjinal listeye göre bir eleman eksik.
     *  ? Hangielemanýn eksik olduðunu bulan bir metot oluþturun.
     *
     *  Çözümü þu þekilde saðlayacaðým. --->
     *  Bir random orjinal liste ve birde copy liste oluþturuyorum. Copyden bir random indexteki elemaný çýkarýyorum.
     *  Eksik olan sayýyý bulmak için orjinal ve copy listelerdeki elemanlarý ayrý ayrý toplayýp
     *  birbirlerinden çýkartarak bulacaðým.
     *
     */

    public static void main(String[] args) {
        List<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        // Random sayýlarý ekliyorum
        for (int i = 0; i < 100; i++) {
            originalList.add(random.nextInt(100));
        }

        // Listenin kopyasýný oluþturuyorum
        List<Integer> copyList = new ArrayList<>(originalList);

        // 0 ile 99 arasýnda rastgele bir index seçiyoruz
        int indexToRemove = random.nextInt(100);

        // Kopya listede ayný indexteki elemaný kaldýrýyoruz
        int removedElement = copyList.get(indexToRemove); // Silinecek eleman
        copyList.remove(indexToRemove);

        System.out.println("Removed Element at index " + indexToRemove + ": " + removedElement);
        System.out.println("Original List------------------: " + originalList);
        System.out.println("Copy List (One Element Removed): " + copyList);

        // Eksik elemaný bulalým.
        Integer missingElement = findMissingElement(originalList, copyList);
        System.out.println("Missing Element: " + missingElement);
    }

    // Eksik eleman için metot
    public static Integer findMissingElement(List<Integer> originalList, List<Integer> copyList) {
        int sumOriginal = 0;
        int sumCopy = 0;

        // Original liste toplamý
        for (Integer num : originalList) {
            sumOriginal += num;
        }

        // Copy liste toplamý
        for (Integer num : copyList) {
            sumCopy += num;
        }

        // Eksik eleman farklarýdýr
        return sumOriginal - sumCopy;
    }



}
