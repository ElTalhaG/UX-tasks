package compose.project.demo.mobile_app.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import compose.project.demo.mobile_app.ui.screens.home.HomeScreen
import compose.project.demo.mobile_app.ui.screens.home.SearchScreen
import compose.project.demo.mobile_app.ui.screens.mylists.MyListsScreen

private const val HOME_ROUTE = "home"
private const val MY_LISTS_ROUTE = "my_lists"
private const val SEARCH_ROUTE = "search"

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
    ) {
        composable(HOME_ROUTE) {
            HomeScreen(
                onMyListsClick = { navController.navigate(MY_LISTS_ROUTE) },
                onListTabClick = { navController.navigate(MY_LISTS_ROUTE) },
                onSearchTabClick = { navController.navigate(SEARCH_ROUTE) },
            )
        }

        composable(MY_LISTS_ROUTE) {
            MyListsScreen(
                viewModel = viewModel(),
                onBackClick = { navController.popBackStack() },
                onHomeTabClick = {
                    navController.navigate(HOME_ROUTE) {
                        popUpTo(HOME_ROUTE) { inclusive = false }
                        launchSingleTop = true
                    }
                },
                onSearchTabClick = { navController.navigate(SEARCH_ROUTE) },
            )
        }

        composable(SEARCH_ROUTE) {
            SearchScreen(
                onBackClick = { navController.popBackStack() },
                onHomeTabClick = {
                    navController.navigate(HOME_ROUTE) {
                        popUpTo(HOME_ROUTE) { inclusive = false }
                        launchSingleTop = true
                    }
                },
                onListTabClick = { navController.navigate(MY_LISTS_ROUTE) },
                viewModel = viewModel(),
            )
        }
    }
}
