package cloud.dmytrominochkin.examplecompose.ui.feed

import android.widget.ImageView
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import cloud.dmytrominochkin.examplecompose.R

@Composable
fun AdBanner() {
    AndroidView(modifier = Modifier.padding(16.dp), factory = { context ->
        ImageView(context).apply {
            setImageResource(R.drawable.banner)
        }
    })
}