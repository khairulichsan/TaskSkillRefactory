package com.ichsan.jsonmanipulationinventory

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    println("1.Find items in Meeting Room.\n" +
                    "2.Find all electronic devices.\n" +
                    "3.Find all furnitures.\n" +
                    "4.Find all items was purchased at 16 Januari 2020.\n" +
                    "5.Find all items with brown color.\n"
    )
    println()
    print("Masukan pencarian yang diinginkan : ")
    var input = readLine()!!.toInt()

    val gson = Gson()
    val json = Dummy().jsonInventory
    var listType = object : TypeToken<List<Data>>() {}.type
    var dataInventory: List<Data> = gson.fromJson(json, listType)


    var listItem: ArrayList<Int> = arrayListOf()

    for (position in dataInventory.indices) {
        var data = dataInventory[position]
        when (input) {
            1 -> {
                var place = data.placement.name
                if (place == "Meeting Room") {
                    listItem.add(position)
                }
            }
            2 -> {
                var type = data.type
                if (type == "electronic") {
                    listItem.add(position)
                }
            }

            3 -> {
                var type = data.type
                if (type == "furniture") {
                    listItem.add(position)
                }
            }

            4 -> {
                var date = convertLongToTime(data.purchased_at)
                if (date == "16 Januari 2020") {
                    listItem.add(position)
                }
            }
            5 -> {
                var tags = data.tags
                for (tag in 0..tags.size - 1) {
                    if (tags[tag] == "brown") {
                        listItem.add(position)
                    }
                }
            }
            else -> if (position == dataInventory.size-1) println("Nomor yang anda masukan salah")
        }
        if (position == dataInventory.size - 1 && input <= 5) {
            if (listItem.size != 0) {
                for (item in 0..listItem.size - 1) {
                    var dataList = dataInventory[listItem[item]]
                    when (input) {
                        1 -> println("ItemId : ${dataList.inventory_id}, Name : ${dataList.name} in Meeting Room")
                        2 -> {
                            println("ItemId : ${dataList.inventory_id}, Name : ${dataList.name}")
                            if (item == listItem.size - 1) println("is Electronic Devices")
                        }
                        3 -> {
                            println("ItemId : ${dataList.inventory_id}, Name : ${dataList.name}")
                            if (item == listItem.size - 1) println("is Furniture")
                        }
                        4 -> {
                            println("ItemId : ${dataList.inventory_id}, Name : ${dataList.name}")
                            if (item == listItem.size - 1) println("was purchased at 16 Januari 2020")
                        }
                        5 -> {
                            println("ItemId : ${dataList.inventory_id}, Name : ${dataList.name}")
                            if (item == listItem.size - 1) println("is Brown Color")
                        }
                    }
                }
            }
            else {
                println("Item Not Found")
            }
        }

    }
}

fun convertLongToTime(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("dd MMMMM yyyy")
    return format.format(date)
}
