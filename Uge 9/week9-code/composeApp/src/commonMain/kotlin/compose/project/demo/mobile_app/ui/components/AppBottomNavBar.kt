package compose.project.demo.mobile_app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// The parent screen owns the selected tab and passes it into this component.
enum class BottomNavTab { HOME, SEARCH, LIST }

@Composable
fun AppBottomNavBar(
    selectedTab: BottomNavTab,
    onTabSelected: (BottomNavTab) -> Unit,
) {
    val tabs = listOf(
        Triple(BottomNavTab.HOME, "Hjem", Icons.Filled.Home),
        Triple(BottomNavTab.SEARCH, "Søg", Icons.Filled.Search),
        Triple(BottomNavTab.LIST, "Lister", Icons.Filled.List),
    )
    val primary = MaterialTheme.colorScheme.primary

    NavigationBar {
        tabs.forEach { (tab, label, icon) ->
            NavigationBarItem(
                selected = selectedTab == tab,
                onClick = { onTabSelected(tab) },
                icon = { Icon(imageVector = icon, contentDescription = label) },
                label = { Text(label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = primary,
                    selectedTextColor = primary,
                    indicatorColor = primary.copy(alpha = 0.12f),
                ),
            )
        }
    }
}
