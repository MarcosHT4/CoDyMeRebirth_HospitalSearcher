package com.example.codymerebirth_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.codymerebirth_hospitalsearcher.databinding.ActivityDistanceBinding

class DistanceActivity : AppCompatActivity() {

    private lateinit var distanceBinding: ActivityDistanceBinding
    private lateinit var pruebaTextView:TextView
    private lateinit var prueba2TextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        distanceBinding = ActivityDistanceBinding.inflate(layoutInflater)
        setContentView(distanceBinding.root)

        pruebaTextView = findViewById(R.id.textView12)
        prueba2TextView = findViewById(R.id.destino)

        var startPoint = intent.getIntExtra("startPoint", 0)
        var finishPoint = intent.getIntExtra("finishPoint", 0)

        pruebaTextView.text = startPoint.toString()
        prueba2TextView.text = finishPoint.toString()


        distanceBinding.verMapaButton.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            // TODO se debe enviar una lista con los hospitales que conforman el camino
            //intent.putExtra(path: List<Hospital>)
            startActivity(intent)
        }

        //TODO aqui se llama al metodo con los datos que se reciben del anterior activity y el algoritmo seleccionado
        //upgradePath()
    }


    fun upgradePath(origen: Hospital, destino: Hospital, distancia: Int){
        distanceBinding.origen.text = origen.name
        distanceBinding.destino.text = destino.name
        distanceBinding.distanciaMinima.text = distancia.toString()
    }
}