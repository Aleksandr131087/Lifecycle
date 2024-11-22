package com.example.lifecycle

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lifecycle.R.id.toolbarMain

class MainActivity : AppCompatActivity() {

    private lateinit var toolbarMain: androidx.appcompat.widget.Toolbar
private lateinit var heightInput: EditText
private lateinit var weightInput: EditText
private lateinit var buttonTransfer: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "«Индекс массы тела»"
        toolbarMain.setLogo(R.drawable.new_48)

        heightInput = findViewById(R.id.heightInput)
        weightInput = findViewById(R.id.weighttInput)
        buttonTransfer = findViewById(R.id.buttonTransfer)

        buttonTransfer.setOnClickListener{
            val weight = weightInput.text.toString().toDoubleOrNull()
            val height = heightInput.text.toString().toDoubleOrNull()
            if (weight!= null && height!= null){
                val intent = Intent(this, Activity2::class.java)
                intent.putExtra("weight", weight)
                intent.putExtra("height", height)
                startActivity(intent)
            }

        }



    }



}