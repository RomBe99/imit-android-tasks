package ru.omsu.imit.androidtasks

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_traffic_lights.*

private const val KEY_ACTIVITY_BG_COLOR = "ACTIVITY_BG_COLOR"

class TrafficLightsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traffic_lights)

        redButton.setOnClickListener {
            trafficLightsStatusTextView.text = getString(R.string.red)
            trafficLightsLayout.setBackgroundColor(getColor(R.color.red))
        }

        yellowButton.setOnClickListener {
            trafficLightsStatusTextView.text = getString(R.string.yellow)
            trafficLightsLayout.setBackgroundColor(getColor(R.color.yellow))
        }

        greenButton.setOnClickListener {
            trafficLightsStatusTextView.text = getString(R.string.green)
            trafficLightsLayout.setBackgroundColor(getColor(R.color.green))
        }

        enteredNameTextView.text = intent.extras?.getString(SECRET_kEY_FOR_NAME) ?: ""

        if (savedInstanceState != null) {
            trafficLightsLayout.setBackgroundColor(savedInstanceState.getInt(KEY_ACTIVITY_BG_COLOR))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_ACTIVITY_BG_COLOR, (trafficLightsLayout.background as ColorDrawable).color)
    }
}