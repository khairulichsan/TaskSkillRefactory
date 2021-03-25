# Program Restaurant Bill
program sederhana yang menampilkan output Bill.

## Contoh Inputan
> Masukan Nama Restoran : Warung Kuala Dua\
  Masukan Nama Kasir : Khairul Ichsan\
  Masukan Menu : nasi goreng \
  Masukan Harga : 5000 \
  Apakah ingin masukan data lagi?(Y/N)Y  \
  Masukan Menu : ayam goreng \
  Masukan Harga : 7000 \
  Apakah ingin masukan data lagi?(Y/N) N \
  
  ## Contoh Input dan Output
  ![output](https://user-images.githubusercontent.com/42132876/112406488-da063880-8d46-11eb-8865-e4e56b9ecd8c.png)
  
   ## Note
   Bagian paling atas berisi nama restoran di berikan aligncenter agar posisi fokus ke tengah
   
   ![center](https://user-images.githubusercontent.com/42132876/112419892-ca92e980-8d5e-11eb-973a-d6cef6e0f908.png)
   

   serta bila text melebihi 30 character maka haru turun baris selanjutnya
   
   ![30lenght](https://user-images.githubusercontent.com/42132876/112420005-0168ff80-8d5f-11eb-8e1e-c5f847c6761c.png)
   
   untuk data yang diinput seperti menu dan harga akan masuk ke arrayof ```val menu : ArrayList<String> = arrayListOf()``` dan
    ```val price : ArrayList<Int> = arrayListOf()``` lalu akan masuk ke dalam perulangan. Mereka akan di tampilkan menurut index dan di jumlahkan kedalam variabel total, serta juga menampilkan isi dari variabel total
    ![total](https://user-images.githubusercontent.com/42132876/112421116-10e94800-8d61-11eb-93e1-2951df47edac.png)
