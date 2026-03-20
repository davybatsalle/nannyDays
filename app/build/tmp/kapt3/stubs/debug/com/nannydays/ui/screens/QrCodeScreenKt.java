package com.nannydays.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0082@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"QrCodeScreen", "", "childId", "", "viewModel", "Lcom/nannydays/ui/viewmodel/ChildViewModel;", "onNavigateBack", "Lkotlin/Function0;", "saveQrCodeToGallery", "", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "childName", "(Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class QrCodeScreenKt {
    
    /**
     * Screen displaying QR code for a child that can be printed/saved.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void QrCodeScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String childId, @org.jetbrains.annotations.NotNull()
    com.nannydays.ui.viewmodel.ChildViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack) {
    }
    
    /**
     * Save QR code bitmap to device gallery.
     */
    private static final java.lang.Object saveQrCodeToGallery(android.content.Context context, android.graphics.Bitmap bitmap, java.lang.String childName, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}