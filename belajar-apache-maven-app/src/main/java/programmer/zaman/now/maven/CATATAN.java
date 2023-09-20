package programmer.zaman.now.maven;

public class CATATAN {
    /*
    * Notes!
    *
    * Pendahuluan           = > Pengenalan Build Automation
    *                         > Pengenalan Apache Maven
    *                         > Membuat Project Maven
    *                         > Maven Lifecycle
    *                         > Build Project
    *                         > Dependency Management
    *                         > Multi-Module Project
    *                         > Dan lain-lain
    *
    * Pengenalan Build      = > Build Automation adalah proses meng-otomatisasi tahapan pembuatan software dan hal-hal yang
    * Automation                berhubungan dengannya, seperti: kompilasi source code menjadi binary  code, mem-package
    *                           binary code menjadi distribution file, membuat dokumentasi, menjalankan automated test sampai
    *                           manajemen dependency.
    *
    *                         > Kompilasi Source Code
    *                           Source Code ----> Compile ----> Binary File
    *
    *                         > Mem-Package Binary File
    *                           Binary File ----> Packaging ----> Distribution File
    *                           Contoh : Java : jar, war, ear
    *
    *                         > Membuat Dokumentasi
    *                           Source Code ----> Compile Doc ----> Documentation
    *
    *                         > Menjalankan Automated Test
    *                           // Lihat di PPT
    *
    *                         > Management Dependency
    *                           // Lihat di PPT
    *
    *                         > Contoh Build Automation Tool
    *                           > Apache Maven
    *                           > Apache Ivy
    *                           > Gradle
    *
    *                         > Pengenalan Apache Maven
    *                           > Apache Maven adalah salah satu build automation yang free dan open source
    *                           > Apache menggunakan XML untuk mendefinisikan build script nya
    *                           > Apache Maven saat ini sangat populer di kalangan Developer Java
    *                           > Apache Maven menggunakan JVM sebagai fondasi dasar
    *                           > https://maven.apache.org/
    *
    *                         > Teknologi yang Didukung
    *                           > Apache Maven mendukung build automation untuk banyak teknologi, seperti :
    *                             > Java
    *                             > Kotlin
    *                             > Groovy
    *                             > Scala
    *                             > dan lain-lain
    *
    * Menginstall Apache    = > Download Maven
    * Maven                     > https://maven.apache.org/download.cgi
    *
    *                         > Setting Path
    *                           > Windows : https://medium.com/programmer-zaman-now/setting-java-path-di-windows-4da2c65d8298
    *                           > Mac & Linux
    *                             > # Add to .bashrc or .zshrc
    *                               export MAVEN_HOME="/usr/local/Cellar/maven/3.6.3_1"
    *                               export PATH="$MAVEN_HOME/bin:$PATH"
    *
    *                         > Mengecek Apache Maven
    *                           > mvn --version
    *
    *                         > Jika mau upgrade tinggal ubah di Path Environtment nya aja
    *
    * Membuat Project       = > Archetype
    *                           > Maven mendukung pembuatan berbagai macam project dengan mudah
    *                           > Pembuatan project di maven menggunakan archetype, archetype adalah template project
    *                           > Kita bisa menggunakan yang sudah disediakan oleh maven, atau bahkan bisa membuat template archetype sendiri
    *                           > https://maven.apache.org/guides/introduction/introduction-to-archetypes.html
    *
    *                         > Membuat Java Project
    *                           > 1. mvn archetype:generate
    *                           > 2. maven-archetype-quickstart (Pilih template ini, ini adalah template java sederhana yang biasa digunakan)
    *
    * Struktur Project      = > Struktur Project Apache Maven
    *                           > .idea (bawaan intellij IDEA)
    *                           > src (bawaan maven)
    *                             > main (source code main)
    *                             > test (source code unit test)
    *                           > target (tempat menampung hasil kompilasi)
    *                           > ... .iml (bawaan intellij IDEA)
    *                           > pom.xml (Deklarasi Struktur Maven, semua konfigurasi, deklarasi, dependency dan lain lain punya apache maven)
    *                             > Notes !
    *                               > Bisa ganti URL jadi URL kalian
    *                               > Update source & target compiler jadi sesuai versi java kalian contoh. 20
    *                               > Jika ada perubahan maka wajib reload maven di tab kanan Maven
    *
    * Maven Lifecycle       = > Lifecycle
    *                           > Maven bekerja dalam konsep lifecycle
    *                           > Untuk menjalankan lifecycle, kita bisa menggunakan perintah : mvn namalifecycle
    *                           > Lifecycle akan menjalankan banyak plugin, entah bawaan maven, atau bisa kita tambahkan plugin lain jika mau
    *                           > https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html
    *
    *                         > Contoh Lifecycle
    *                           > clean, menghapus folder target (tempat menyimpan hasil kompilasi)
    *                           > compile, untuk melakukan kompilasi source code project
    *                           > test-compile, untuk melakukan kompilasi source code project
    *                           > test, untuk menjalankan unit test
    *                           > package, untuk membuat distribution file aplikasi
    *                           > install, untuk menginstalll project ke local repository, sehigga bisa digunakan di project lain di local
    *                           > deploy,  deploy project ke remote repository di server
    *
    *                         > Contoh Penggunaan
    *                           > mvn compile               // Untuk Compile main
    *                           > mvn test-compile          // Untuk Compile test
    *                           > mvn clean                 // Hapus folder Compile(target)
    *                           > mvn compile test-compile  // Bisa melakukan 2 atau lebih perintah sekaligus
    *                           > mvn test                  // Untuk melakukan testing unit test
    *
    * Build Project         = > Saat kita membuat project biasanya akan ada 2 jenis kode yang kita buat, kode program nya, dan kode testing nya
    *                         > Maven mendukung hal tersebut
    *
    *                         > Menjalankan Kompilasi Program
    *                           > mvn compile
    *
    *                         > Menjalankan Unit Test
    *                           > mvn test
    *
    *                         > Mem-package Project
    *                           > mvn package
    *
    *                         > Praktek :
    *                           > mvn clean compile test package                            // Menjalankan banyak lifecycle sekaligus, dari clean sampai package atau membuat file .jar
    *                           > java -jar target/belajar-apache-maven-1.0-SNAPSHOT.jar    // Perintah untuk menjalankan file .jar yang sudah dibuat
    *
    * Dependency            = > Proyek  aplikasi jarang sekali berdiri sendiri, biasanya membutuhkan dukungan dari pihak lain, seperti tool atau library
    *                         > Tanpa build tool seperti Apache Maven, untuk menambahkan library dari luar, kita harus melakukannya secara manual
    *                         > Apache Maven mendukung dependency management, dimana kita tidak perlu me-manage secara manual proses penambahkan dependency (tool atau library) ke dalam proyek aplikasi kita
    *
    *                         > Dependency Scope
    *                           > Saat kita menambahkan dependency ke project Maven, kita harus menentukan scope dependency
    *                             tersebut, ada banyak scope yang ada di Maven, namun sebenarnya hanya beberapa saja yang sering
    *                             kita gunakan, seperti :
    *                             > compile, ini adalah  scope default. Compile artinya dependency tersebut akan digunakan untuk build project, test project dan menjalankan project.
    *                             > test, ini adalah scope untuk test project, hanya akan di include di bagian test project
    *
    *                         > Mencari Dependency
    *                           > https://search.maven.org/
    *                           > https://mvnrepository.com/
    *
    *                         > Cara Menambahkan Dependency
    *                           > Tinggal copas dari sumber ke pom.xml
    *
    *                         > pom.xml, Person.java, App.java
    *
    * Maven Properties      = > Maven mendukung properties untuk menyimpan data konfigurasi
    *                         > Fitur ini akan sangat memudahkan kita kedepannya, dibandingkan melakukan hardcode di konfigurasi maven
    *
    *                         > pom.xml
    *
    * Membuat Distribution  = > Secara default, maven mendukung pembuatan distribution file menggunakan lifecycle package
    * File                    > Hanya saja, hasil distribution file nya berupa file jar yang berisikan binary code dari project kita
    *                         > Dependency lainnya tidak dimasukkan, sehingga tidak bisa langsung dijalankan
    *
    *                         > Menggunakan Assembly Plugin
    *                           > Salah satu plugin yang bisa kita gunakan untuk membuat distribution file beserta dependency yang kita butuhkan adalah Assembly Plugin
    *                           > https://maven.apache.org/plugins/maven-assembly-plugin/usage.html
    *                           > Tidak hanya Assembly Plugin, sebenarnya masih banyak plugin lain yang bisa kita gunakan untuk membuat distribution file di Maven
    *                           > Untuk membuat distribution file, kita bisa menggunakan perintah mvn package assembly:single
    *
    *                         > Cara menjalankan Assembly Plugin
    *                           > mvn clean package assembly:single
    *
    *                         > Cara menjalankan file .jar
    *                           > java -jar target/belajar-apache-maven-1.0-SNAPSHOT.jar                            // .jar yang biasa tanpa include dependency
    *                           > java -jar target/belajar-apache-maven-1.0-SNAPSHOT-jar-with-dependencies.jar      // .jar hasil Assembly plugin, include semua dependency
    *
    *                         > Selanjutnya :
    *                           > .jar mau di jalankan di server ?
    *                           > .jar mau dibuat docker image (Docker) ?
    *                           > Bisa semua
    *
    *                         > pom.xml
    *
    * Multi Module Project  = > Saat aplikasi kita sudah sangat besar, kadang ada baiknya kita buat aplikasi dalam bentuk modular
    *                         > Misal kita pisahkan module model, controller, view, service, repository, dan lain-lain
    *                         > Untungnya, Maven mendukung pembuatan project multi module
    *
    *                         > Membuat Module Baru
    *                           > Untuk membuat module baru, di dalam project yang sudah ada, kita hanya tinggal membuat folder baru, lalu menambahkan setting pom.xml di folder tersebut
    *                           > Module harus memiliki parent, dimana parent nya adalah project diatas folder tersebut
    *                           > Selanjutnya, di parent nya pun, module harus di include
    *
    *                         > Cara menjalankan Assembly Plugin
    *                           > mvn clean package assembly:single
    *
    *                         > Cara menjalankan file .jar
    *                           > java -jar belajar-apache-maven-app\target\belajar-apache-maven-app-1.0-SNAPSHOT-jar-with-dependencies.jar
    *
    *                         > belajar-apache-maven-app (dan semua isinya), belajar-apache-maven-data (dan semua isinya)
    *
    * Dependency Management = > Saat project kita sudah besar, kadang kita sering menggunakan banyak dependency
    *                         > Masalah dengan banyaknya dependency adalah, jika kita salah menggunakan dependency yang sama namun versinya berbeda-beda
    *                         > Maven mendukung fitur dependency management, dimana kita bisa memasukkan daftar dependency di parent module beserta versinya, lalu menambahkan dependency tersebut di module tanpa harus menggunakan versinya
    *                         > Secara otomatis versi dependency akan sama dengan yang ada di dependency management di parent module
    *
    *                         > Agar versi dependency di tiap module mengikuti pom.xml parentnya
    *
    *                         > pom.xml (belajar-apache-maven), pom.xml (belajar-apache-maven-app)
    *
    * Materi Selanjutnya    = > Java Unit Test
    *                         > Java Stream
    *                         > Java Database
    *
    * */
}
