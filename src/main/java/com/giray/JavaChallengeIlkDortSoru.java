package com.giray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaChallengeIlkDortSoru {
    /**
     *
     * 1--> SAP Commerce (Hybris) nedir?
     * �fademiz bulut tabanl� bir omni-channel e-ticaret sistemidir.Buradaki omni-channel terimi b�t�nle�ik �ok kanal� temsil eder.
     * Ama� �evrim i�i ve �evrim d��� t�m ileti�im kanallar�n�n, b�t�nle�mi� olarak tek odak noktas�n� m��teri deneyimi k�lmakt�r.
     * Sat�� ve pazarlama kanallar� entegre olarak �al���r.
     * Geli�mi� B2B(Business to Business), B2C(Business to Consumer), B2B2C kullan�m seneryolar�na sahip b�y�k i�letmeler i�in olu�turulmu� bir e-ticaret sistemidir.
     * Birde multi-channel e-ticaret sistemi vard�r. �kisi aras�ndaki fark multi-channelin sat�� ve pazarlama kanallar� ba��ms�z bir �ekilde �al���r.
     * �imdilerde ad� SAP Commerce CLoud olarak kullan�lmaktad�r.
     * M��terilerin �zel gereksinimlerine g�re haz�rlanabilen �ekli tekil bir m��teri deneyimi ya�anmas�n� hedefler.
     * �zetlemek gerekirse y�llard�r ge�mi�i olan omni-channel bir yap� olarak kendini kan�tlam��
     * bir Java Spring tabanl� e-ticaret sistemidir.
     *
     *
     *
     * Hangi ama�larla kullan�lm��t�r?
     * Kullan�m amac� e-ticaret i�lemlerini basitle�tirmesidir.
     * -Hizmet verimlili�ini artt�rmas�,
     * -M��teri ile etkile�im tarih�esinin takip edilmesine imkan vermesi,
     * -M��terinin hangi �r�nlere sahip oldu�u ve bunlar ile ilgili t�m bilgileri g�stermesi,
     * -Kurulan alarmlar ile ilgili fark�ndal��� artt�rmas� kullan�m ama�lar� aras�ndad�r.
     * �ok kanall� ticaretin uygulanmas�n� olanak k�lar. Web sitesi, mobil uygulama, sosyal medya, ma�azalar gibi sat�� kanallar�n� tek noktada toplar.
     * �r�n sipari� ve bu �r�nlerin y�netilmelerindede fiyatland�rman�n, envanterin tek yerden y�netilmesini sa�lar.
     * Ki�iselle�tirilebilir bir m��teri deneyimi sa�lar.
     *
     *
     * Kullan�ld��� teknolojiler nelerdir?
     * Java-------------------------------> Java ile yaz�l�r.
     * Spring Framework-------------------> Spring framework ile esneklik ve geni�letilebilirlik sa�lar.
     * MySQL, Oracle, HANA----------------> Veritaban� i�lemleri i�in kullan�l�r.
     * Apache Tomcat----------------------> Apache Tomcat ile web sunucusunda �al���r.
     * REST Web Servisleri----------------> Web servislerine entegrasyon sa�lar.
     * Solr-------------------------------> G��l� bir arama motorunu kullan�r.
     * Assisted Service Module------------> M��terinin sat�n alma ile ilgili tak�ld��� noktalara �a�r� merkezi olarak m�dahale eder.
     * Microservis ve SAP Cloud Platform--> Mikroservisler mimarisi ile esneklik sa�lar. SAP ile entegre �al��abilir.
     *
     *----------------------------------------------------------------------------------------------------------------
     *
     * 2--> Birbirinden ba��ms�z iki platformun birbiriyle haberle�mesi nas�l sa�lanabilir?
     *      3 �ekilde inceleyebiliriz.
     *
     *      1----> Web �zerinden RESTful API'ler ile ileti�im sa�layabiliriz. Bu durumda bir platform REST API sa�lar ve di�er
     *      platform bu API'leri �a��r�r. Bu durumda iki platform birbiriyle iyi bir haberle�me yapabilir.
     *      G�venlik a�amas�nda HTTPS �ifrelemesi sa�lanabilir.Kimlik i�in JWT'lar kullan�labilir.
     *      2----> Mesajla�ma Sistemleri �zerinden ileti�im sa�lar�z.
     *      Apache Kafka veya RabbitMQ gibi mesajla�ma sistemleri mesajlar� kuyrukta tutar ve veri kayb�n� �nler.
     *      Java ile RabbitMQ mesaj� g�ndeririz ve C# ile kuyru�u dinleriz.
     *      3----> gRPC(Google Remote Procedure Call) ile iletisim kurar�z.
     *      Java �zerinden gRPC sunucusu kurulur. Di�er platformdan bu sunucuya ba�lanarak ileti�im sa�layabiliriz.
     *      gRPC sunucusu binary veri transferi yapar ve bu JSON/XML format�na nazaran daha h�zl� ger�ekle�ir.
     *
     *
     *----------------------------------------------------------------------------------------------------------------
     *
     * 3--> SOLR nedir? Kullan�m alanlar� ve kullan�m �rne�i?
     *
     *      SOLR--> B�y�k miktarda veriyi h�zl� bir bi�imde aramak i�in kullan�lan, a��k kaynakl� Java tabanl� bir veri arama motorudur.
     *      B�y�k veri tabanl� sistemlerde karma��k filtreleme i�lemlerini h�zl�ca yapabilecek bir sistemdir.
     *      Apache Lucene �zerine in�a edilmi�tir. Bu nedenle zengin bir sorgu dili sa�lar. Bunlar sonu� s�ralama, filtreleme,
     *      metin aramalar� vb �eklindedir.
     *      B�y�k veriyi h�zl� bir �ekilde kontrol sa�lad���ndan E-Ticaret, Kurumsal i�erik y�netimleri, Web siteleri vb �ekillerde �ok�a kullan�l�r.
     *
     *      1----> Yayg�n �ekilde kullan�ld���ndan bir E-Ticaret �rne�i verebilirim.
     *      Bir m��teri alaca�� �r�n ile alakal� marka, fiyat, renk, ni� bir �zellik gibi filtreleme yaparken, SOLR h�zl� bir �ekilde
     *      sonu�lar� s�zer ve uygun olanlar� listeler. Ayn� zamanda kullan�c�n�n bir �nceki arama ge�mi�lerini g�r�nt�leyerek
     *      m��teriye uygun ve �zelle�tirilmi� �r�nleride �n�ne getirir.
     *
     *      2----> �kinci �rne�i sigorta alan�ndan verece�im.
     *      M��teri arac�na ve evine kasko yapt�rmak istiyor. Hasars�zl�k indirimlerinden, y�llarca ayn� yerde sigortas�n� yapt�rd���ndan
     *      ona �zel fiyat almak istiyor. Buna istinaden Solr m��teri bilgileri, Hasar ve taleplerin y�netimi, Veri analiti�i, m��terinin
     *      ki�iseller�tirilmi� teklifleri i�erisinden ve daha �nce yapm�� oldu�u kasko tekliflerinden verileri �ekebilir.Ve
     *      m��teriye en uygun teklifi sunabilir.
     *
     *
     *
     *
     */


    /**
     * 4 Eksik eleman bulma. ------>
     *  ? Java'da 100 adet random say�ya sahip bir liste olu�turun.
     *  ? Dahasonra bu listenin bir kopyas�n� olu�turun.
     *  ? 0ile100 aras�nda rastgele bir say� �retin.
     *  ? Kopyalistedeki bu random say�n�n oldu�u indisteski de�eri silin.
     *  ? �imdi elinizde iki adet liste var ve kopya listede orjinal listeye g�re bir eleman eksik.
     *  ? Hangieleman�n eksik oldu�unu bulan bir metot olu�turun.
     *
     *  ��z�m� �u �ekilde sa�layaca��m. --->
     *  Bir random orjinal liste ve birde copy liste olu�turuyorum. Copyden bir random indexteki eleman� ��kar�yorum.
     *  Eksik olan say�y� bulmak i�in orjinal ve copy listelerdeki elemanlar� ayr� ayr� toplay�p
     *  birbirlerinden ��kartarak bulaca��m.
     *
     */

    public static void main(String[] args) {
        List<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        // Random say�lar� ekliyorum
        for (int i = 0; i < 100; i++) {
            originalList.add(random.nextInt(100));
        }

        // Listenin kopyas�n� olu�turuyorum
        List<Integer> copyList = new ArrayList<>(originalList);

        // 0 ile 99 aras�nda rastgele bir index se�iyoruz
        int indexToRemove = random.nextInt(100);

        // Kopya listede ayn� indexteki eleman� kald�r�yoruz
        int removedElement = copyList.get(indexToRemove); // Silinecek eleman
        copyList.remove(indexToRemove);

        System.out.println("Removed Element at index " + indexToRemove + ": " + removedElement);
        System.out.println("Original List------------------: " + originalList);
        System.out.println("Copy List (One Element Removed): " + copyList);

        // Eksik eleman� bulal�m.
        Integer missingElement = findMissingElement(originalList, copyList);
        System.out.println("Missing Element: " + missingElement);
    }

    // Eksik eleman i�in metot
    public static Integer findMissingElement(List<Integer> originalList, List<Integer> copyList) {
        int sumOriginal = 0;
        int sumCopy = 0;

        // Original liste toplam�
        for (Integer num : originalList) {
            sumOriginal += num;
        }

        // Copy liste toplam�
        for (Integer num : copyList) {
            sumCopy += num;
        }

        // Eksik eleman farklar�d�r
        return sumOriginal - sumCopy;
    }



}
