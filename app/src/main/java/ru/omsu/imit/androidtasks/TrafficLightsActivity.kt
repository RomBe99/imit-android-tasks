package ru.omsu.imit.androidtasks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_traffic_lights.*

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
    }
}