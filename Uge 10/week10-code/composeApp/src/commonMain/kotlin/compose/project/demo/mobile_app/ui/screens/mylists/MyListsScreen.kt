package compose.project.demo.mobile_app.ui.screens.mylists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.project.demo.mobile_app.ui.components.AppBottomNavBar
import compose.project.demo.mobile_app.ui.components.AppTopBar
import compose.project.demo.mobile_app.ui.components.BottomNavTab
import compose.project.demo.mobile_app.ui.components.MyListCard
import compose.project.demo.mobile_app.ui.theme.BackgroundGray
import compose.project.demo.mobile_app.ui.theme.ErrorRed

@Composable
fun MyListsScreen(
    onBackClick: () -> Unit = {},
    onSettingsClick: (() -> Unit)? = null,
    onHomeTabClick: () -> Unit = {},
    onSearchTabClick: () -> Unit = {},
    viewModel: MyListsViewModel,
) {
    val state by viewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            containerColor = BackgroundGray,
            topBar = {
                AppTopBar(
                    onBackClick = onBackClick,
                    onSettingsClick = onSettingsClick,
                )
            },
            bottomBar = {
                AppBottomNavBar(
                    selectedTab = BottomNavTab.LIST,
                    onTabSelected = { tab ->
                        when (tab) {
                            BottomNavTab.HOME -> onHomeTabClick()
                            BottomNavTab.SEARCH -> onSearchTabClick()
                            BottomNavTab.LIST -> {}
                        }
                    },
                )
            },
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
            ) {
                when (val currentState = state) {
                    MyListsState.Loading -> CircularProgressIndicator()
                    is MyListsState.Error -> Text(
                        text = currentState.msg,
                        color = ErrorRed,
                    )
                    is MyListsState.Success -> LazyColumn(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        items(currentState.lists, key = { list -> list.id }) { list ->
                            MyListCard(name = list.name)
                        }
                    }
                }
                Spacer(Modifier.height(12.dp))
            }
        }
    }
}