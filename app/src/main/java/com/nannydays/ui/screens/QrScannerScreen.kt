package com.nannydays.ui.screens

import android.Manifest
import android.content.pm.PackageManager
import android.util.Size
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.FlashOff
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage
import com.nannydays.R
import com.nannydays.ui.components.NannyDaysTopBar
import com.nannydays.ui.viewmodel.CheckInResult
import com.nannydays.ui.viewmodel.SessionViewModel
import com.nannydays.util.QrCodeUtils
import java.util.concurrent.Executors

/**
 * Screen for scanning QR codes to check in/out children.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QrScannerScreen(
    sessionViewModel: SessionViewModel,
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val snackbarHostState = remember { SnackbarHostState() }
    
    var hasCameraPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED
        )
    }
    
    var isProcessing by remember { mutableStateOf(false) }
    var lastScannedCode by remember { mutableStateOf<String?>(null) }
    var flashEnabled by remember { mutableStateOf(false) }
    
    val checkInResult by sessionViewModel.checkInResult.collectAsState(initial = null)
    
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        hasCameraPermission = granted
    }
    
    LaunchedEffect(Unit) {
        if (!hasCameraPermission) {
            permissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }
    
    // Handle check-in results
    LaunchedEffect(checkInResult) {
        when (val result = checkInResult) {
            is CheckInResult.Success -> {
                val message = if (result.isCheckIn) {
                    "✓ ${context.getString(R.string.checked_in_success, result.childName)}"
                } else {
                    "✓ ${context.getString(R.string.checked_out_success, result.childName)}"
                }
                snackbarHostState.showSnackbar(message)
                // Reset for next scan
                kotlinx.coroutines.delay(1500)
                isProcessing = false
                lastScannedCode = null
            }
            is CheckInResult.AlreadyCheckedIn -> {
                snackbarHostState.showSnackbar(context.getString(R.string.already_checked_in_scan, result.childName))
                isProcessing = false
                lastScannedCode = null
            }
            is CheckInResult.ChildNotFound -> {
                snackbarHostState.showSnackbar(context.getString(R.string.child_not_found))
                isProcessing = false
                lastScannedCode = null
            }
            is CheckInResult.InvalidQrCode -> {
                snackbarHostState.showSnackbar(context.getString(R.string.invalid_qr_code))
                isProcessing = false
                lastScannedCode = null
            }
            is CheckInResult.Error -> {
                snackbarHostState.showSnackbar(context.getString(R.string.error_message, result.message))
                isProcessing = false
                lastScannedCode = null
            }
            else -> {}
        }
    }
    
    Scaffold(
        topBar = {
            NannyDaysTopBar(
                title = stringResource(R.string.scan_qr_code),
                onNavigateBack = onNavigateBack,
                actions = {
                    if (hasCameraPermission) {
                        IconButton(onClick = { flashEnabled = !flashEnabled }) {
                            Icon(
                                if (flashEnabled) Icons.Default.FlashOn else Icons.Default.FlashOff,
                                contentDescription = stringResource(R.string.toggle_flash)
                            )
                        }
                    }
                }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            if (hasCameraPermission) {
                CameraPreview(
                    flashEnabled = flashEnabled,
                    onQrCodeScanned = { qrCode ->
                        if (!isProcessing && qrCode != lastScannedCode) {
                            if (QrCodeUtils.isValidQrCode(qrCode)) {
                                isProcessing = true
                                lastScannedCode = qrCode
                                sessionViewModel.processQrCode(qrCode)
                            }
                        }
                    }
                )
                
                // Scanning overlay
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    // Scanning frame indicator
                    Box(
                        modifier = Modifier
                            .size(250.dp)
                            .background(Color.Transparent)
                    ) {
                        // Corner indicators
                        val cornerSize = 30.dp
                        val strokeWidth = 4.dp
                        
                        // Top-left
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .size(cornerSize)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(strokeWidth)
                                    .background(MaterialTheme.colorScheme.primary)
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(strokeWidth)
                                    .background(MaterialTheme.colorScheme.primary)
                            )
                        }
                        
                        // Top-right
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(cornerSize)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(strokeWidth)
                                    .background(MaterialTheme.colorScheme.primary)
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(strokeWidth)
                                    .align(Alignment.TopEnd)
                                    .background(MaterialTheme.colorScheme.primary)
                            )
                        }
                        
                        // Bottom-left
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .size(cornerSize)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(strokeWidth)
                                    .align(Alignment.BottomStart)
                                    .background(MaterialTheme.colorScheme.primary)
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(strokeWidth)
                                    .background(MaterialTheme.colorScheme.primary)
                            )
                        }
                        
                        // Bottom-right
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .size(cornerSize)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(strokeWidth)
                                    .align(Alignment.BottomEnd)
                                    .background(MaterialTheme.colorScheme.primary)
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(strokeWidth)
                                    .align(Alignment.BottomEnd)
                                    .background(MaterialTheme.colorScheme.primary)
                            )
                        }
                    }
                }
                
                // Instructions at bottom
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .background(Color.Black.copy(alpha = 0.6f))
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (isProcessing) {
                        CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = stringResource(R.string.processing),
                            color = Color.White,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    } else {
                        Text(
                            text = stringResource(R.string.qr_scan_instruction),
                            color = Color.White,
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = stringResource(R.string.camera_auto_scan),
                            color = Color.White.copy(alpha = 0.7f),
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            } else {
                // No camera permission
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        Icons.Default.CameraAlt,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.camera_permission_required),
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.camera_permission_rationale),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = { permissionLauncher.launch(Manifest.permission.CAMERA) }
                    ) {
                        Text(stringResource(R.string.grant_permission))
                    }
                }
            }
        }
    }
}

@Composable
@androidx.annotation.OptIn(androidx.camera.core.ExperimentalGetImage::class)
private fun CameraPreview(
    flashEnabled: Boolean,
    onQrCodeScanned: (String) -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    var camera by remember { mutableStateOf<androidx.camera.core.Camera?>(null) }
    
    // Update flash state when it changes
    LaunchedEffect(flashEnabled) {
        camera?.cameraControl?.enableTorch(flashEnabled)
    }
    
    AndroidView(
        factory = { ctx ->
            val previewView = PreviewView(ctx)
            val executor = Executors.newSingleThreadExecutor()
            val barcodeScanner = BarcodeScanning.getClient()
            
            cameraProviderFuture.addListener({
                val cameraProvider = cameraProviderFuture.get()
                
                val preview = Preview.Builder().build().also {
                    it.setSurfaceProvider(previewView.surfaceProvider)
                }
                
                val imageAnalysis = ImageAnalysis.Builder()
                    .setTargetResolution(Size(1280, 720))
                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                    .build()
                    .also { analysis ->
                        analysis.setAnalyzer(executor) { imageProxy ->
                            val mediaImage = imageProxy.image
                            if (mediaImage != null) {
                                val inputImage = InputImage.fromMediaImage(
                                    mediaImage,
                                    imageProxy.imageInfo.rotationDegrees
                                )
                                
                                barcodeScanner.process(inputImage)
                                    .addOnSuccessListener { barcodes ->
                                        for (barcode in barcodes) {
                                            if (barcode.valueType == Barcode.TYPE_TEXT) {
                                                barcode.rawValue?.let { value ->
                                                    onQrCodeScanned(value)
                                                }
                                            }
                                        }
                                    }
                                    .addOnCompleteListener {
                                        imageProxy.close()
                                    }
                            } else {
                                imageProxy.close()
                            }
                        }
                    }
                
                val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
                
                try {
                    cameraProvider.unbindAll()
                    camera = cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        cameraSelector,
                        preview,
                        imageAnalysis
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }, ContextCompat.getMainExecutor(ctx))
            
            previewView
        },
        modifier = Modifier.fillMaxSize()
    )
}
