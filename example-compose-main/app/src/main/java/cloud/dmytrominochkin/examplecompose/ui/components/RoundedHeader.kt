package cloud.dmytrominochkin.examplecompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cloud.dmytrominochkin.examplecompose.ui.theme.ExampleComposeTheme

@Composable
fun RoundedHeader(title: String) {
    Surface(
        modifier = Modifier.fillMaxWidth().height(50.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(50, 50, 0, 0)
    ) {
        val padding = 16.dp
        Text(
            text = title,
            modifier = Modifier.padding(start = padding, top = padding, end = padding),
            style = MaterialTheme.typography.h6
        )
    }
}

@Preview
@Composable
fun RoundedHeaderPreview() {
    ExampleComposeTheme {
        RoundedHeader(title = "Header")
    }
}