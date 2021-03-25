# JSON MANIPULATION ARTICLE
menampilkan isi data dari nomor yang di pilih.
  ## contoh optional input
  ![option](https://user-images.githubusercontent.com/42132876/112409394-fd7fb200-8d4b-11eb-89fa-efd569e68366.png)

> Pilih nomor salah satu untuk menampilkan Data\
 

  ![optioninventrorychoose](https://user-images.githubusercontent.com/42132876/112409522-391a7c00-8d4c-11eb-89ef-ecbed5d34f7f.png)
  
  ## ulasan
  pertama melalukan dependensi di build.grade mengunakan
  ```implementation 'com.google.code.gson:gson:2.8.6'```
  
  We have JSON Data:
https://gist.github.com/dhamanutd/6993984928506eea49908c2e3fcbc628

  semua data json masukan kedalam class Dummy di val jsonprofil
  
  ![dummy](https://user-images.githubusercontent.com/42132876/112422877-290e9680-8d64-11eb-85da-f11d2f236583.png)
  
  
  dan juga membuat class data untuk model
  
  ![data](https://user-images.githubusercontent.com/42132876/112423213-c8cc2480-8d64-11eb-99a5-e49dba608a20.png)

lalu class dummy dan class Data akan di panggil kedalam ```Main.kt``` :

``` val listType = object : TypeToken<List<Data>>() {}.type
    val json = Dummy().jsonProfile
    val dataProfile: List<Data> = gson.fromJson(json, listType)
 ```
 ketika sudah di input sebuah nomor yang kita pilih akan masuk dalam perulangan
 
 ## 1.Find users who don't have any phone numbers.
 ``` val phone = dataProfile[user].profile?.phones?.size
                if (phone == 0) {
                    nameUser = dataProfile[user].username
                    println("$nameUser don't have any phone Number")
  ```
  
  ### 2. Find users who have articles.
   ``` val articles = dataProfile[user].articles.size
                if (articles == 0) {
                    nameUser = dataProfile[user].username
                    println("$nameUser don't have Articles")
  ```
  
  ### 3. Find users who have "annis" on their name. 
   ``` val fullname = dataProfile[user].profile?.full_name
                val splitName = fullname?.split(" ")
                if (splitName != null) {
                    for (word in 0..(splitName.size - 1)) {
                        val splitWord = splitName[word].split("")
                        var name = ""

                        for (char in 1..splitWord.size - 1) {
                            name += splitWord[char]
                            if (name.toLowerCase(Locale.ROOT) == "annis") {
                                println("$fullname have a word annis")
                            }
                        }
                    }
                }
  ```
  
  ### 4. Find users who have articles on the year 2020. 
   ```  val articles = dataProfile[user].articles.size
                if (articles != 0) {
                    val publish = dataProfile[user].articles
                    for (count in publish.indices) {
                        val splitPublish = publish[count].published_at.split("")
                        var yearPublish = ""
                        for (number in 1..4) {
                            yearPublish += splitPublish[number]
                        }
                        if (yearPublish.toInt() == 2020) {
                            have++
                            nameUser = dataProfile[user].username
                            println("$nameUser have Articles at 2020")
                        }
  ```
  
  ### 5. Find users who are born in 1986.
   ``` val born = dataProfile[user].profile?.birthday
                val bornSplit = born?.split("")
                var bornYear = ""
                for (count in 1..4) {
                    bornYear += bornSplit?.get(count)
                    if (bornYear.toInt() == 1986) {
                        have++
                        nameUser = dataProfile[user].username
                        println("$nameUser born at 1986")
                    }
                }
  ```
  
  ## 6.Find articles that contain "tips" on the title. 
 ``` val articles = dataProfile[user].articles
                val totalArticles = articles.size
                if (totalArticles != 0) {
                    for (count in articles.indices) {
                        nameArticles = articles[count].title
                        val splitName = nameArticles.split(" ")
                        for (word in 0..splitName.size - 1) {
                            val splitWord = splitName[word].split("")
                            var wordTips = ""
                            for (char in 1..splitWord.size-1){
                                wordTips += splitWord[char]
                            }
                            if ( wordTips.toLowerCase(Locale.ROOT) == "tips") {
                                have++
                                nameUser = dataProfile[user].username
                                println("$nameUser have articles with contains \"tips\" with title $nameArticles ")
                                continue
                            }
                        }
  ```
  
  ## 7.Find articles published before August 2019.
 ```  val articles = dataProfile[user].articles
                val countArticles = articles.size
                if (countArticles != 0) {
                    for (article in 0 until countArticles){
                        var month = ""
                        var year = ""
                        val publish = articles[article].published_at
                        val splitPublish = publish.split("-")
                        for (i in 0..1){
                            if (i == 0) year += splitPublish[i]
                            if (i == 1) month += splitPublish[i]
                        }
                        if (year.toInt()<2020 && month.toInt()<8) {
                            have++
                            nameArticles = articles[article].title
                            nameUser = dataProfile[user].username
                            println("$nameUser have articles before August 2019 with title $nameArticles")
                        }
                    }
                }
  ```
