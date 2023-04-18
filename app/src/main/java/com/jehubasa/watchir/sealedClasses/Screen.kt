package com.jehubasa.watchir.sealedClasses

sealed class Screen(val route: String){
    object splashScreen: Screen(route = "splash")
    object mainScreen: Screen(route = "main")
}
