package com.example.codymerebirth_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class PathSelectionActivity : AppCompatActivity() {
    var spinnerStartPoint:Spinner? = null
    var spinnerFinishPoint:Spinner? = null
    var buttonMinDistance:Button? = null
    var isDijkstra:Boolean? = null
    var continent:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_path_selection)
        init()
        isDijkstra = intent.getBooleanExtra("isDijkstra",false)
        continent = intent.getIntExtra("continent", 0)
        if (continent == 0){
            ArrayAdapter.createFromResource(
                this,
                R.array.southAmerica,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerStartPoint?.adapter = adapter
            }
            ArrayAdapter.createFromResource(
                this,
                R.array.southAmerica,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerFinishPoint?.adapter = adapter
            }
        }else if(continent == 1){
            ArrayAdapter.createFromResource(
                this,
                R.array.eastEurope,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerStartPoint?.adapter = adapter
            }
            ArrayAdapter.createFromResource(
                this,
                R.array.eastEurope,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerFinishPoint?.adapter = adapter
            }
        }else if(continent == 2){
            ArrayAdapter.createFromResource(
                this,
                R.array.westEurope,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerStartPoint?.adapter = adapter
            }
            ArrayAdapter.createFromResource(
                this,
                R.array.westEurope,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerFinishPoint?.adapter = adapter
            }
        }
        buttonMinDistance?.setOnClickListener{
            val intent = Intent(this, DistanceActivity::class.java)
            startActivity(intent)
        }
    }
    fun init(){
        spinnerStartPoint = findViewById(R.id.spinnerStartPoint)
        spinnerFinishPoint = findViewById(R.id.spinnerFinishPoint)
        buttonMinDistance = findViewById(R.id.buttonStartMinDistance)
    }
}


