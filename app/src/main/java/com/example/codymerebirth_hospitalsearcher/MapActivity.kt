package com.example.codymerebirth_hospitalsearcher

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codymerebirth_hospitalsearcher.databinding.ActivityMapBinding
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var mapBinding: ActivityMapBinding
    private lateinit var path: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapBinding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(mapBinding.root)
        createMapFragment()

       path = intent.getIntegerArrayListExtra("listPath")!!


    }



    private fun createMapFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }






    override fun onMapReady(p0: GoogleMap) {
        map = p0
        drawPath(path)
    }




    private fun addMarker(hospital: Hospital, color: Float) {
        map.addMarker(MarkerOptions().position(hospital.coordinates).title(hospital.name).icon(
            BitmapDescriptorFactory.defaultMarker(color)))
    }

    private fun drawPath(listPath: ArrayList<Int>){
        addMarker(latamHospitals[listPath[0]]!!, BitmapDescriptorFactory.HUE_GREEN)
        listPath.forEachIndexed { index, i ->
            if(index != 0) {
                if(index != listPath.size-1) {
                    addMarker(latamHospitals[i]!!, BitmapDescriptorFactory.HUE_RED)
                }
                map.addPolyline(PolylineOptions().add(latamHospitals[i]!!.coordinates).add(latamHospitals[listPath[index-1]]!!.coordinates).color(Color.RED))
            }
        }
        addMarker(latamHospitals[listPath[listPath.size-1]]!!, BitmapDescriptorFactory.HUE_BLUE)
    }

}