import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jehubasa.watchir.sealedClasses.Screen
import com.jehubasa.watchir.viewModels.MostPopularMoviesViewModel
import com.jehubasa.watchir.views.MainScreen
import com.jehubasa.watchir.views.SplashScreen

@Composable
fun setUpSpashToMainNavGraph(navHostController: NavHostController) {

    val mostPopularMoviesViewModel : MostPopularMoviesViewModel = viewModel()

    NavHost(navController = navHostController, startDestination = Screen.splashScreen.route) {
        composable(route = Screen.splashScreen.route){
            LaunchedEffect(key1 = it){
            }
            SplashScreen(navController = navHostController,mostPopularMoviesViewModel)
        }
        composable(route = Screen.mainScreen.route){ MainScreen(mostPopularMoviesViewModel)}
    }
}