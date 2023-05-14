package com.example.telas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.telas.ui.theme.TelasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "tela1"){
                        composable("tela1"){Tela1(navController)}
                        composable("Tela2"){Tela2(navController)}
                        composable("Tela3"){Tela3(navController)}
                    }
                }
            }
        }
    }
}

@Composable
fun Tela1(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tela 1", style = TextStyle(fontSize = 24.sp))
        Button(onClick = { navController.navigate("tela2") }) {
            Text(text = "Ir para a tela 2")
        }
        Text(text = "Tela 3", style = TextStyle(fontSize = 24.sp))
        Button(onClick = { navController.navigate("tela3") }) {
            Text(text = "Ir para a tela 3")
        }
    }
}

@Composable
fun Tela2(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tela 2", style = TextStyle(fontSize = 24.sp))
        Button(onClick = {navController.navigate("tela1")}) {
            Text(text = "Voltar para a tela 1")
        }
    }
}

@Composable
fun Tela3(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tela 3", style = TextStyle(fontSize = 24.sp))
        Button(onClick = {navController.navigate("tela1")}) {
            Text(text = "Voltar para a tela 1")
        }
    }
}