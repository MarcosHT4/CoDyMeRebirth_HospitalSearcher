package com.example.codymerebirth_hospitalsearcher

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codymerebirth_hospitalsearcher.databinding.ActivityMapBinding
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.*

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var mapBinding: ActivityMapBinding
    private lateinit var path: ArrayList<Int>
    var continent:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapBinding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(mapBinding.root)
        createMapFragment()

       path = intent.getIntegerArrayListExtra("listPath")!!
        continent = intent.getIntExtra("continente",0)


    }

    private fun createMapFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(p0: GoogleMap) {
        map = p0
        when(continent){
            0 -> drawPath(path, latamHospitals)
            1 -> drawPath(path, eastEuropeHospital)
            2 -> drawPath(path, westEuropeHospital)
        }

    }

    private fun addMarker(hospital: Hospital, color: Float) {
        map.addMarker(MarkerOptions().position(hospital.coordinates).title(hospital.name).icon(
            BitmapDescriptorFactory.defaultMarker(color)))
    }

    private fun boundsFromLatLngList(list : List<LatLng>): LatLngBounds {
        var x0: Double? = null
        var x1: Double? = null
        var y0: Double? = null
        var y1: Double? = null
        list.forEach {
            if (x0 == null) {
                x0 = it.latitude
                x1 = it.latitude
                y0 = it.longitude;
                y1 = it.longitude
            } else {
                if (it.latitude > x1!!) x1 = it.latitude
                if (it.latitude < x0!!) x0 = it.latitude
                if (it.longitude > y1!!) y1 = it.longitude
                if (it.longitude < y0!!) y0 = it.longitude
            }
        }
        return LatLngBounds(LatLng(x0!!, y0!!), LatLng(x1!!, y1!!))
    }


    private fun drawPath(listPath: ArrayList<Int>, hospitals: HashMap<Int,Hospital>){
        val listLatLng = ArrayList<LatLng>()

        addMarker(hospitals[listPath[0]]!!, BitmapDescriptorFactory.HUE_GREEN)

        listPath.forEachIndexed { index, i ->
            if(index != 0) {
                if(index != listPath.size-1) {
                    addMarker(hospitals[i]!!, BitmapDescriptorFactory.HUE_RED)
                }
                map.addPolyline(PolylineOptions().add(hospitals[i]!!.coordinates).add(hospitals[listPath[index-1]]!!.coordinates).color(Color.RED))
            }
        }
        addMarker(hospitals[listPath[listPath.size-1]]!!, BitmapDescriptorFactory.HUE_BLUE)
        listPath.forEach {
            listLatLng.add(hospitals[it]!!.coordinates)
        }

        val listToZoom = boundsFromLatLngList(listLatLng)
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(listToZoom.center, 3f))
    }

}