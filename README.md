# Adpro - Eshop
Haliza N. S. Arfa | 2306211401

---

## Module 1: Coding Standard

### Reflection 1 

#### Penerapan Prinsip Clean Code
Saya telah menerapkan prinsip _clean code_ pada beberapa hal berikut ini:
1. **Meaningful Names**: Penamaan variabel, fungsi, kelas, dan argumen dalam tutorial ini saya buat sejelas mungkin. Dengan nama yang berarti, saya tidak perlu lagi memberi komentar untuk menjelaskan maksud dari nama-nama tersebut.
2.  **Functions**: Fungsi yang saya buat menggunakan nama yang deskriptif, pendek, serta memiliki _single responsibility_. _Single responsibility_ yang dimaksud adalah hanya melakukan satu hal pada setiap fungsinya.
3.  **Objects and Data Structures**: Contoh yang saya terapkan adalah ketika men-_generate_ string UUID untuk setiap class `Product` yang dibuat. Kode tersebut saya letakkan pada _constructor_ `Product` secara langsung, menerapkan prinsip OOP.

#### Penerapan Secure Coding
Saya menerapkan _input validation_ ketika membuat sebuah `Product` tanpa nama atau ketika _quantity_ bernilai negatif. Dengan penerapan ini, suatu `Product` akan dipastikan memiliki nama dan dengan jumlah minimum 0 pada proses _create_, sehingga meminimalisasi error yang mungkin dapat terjadi. 

### Reflection 2

#### Perasaan dalam Membuat Unit Test
Bagi saya, _unit test_ dapat dengan mudah membantu saya mengidentifikasi kesalahan atau _bug_ yang dimiliki kode yang saya buat. Dengan _unit test_, saya tidak perlu selalu melakukan _run_ aplikasi dan memasukkan satu persatu data secara manual untuk memastikan _flow_ aplikasi sudah sesuai.

#### Banyak Test yang Diperlukan dan Code Coverage
Jumlah _unit test_ bergantung pada kompleksitas dari suatu `Class`. Jika cenderung lebih simpel, maka _test_ yang dibutuhkan juga lebih sedikit. _Code coverage_ juga harus diperhatikan dalam pembuatan _unit test_. _Code coverage_ sendiri adalah alat ukur untuk mengukur test yang sudah dibuat oleh _developer_. Namun, _code coverage_ 100% belum tentu menunjukkan bahwa suatu kode bebas dari _bug_ karena menghitung dari banyak eksekusi, bukan logika program. 

#### Cleanliness dari Functional Test yang Baru
Menurut saya, _functional test suite_ tersebut berpotensi untuk menurunkan kualitas dari _clean code_-nya. Hal ini karena _test suite_ tersebut mungkin mengandung banyak kode yang bersifat duplikat dari _test suite_ yang sudah ada sebelumnya. Untuk meningkatkan kualitas kode, bisa dibuat _helper class_ yang memiliki fungsi-fungsi _basic_ yang digunakan kedua _test suite_, sehingga kode tetap mengikuti prinsip DRY (Don't Repeat Yourself).
