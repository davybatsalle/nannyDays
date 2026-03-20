package com.nannydays.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.nannydays.NannyDaysApplication
import com.nannydays.ui.screens.*
import com.nannydays.ui.viewmodel.ChildViewModel
import com.nannydays.ui.viewmodel.ReportViewModel
import com.nannydays.ui.viewmodel.SessionViewModel

/**
 * Navigation host for the NannyDays app.
 */
@Composable
fun NannyDaysNavHost(
    navController: NavHostController,
    application: NannyDaysApplication
) {
    val childViewModel: ChildViewModel = viewModel(
        factory = ChildViewModel.Factory(
            application.childRepository,
            application.careSessionRepository
        )
    )
    
    val sessionViewModel: SessionViewModel = viewModel(
        factory = SessionViewModel.Factory(
            application.careSessionRepository,
            application.childRepository
        )
    )
    
    val reportViewModel: ReportViewModel = viewModel(
        factory = ReportViewModel.Factory(
            application.childRepository,
            application.careSessionRepository
        )
    )

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                childViewModel = childViewModel,
                sessionViewModel = sessionViewModel,
                onNavigateToChildren = { navController.navigate(Screen.Children.route) },
                onNavigateToSessions = { navController.navigate(Screen.Sessions.route) },
                onNavigateToReports = { navController.navigate(Screen.Reports.route) },
                onNavigateToQrScanner = { navController.navigate(Screen.QrScanner.route) },
                onNavigateToChildDetail = { childId ->
                    navController.navigate(Screen.ChildDetail.createRoute(childId))
                }
            )
        }
        
        composable(Screen.Children.route) {
            ChildListScreen(
                viewModel = childViewModel,
                onNavigateToAddChild = { navController.navigate(Screen.AddChild.route) },
                onNavigateToChildDetail = { childId ->
                    navController.navigate(Screen.ChildDetail.createRoute(childId))
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.AddChild.route) {
            AddEditChildScreen(
                viewModel = childViewModel,
                childId = null,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(
            route = Screen.EditChild.route,
            arguments = listOf(navArgument("childId") { type = NavType.StringType })
        ) { backStackEntry ->
            val childId = backStackEntry.arguments?.getString("childId")
            AddEditChildScreen(
                viewModel = childViewModel,
                childId = childId,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(
            route = Screen.ChildDetail.route,
            arguments = listOf(navArgument("childId") { type = NavType.StringType })
        ) { backStackEntry ->
            val childId = backStackEntry.arguments?.getString("childId") ?: return@composable
            ChildDetailScreen(
                childId = childId,
                childViewModel = childViewModel,
                sessionViewModel = sessionViewModel,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToEdit = { 
                    navController.navigate(Screen.EditChild.createRoute(childId))
                },
                onNavigateToQrCode = {
                    navController.navigate(Screen.QrCode.createRoute(childId))
                },
                onNavigateToSessions = {
                    navController.navigate(Screen.SessionsForChild.createRoute(childId))
                }
            )
        }
        
        composable(
            route = Screen.QrCode.route,
            arguments = listOf(navArgument("childId") { type = NavType.StringType })
        ) { backStackEntry ->
            val childId = backStackEntry.arguments?.getString("childId") ?: return@composable
            QrCodeScreen(
                childId = childId,
                viewModel = childViewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.QrScanner.route) {
            QrScannerScreen(
                sessionViewModel = sessionViewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.Sessions.route) {
            SessionListScreen(
                sessionViewModel = sessionViewModel,
                childViewModel = childViewModel,
                childId = null,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(
            route = Screen.SessionsForChild.route,
            arguments = listOf(navArgument("childId") { type = NavType.StringType })
        ) { backStackEntry ->
            val childId = backStackEntry.arguments?.getString("childId")
            SessionListScreen(
                sessionViewModel = sessionViewModel,
                childViewModel = childViewModel,
                childId = childId,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.Reports.route) {
            ReportsScreen(
                viewModel = reportViewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
