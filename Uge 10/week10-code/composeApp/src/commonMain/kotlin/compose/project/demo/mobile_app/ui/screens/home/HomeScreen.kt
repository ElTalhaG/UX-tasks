package compose.project.demo.mobile_app.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import compose.project.demo.mobile_app.ui.components.AppBottomNavBar
import compose.project.demo.mobile_app.ui.components.AppTopBar
import compose.project.demo.mobile_app.ui.components.BottomNavTab
import compose.project.demo.mobile_app.ui.components.ItemCard
import compose.project.demo.mobile_app.ui.components.SettingsListItem
import compose.project.demo.mobile_app.ui.theme.BackgroundGray
import compose.project.demo.mobile_app.ui.theme.IconContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun HomeScreen(
    onMyListsClick: () -> Unit = {},
    onListTabClick: () -> Unit = onMyListsClick,
    onSearchTabClick: () -> Unit = {},
) {
    var isFavorite by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            AppBottomNavBar(
                selectedTab = BottomNavTab.HOME,
                onTabSelected = { selectedTab ->
                    when (selectedTab) {
                        BottomNavTab.HOME -> {}
                        BottomNavTab.LIST -> onListTabClick()
                        BottomNavTab.SEARCH -> onSearchTabClick()
                    }
                },
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp),
            contentAlignment = Alignment.Center,
        ) {
            ItemCard(
                title = "Letmælk 1 l",
                price = 12.95,
                isFavorite = isFavorite,
                onFavoriteClick = { isFavorite = !isFavorite },
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp, vertical = 16.dp),
        ) {
            Spacer(Modifier.height(24.dp))

            SettingsListItem(
                label = "Dine Indkøbslister",
                icon = Icons.Default.ShoppingCart,
                iconTint = MaterialTheme.colorScheme.primary,
                iconBackground = IconContainer,
                onClick = onMyListsClick,
            )

            SettingsListItem(
                label = "Opret ny indkøbsliste",
                icon = Icons.Default.Add,
                iconTint = MaterialTheme.colorScheme.primary,
                iconBackground = IconContainer,
                onClick = {},
            )
        }
    }
}

data class SearchState(val query: String = "")

class SearchViewModel : ViewModel() {
    private val _state = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState> = _state

    fun updateQuery(query: String) {
        _state.value = _state.value.copy(query = query)
    }
}

@Composable
fun SearchScreen(
    onBackClick: () -> Unit,
    onHomeTabClick: () -> Unit,
    onListTabClick: () -> Unit,
    viewModel: SearchViewModel,
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        containerColor = BackgroundGray,
        topBar = {
            AppTopBar(
                title = "Søg",
                onBackClick = onBackClick,
            )
        },
        bottomBar = {
            AppBottomNavBar(
                selectedTab = BottomNavTab.SEARCH,
                onTabSelected = { selectedTab ->
                    when (selectedTab) {
                        BottomNavTab.HOME -> onHomeTabClick()
                        BottomNavTab.LIST -> onListTabClick()
                        BottomNavTab.SEARCH -> {}
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            OutlinedTextField(
                value = state.query,
                onValueChange = viewModel::updateQuery,
                label = { Text("Varenavn") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
            )
            Text(
                text = if (state.query.isBlank()) {
                    "Skriv et produktnavn for at søge."
                } else {
                    "Du søger efter: " + state.query
                },
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}
