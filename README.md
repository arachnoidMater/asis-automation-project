# **🚀Test Automation Project - Kurulum ve Çalıştırma Rehberi**

## **📌Proje Hakkında**

Bu proje, web ve mobile platformlar için geliştirilmiş Selenium + Appium + Java + Cucumber (BDD) tabanlı bir test otomasyon projesidir.
Proje kapsamında Login, Logout, Add Employee, Employee Search, Form Interaction, App Launch, Scroll & Navigation ve Alert Dialog senaryoları otomatik olarak test edilmektedir.

## **🛠️Kullanılan Teknolojiler**

• Java 17+

• Selenium WebDriver

• Appium

• Cucumber (BDD)

• JUnit 5

• Maven

• Allure Report

• Android Emulator / Real Device

• UiAutomator2

## **🔹Platform Seçimi**

Testler hem web hem mobile platformda çalışacak şekilde yapılandırılmıştır.
Platform seçimi base.properties dosyasından yapılır.

platform=web veya platform=mobile

## **⚙️Ön Gereksinimler**

Testleri çalıştırmadan önce aşağıdaki kurulumların yapılmış olması gerekir:

### **💻MAC**

1️⃣ Java
• Java 17 veya üzeri
(https://www.oracle.com/tr/java/technologies/downloads/)

2️⃣ Android SDK & Emulator
• Android Studio kurulu olmalı
• En az bir Android Emulator oluşturulmalı (Örn: Android 13 – API 33)
(https://developer.android.com/studio?hl=tr)

3️⃣ Appium
• Appium (CLI) kurulu olmalı
(https://appium.io/docs/en/latest/quickstart/install/)

• Appium server 4723 portunda çalışıyor olmalı

4️⃣ Node.js
Appium için gereklidir.
(https://nodejs.org/en/download/prebuilt-installer)

### **🪟WINDOWS**

1)Appium kurulumu yapılır. (https://appium.io/docs/en/latest/quickstart/install/)

2)Java kurulumu yapılır. (https://www.java.com/download/ie_manual.jsp)

3)Java jdk kurulumu yapılır.(https://www.oracle.com/tr/java/technologies/downloads/)

4)Node.JS kurulumu yapılır.(https://nodejs.org/en/download/prebuilt-installer)

5)Android Studio kurulumu yapılır.(https://developer.android.com/studio?hl=tr)

#### Web testleri için; 

• Chrome browser kurulu olmalıdır.  
• ChromeDriver otomatik olarak Selenium Manager tarafından yönetilmektedir.

Ekstra kurulum gerektirmez.


## **▶️ Testleri Çalıştırma**

### IntelliJ IDEA Üzerinden

#### Mobile testleri için;

1. Emulator açık olmalı
2. Appium server çalışıyor olmalı
3. Projede apps/ klasörü içerisine ilgili APK dosyası eklenmelidir.
⚠️ APK dosyası repository’ye dahil edilmemiştir.
4. `base.properties` dosyası içerisinde platform=mobile seçimi yapılır.
5. TestRunner class üzerinden Mobile ait herhangi bir tag seçilir: @scroll / @mobile / @alert
6. Ardından `mvn clean test` ile testler çalıştırılır veya TestRunner class üzerinden `Run` butonu ile çalıştırılır.

#### Web testleri için;

1. `base.properties` dosyası içerisinde platform=web seçimi yapılır.
2. Web testlerinin çalışabilmesi için `base.properties` dosyasına aşağıdaki değer eklenmelidir:
```properties
baseUrl=https://example.com
```
3. TestRunner class üzerinden Web'e ait herhangi bir tag seçilir: @login / @web
4. Ardından `mvn clean test` ile testler çalıştırılır veya TestRunner class üzerinden `Run` butonu ile çalıştırılır.

## **🔹Tag Kullanımı**

Testler tag bazlı çalıştırılabilir:

• @mobile → Mobile testleri

• @web → Web testleri

• @scroll → Scroll senaryosu

• @alert → Alert senaryosu

Runner class içerisinden tag değiştirilerek ilgili senaryolar çalıştırılabilir.

## **📊 Raporlama**

### **🔹 Allure Report**

1️⃣ Eski sonuçları temizle:
`rm -rf allure-results allure-report`

2️⃣ Testleri çalıştır:
`mvn clean test`

3️⃣ Rapor oluştur:
`allure generate allure-results --clean -o allure-report`

4️⃣ Raporu aç:
`allure open allure-report`

## **📸 Screenshot Mekanizması**

• Fail olan testlerde otomatik screenshot alınır.
• Screenshot’lar target/screenshots klasörüne kaydedilir ve Allure raporunda da görüntülenebilir.

## **📂Proje Yapısı**

```text
src
├── main
│  └── java
│    ├── core
│    │  ├── BaseConfiguration
│    │  ├── Driver
│    │  └── Utils
│    └── pages
├── test
│  ├── java
│  │  ├── hooks
│  │  ├── runner
│  │  └── steps
│  └── resources
│    └── features
```

## **⚠️Notlar**

• Testlerde explicit wait kullanılmıştır.
• Thread.sleep kullanılmamıştır.  
• Framework Page Object Model (POM) yapısına uygundur.  
• Web ve Mobile testler tek framework üzerinden yönetilmektedir.


## **👤Geliştirici**

## **Kübra Aykan**


