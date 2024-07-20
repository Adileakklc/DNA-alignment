# DNA-alignment

Bu Java programı, iki DNA dizisinin en uygun hizalanmasını hesaplar ve görsel olarak sunar. Hizalama işlemi sırasında eşleşme ve uyumsuzluklara göre puanlama yapılır.

## Nasıl Kullanılır

1. **Java Kurulumu:**
   - Bu programı çalıştırmak için bilgisayarınızda Java Runtime Environment (JRE) yüklü olmalıdır. Eğer yüklü değilse, [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) sayfasından JDK'yi indirip kurabilirsiniz.

2. **Projeyi Çalıştırma:**
   - Projeyi bilgisayarınıza klonlayın veya ZIP olarak indirin.
   - Komut satırını açın ve proje klasörüne gidin.
   - Aşağıdaki komutu kullanarak programı çalıştırın:
     ```
     java alignment.DNAAlignment
     ```
   
3. **DNA Dizilerini Girme:**
   - Program sizi ilk ve ikinci DNA dizilerini girmeniz için yönlendirecektir.
   - Girdikten sonra en uygun hizalamayı ve hizalama puanını göreceksiniz.

## Örnek Kullanım

Örneğin, aşağıdaki DNA dizilerini girerek programı çalıştırabilirsiniz:

```
İlk DNA dizisi: GCAGTAGATG
İkinci DNA dizisi: GCAGCGCGTG
```

Program çıktısı şu şekilde olacaktır:

```
En Uygun DNA Hizalaması:
GCAGTAGATG
GCAG-CGCGTG
Hizalama Puanı: 14
```

## Geliştirme Ortamı

- Bu program Java programlama dili ile yazılmıştır.
- Geliştirme ortamı olarak IntelliJ IDEA kullanılmıştır.
