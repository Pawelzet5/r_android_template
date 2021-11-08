package com.example.r_android_template.service

import android.util.Log
import org.json.JSONArray
import org.json.JSONTokener
import java.math.BigDecimal
import java.math.RoundingMode

object EstateRepository{

    var estateList = mutableListOf<Estate>()

    fun parseJSON() {
        val jsonArray = JSONTokener(Service.getString()).nextValue() as JSONArray
        for (i in 0 until jsonArray.length()) {
        // ID
        val id = jsonArray.getJSONObject(i).getInt("id")
        //Log.i("ID: ", id.toString())

        // Estate Number
        val estateNo = jsonArray.getJSONObject(i).getString("estateNo")
       // Log.i("estateNo: ", estateNo)

        // Area
        val area = jsonArray.getJSONObject(i).getString("area")
        val areaTrimmed = BigDecimal(area.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()
        //Log.i("Area: ", area.toString())

        // Land
        val land = jsonArray.getJSONObject(i).getString("land")
        //Log.i("Land: ", land)
        // District
        val district = jsonArray.getJSONObject(i).getString("district")
       // Log.i("District: ", district)

        estateList.add(Estate(id, estateNo, areaTrimmed, land, district))

        }

        }
    }
