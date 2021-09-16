package com.pro.codymerebirth_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.pro.codymerebirth_hospitalsearcher.R

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


        }else if(continent == 3){
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploUnoDijkstra,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerStartPoint?.adapter = adapter
            }
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploUnoDijkstra,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerFinishPoint?.adapter = adapter
            }

            hospitalNumber.put("Palestina", 0)
            hospitalNumber.put("Imperio Romano", 1)
            hospitalNumber.put("Rodesia", 2)
            hospitalNumber.put("Zanzibar", 3)
            hospitalNumber.put("Vietnam del Sur", 4)


        }else if(continent == 4){
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploDosDijkstra,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerStartPoint?.adapter = adapter
            }
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploDosDijkstra,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerFinishPoint?.adapter = adapter
            }

            hospitalNumber.put("Imperio Thalia", 0)
            hospitalNumber.put("Dinastia Koteron", 1)
            hospitalNumber.put("Imperio Tribbitus", 2)
            hospitalNumber.put("Dinastia Criten", 3)
            hospitalNumber.put("Dinastia Teonem", 4)


        }else if(continent == 5){
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploTresDijkstra,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerStartPoint?.adapter = adapter
            }
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploTresDijkstra,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerFinishPoint?.adapter = adapter
            }

            hospitalNumber.put("Rodemy", 0)
            hospitalNumber.put("Atlantis", 1)
            hospitalNumber.put("Ciudadela Olimpica", 2)
            hospitalNumber.put("Ciudad Griega", 3)
            hospitalNumber.put("Crisa", 4)


        }else if(continent == 6){
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploCuatroDijkstra,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerStartPoint?.adapter = adapter
            }
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploCuatroDijkstra,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerFinishPoint?.adapter = adapter
            }

            hospitalNumber.put("Groenlandia", 0)
            hospitalNumber.put("Hielolandia", 1)
            hospitalNumber.put("Area 51", 2)
            hospitalNumber.put("Illuminatilandia", 3)
            hospitalNumber.put("Curasao", 4)


        }else if(continent == 7){
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploUnoFloydWarshall,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerStartPoint?.adapter = adapter
            }
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploUnoFloydWarshall,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerFinishPoint?.adapter = adapter
            }

            hospitalNumber.put("Union Sovietica", 0)
            hospitalNumber.put("Corea del Norte", 1)
            hospitalNumber.put("Pemba", 2)
            hospitalNumber.put("Mozambique", 3)
            hospitalNumber.put("Darfur", 4)


        }else if(continent == 8){
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploDosFloydWarshall,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerStartPoint?.adapter = adapter
            }
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploDosFloydWarshall,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerFinishPoint?.adapter = adapter
            }

            hospitalNumber.put("Irania", 0)
            hospitalNumber.put("Lotus", 1)
            hospitalNumber.put("Ugevaria", 2)
            hospitalNumber.put("Dinada", 3)
            hospitalNumber.put("Atoseo", 4)


        }else if(continent == 9){
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploTresFloydWarshall,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerStartPoint?.adapter = adapter
            }
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploTresFloydWarshall,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerFinishPoint?.adapter = adapter
            }

            hospitalNumber.put("Slug Giant", 0)
            hospitalNumber.put("Slug Flyer", 1)
            hospitalNumber.put("Lemor", 2)
            hospitalNumber.put("Servil", 3)
            hospitalNumber.put("Atrolug", 4)


        }else if(continent == 10){
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploCuatroFloydWarshall,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerStartPoint?.adapter = adapter
            }
            ArrayAdapter.createFromResource(
                this,
                R.array.ejemploCuatroFloydWarshall,
                android.R.layout.simple_spinner_dropdown_item
            ).also {adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerFinishPoint?.adapter = adapter
            }

            hospitalNumber.put("Triangulo de las Bermudas", 0)
            hospitalNumber.put("Uganda", 1)
            hospitalNumber.put("Egipto", 2)
            hospitalNumber.put("Suiza", 3)
            hospitalNumber.put("Bolivia", 4)


        }




        buttonMinDistance?.setOnClickListener{

            startPointName = spinnerStartPoint?.selectedItem.toString()
            finishPointName = spinnerFinishPoint?.selectedItem.toString()

            startPoint = hospitalNumber[startPointName]
            finishPoint = hospitalNumber[finishPointName]

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


