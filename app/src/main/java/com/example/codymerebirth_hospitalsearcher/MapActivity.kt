package com.example.codymerebirth_hospitalsearcher

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codymerebirth_hospitalsearcher.databinding.ActivityMapBinding
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var mapBinding: ActivityMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapBinding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(mapBinding.root)
        //createMapFragment()

    }



    private fun createMapFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }






    override fun onMapReady(p0: GoogleMap) {
        map = p0

    }




    private fun addMarker(hospital: Hospital) {
        map.addMarker(MarkerOptions().position(hospital.coordinates).title(hospital.name))
    }





/*
    private fun lineBetweenHospitals(hospital1: Hospital){
        addMarker(h1)
        hospital1.neighbors?.forEach {
            addMarker(it)
            map.addPolyline(PolylineOptions().add(hospital1.coordinates).add(it.coordinates).color(Color.RED))
        }
    }

    */


}

/*
val neighbors: List<Hospital> = listOf(
    Hospital("Clinic", ,LatLng(-15.50703525, -67.1186046495648)),
    Hospital("Hospital General", ,LatLng(-14.50703525, -67.3006046495648)),
    Hospital("Hospital ArcoIris", ,LatLng(-15.50703525, -66.1186046495648)),
    Hospital("Hospital AntiVac", ,LatLng(10.50703525, 66.1186046495648)),
)

val h1 = Hospital("Hospital GG EZ", ,LatLng(-16.50703525, -68.1186046495648), neighbors)
*/