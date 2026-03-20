package com.nannydays.ui.navigation;

/**
 * Navigation destinations for the NannyDays app.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\n\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\n\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/nannydays/ui/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "AddChild", "ChildDetail", "Children", "EditChild", "Home", "QrCode", "QrScanner", "Reports", "Sessions", "SessionsForChild", "Lcom/nannydays/ui/navigation/Screen$AddChild;", "Lcom/nannydays/ui/navigation/Screen$ChildDetail;", "Lcom/nannydays/ui/navigation/Screen$Children;", "Lcom/nannydays/ui/navigation/Screen$EditChild;", "Lcom/nannydays/ui/navigation/Screen$Home;", "Lcom/nannydays/ui/navigation/Screen$QrCode;", "Lcom/nannydays/ui/navigation/Screen$QrScanner;", "Lcom/nannydays/ui/navigation/Screen$Reports;", "Lcom/nannydays/ui/navigation/Screen$Sessions;", "Lcom/nannydays/ui/navigation/Screen$SessionsForChild;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/nannydays/ui/navigation/Screen$AddChild;", "Lcom/nannydays/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class AddChild extends com.nannydays.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.nannydays.ui.navigation.Screen.AddChild INSTANCE = null;
        
        private AddChild() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/nannydays/ui/navigation/Screen$ChildDetail;", "Lcom/nannydays/ui/navigation/Screen;", "()V", "createRoute", "", "childId", "app_debug"})
    public static final class ChildDetail extends com.nannydays.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.nannydays.ui.navigation.Screen.ChildDetail INSTANCE = null;
        
        private ChildDetail() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull()
        java.lang.String childId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/nannydays/ui/navigation/Screen$Children;", "Lcom/nannydays/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Children extends com.nannydays.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.nannydays.ui.navigation.Screen.Children INSTANCE = null;
        
        private Children() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/nannydays/ui/navigation/Screen$EditChild;", "Lcom/nannydays/ui/navigation/Screen;", "()V", "createRoute", "", "childId", "app_debug"})
    public static final class EditChild extends com.nannydays.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.nannydays.ui.navigation.Screen.EditChild INSTANCE = null;
        
        private EditChild() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull()
        java.lang.String childId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/nannydays/ui/navigation/Screen$Home;", "Lcom/nannydays/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Home extends com.nannydays.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.nannydays.ui.navigation.Screen.Home INSTANCE = null;
        
        private Home() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/nannydays/ui/navigation/Screen$QrCode;", "Lcom/nannydays/ui/navigation/Screen;", "()V", "createRoute", "", "childId", "app_debug"})
    public static final class QrCode extends com.nannydays.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.nannydays.ui.navigation.Screen.QrCode INSTANCE = null;
        
        private QrCode() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull()
        java.lang.String childId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/nannydays/ui/navigation/Screen$QrScanner;", "Lcom/nannydays/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class QrScanner extends com.nannydays.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.nannydays.ui.navigation.Screen.QrScanner INSTANCE = null;
        
        private QrScanner() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/nannydays/ui/navigation/Screen$Reports;", "Lcom/nannydays/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Reports extends com.nannydays.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.nannydays.ui.navigation.Screen.Reports INSTANCE = null;
        
        private Reports() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/nannydays/ui/navigation/Screen$Sessions;", "Lcom/nannydays/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Sessions extends com.nannydays.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.nannydays.ui.navigation.Screen.Sessions INSTANCE = null;
        
        private Sessions() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/nannydays/ui/navigation/Screen$SessionsForChild;", "Lcom/nannydays/ui/navigation/Screen;", "()V", "createRoute", "", "childId", "app_debug"})
    public static final class SessionsForChild extends com.nannydays.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.nannydays.ui.navigation.Screen.SessionsForChild INSTANCE = null;
        
        private SessionsForChild() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull()
        java.lang.String childId) {
            return null;
        }
    }
}