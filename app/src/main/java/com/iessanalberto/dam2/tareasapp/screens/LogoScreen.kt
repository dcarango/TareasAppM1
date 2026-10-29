package com.iessanalberto.dam2.tareasapp.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.iessanalberto.dam2.tareasapp.R
import com.iessanalberto.dam2.tareasapp.navigation.AppScreens


@Composable
fun LogoScreen (navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter =  painterResource(R.drawable.ottoniel),
            contentDescription = "El baboso de mi gato"
        )
        Button(
            onClick = { navController.navigate(route = AppScreens.TareasScreen.route) }
        ) {
            Text( text = "Tareas")
        }
    }
}