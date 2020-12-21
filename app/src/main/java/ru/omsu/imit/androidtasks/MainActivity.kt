package ru.omsu.imit.androidtasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

const val SECRET_kEY_FOR_NAME = "ru.omsu.imit.androidtasks.SECRET_kEY"

private const val KEY_CROW_COUNT = "CROW_COUNT"

class MainActivity : AppCompatActivity() {
    private var crowCount = 0
    private var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mysteryCatImageButton.setOnClickListener {
            name = if (enterNameEditText.text.isEmpty()) "stranger" else enterNameEditText.text.toString()

            greetingTextView.text = getString(R.string.cat_greeting).format(name)
        }

        crowCountButton.setOnClickListener {
            crowCountTextView.text = getString(R.string.crow_count_format_str).format(++crowCount)
        }

        toTrafficLightsButton.setOnClickListener {
            val intent = Intent(this, TrafficLightsActivity::class.java)

            if (name.isNotEmpty()) {
                intent.putExtra(SECRET_kEY_FOR_NAME, name)
            }

            startActivity(intent)
        }

        thePassengerButton.setOnClickListener {
            val intent = Intent(this, AboutPassengerActivity::class.java)

            startActivity(intent)
        }

        if (savedInstanceState != null) {
            crowCount = savedInstanceState.getInt(KEY_CROW_COUNT)
            crowCountTextView.text = getString(R.string.crow_count_format_str).format(crowCount)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_CROW_COUNT, crowCount)
    }
}