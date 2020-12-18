package ru.omsu.imit.androidtasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var crowCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mysteryCatImageButton.setOnClickListener {
            greetingTextView.text = getString(R.string.cat_greeting).format("stranger")
        }

        crowCountButton.setOnClickListener {
            crowCountTextView.text = getString(R.string.crow_count_format_str).format(++crowCount)
        }
    }
}