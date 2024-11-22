package com.example.lifecycle

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {

    private lateinit var indexResult: TextView
    private lateinit var resultText: TextView
    private lateinit var imageView: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        indexResult = findViewById(R.id.IndexResult)
        imageView = findViewById(R.id.ImageView)
resultText = findViewById(R.id.ResultText)

    val weight = intent.getDoubleExtra("weight", 0.0)
    val height = intent.getDoubleExtra("height", 0.0)

    val indexResult2 = calculateindexResult(weight, height)
        indexResult.text = String.format("Ваш индекс массы тела: %.2f", indexResult2)

        when {
            indexResult2 as Double in 0.0..< 18.5 -> {
                imageView.setImageResource(R.drawable.thin_man)
                resultText.text = String.format("Ваш индекс массы тела: %.2f\n" , indexResult2)
                indexResult.text = "Рекомендуется увеличить потребление калорий и заниматься силовыми тренировками. (Нормальный индекс тела расположен в пределах от 18,5 до 24,9)."
            }

            indexResult2 in 18.5..24.9 -> {
                imageView.setImageResource(R.drawable.norm_man)
                resultText.text = String.format("Ваш индекс массы тела: %.2f\n", indexResult2)
                indexResult.text = "Вы в норме! Продолжайте вести здоровый образ жизни."
            }

            else -> {
                imageView.setImageResource(R.drawable.fat_man)
                resultText.text = String.format("Ваш индекс массы тела: %.2f\n", indexResult2)
                indexResult.text =
                    "Рекомендуется следить за питанием и заниматься физической активностью. (Нормальный индекс тела расположен в пределах от 18,5 до 24,9)."
            }
        }
    }

    private fun calculateindexResult(weight: Double, height: Double): Any {
        return weight / (height * height)
    }
}

