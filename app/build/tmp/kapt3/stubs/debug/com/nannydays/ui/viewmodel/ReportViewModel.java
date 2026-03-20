package com.nannydays.ui.viewmodel;

/**
 * ViewModel for generating and exporting reports.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u00018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020\'2\u0006\u0010(\u001a\u00020)J\u0006\u0010+\u001a\u00020\'J2\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-2\u0006\u0010(\u001a\u00020)2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/H\u0082@\u00a2\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\'2\b\u00104\u001a\u0004\u0018\u00010\u0012J\u0016\u00105\u001a\u00020\'2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\tR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00160\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018\u00a8\u00069"}, d2 = {"Lcom/nannydays/ui/viewmodel/ReportViewModel;", "Landroidx/lifecycle/ViewModel;", "childRepository", "Lcom/nannydays/data/repository/ChildRepository;", "careSessionRepository", "Lcom/nannydays/data/repository/CareSessionRepository;", "(Lcom/nannydays/data/repository/ChildRepository;Lcom/nannydays/data/repository/CareSessionRepository;)V", "_endDate", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_exportResult", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/nannydays/ui/viewmodel/ExportResult;", "_isLoading", "", "_report", "Lcom/nannydays/data/model/ChildReport;", "_selectedChild", "Lcom/nannydays/data/model/Child;", "_startDate", "allChildren", "Lkotlinx/coroutines/flow/StateFlow;", "", "getAllChildren", "()Lkotlinx/coroutines/flow/StateFlow;", "endDate", "getEndDate", "exportResult", "Lkotlinx/coroutines/flow/SharedFlow;", "getExportResult", "()Lkotlinx/coroutines/flow/SharedFlow;", "isLoading", "report", "getReport", "selectedChild", "getSelectedChild", "startDate", "getStartDate", "exportToCsv", "", "context", "Landroid/content/Context;", "exportToPdf", "generateReport", "getOutputStreamForFile", "Lkotlin/Pair;", "Ljava/io/OutputStream;", "", "fileName", "mimeType", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectChild", "child", "setDateRange", "start", "end", "Factory", "app_debug"})
public final class ReportViewModel extends androidx.lifecycle.ViewModel {
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
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Long> _startDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Long> startDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Long> _endDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Long> endDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.nannydays.data.model.ChildReport> _report = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.nannydays.data.model.ChildReport> report = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.nannydays.ui.viewmodel.ExportResult> _exportResult = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.SharedFlow<com.nannydays.ui.viewmodel.ExportResult> exportResult = null;
    
    public ReportViewModel(@org.jetbrains.annotations.NotNull()
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
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Long> getStartDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Long> getEndDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.nannydays.data.model.ChildReport> getReport() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<com.nannydays.ui.viewmodel.ExportResult> getExportResult() {
        return null;
    }
    
    public final void selectChild(@org.jetbrains.annotations.Nullable()
    com.nannydays.data.model.Child child) {
    }
    
    public final void setDateRange(long start, long end) {
    }
    
    public final void generateReport() {
    }
    
    public final void exportToCsv(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void exportToPdf(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    /**
     * Get an output stream for saving a file to the Downloads folder.
     * Uses MediaStore API for Android 10+ and direct file access for older versions.
     */
    private final java.lang.Object getOutputStreamForFile(android.content.Context context, java.lang.String fileName, java.lang.String mimeType, kotlin.coroutines.Continuation<? super kotlin.Pair<? extends java.io.OutputStream, java.lang.String>> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/nannydays/ui/viewmodel/ReportViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "childRepository", "Lcom/nannydays/data/repository/ChildRepository;", "careSessionRepository", "Lcom/nannydays/data/repository/CareSessionRepository;", "(Lcom/nannydays/data/repository/ChildRepository;Lcom/nannydays/data/repository/CareSessionRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
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