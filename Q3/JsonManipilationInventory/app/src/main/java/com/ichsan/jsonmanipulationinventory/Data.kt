package com.ichsan.jsonmanipulationinventory

class Data (
    val inventory_id : Int,
    val name : String,
    val type : String,
    val tags : List<String>,
    val purchased_at : Long,
    val placement : Place) {
        data class Place(
                val room_id : Int,
                val name : String)
    }