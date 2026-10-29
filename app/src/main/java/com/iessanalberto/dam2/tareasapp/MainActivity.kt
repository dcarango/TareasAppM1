package com.iessanalberto.dam2.tareasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.iessanalberto.dam2.tareasapp.navigation.AppNavigation
import com.iessanalberto.dam2.tareasapp.ui.theme.TareasAppTheme

/**
 * Este es el que realmente se ejecuta, solo llama el AppNavigation
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TareasAppTheme {
                AppNavigation()
            }
        }
    }
}


