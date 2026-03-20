package com.nannydays.ui.viewmodel;

/**
 * ViewModel for managing care session data and operations.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u00012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000fJ\u000e\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000fJ\u0006\u0010\'\u001a\u00020#J\u000e\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0014J\u0016\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140+2\u0006\u0010$\u001a\u00020\u000fJ\u001a\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0+2\u0006\u0010$\u001a\u00020\u000fJ\b\u0010-\u001a\u00020#H\u0002J\u000e\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\u000fJ\u000e\u00100\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000fJ\u000e\u00101\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0014R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016\u00a8\u00063"}, d2 = {"Lcom/nannydays/ui/viewmodel/SessionViewModel;", "Landroidx/lifecycle/ViewModel;", "careSessionRepository", "Lcom/nannydays/data/repository/CareSessionRepository;", "childRepository", "Lcom/nannydays/data/repository/ChildRepository;", "(Lcom/nannydays/data/repository/CareSessionRepository;Lcom/nannydays/data/repository/ChildRepository;)V", "_activeSessionsWithChildren", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/nannydays/ui/viewmodel/SessionWithChild;", "_checkInResult", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/nannydays/ui/viewmodel/CheckInResult;", "_errorMessage", "", "_isLoading", "", "activeSessions", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/nannydays/data/model/CareSession;", "getActiveSessions", "()Lkotlinx/coroutines/flow/StateFlow;", "activeSessionsWithChildren", "getActiveSessionsWithChildren", "allSessions", "getAllSessions", "checkInResult", "Lkotlinx/coroutines/flow/SharedFlow;", "getCheckInResult", "()Lkotlinx/coroutines/flow/SharedFlow;", "errorMessage", "getErrorMessage", "isLoading", "checkIn", "", "childId", "notes", "checkOut", "clearError", "deleteSession", "session", "getActiveSessionForChild", "Lkotlinx/coroutines/flow/Flow;", "getSessionsForChild", "loadActiveSessionsWithChildren", "processQrCode", "qrData", "toggleCheckInOut", "updateSession", "Factory", "app_debug"})
public final class SessionViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.nannydays.data.repository.CareSessionRepository careSessionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.nannydays.data.repository.ChildRepository childRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.nannydays.data.model.CareSession>> allSessions = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.nannydays.data.model.CareSession>> activeSessions = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.nannydays.ui.viewmodel.SessionWithChild>> _activeSessionsWithChildren = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.nannydays.ui.viewmodel.SessionWithChild>> activeSessionsWithChildren = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.nannydays.ui.viewmodel.CheckInResult> _checkInResult = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.SharedFlow<com.nannydays.ui.viewmodel.CheckInResult> checkInResult = null;
    
    public SessionViewModel(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.repository.CareSessionRepository careSessionRepository, @org.jetbrains.annotations.NotNull()
    com.nannydays.data.repository.ChildRepository childRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.nannydays.data.model.CareSession>> getAllSessions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.nannydays.data.model.CareSession>> getActiveSessions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.nannydays.ui.viewmodel.SessionWithChild>> getActiveSessionsWithChildren() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<com.nannydays.ui.viewmodel.CheckInResult> getCheckInResult() {
        return null;
    }
    
    private final void loadActiveSessionsWithChildren() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nannydays.data.model.CareSession>> getSessionsForChild(@org.jetbrains.annotations.NotNull()
    java.lang.String childId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.nannydays.data.model.CareSession> getActiveSessionForChild(@org.jetbrains.annotations.NotNull()
    java.lang.String childId) {
        return null;
    }
    
    /**
     * Check in a child - start a new care session.
     */
    public final void checkIn(@org.jetbrains.annotations.NotNull()
    java.lang.String childId, @org.jetbrains.annotations.NotNull()
    java.lang.String notes) {
    }
    
    /**
     * Check out a child - end active care session.
     */
    public final void checkOut(@org.jetbrains.annotations.NotNull()
    java.lang.String childId) {
    }
    
    /**
     * Toggle check-in/out for a child based on current state.
     */
    public final void toggleCheckInOut(@org.jetbrains.annotations.NotNull()
    java.lang.String childId) {
    }
    
    /**
     * Process QR code scan and perform check-in/out.
     */
    public final void processQrCode(@org.jetbrains.annotations.NotNull()
    java.lang.String qrData) {
    }
    
    public final void updateSession(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.model.CareSession session) {
    }
    
    public final void deleteSession(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.model.CareSession session) {
    }
    
    public final void clearError() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/nannydays/ui/viewmodel/SessionViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "careSessionRepository", "Lcom/nannydays/data/repository/CareSessionRepository;", "childRepository", "Lcom/nannydays/data/repository/ChildRepository;", "(Lcom/nannydays/data/repository/CareSessionRepository;Lcom/nannydays/data/repository/ChildRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class Factory implements androidx.lifecycle.ViewModelProvider.Factory {
        @org.jetbrains.annotations.NotNull()
        private final com.nannydays.data.repository.CareSessionRepository careSessionRepository = null;
        @org.jetbrains.annotations.NotNull()
        private final com.nannydays.data.repository.ChildRepository childRepository = null;
        
        public Factory(@org.jetbrains.annotations.NotNull()
        com.nannydays.data.repository.CareSessionRepository careSessionRepository, @org.jetbrains.annotations.NotNull()
        com.nannydays.data.repository.ChildRepository childRepository) {
            super();
        }
        
        @java.lang.Override()
        @kotlin.Suppress(names = {"UNCHECKED_CAST"})
        @org.jetbrains.annotations.NotNull()
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
        java.lang.Class<T> modelClass) {
            return null;
        }
    }
}