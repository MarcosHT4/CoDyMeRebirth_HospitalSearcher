package com.example.codymerebirth_hospitalsearcher

import com.google.android.gms.maps.model.LatLng

data class Hospital (val name: String, val coordinates: LatLng, val neighbors: List<Hospital>?)