package app.bidar.testlambda

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import app.bidar.testlambda.ui.theme.TestLambdaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestLambdaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun App() {
    val mContext = LocalContext.current

    Column() {
        Button(
            onClick = {
                //mToast(mContext, Converter(5, 1) { i, i2 -> i + i2 })

                //var rez = formol(1 , 5)
                mToast(mContext, Converter2(5, 1, formol(1 , 5)) )

            }
        ) {
            Text(text = "Button")
        }
    }
}

private fun mToast(context: Context , int: Int){
    Toast.makeText(context, "This is a Sample Toast: $int", Toast.LENGTH_LONG).show()
}


fun Converter (
    int1: Int,
    int2: Int,
    formola: (Int, Int) -> Int
): Int {
    return formola(int1, int2)
}


fun Converter2(
    int1: Int,
    int2: Int,
    fm: formol
): Int {
    return 1
}

class formol (
    var i: Int,
    var i2: Int
    ) {
    val out = i + i2
}


/*

fun main() {
    val coins: (Double) -> Double = { input ->
        (1.8 * input) + 32
    }
    //cel to far
    printFinalTemperature(27.0, "Cel", "fah") {(1.8 * it) + 32}
    printFinalTemperature(135.0, "Cel", "fah") { it - 273.15 }
    printFinalTemperature(10.0, "Cel", "fah") { 5.0 / 9.0 * (it - 32) + 273.15 }
}
fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
*/
