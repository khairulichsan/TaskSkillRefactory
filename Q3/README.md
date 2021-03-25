# JSON MANIPULATION INVENTORY
menampilkan isi data dari nomor yang di pilih.
  ## contoh optional input
  ![optioninventrory](https://user-images.githubusercontent.com/42132876/112410252-7d5a4c00-8d4d-11eb-8fb8-3dc926106975.png)

> Pilih nomor salah satu untuk menampilkan Data
 

  ![optioninventrorychoose](https://user-images.githubusercontent.com/42132876/112410309-8fd48580-8d4d-11eb-9456-60e441239a3b.png)
  
  
  ## Ulasan
  
  
   pertama melalukan dependensi di build.grade mengunakan
  ```implementation 'com.google.code.gson:gson:2.8.6'```
  
  We have JSON Data:
https://gist.github.com/dhamanutd/97aa0d2131903ea8c071721032c7b2a3

semua data json masukan kedalam ```class dummy``` di ```val jsonInventory```

setelah itu membuat ```class data``` untuk model

![12](https://user-images.githubusercontent.com/42132876/112427678-91617600-8d6c-11eb-8e63-5b30b7939a46.png)

seperti biasa ```class dummy``` dan ```class data``` akan di panggil kedalam ```Main.kt``` :

![10](https://user-images.githubusercontent.com/42132876/112428161-51e75980-8d6d-11eb-8c63-30d7c8bd38c6.png)

lalu akan masuk ke dalam perulangan untuk menentukan posisi yang akan di pakai ke perulangn selanjutnya :

```  var listItem: ArrayList<Int> = arrayListOf()
    for (position in dataInventory.indices) {
        var data = dataInventory[position]
        when (input) {
            1 -> {
                var place = data.placement.name
                if (place == "Meeting Room") {
                    listItem.add(position)
                }
            }
         ...   
```
selajutnya ke perulangan menetukan listItem dan menampilkan data :
```
       if (position == dataInventory.size - 1 && input <= 5) {
            if (listItem.size != 0) {
                for (item in 0..listItem.size - 1) {
                    var dataList = dataInventory[listItem[item]]
                    when (input) {
                        1 -> println("ItemId : ${dataList.inventory_id}, Name : ${dataList.name} in Meeting Room")
                        2 -> {
         ...
```

