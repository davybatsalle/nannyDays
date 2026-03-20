package com.nannydays.ui.navigation

/**
 * Navigation destinations for the NannyDays app.
 */
sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Children : Screen("children")
    object AddChild : Screen("add_child")
    object EditChild : Screen("edit_child/{childId}") {
        fun createRoute(childId: String) = "edit_child/$childId"
    }
    object ChildDetail : Screen("child_detail/{childId}") {
        fun createRoute(childId: String) = "child_detail/$childId"
    }
    object QrCode : Screen("qr_code/{childId}") {
        fun createRoute(childId: String) = "qr_code/$childId"
    }
    object QrScanner : Screen("qr_scanner")
    object Sessions : Screen("sessions")
    object SessionsForChild : Screen("sessions/{childId}") {
        fun createRoute(childId: String) = "sessions/$childId"
    }
    object Reports : Screen("reports")
}
