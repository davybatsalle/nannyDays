package com.nannydays.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aT\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0003\u001a0\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u00a8\u0006\u0014"}, d2 = {"SessionListItem", "", "session", "Lcom/nannydays/data/model/CareSession;", "childName", "", "showChildName", "", "isExpanded", "onClick", "Lkotlin/Function0;", "onCheckOut", "onDelete", "SessionListScreen", "sessionViewModel", "Lcom/nannydays/ui/viewmodel/SessionViewModel;", "childViewModel", "Lcom/nannydays/ui/viewmodel/ChildViewModel;", "childId", "onNavigateBack", "app_debug"})
public final class SessionListScreenKt {
    
    /**
     * Screen displaying list of care sessions.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void SessionListScreen(@org.jetbrains.annotations.NotNull()
    com.nannydays.ui.viewmodel.SessionViewModel sessionViewModel, @org.jetbrains.annotations.NotNull()
    com.nannydays.ui.viewmodel.ChildViewModel childViewModel, @org.jetbrains.annotations.Nullable()
    java.lang.String childId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void SessionListItem(com.nannydays.data.model.CareSession session, java.lang.String childName, boolean showChildName, boolean isExpanded, kotlin.jvm.functions.Function0<kotlin.Unit> onClick, kotlin.jvm.functions.Function0<kotlin.Unit> onCheckOut, kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
}