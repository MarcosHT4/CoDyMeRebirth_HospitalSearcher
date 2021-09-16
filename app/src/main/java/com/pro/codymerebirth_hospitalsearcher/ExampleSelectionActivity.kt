package com.pro.codymerebirth_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.pro.codymerebirth_hospitalsearcher.R

class ExampleSelectionActivity : AppCompatActivity() {

    var buttonExampleDijkstra1:Button? = null
    var buttonExampleDijkstra2:Button? = null
    var buttonExampleDijkstra3:Button? = null
    var buttonExampleDijkstra4:Button? = null

    var buttonExampleFloydWarshall1:Button? = null
    var buttonExampleFloydWarshall2:Button? = null
    var buttonExampleFloydWarshall3:Button? = null
    var buttonExampleFloydWarshall4:Button? = null

    var isDijkstra:Boolean? = null
    var continent:Int? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_selection)

        init()

        buttonExampleDijkstra1?.setOnClickListener {

            val intent = Intent(this, PathSelectionActivity::class.java)
            isDijkstra = true
            continent = 3
            intent.putExtra("isDijkstra", isDijkstra)
            intent.putExtra("continent", continent)
            startActivity(intent)


        }

        buttonExampleDijkstra2?.setOnClickListener {

            val intent = Intent(this, PathSelectionActivity::class.java)
            isDijkstra = true
            continent = 4
            intent.putExtra("isDijkstra", isDijkstra)
            intent.putExtra("continent", continent)
            startActivity(intent)


        }

        buttonExampleDijkstra3?.setOnClickListener {

            val intent = Intent(this, PathSelectionActivity::class.java)
            isDijkstra = true
            continent = 5
            intent.putExtra("isDijkstra", isDijkstra)
            intent.putExtra("continent", continent)
            startActivity(intent)


        }

        buttonExampleDijkstra4?.setOnClickListener {

            val intent = Intent(this, PathSelectionActivity::class.java)
            isDijkstra = true
            continent = 6
            intent.putExtra("isDijkstra", isDijkstra)
            intent.putExtra("continent", continent)
            startActivity(intent)


        }

        buttonExampleFloydWarshall1?.setOnClickListener {

            val intent = Intent(this, PathSelectionActivity::class.java)
            isDijkstra = false
            continent = 7
            intent.putExtra("isDijkstra", isDijkstra)
            intent.putExtra("continent", continent)
            startActivity(intent)


        }

        buttonExampleFloydWarshall2?.setOnClickListener {

            val intent = Intent(this, PathSelectionActivity::class.java)
            isDijkstra = false
            continent = 8
            intent.putExtra("isDijkstra", isDijkstra)
            intent.putExtra("continent", continent)
            startActivity(intent)


        }

        buttonExampleFloydWarshall3?.setOnClickListener {

            val intent = Intent(this, PathSelectionActivity::class.java)
            isDijkstra = false
            continent = 9
            intent.putExtra("isDijkstra", isDijkstra)
            intent.putExtra("continent", continent)
            startActivity(intent)


        }

        buttonExampleFloydWarshall4?.setOnClickListener {

            val intent = Intent(this, PathSelectionActivity::class.java)
            isDijkstra = false
            continent = 10
            intent.putExtra("isDijkstra", isDijkstra)
            intent.putExtra("continent", continent)
            startActivity(intent)


        }

    }

    private fun init() {

        buttonExampleDijkstra1 = findViewById(R.id.buttonEjemploDijkstra1)
        buttonExampleDijkstra2 = findViewById(R.id.buttonEjemploDijkstra2)
        buttonExampleDijkstra3 = findViewById(R.id.buttonEjemploDijkstra3)
        buttonExampleDijkstra4 = findViewById(R.id.buttonEjemploDijkstra4)

        buttonExampleFloydWarshall1 = findViewById(R.id.buttonEjemploFloydWarshall1)
        buttonExampleFloydWarshall2 = findViewById(R.id.buttonEjemploFloydWarshall2)
        buttonExampleFloydWarshall3 = findViewById(R.id.buttonEjemploFloydWarshall3)
        buttonExampleFloydWarshall4 = findViewById(R.id.buttonEjemploFloydWarshall4)



    }



}