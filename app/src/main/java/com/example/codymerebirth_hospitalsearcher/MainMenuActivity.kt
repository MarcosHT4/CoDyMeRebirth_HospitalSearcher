package com.example.codymerebirth_hospitalsearcher

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainMenuActivity : AppCompatActivity() {

    var buttonMinimumDistance: Button? = null
    var buttonTutorial: Button? = null
    var buttonExamples: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        init()

        buttonMinimumDistance?.setOnClickListener{

            val intent = Intent(this, SelectAlgorithmActivity::class.java)
            startActivity(intent)

        }

        buttonTutorial?.setOnClickListener{

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=kS5mMg2uyHA"))
            startActivity(intent)


        }

        buttonExamples?.setOnClickListener{

            val intent = Intent(this, ExampleSelectionActivity::class.java)
            startActivity(intent)


        }

    }

    fun init(){

        buttonMinimumDistance = findViewById(R.id.buttonDistanciaMinimaMenu)
        buttonTutorial = findViewById(R.id.buttonTutorialMenu)
        buttonExamples = findViewById(R.id.buttonEjemplosMenu)


    }
}