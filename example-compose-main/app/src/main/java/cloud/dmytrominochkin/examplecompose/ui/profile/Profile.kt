package cloud.dmytrominochkin.examplecompose.ui.profile

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cloud.dmytrominochkin.examplecompose.R
import cloud.dmytrominochkin.examplecompose.model.User
import cloud.dmytrominochkin.examplecompose.ui.components.RoundedHeader
import cloud.dmytrominochkin.examplecompose.ui.photos.PhotosGrid
import cloud.dmytrominochkin.examplecompose.ui.photos.PhotosTab
import cloud.dmytrominochkin.examplecompose.ui.theme.ExampleComposeTheme

@Composable
fun Profile(user: User, modifier: Modifier = Modifier) {
    val padding = 16.dp
    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.onSurface,
        contentColor = MaterialTheme.colors.surface
    ) {
            Column(Modifier.padding(top = 24.dp)) {
                Spacer(modifier = Modifier.weight(1f))
                ProfileHeader(user)
                Spacer(modifier = Modifier.weight(1f))
                TagsList(
                    user.tags,
                    Modifier.padding(top = padding, bottom = padding)
                )
                Spacer(modifier = Modifier.weight(1f))
                //PhotosCard(groupedPhotos = user.photos)
            }
    }
}

@Composable
private fun PhotosCard(groupedPhotos: Map<String, List<Int>>) {
    val groups = groupedPhotos.keys.toList()
    RoundedHeader(title = "Photos")
    Surface {
        Column {
            var selectedGroup by rememberSaveable { mutableStateOf(groups.first()) }
            PhotosTab(
                groups = groups,
                selectedGroup = selectedGroup,
                onSelected = { selectedGroup = it }
            )
            PhotosGrid(
                groupedPhotos.getValue(selectedGroup),
                Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
            )
        }
    }
}

@Composable
private fun TagsList(tags: List<String>, modifier: Modifier = Modifier) {
    val padding = 8.dp
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(start = padding * 2, end = padding),
        horizontalArrangement = Arrangement.spacedBy(padding)
    ) {
        items(tags) {
            Text(
                text = it,
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .border(
                        1.dp,
                        LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
                        CircleShape
                    )
                    .padding(padding)
            )
        }
    }
}

@Preview(widthDp = 200)
@Composable
fun TagPreview() {
    val user = User(
        "3",
        "Cat-3",
        "Male",
        R.drawable.ava_1,
        "1",
        "894",
        listOf("travel", "urban", "fashion", "food", "mood", "home"),
        //emptyMap()
    )
    ExampleComposeTheme {
        Surface {
            TagsList(user.tags)
        }
    }
}