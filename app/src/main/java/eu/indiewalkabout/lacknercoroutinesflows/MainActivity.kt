package eu.indiewalkabout.lacknercoroutinesflows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import eu.indiewalkabout.lacknercoroutinesflows.ui.theme.LacknerCoroutinesFlowsTheme
import eu.indiewalkabout.lacknercoroutinesflows.useReduce
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        GlobalScope.launch {
            repeat(100) {
                delay(1000L)
                println("Coroutine 1")
            }
        }



        useMakePrinter("INFO","All systems go")

        setContent {
            LacknerCoroutinesFlowsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Use lambda " + useMakePrinter_02("INFO", "All systems go"),
            modifier = modifier
        )

        Text(
            text = "Use map " + useMap(listOf(1,2,3,4,5), {it * 3 / 4}),
            modifier = modifier
        )

        Text(
            // NB: acc is list[0], to start from acc = 0 use useFold, or map and reduce
            text = "Use reduce " + useReduce(listOf(0,1,2,3,4,5), {acc,it -> acc + it*2+3}),
            modifier = modifier
        )

        Text(
            text = "Use map and reduce, start with acc = 0  " + useMapReduce(listOf(1,2,3,4,5),{it*2+3}, {acc,it -> acc + it}),
            modifier = modifier
        )

        Text(
            text = "Use fold (like using map and reduce starting with acc = 0)" + useMapReduce(listOf(1,2,3,4,5),{it*2+3}, {acc,it -> acc + it}),
            modifier = modifier
        )

        Text(
            text = "Use map and reduce " + useMapReduce(listOf(1,2,3,4,5),{it%2}, {acc,it -> acc + it+1}),
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LacknerCoroutinesFlowsTheme {
        Greeting("Android")
    }
}