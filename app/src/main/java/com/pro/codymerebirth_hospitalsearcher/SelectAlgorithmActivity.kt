package com.pro.codymerebirth_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.pro.codymerebirth_hospitalsearcher.R

class SelectAlgorithmActivity : AppCompatActivity() {
    var buttonDijstra:Button? = null
    var buttonFloydWarshall:Button? = null
    var isDijkstra:Boolean? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_algorithm)
        init()

        buttonDijstra?.setOnClickListener{

            isDijkstra = true

            val intent = Intent(this, ContinentSelectActivity::class.java)
            intent.putExtra("isDijkstra", isDijkstra)
            startActivity(intent)

        }


        buttonFloydWarshall?.setOnClickListener{

            isDijkstra = false
            val intent = Intent(this, ContinentSelectActivity::class.java)
            intent.putExtra("isDijkstra", isDijkstra)
            startActivity(intent)

        }
    }

    fun init(){

        buttonDijstra = findViewById(R.id.buttonDijkstraSelect)
        buttonFloydWarshall = findViewById(R.id.buttonFloydWarshallSelect)

    }
}