package ro.pub.cs.systems.eim.Coloviu1_1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class Colocviu1_1SecondaryActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviu1_1_secondary)

        val textViewSecondary = findViewById<TextView>(R.id.textViewSecondary)
        val numPresses = intent.getIntExtra(Constants.NUM_PRESSES, 0)

        textViewSecondary.text = numPresses.toString()

        val registerButton = findViewById<Button>(R.id.registerButton)
        registerButton.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        val cancelButton = findViewById<Button>(R.id.cancelButton)
        cancelButton.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}