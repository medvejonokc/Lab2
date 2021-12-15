package cloud.dmytrominochkin.examplecompose.ui.feed

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cloud.dmytrominochkin.examplecompose.model.User
import cloud.dmytrominochkin.examplecompose.ui.user.UserCard

@ExperimentalAnimationApi
@Composable
fun Feed(
    userList: List<User>,
    onSelected: (User) -> Unit
) {
    Surface(Modifier.fillMaxSize()) {
        val users by remember { mutableStateOf(userList) }
        val state = rememberLazyListState()
        LazyColumn(state = state) {
            item {
                FeedHeader()
            }
            items(users.subList(fromIndex = 0, toIndex = minOf(users.size, 2))) {
                UserCard(user = it, onClick = { onSelected(it) })
            }
            if (users.size > 2) {
                item {
                    AdBanner()
                }
                items(users.subList(fromIndex = 2, toIndex = users.size)) {
                    UserCard(user = it, onClick = { onSelected(it) })
                }
            }
        }
        FeedFab(state, Modifier.wrapContentSize(align = Alignment.BottomEnd))
    }
}