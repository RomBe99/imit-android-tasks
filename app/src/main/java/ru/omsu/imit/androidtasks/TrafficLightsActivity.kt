package ru.omsu.imit.androidtasks

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_traffic_lights.*

private const val KEY_ACTIVITY_BG_COLOR = "ACTIVITY_BG_COLOR"

class TrafficLightsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traffic_lights)

        val redListener = {
            trafficLightsStatusTextView.text = getString(R.string.red)
            trafficLightsLayout.setBackgroundColor(getColor(R.color.red))
        }

        val yellowListener = {
            trafficLightsStatusTextView.text = getString(R.string.yellow)
            trafficLightsLayout.setBackgroundColor(getColor(R.color.yellow))
        }

        val greenListener = {
            trafficLightsStatusTextView.text = getString(R.string.green)
            trafficLightsLayout.setBackgroundColor(getColor(R.color.green))
        }

        redButton.setOnClickListener { redListener.invoke() }
        yellowButton.setOnClickListener { yellowListener.invoke() }
        greenButton.setOnClickListener { greenListener.invoke() }

        trafficLightsMenu.setOnClickListener {
            PopupMenu(this, it).apply {
                inflate(R.menu.menu_traffic_lights)

                setOnMenuItemClickListener { menuItem ->
                    when (menuItem.itemId) {
                        R.id.redTrafficLightsMenuItem -> {
                            redListener.invoke()

                            true
                        }
                        R.id.yellowTrafficLightsMenuItem -> {
                            yellowListener.invoke()

                            true
                        }
                        R.id.greenTrafficLightsMenuItem -> {
                            greenListener.invoke()

                            true
                        }

                        else -> false
                    }
                }
            }.show()
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