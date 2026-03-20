package com.nannydays.ui.screens

import android.content.ContentValues
import android.graphics.Bitmap
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Print
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nannydays.ui.components.NannyDaysTopBar
import com.nannydays.ui.viewmodel.ChildViewModel
import com.nannydays.util.QrCodeUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.OutputStream

/**
 * Screen displaying QR code for a child that can be printed/saved.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QrCodeScreen(
    childId: String,
    viewModel: ChildViewModel,
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    
    val child by viewModel.getChildById(childId).collectAsState(initial = null)
    
    // Generate QR code
    val qrCodeBitmap = remember(childId) {
        QrCodeUtils.generateQrCode(childId, 512)
    }
    
    Scaffold(
        topBar = {
            NannyDaysTopBar(
                title = "QR Code",
                onNavigateBack = onNavigateBack,
                actions = {
                    IconButton(
                        onClick = {
                            scope.launch {
                                val saved = saveQrCodeToGallery(context, qrCodeBitmap, child?.name ?: "child")
                                if (saved) {
                                    snackbarHostState.showSnackbar("QR code saved to gallery")
                                } else {
                                    snackbarHostState.showSnackbar("Failed to save QR code")
                                }
                            }
                        }
                    ) {
                        Icon(Icons.Default.Download, contentDescription = "Save QR Code")
                    }
                }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Child name
            child?.let { currentChild ->
                Text(
                    text = currentChild.name,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                
                Spacer(modifier = Modifier.height(24.dp))
            }
            
            // QR Code
            Card(
                modifier = Modifier.size(300.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        bitmap = qrCodeBitmap.asImageBitmap(),
                        contentDescription = "QR Code for ${child?.name}",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Instructions
            Text(
                text = "Scan this QR code to quickly check in or out",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Actions
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedButton(
                    onClick = {
                        scope.launch {
                            val saved = saveQrCodeToGallery(context, qrCodeBitmap, child?.name ?: "child")
                            if (saved) {
                                snackbarHostState.showSnackbar("QR code saved to gallery")
                            } else {
                                snackbarHostState.showSnackbar("Failed to save QR code")
                            }
                        }
                    }
                ) {
                    Icon(Icons.Default.Download, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Save")
                }
                
                Button(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("Print the saved image from your gallery")
                        }
                    }
                ) {
                    Icon(Icons.Default.Print, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Print")
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Tip
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Text(
                    text = "💡 Tip: Print this QR code and attach it to the child's bag or card for quick check-ins!",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }
    }
}

/**
 * Save QR code bitmap to device gallery.
 */
private suspend fun saveQrCodeToGallery(
    context: android.content.Context,
    bitmap: Bitmap,
    childName: String
): Boolean = withContext(Dispatchers.IO) {
    try {
        val filename = "NannyDays_QR_${childName.replace(" ", "_")}_${System.currentTimeMillis()}.png"
        
        val outputStream: OutputStream? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val contentValues = ContentValues().apply {
                put(MediaStore.Images.Media.DISPLAY_NAME, filename)
                put(MediaStore.Images.Media.MIME_TYPE, "image/png")
                put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/NannyDays")
            }
            val uri = context.contentResolver.insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                contentValues
            )
            uri?.let { context.contentResolver.openOutputStream(it) }
        } else {
            val directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            val nannyDaysDir = java.io.File(directory, "NannyDays")
            if (!nannyDaysDir.exists()) {
                nannyDaysDir.mkdirs()
            }
            val file = java.io.File(nannyDaysDir, filename)
            java.io.FileOutputStream(file)
        }
        
        outputStream?.use { stream ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        }
        
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}
