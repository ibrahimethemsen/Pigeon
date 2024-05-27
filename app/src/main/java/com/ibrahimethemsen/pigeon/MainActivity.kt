package com.ibrahimethemsen.pigeon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.ibrahimethemsen.pigeon.home.HomeRoute
import com.ibrahimethemsen.pigeon.home.HomeScreen
import com.ibrahimethemsen.pigeon.home.HomeViewModel
import com.ibrahimethemsen.pigeon.ui.theme.PigeonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PigeonUI()
        }
    }
}

@Composable
fun PigeonUI(){
    PigeonTheme{
        HomeRoute()
    }
}
