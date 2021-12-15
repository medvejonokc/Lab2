package cloud.dmytrominochkin.examplecompose.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cloud.dmytrominochkin.examplecompose.R
import cloud.dmytrominochkin.examplecompose.model.User
import cloud.dmytrominochkin.examplecompose.ui.theme.ExampleComposeTheme

@Composable
fun ProfileHeader(user: User) {
    val padding = 25.dp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = padding, end = padding),
        //verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(user.avatar),
            modifier = Modifier
                .size(340.dp),

            contentDescription = "ava",
            contentScale = ContentScale.Crop
        )

        Column(Modifier.weight(1f)) {
            Text(
                text = user.name,
                style = MaterialTheme.typography.h6
            )
            Column(
                modifier = Modifier.fillMaxHeight(),
                //horizontalArrangement = Arrangement.SpaceBetween,
                //verticalAlignment = Alignment.CenterVertically
            ) {
                FollowingInfo(text = "Sex:", number = user.sex)
                FollowingInfo(text = "Age:", number = user.age)
                FollowingInfo(text = "Personality:", number = user.Personality)
            }
        }
    }
}

@Preview
@Composable
fun ProfileHeaderPreview() {
    val user = User(
        "2",
        "Cat-2",
        "Female",
        R.drawable.ava_2,
        "10",
        "black big cat",
        emptyList(),
        //emptyMap()
    )
    ExampleComposeTheme {
        Surface {
            ProfileHeader(user = user)
        }
    }
}