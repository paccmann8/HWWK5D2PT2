package com.example.hwwk5d2pt2

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    override fun onResume() {
        super.onResume()
        readFromProvider()
    }

    private fun readFromProvider() {
        val contentResolver = contentResolver
        val contentUrl = "content://com.example.room.provider.MyHotelProvider/Guests"

        val uri = Uri.parse(contentUrl)

        val cursor = contentResolver.query(uri, null, null, null, null)

        var guestList = mutableListOf<String>()
        cursor?.moveToFirst()



        while(cursor?.moveToNext() == true){

            guestList.add(cursor.getString(cursor.getColumnIndex("Guest")))
        }

        TextView.text=guestList.toString()
        cursor?.close()
    }

}