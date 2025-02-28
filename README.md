# Adpro - Eshop
Haliza N. S. Arfa | 2306211401 | Adpro A

## Deployment Link
[E-Shop on Koyeb](https://halizaarfa-adpro-eshop.koyeb.app/)

---

<details>
<summary>Module 1: Coding Standard</summary>

# Module 1: Coding Standard

## Reflection 1 

### Penerapan Prinsip Clean Code
Saya telah menerapkan prinsip _clean code_ pada beberapa hal berikut ini:
1. **Meaningful Names**: Penamaan variabel, fungsi, kelas, dan argumen dalam tutorial ini saya buat sejelas mungkin. Dengan nama yang berarti, saya tidak perlu lagi memberi komentar untuk menjelaskan maksud dari nama-nama tersebut.
2.  **Functions**: Fungsi yang saya buat menggunakan nama yang deskriptif, pendek, serta memiliki _single responsibility_. _Single responsibility_ yang dimaksud adalah hanya melakukan satu hal pada setiap fungsinya.
3.  **Objects and Data Structures**: Contoh yang saya terapkan adalah ketika men-_generate_ string UUID untuk setiap class `Product` yang dibuat. Kode tersebut saya letakkan pada _constructor_ `Product` secara langsung, menerapkan prinsip OOP.

### Penerapan Secure Coding
Saya menerapkan _input validation_ ketika membuat sebuah `Product` tanpa nama atau ketika _quantity_ bernilai negatif. Dengan penerapan ini, suatu `Product` akan dipastikan memiliki nama dan dengan jumlah minimum 0 pada proses _create_, sehingga meminimalisasi error yang mungkin dapat terjadi. 

## Reflection 2

### Perasaan dalam Membuat Unit Test
Bagi saya, _unit test_ dapat dengan mudah membantu saya mengidentifikasi kesalahan atau _bug_ yang dimiliki kode yang saya buat. Dengan _unit test_, saya tidak perlu selalu melakukan _run_ aplikasi dan memasukkan satu persatu data secara manual untuk memastikan _flow_ aplikasi sudah sesuai.

### Banyak Test yang Diperlukan dan Code Coverage
Jumlah _unit test_ bergantung pada kompleksitas dari suatu `Class`. Jika cenderung lebih simpel, maka _test_ yang dibutuhkan juga lebih sedikit. _Code coverage_ juga harus diperhatikan dalam pembuatan _unit test_. _Code coverage_ sendiri adalah alat ukur untuk mengukur test yang sudah dibuat oleh _developer_. Namun, _code coverage_ 100% belum tentu menunjukkan bahwa suatu kode bebas dari _bug_ karena menghitung dari banyak eksekusi, bukan logika program. 

### Cleanliness dari Functional Test yang Baru
Menurut saya, _functional test suite_ tersebut berpotensi untuk menurunkan kualitas dari _clean code_-nya. Hal ini karena _test suite_ tersebut mungkin mengandung banyak kode yang bersifat duplikat dari _test suite_ yang sudah ada sebelumnya. Untuk meningkatkan kualitas kode, bisa dibuat _helper class_ yang memiliki fungsi-fungsi _basic_ yang digunakan kedua _test suite_, sehingga kode tetap mengikuti prinsip DRY (Don't Repeat Yourself).

</details>

<details>
<summary>Module 2: CI/CD Dev Ops</summary>

# Module 2: CI/CD & Dev Ops

## Reflection

### Daftar Isu Code Quality yang Diperbaiki
#### Unnecessary modifier `public` on method `...`: the method is declared in an interface type

**Permasalahan:** Modifier `public` tidak diperlukan karena dalam suatu interface, method sudah secara default bersifat `public`.

**Contoh Isu pada Proyek:**
```java
public interface ProductService {
    public Product create (Product product);
}
```

**Solusi:** Menghapus modifier `public` pada _method_ tersebut.
```java
public interface ProductService {
    Product create (Product product);
}
```

#### Unused import `org.springframework.web.bind.annotation.*`
**Permasalahan:** Import `*` (all) menyebabkan banyaknya method yang tidak digunakan turut ter-import.

**Contoh Isu pada Proyek:**
```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }
}
```

**Solusi:** Melakukan import spesifik pada method yang digunakan saja, yakni `GetMapping`.
```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }
}
```

### CI/CD pada Workflow

Saya sudah mengimplementasikan CI/CD pada proyek ini. Saya menggunakan GitHub Actions untuk menjalankan workflow yang saya buat seperti `ci.yml`, `scorecard.yml`, dan `pmd.yml`. Workflow-workflow ini sudah otomatis dijalankan ketika adanya push atau pull request ke suatu branch. Misalnya, `ci.yml` mendefinisikan CI yang menjalankan unit test seluruh unit tests, sementara `pmd.yml` melakukan pengecekan terhadap kode ketika adanya push pada setiap branch. Pada titik ini, saya sudah menerapkan Continuous Integration (CI). Untuk Continuous Deployment (CD), saya menggunakan Koyeb sebagai platform yang akan secara otomatis men-_deploy_ aplikasi saya ketika ada push atau pull request ke suatu branch.

### Code Coverage
![image](https://github.com/user-attachments/assets/6e1ac403-fff5-4850-8058-205922ea159e)

</details>

# Module 3: Maintainability & OO Principles

## Reflection

### Prinsip S.O.L.I.D yang Diterapkan
#### 1. **Single Responsibility Principle (SRP)**
Diterapkan pada `HomePageController`, `ProductController`, dan `CarController`.
- `HomePageController`: melakukan mapping dengan endpoint `/`.
- `ProductController`: melakukan mapping dengan endpoint `/product`.
- `CarController`: melakukan mapping dengan endpoint `/car`.

Oleh karena itu, saya membuat tiga class yang berbeda.

#### 2. **Liskov Substitution Principle (LSP)**
Pada branch `before-solid`, `ProductController.java` memiliki subclass yaitu `CarController`. Padahal, `CarController` memiliki perilaku yang berbeda dengan `ProductController`.
Misalnya pada `editProductPost`, `ProductController` menggunakan method `PUT` sementara `CarController` menggunakan method POST.
Dengan begitu, objek dari superclass tidak dapat digantikan oleh objek dari subclass-nya dan menyalahi LSP.

Solusi yang saya terapkan adalah menghapus extends pada `CarController` dan membuat `CarController` menjadi class tersendiri pada file yang berbeda.

#### 3. **Interface Segregation Principle (ISP)**
Sudah diterapkan pada `CarService`. Menurut saya, tidak perlu dipisah lagi karena interface ini fokus pada satu hal yaitu CRUD (Create, Read, Update, Delete) untuk `Car`.

#### 4. **Dependency Inversion Principle (DIP)**
Pada branch `before-solid`, `CarController` bergantung langsung dengan implementation, `CarServiceImpl`. Seharusnya, `CarController` bergantung dengan interface `CarService`.

Oleh karena itu, saya mengganti tipe data dari variabel `carService` pada `CarController` menjadi `CarService`, dependency diinjeksi melalui constructor.

### Kelebihan dari Menerapkan Prinsip S.O.L.I.D
Dengan SRP, kode menjadi lebih mudah di-maintain. Perubahan pada suatu fitur tidak akan berdampak besar ke bagian lain.
Dengan DIP, seperti pada contoh `CarController` yang bergantung pada interface alih-alih implementation, logika kode dapat diubah seiring waktu tanpa mengubah kode yang bergantung padanya.
Kode juga dapat dengan mudah diperluas tanpa perlu modifikasi, sehingga meningkatkan reusability di mana kode dapat digunakan kembali.
Selain itu, jika bekerja dalam tim, penerapan S.O.L.I.D akan mempermudah code review karena kode akan lebih mudah dipahami anggota tim.

### Kekurangan dari Tidak Menerapkan Prinsip S.O.L.I.D
Menurut saya, kekurangan dari tidak diterapkannya S.O.L.I.D adalah kebalikan dari kelebihan-kelebihannya. Kode akan lebih sulit dikelola dan dipahami. Unit test juga akan sulit dilakukan. Ketika ada modifikasi kode, dibutuhkan effort yang tinggi karena modifikasi harus dilakukan di banyak bagian lainnya.
Misalnya, jika SRP tidak diterapkan, orang lain yang membaca kode mungkin akan kebingungan mencari kode bagian mana yang mengatur mapping dengan endpoint `/car`.
Jika DIP tidak diterapkan dan `CarController` bergantung langsung pada `CarServiceImpl`, setiap perubahan pada `CarServiceImpl` bisa merusak `CarController`.