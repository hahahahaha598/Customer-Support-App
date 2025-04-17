package com.example.customersupportapp.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx. navigation.compose.NavHost
import androidx.navigation.compose.composable


enum class Screen {
    Login,
    SignUp,
    // 之后你可以继续加更多 screen：Home, TicketList, etc.
}

@Composable
fun NavigateScreen(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Login.name) {
        composable(Screen.Login.name) {
            LoginScreen(
                onLoginClick = { email, password ->
                    // TODO: 登录逻辑
                },
                onSignUpClick = {
                    navController.navigate(Screen.SignUp.name)
                }
            )
        }

        composable(Screen.SignUp.name) {
            SignUpScreen(
                onSignUpClick = { name, email, password ->
                    // TODO: 注册逻辑
                    navController.popBackStack()
                },
                onLoginClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

