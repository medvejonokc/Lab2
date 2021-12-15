package cloud.dmytrominochkin.examplecompose.ui.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cloud.dmytrominochkin.examplecompose.ui.components.RoundedHeader
import cloud.dmytrominochkin.examplecompose.ui.theme.ExampleComposeTheme

@Composable
fun FeedHeader() {
    Surface(
        color = MaterialTheme.colors.onSurface,
        contentColor = MaterialTheme.colors.surface
    ) {
        Column {
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = "Hello,",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 16.dp)
            )
            Text(
                text = "Andrei Rozhkov",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            RoundedHeader(title = "Your feed about Friends")
        }
    }
}

@Preview
@Composable
fun FeedHeaderPreview() {
    ExampleComposeTheme {
        FeedHeader()
    }
}