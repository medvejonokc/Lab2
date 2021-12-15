package cloud.dmytrominochkin.examplecompose

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import cloud.dmytrominochkin.examplecompose.model.User
import cloud.dmytrominochkin.examplecompose.ui.components.StatusBarColorProvider
import cloud.dmytrominochkin.examplecompose.ui.feed.Feed
import cloud.dmytrominochkin.examplecompose.ui.profile.Profile

@ExperimentalAnimationApi
@Composable
fun MainScreen() {
    StatusBarColorProvider()
    Surface(color = MaterialTheme.colors.onSurface) {
        var selectedId by rememberSaveable { mutableStateOf<String?>(null) }
        Crossfade(targetState = selectedId) { id ->
            if (id == null) {
                Feed(
                    users,
                    onSelected = { selectedId = it.id }
                )
            } else {
                Profile(users.first { it.id == id })
                BackHandler {
                    selectedId = null
                }
            }
        }
    }
}

private val users = mutableListOf(
    User(
        "1",
        "Чендлер Бинг",
        "Man",
        R.drawable.an1,
        "18",
        "Язвительный и саркастический парень с остроумным и дураческим чувством юмора.",
        listOf("food", "fashion", "nature", "dogs", "people", "selfies", "style", "fashion", "cats"),

    ),
    User(
        "2",
        "Рэйчел Грин",
        "Woman",
        R.drawable.an2,
        "24",
        "Успешная, популярная, даже немного избалованная девушка.",
        listOf("people", "selfies", "style", "fashion"),

    ),
    User(
        "3",
        "Джоуи Триббиани",
        "Man",
        R.drawable.an3,
        "25",
        "Итало-американский актер сериалов, проживающий в Нью-Йорке со своим лучшим другом Чендлером Бингом и яростно мечтающий стать известным.",
        listOf("selife", "cats", "nature", "fashion"),

    )
)