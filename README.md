# Responsi Mobile
Nama : Muhammad Syahrial hipdi

NIM  : H1D023047

Shift Lama : E

Shift Baru : E

# Demo Aplikasi




https://github.com/user-attachments/assets/407bf25c-f794-4fe9-aea8-dcb162b57851





# Penjelasan Alur Aplikasi
Aplikasi ini menampilkan informasi tim sepakbola, pelatih, dan pemain secara real-time dari API Football Data. Dibangun dengan arsitektur MVVM modern yang terstruktur.
1. Inisialisasi Aplikasi
Saat aplikasi dibuka, sistem memuat MainActivity dan menginisialisasi komponen jaringan Retrofit dengan konfigurasi API key dan base URL. Semua setup jaringan sudah otomatis terkoneksi.
2. Navigasi Pengguna
User berinteraksi dengan antarmuka, memilih tim tertentu, dan sistem berpindah ke halaman detail (ClubActivity, DaftarSquad, atau CoachActivity) dengan membawa ID tim sebagai parameter.
3. Pengambilan Data
ViewModel memulai proses pengambilan data dengan menjalankan coroutine di background. Retrofit mengirim request HTTP ke API server dengan authentication header yang sudah terkoneksi otomatis.
4. Pemrosesan Response
API merespons dengan data JSON yang kemudian dikonversi oleh Gson menjadi object Kotlin. Data coach, daftar pemain, dan informasi tim dipetakan ke model data yang sesuai.
5. Update Antarmuka
LiveData di ViewModel diperbarui dengan data baru, yang memicu observer di Activity. RecyclerView menampilkan daftar pemain dengan warna berbeda berdasarkan posisi, sementara halaman coach menampilkan detail informasi pelatih.
6. Interaksi Lanjutan
User dapat men-tap pemain untuk melihat detail lebih lanjut melalui dialog fragment, atau berpindah antar halaman untuk menjelajahi informasi berbeda tentang tim yang sama.
Manajemen Sistem
Aplikasi menangani error jaringan secara graceful, mengelola lifecycle dengan baik, dan menjaga performa optimal melalui ViewModel yang bertahan selama configuration changes serta RecyclerView yang efisien.

Alur Data Singkat
User Input → Activity → ViewModel → API Call → JSON Response → Data Mapping → LiveData Update → UI Rendering → User melihat hasil

Sistem ini memastikan data selalu ter-update, antarmuka responsif, dan pengalaman pengguna yang smooth dari awal hingga akhir.
