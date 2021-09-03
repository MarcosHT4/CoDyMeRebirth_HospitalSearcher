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
    val h1 = Hospital("Hospital GG EZ", LatLng(-16.50703525, -68.1186046495648), null)
    val h2 = Hospital("Hospital GG NO TEAM", LatLng(-15.50703525, -67.1186046495648), null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapBinding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(mapBinding.root)
        createMapFragment()

    }

    private fun createMapFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        map = p0

        addMarker(h1)
        addMarker(h2)
        lineBetweenTwoHospitals(h1, h2)
    }

    private fun addMarker(hospital: Hospital) {
        map.addMarker(MarkerOptions().position(hospital.coordinates).title(hospital.name))
    }

    private fun lineBetweenTwoHospitals(hospital1: Hospital, hospital2: Hospital){
        map.addPolyline(PolylineOptions().add(hospital1.coordinates).add(hospital2.coordinates).color(Color.RED))
    }

}