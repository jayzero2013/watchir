package com.jehubasa.watchir.sealedClasses

sealed class Screen(val route: String){
    object mainScreen: Screen(route = "main")
    object selectedMoviesScreen: Screen(route = "selected")
}
