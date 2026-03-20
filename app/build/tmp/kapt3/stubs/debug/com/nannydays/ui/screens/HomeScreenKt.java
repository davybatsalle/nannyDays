package com.nannydays.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001aB\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001ad\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0017H\u0007\u001a&\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a@\u0010\u001c\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u00a8\u0006\u001d"}, d2 = {"ActiveSessionCard", "", "sessionWithChild", "Lcom/nannydays/ui/viewmodel/SessionWithChild;", "onCheckOut", "Lkotlin/Function0;", "onClick", "ChildQuickCard", "childName", "", "isActive", "", "onCheckIn", "HomeScreen", "childViewModel", "Lcom/nannydays/ui/viewmodel/ChildViewModel;", "sessionViewModel", "Lcom/nannydays/ui/viewmodel/SessionViewModel;", "onNavigateToChildren", "onNavigateToSessions", "onNavigateToReports", "onNavigateToQrScanner", "onNavigateToChildDetail", "Lkotlin/Function1;", "QuickActionCard", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "label", "QuickActionsSection", "app_debug"})
public final class HomeScreenKt {
    
    /**
     * Home screen / Dashboard showing active sessions and quick actions.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    com.nannydays.ui.viewmodel.ChildViewModel childViewModel, @org.jetbrains.annotations.NotNull()
    com.nannydays.ui.viewmodel.SessionViewModel sessionViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToChildren, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToSessions, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToReports, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToQrScanner, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNavigateToChildDetail) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void QuickActionsSection(kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToChildren, kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToSessions, kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToReports, kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToQrScanner) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void QuickActionCard(androidx.compose.ui.graphics.vector.ImageVector icon, java.lang.String label, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ActiveSessionCard(com.nannydays.ui.viewmodel.SessionWithChild sessionWithChild, kotlin.jvm.functions.Function0<kotlin.Unit> onCheckOut, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ChildQuickCard(java.lang.String childName, boolean isActive, kotlin.jvm.functions.Function0<kotlin.Unit> onCheckIn, kotlin.jvm.functions.Function0<kotlin.Unit> onCheckOut, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
}