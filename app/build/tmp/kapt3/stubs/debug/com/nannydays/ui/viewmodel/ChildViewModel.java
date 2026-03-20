package com.nannydays.ui.viewmodel;

/**
 * ViewModel for managing child data and operations.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001/B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J<\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u000bJ\u0006\u0010&\u001a\u00020\u001dJ\u000e\u0010\'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u000fJ\u0016\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0*2\u0006\u0010+\u001a\u00020\u000bJ\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u000bJ\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u000fH\u0002J\u000e\u0010.\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u000fR\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014\u00a8\u00060"}, d2 = {"Lcom/nannydays/ui/viewmodel/ChildViewModel;", "Landroidx/lifecycle/ViewModel;", "childRepository", "Lcom/nannydays/data/repository/ChildRepository;", "careSessionRepository", "Lcom/nannydays/data/repository/CareSessionRepository;", "(Lcom/nannydays/data/repository/ChildRepository;Lcom/nannydays/data/repository/CareSessionRepository;)V", "_childWithSummary", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/nannydays/data/model/ChildWithSummary;", "_errorMessage", "", "_isLoading", "", "_selectedChild", "Lcom/nannydays/data/model/Child;", "allChildren", "Lkotlinx/coroutines/flow/StateFlow;", "", "getAllChildren", "()Lkotlinx/coroutines/flow/StateFlow;", "childWithSummary", "getChildWithSummary", "errorMessage", "getErrorMessage", "isLoading", "selectedChild", "getSelectedChild", "addChild", "", "name", "dateOfBirth", "", "standardHoursPerWeek", "", "parentName", "parentContact", "notes", "clearError", "deleteChild", "child", "getChildById", "Lkotlinx/coroutines/flow/Flow;", "childId", "loadChild", "loadChildSummary", "updateChild", "Factory", "app_debug"})
public final class ChildViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.nannydays.data.repository.ChildRepository childRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.nannydays.data.repository.CareSessionRepository careSessionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.nannydays.data.model.Child>> allChildren = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.nannydays.data.model.Child> _selectedChild = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.nannydays.data.model.Child> selectedChild = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.nannydays.data.model.ChildWithSummary> _childWithSummary = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.nannydays.data.model.ChildWithSummary> childWithSummary = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> errorMessage = null;
    
    public ChildViewModel(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.repository.ChildRepository childRepository, @org.jetbrains.annotations.NotNull()
    com.nannydays.data.repository.CareSessionRepository careSessionRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.nannydays.data.model.Child>> getAllChildren() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.nannydays.data.model.Child> getSelectedChild() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.nannydays.data.model.ChildWithSummary> getChildWithSummary() {
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
    public final kotlinx.coroutines.flow.Flow<com.nannydays.data.model.Child> getChildById(@org.jetbrains.annotations.NotNull()
    java.lang.String childId) {
        return null;
    }
    
    public final void loadChild(@org.jetbrains.annotations.NotNull()
    java.lang.String childId) {
    }
    
    private final void loadChildSummary(com.nannydays.data.model.Child child) {
    }
    
    public final void addChild(@org.jetbrains.annotations.NotNull()
    java.lang.String name, long dateOfBirth, float standardHoursPerWeek, @org.jetbrains.annotations.NotNull()
    java.lang.String parentName, @org.jetbrains.annotations.NotNull()
    java.lang.String parentContact, @org.jetbrains.annotations.NotNull()
    java.lang.String notes) {
    }
    
    public final void updateChild(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.model.Child child) {
    }
    
    public final void deleteChild(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.model.Child child) {
    }
    
    public final void clearError() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/nannydays/ui/viewmodel/ChildViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "childRepository", "Lcom/nannydays/data/repository/ChildRepository;", "careSessionRepository", "Lcom/nannydays/data/repository/CareSessionRepository;", "(Lcom/nannydays/data/repository/ChildRepository;Lcom/nannydays/data/repository/CareSessionRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class Factory implements androidx.lifecycle.ViewModelProvider.Factory {
        @org.jetbrains.annotations.NotNull()
        private final com.nannydays.data.repository.ChildRepository childRepository = null;
        @org.jetbrains.annotations.NotNull()
        private final com.nannydays.data.repository.CareSessionRepository careSessionRepository = null;
        
        public Factory(@org.jetbrains.annotations.NotNull()
        com.nannydays.data.repository.ChildRepository childRepository, @org.jetbrains.annotations.NotNull()
        com.nannydays.data.repository.CareSessionRepository careSessionRepository) {
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