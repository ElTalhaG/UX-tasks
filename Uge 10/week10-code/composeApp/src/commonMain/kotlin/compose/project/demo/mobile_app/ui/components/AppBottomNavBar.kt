package compose.project.demo.mobile_app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class BottomNavTab { HOME, SEARCH, LIST }

@Composable
fun AppBottomNavBar(
    selectedTab: BottomNavTab?,
    onTabSelected: (BottomNavTab) -> Unit,
    showList: Boolean = true,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 8.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .height(64.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (showList) {
                IconButton(onClick = { onTabSelected(BottomNavTab.LIST) }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.List,
                        contentDescription = "Lister",
                        tint = if (selectedTab == BottomNavTab.LIST) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSecondary,
                    )
                }
            }

            IconButton(onClick = { onTabSelected(BottomNavTab.HOME) }) {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Hjem",
                    tint = if (selectedTab == BottomNavTab.HOME) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSecondary,
                )
            }

            IconButton(onClick = { onTabSelected(BottomNavTab.SEARCH) }) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Søg",
                    tint = if (selectedTab == BottomNavTab.SEARCH) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSecondary,
                )
            }
        }
    }
}
