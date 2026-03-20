package com.nannydays.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a\u001e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u00a8\u0006\f"}, d2 = {"CameraPreview", "", "flashEnabled", "", "onQrCodeScanned", "Lkotlin/Function1;", "", "QrScannerScreen", "sessionViewModel", "Lcom/nannydays/ui/viewmodel/SessionViewModel;", "onNavigateBack", "Lkotlin/Function0;", "app_debug"})
public final class QrScannerScreenKt {
    
    /**
     * Screen for scanning QR codes to check in/out children.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void QrScannerScreen(@org.jetbrains.annotations.NotNull()
    com.nannydays.ui.viewmodel.SessionViewModel sessionViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack) {
    }
    
    @androidx.compose.runtime.Composable()
    @androidx.annotation.OptIn(markerClass = {androidx.camera.core.ExperimentalGetImage.class})
    private static final void CameraPreview(boolean flashEnabled, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onQrCodeScanned) {
    }
}