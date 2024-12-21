README: Program Pengecekan Bilangan Genap/Ganjil

Deskripsi Program

Program ini adalah aplikasi GUI berbasis Java Swing untuk mengecek bilangan genap atau ganjil. Program ini juga dilengkapi dengan tabel riwayat untuk mencatat angka yang telah dicek, serta menyediakan fitur edit dan hapus data dari tabel.
---

Fitur Utama
1. Pengecekan Bilangan Genap/Ganjil

Memasukkan angka untuk diperiksa apakah genap atau ganjil.

Jika angka desimal dimasukkan, angka akan dibulatkan terlebih dahulu sebelum dicek.

2. Tabel Riwayat

Menyimpan angka yang telah dicek beserta hasilnya dalam tabel.

3. Hapus Data

Menghapus data tertentu dari tabel riwayat.

4. Edit Data

Mengubah angka yang dipilih dari tabel riwayat dengan angka baru, dan hasil akan diperbarui.

5. Ikon Tombol

Tombol dilengkapi dengan ikon visual untuk memperjelas fungsi masing-masing tombol.

---

Komponen Antarmuka

Label dan Input Field

JLabel: Memberikan informasi untuk input.

JTextField: Tempat memasukkan angka yang akan dicek.

Tombol

Cek: Mengecek apakah bilangan genap atau ganjil.

Hapus Data: Menghapus data yang dipilih dari tabel.

Edit Data: Mengedit data yang dipilih dari tabel.

Tabel Riwayat

JTable: Menyimpan angka yang telah dicek beserta hasilnya.

JScrollPane: Memberikan scroll untuk navigasi data yang panjang.

---

Logika Program

1. Cek Bilangan Genap/Ganjil

Membaca angka dari JTextField.

Membulatkan angka ke bilangan bulat terdekat.

Memasukkan angka dan hasil pengecekan (genap/ganjil) ke tabel.



2. Hapus Data dari Tabel

Menghapus baris yang dipilih dari tabel.

Memberikan peringatan jika tidak ada baris yang dipilih.



3. Edit Data pada Tabel

Mengedit angka di baris tertentu dengan angka baru yang dimasukkan.

Memperbarui hasil pengecekan setelah angka diubah.

---

Cara Menjalankan Program

1. Kompilasi Program
Jalankan perintah berikut di terminal:

javac UAP.java

2. Eksekusi Program
Jalankan program dengan perintah:

java UAP

---

Kebutuhan Sistem

Java Development Kit (JDK) versi 8 atau lebih baru.

Koneksi Internet untuk memuat ikon tombol.

---

Screenshot Tampilan

1. Antarmuka Utama

Input angka di bagian atas.

Tabel riwayat di bagian bawah.

2. Dialog Edit Data

Pop-up untuk mengganti angka yang telah dimasukkan sebelumnya.

---

Catatan

Pastikan angka yang dimasukkan valid. Jika input tidak valid, program akan menampilkan pesan kesalahan.

Pilih data di tabel sebelum menggunakan tombol Hapus Data atau Edit Data. Jika tidak, akan muncul peringatan.

Semoga bermanfaat!
