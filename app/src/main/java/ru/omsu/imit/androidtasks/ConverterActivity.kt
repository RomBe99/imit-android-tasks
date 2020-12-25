package ru.omsu.imit.androidtasks

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_converter.*

class ConverterActivity : AppCompatActivity() {
    private val converters = mutableMapOf<Int, (Double) -> Double>(
        R.id.meterRadioButton to { d -> d * 7.6 },
        R.id.parrotRadioButton to { d -> d / 7.6 }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)
    }

    fun convert(view: View) {
        if (enteredText.text.isEmpty()) {
            Toast.makeText(applicationContext, R.string.empty_value, Toast.LENGTH_LONG).show()

            return
        }

        val enteredValue = enteredText.text.toString().toDouble()
        val convertedValue = converters[radioGroup.checkedRadioButtonId]?.invoke(enteredValue)
        enteredText.setText(convertedValue.toString())
    }
}