package cloud.dmytrominochkin.examplecompose.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun StatusBarColorProvider() {
    val systemUiController = rememberSystemUiController()
    val color = MaterialTheme.colors.onSurface

    SideEffect {
        systemUiController.setSystemBarsColor(color = color)
    }
}