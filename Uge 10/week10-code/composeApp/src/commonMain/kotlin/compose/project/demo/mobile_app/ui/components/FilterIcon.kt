package compose.project.demo.mobile_app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import compose.project.demo.mobile_app.ui.theme.PrimaryBlue

@Composable
fun FilterIcon(
    isActive: Boolean,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        BadgedBox(
            badge = {
                if (isActive) {
                    Badge(
                        containerColor = PrimaryBlue
                    )
                }
            }
        ) {
            Icon(
                Icons.Default.FilterList,
                contentDescription = "Filter"
            )
        }
    }
}