package ro.pub.cs.systems.eim.Coloviu1_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ro.pub.cs.systems.eim.Coloviu1_1.ui.theme.Colocviu1_1Theme
import ro.pub.cs.systems.eim.Coloviu1_1.Constants

class Colocviu1_1MainActivity : ComponentActivity() {

    private lateinit var northButton: Button
    private lateinit var eastButton: Button
    private lateinit var westButton: Button
    private lateinit var southButton: Button
    private lateinit var textView: TextView
    private lateinit var numPressesTextView: TextView
    private lateinit var secondaryActivityButton: Button

    var text = "North, East, West, South"
    var numPressesText = "Number of Presses: "
    var numPresses = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviu1_1_main)

        northButton = findViewById<Button>(R.id.northButton)
        eastButton = findViewById<Button>(R.id.eastButton)
        westButton = findViewById<Button>(R.id.westButton)
        southButton = findViewById<Button>(R.id.southButton)
        secondaryActivityButton = findViewById<Button>(R.id.secondaryActivityButton)
        textView = findViewById<TextView>(R.id.textView)
        numPressesTextView = findViewById<TextView>(R.id.numPresses)

        numPressesTextView.setText("Number of Presses: 0")

        northButton.setOnClickListener {
            numPresses++
            text = text + ", North"
            textView.text = text

            numPressesTextView.text = numPressesText + numPresses.toString()
        }
        eastButton.setOnClickListener {
            numPresses++
            text = text + ", East"
            textView.text = text

            numPressesTextView.text = numPressesText + numPresses.toString()
        }
        westButton.setOnClickListener {
            numPresses++
            text = text + ", West"
            textView.text = text

            numPressesTextView.text = numPressesText + numPresses.toString()
        }
        southButton.setOnClickListener {
            numPresses++
            text = text + ", South"
            textView.text = text

            numPressesTextView.text = numPressesText + numPresses.toString()
        }

        val secondaryActivityLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "The activity returned with result Registered", Toast.LENGTH_LONG).show()
            } else if (result.resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "The activity returned with result Canceled", Toast.LENGTH_LONG).show()
            }
        }

        secondaryActivityButton.setOnClickListener {
                val intent = Intent(this, Colocviu1_1SecondaryActivity::class.java)
                intent.putExtra(Constants.NUM_PRESSES, numPresses)
                secondaryActivityLauncher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(Constants.NUM_PRESSES, numPressesTextView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.containsKey(Constants.NUM_PRESSES)) {
            numPressesTextView.setText(savedInstanceState.getString(Constants.NUM_PRESSES))
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Colocviu1_1Theme {
        Greeting("Android")
    }
}