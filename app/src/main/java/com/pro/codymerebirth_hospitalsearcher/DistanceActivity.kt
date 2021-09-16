package com.pro.codymerebirth_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import com.pro.codymerebirth_hospitalsearcher.databinding.ActivityDistanceBinding
import com.google.android.gms.maps.model.LatLng
import java.util.ArrayList

class DistanceActivity : AppCompatActivity() {

    private lateinit var distanceBinding: ActivityDistanceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        distanceBinding = ActivityDistanceBinding.inflate(layoutInflater)
        setContentView(distanceBinding.root)

        val continente = intent.getIntExtra("continent", 0)
        val startPoint = intent.getIntExtra("startPoint", 0)
        val finishPoint = intent.getIntExtra("finishPoint", 0)
        val isDijkstra = intent.getBooleanExtra("isDijkstra", true)
        var listPath: ArrayList<Int>? = null
        var totalDistance:Int = 0


        distanceBinding.verMapaButton.setOnClickListener {
            if(totalDistance == 0) {
                Toast.makeText(this, "Ya estas en el destino LA...", Toast.LENGTH_LONG).show()
            }else if(totalDistance in 1..99999){
                val intent = Intent(this, MapActivity::class.java)
                intent.putIntegerArrayListExtra("listPath", listPath)
                intent.putExtra("continente", continente)
                startActivity(intent)
            }else{
                Toast.makeText(this, "No hay camino LA...", Toast.LENGTH_LONG).show()
            }
        }

        createDistances(continente)

        if(isDijkstra) {

            val dijskstra: Dijkstra = Dijkstra(grafoFloydWarshall, false, false)
            dijskstra.dijkstra(startPoint)
            totalDistance = dijskstra.minDistance(finishPoint)
            listPath = dijskstra.path(finishPoint)

        } else {
            when(continente){

                0->totalDistance =
                    FloydWarshall.doCalcs(grafoFloydWarshall, 19, startPoint, finishPoint)
                1->totalDistance =
                    FloydWarshall.doCalcs(grafoFloydWarshall, 16, startPoint, finishPoint)
                2->totalDistance =
                    FloydWarshall.doCalcs(grafoFloydWarshall, 12, startPoint, finishPoint)
                else -> {

                    totalDistance =
                        FloydWarshall.doCalcs(grafoFloydWarshall, 5, startPoint, finishPoint)

                }
            }

            listPath = FloydWarshall.printResult(startPoint, finishPoint)
        }
        if(startPoint == finishPoint){
            totalDistance = 0
        }

        when (continente) {
            0-> upgradePath(latamHospitals[startPoint]!!, latamHospitals[finishPoint]!!, totalDistance)
            1-> upgradePath(eastEuropeHospital[startPoint]!!, eastEuropeHospital[finishPoint]!!, totalDistance)
            2-> upgradePath(westEuropeHospital[startPoint]!!, westEuropeHospital[finishPoint]!!, totalDistance)
            3-> upgradePath(exampleHospital1Dijkstra[startPoint]!!, exampleHospital1Dijkstra[finishPoint]!!, totalDistance)
            4-> upgradePath(exampleHospital2Dijkstra[startPoint]!!, exampleHospital2Dijkstra[finishPoint]!!, totalDistance)
            5-> upgradePath(exampleHospital3Dijkstra[startPoint]!!, exampleHospital3Dijkstra[finishPoint]!!, totalDistance)
            6-> upgradePath(exampleHospital4Dijkstra[startPoint]!!, exampleHospital4Dijkstra[finishPoint]!!, totalDistance)
            7-> upgradePath(exampleHospital1FloydWarshall[startPoint]!!, exampleHospital1FloydWarshall[finishPoint]!!, totalDistance)
            8-> upgradePath(exampleHospital2FloydWarshall[startPoint]!!, exampleHospital2FloydWarshall[finishPoint]!!, totalDistance)
            9-> upgradePath(exampleHospital3FloydWarshall[startPoint]!!, exampleHospital3FloydWarshall[finishPoint]!!, totalDistance)
            10-> upgradePath(exampleHospital4FloydWarshall[startPoint]!!, exampleHospital4FloydWarshall[finishPoint]!!, totalDistance)
        }


    }


    fun upgradePath(origen: Hospital, destino: Hospital, distancia: Int){
        distanceBinding.origen.text = origen.name
        distanceBinding.destino.text = destino.name
        if(distancia < 100000) {
            distanceBinding.distanciaMinima.text = distancia.toString()
        }else{
            distanceBinding.distanciaMinima.text = "No hay camino disponible"
        }

    }
    fun createDistances(continente: Int){
        when(continente){
            0 -> {
             addEdge(9, 8, 1400)
             addEdge(8,7,1103)
             addEdge(7, 6, 1802)
             addEdge(6, 0, 2033)
             addEdge(0, 1, 1427)
             addEdge(1, 2, 1344)
             addEdge(6, 5, 3286)
             addEdge(5, 4, 1407)
             addEdge(4, 2, 593)
             addEdge(2, 3, 2903)
             addEdge(3, 10, 2755)
             addEdge(10, 11, 444)
             addEdge(11, 12, 336)
            } 1 -> {
            addEdge(0,1,1090)
            addEdge(1,2,978)
            addEdge(1,3,484)
            addEdge(3,4,959)
            addEdge(4,5,550)
            addEdge(5,6,572)
            addEdge(5,7,688)
            addEdge(5,8,662)
            addEdge(4,9,526)
            addEdge(9,10,1847)
            addEdge(9,12,472)
            addEdge(9,11,1848)
            addEdge(10,13,1469)
            addEdge(10,11,2964)
            addEdge(11,12,1854)
            addEdge(11,14,276)
            addEdge(14,15,1398)
        } 2 -> {
            addEdge(11, 10, 464)
            addEdge(0,1, 623)
            addEdge(1,9, 609)
            addEdge(1,2, 1271)
            addEdge(2, 7, 1420)
            addEdge(2, 3, 582)
            addEdge(3,4,  839)
            addEdge(2, 8, 373)
            addEdge(2, 5, 313)
            addEdge(5, 6, 210)
        } 3 -> {

            addEdge(0,1,600)
            addEdge(0,2,432)
            addEdge(2,4,20)
            addEdge(0,3,103)

        } 4 -> {

            addEdge(0,1,60)
            addEdge(1,2,490)
            addEdge(0,3,620)
            addEdge(3,4,3002)
        } 5 -> {

            addEdge(0,1,21)
            addEdge(1,2,45)
            addEdge(0,3,275)
            addEdge(3,4,534)

        } 6 ->{

            addEdge(0,2,5691)
            addEdge(0,4,7855)
            addEdge(2, 3, 3373)
            addEdge(3, 1, 4528)
            addEdge(1, 4, 6816)


        }7 -> {

            addEdge(0,1,700)
            addEdge(1,2,50)
            addEdge(1,3,150)
            addEdge(1,4,300)

        } 8 -> {

            addEdge(0,1,10)
            addEdge(1,3,75)
            addEdge(3,4,242)
            addEdge(1,2,501)


        } 9 -> {

            addEdge(0,1,563)
            addEdge(1,2,248)
            addEdge(1,4,875)
            addEdge(2,3,654)

        } 10 -> {

            addEdge(2, 3, 2793)
            addEdge(2, 1, 2893)
            addEdge(1, 0, 11290)
            addEdge(1, 4, 11181)
            addEdge(0, 4, 4632)

        }
        }
    }


    fun addEdge(origen: Int, destino: Int, distancia: Int){
        grafoFloydWarshall[origen][destino] = distancia
        grafoFloydWarshall[destino][origen] = distancia
    }
}






val grafoFloydWarshall = Array(20){ IntArray(20) { 0 } }