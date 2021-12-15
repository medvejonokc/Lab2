package cloud.dmytrominochkin.examplecompose.ui.photos

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import cloud.dmytrominochkin.examplecompose.ui.theme.ExampleComposeTheme

@Composable
fun PhotosTab(groups: List<String>, selectedGroup: String, onSelected: (String) -> Unit) {
    val selectedIndex = groups.indexOf(selectedGroup)
    TabRow(
        selectedTabIndex = selectedIndex,
        backgroundColor = MaterialTheme.colors.surface,
        indicator = { positions ->
            TabIndicatorContainer(positions, groups.indexOf(selectedGroup)) {
                // circle indicator
                val color = MaterialTheme.colors.primary
                Canvas(Modifier.size(4.dp)) {
                    drawCircle(color)
                }
            }
        },
        divider = {}
    ) {
        groups.forEachIndexed { index, group ->
            val color = animateColorAsState(
                if (selectedGroup == group) MaterialTheme.colors.primary else
                    MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled)
            )
            Tab(
                selected = index == selectedIndex,
                text = { Text(text = group, color = color.value) },
                onClick = { onSelected(group) },
                selectedContentColor = MaterialTheme.colors.surface
            )
        }
    }
}

@Composable
private fun TabIndicatorContainer(
    tabPositions: List<TabPosition>,
    selectedIndex: Int,
    content: @Composable() () -> Unit
) {
    val transition = updateTransition(targetState = selectedIndex, label = "selectedIndex")

    val offset = transition.animateDp(transitionSpec = {
        spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessLow)
    }, label = "tabPositions") {
        val position = tabPositions[it]
        (position.left + position.right) / 2
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.BottomStart)
            .offset { IntOffset(x = offset.value.roundToPx(), y = (-2).dp.roundToPx()) }
    ) {
        content()
    }
}

@Preview
@Composable
fun TabPreview() {
    ExampleComposeTheme {
        var selectedGroup by remember { mutableStateOf("food") }
        PhotosTab(
            groups = listOf("selfie", "cosplay", "food", "cats"),
            selectedGroup = selectedGroup,
            onSelected = { selectedGroup = it }
        )
    }
}