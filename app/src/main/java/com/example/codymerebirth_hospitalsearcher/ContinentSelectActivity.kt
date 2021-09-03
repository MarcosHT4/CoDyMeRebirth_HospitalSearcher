package com.example.codymerebirth_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ContinentSelectActivity : AppCompatActivity() {

    var isDijkstra:Boolean? = null
    var buttonSelectLatam:Button? = null
    var buttonSelectEastEurope:Button? = null
    var buttonSelectWestEurope:Button? = null
    var continent:Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_continent_select)
        init()

        isDijkstra = intent.getBooleanExtra("isDijkstra", false)
        buttonSelectLatam?.setOnClickListener {

            continent = 0
            val intent = Intent(this, PathSelectionActivity::class.java)
            intent.putExtra("isDijkstra", isDijkstra)
            intent.putExtra("continent" , continent)
            startActivity(intent)

        }

        buttonSelectEastEurope?.setOnClickListener {

            continent = 1
            val intent = Intent(this, PathSelectionActivity::class.java)
            intent.putExtra("isDijkstra", isDijkstra)
            intent.putExtra("continent" , continent)
            startActivity(intent)

        }

        buttonSelectWestEurope?.setOnClickListener {

            continent = 2
            val intent = Intent(this, PathSelectionActivity::class.java)
            intent.putExtra("isDijkstra", isDijkstra)
            intent.putExtra("continent" , continent)
            startActivity(intent)

        }







    }

    fun init() {

        buttonSelectLatam = findViewById(R.id.buttonSelectLatam)
        buttonSelectEastEurope = findViewById(R.id.buttonSelectEastEurope)
        buttonSelectWestEurope = findViewById(R.id.buttonSelectWestEurope)

    }
}