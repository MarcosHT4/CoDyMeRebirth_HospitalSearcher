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
    val hospitalNumber:HashMap<String, Int> = HashMap();
    var startPointName:String? = null
    var finishPointName:String? = null
    var startPoint:Int? = null
    var finishPoint:Int? = null

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

            hospitalNumber.put("Sucre", 0)
            hospitalNumber.put("Asuncion", 1)
            hospitalNumber.put("Montevideo", 2)
            hospitalNumber.put("Brasilia", 3)
            hospitalNumber.put("Buenos Aires", 4)
            hospitalNumber.put("Santiago", 5)
            hospitalNumber.put("Lima", 6)
            hospitalNumber.put("Quito", 7)
            hospitalNumber.put("Bogota", 8)
            hospitalNumber.put("Caracas", 9)
            hospitalNumber.put("Georgetown", 10)
            hospitalNumber.put("Paramaribo", 11)
            hospitalNumber.put("Cayena", 12)



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

            hospitalNumber.put("Moscu", 0)
            hospitalNumber.put("Helsinki", 1)
            hospitalNumber.put("Oslo", 2)
            hospitalNumber.put("Estocolmo", 3)
            hospitalNumber.put("Minsk", 4)
            hospitalNumber.put("Varsovia", 5)
            hospitalNumber.put("Berlin", 6)
            hospitalNumber.put("Praga", 7)
            hospitalNumber.put("Bratislava", 8)
            hospitalNumber.put("Kiev", 9)
            hospitalNumber.put("Budapest", 10)
            hospitalNumber.put("Tiflis", 11)
            hospitalNumber.put("Chisinau", 12)
            hospitalNumber.put("Atenas", 13)
            hospitalNumber.put("Erevan", 14)
            hospitalNumber.put("Ankara", 15)



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

            hospitalNumber.put("Lisboa", 0)
            hospitalNumber.put("Madrid", 1)
            hospitalNumber.put("Paris", 2)
            hospitalNumber.put("Berna", 3)
            hospitalNumber.put("Viena", 4)
            hospitalNumber.put("Bruselas", 5)
            hospitalNumber.put("Amsterdam", 6)
            hospitalNumber.put("Roma", 7)
            hospitalNumber.put("Luxemburgo", 8)
            hospitalNumber.put("Andorra La Vella", 9)
            hospitalNumber.put("Londres", 10)
            hospitalNumber.put("Dublin", 11)


        }

        startPointName = spinnerStartPoint?.selectedItem.toString()
        finishPointName = spinnerFinishPoint?.selectedItem.toString()

        startPoint = hospitalNumber.get(startPointName)
        finishPoint = hospitalNumber.get(finishPointName)

        buttonMinDistance?.setOnClickListener{
            val intent = Intent(this, DistanceActivity::class.java)
            intent.putExtra("isDijkstra", isDijkstra)
            intent.putExtra("continent", continent)
            intent.putExtra("startPoint", startPoint)
            intent.putExtra("finishPoint", finishPoint)
            startActivity(intent)
        }













    }
    fun init(){
        spinnerStartPoint = findViewById(R.id.spinnerStartPoint)
        spinnerFinishPoint = findViewById(R.id.spinnerFinishPoint)
        buttonMinDistance = findViewById(R.id.buttonStartMinDistance)
    }
}


