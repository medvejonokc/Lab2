package cloud.dmytrominochkin.examplecompose.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import cloud.dmytrominochkin.examplecompose.ui.theme.ExampleComposeTheme

@Composable
fun FollowingInfo(text: String, number: String) {
    Column() {
        Text(text = text, style = MaterialTheme.typography.caption)
        Text(text = number, style = MaterialTheme.typography.subtitle2)

    }
}

@Preview
@Composable
fun FollowingInfoPreview() {
    ExampleComposeTheme {
        Surface {
            FollowingInfo("following", "10")
        }
    }
}