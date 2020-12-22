package ru.omsu.imit.androidtasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
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
            name = with(enterNameEditText.text) { if (isEmpty()) "stranger" else toString() }

            greetingTextView.text = getString(R.string.cat_greeting).format(name)
        }

        crowCountButton.setOnClickListener {
            crowCountTextView.text = getString(R.string.crow_count_format_str).format(++crowCount)
        }

        if (savedInstanceState != null) {
            crowCount = savedInstanceState.getInt(KEY_CROW_COUNT)
            crowCountTextView.text = getString(R.string.crow_count_format_str).format(crowCount)
        }

        val toastImg = ImageView(this).apply {
            setImageResource(R.drawable.toast_cat)
        }

//  Create toast in program (Use custom toasts considered bad practice)

        if (savedInstanceState == null) {
            Toast.makeText(applicationContext, R.string.app_greeting, Toast.LENGTH_LONG).apply {
                setGravity(Gravity.CENTER, 0, 0)
                (view as LinearLayout).addView(toastImg, 0)
            }.show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_CROW_COUNT, crowCount)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_the_passenger -> {
                val intent = Intent(this, AboutPassengerActivity::class.java)

                startActivity(intent)

                return true
            }
            R.id.action_to_traffic_lights -> {
                val intent = Intent(this, TrafficLightsActivity::class.java).apply {
                    if (name.isNotEmpty()) {
                        putExtra(SECRET_kEY_FOR_NAME, name)
                    }
                }

                startActivity(intent)

                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}