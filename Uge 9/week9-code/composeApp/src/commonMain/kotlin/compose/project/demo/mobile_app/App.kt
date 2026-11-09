package compose.project.demo.mobile_app

import androidx.compose.runtime.Composable
import compose.project.demo.mobile_app.navigation.AppNavHost
import compose.project.demo.mobile_app.ui.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        AppNavHost()
    }
}
