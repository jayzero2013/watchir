import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jehubasa.watchir.sealedClasses.Screen
import com.jehubasa.watchir.viewModels.MoviesViewModel
import com.jehubasa.watchir.views.MainScreen
import com.jehubasa.watchir.views.SelectedMoviePage

@Composable
fun setUpSpashToMainNavGraph(
    navHostController: NavHostController,
    viewModel: MoviesViewModel
) {

    NavHost(navController = navHostController, startDestination = Screen.mainScreen.route) {
        composable(route = Screen.mainScreen.route) {
            MainScreen(
                viewModel,
                navController = navHostController
            )
        }
        composable(route = Screen.selectedMoviesScreen.route) {
            SelectedMoviePage(
                moviesViewModel = viewModel
            )
        }
    }
}