package com.nannydays.util

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter

/**
 * Utility class for QR code operations.
 */
object QrCodeUtils {
    
    private const val QR_CODE_SIZE = 512
    private const val QR_CODE_PREFIX = "NANNYDAYS:CHILD:"
    
    /**
     * Generates a QR code bitmap for the given child ID.
     */
    fun generateQrCode(childId: String, size: Int = QR_CODE_SIZE): Bitmap {
        val qrCodeData = "$QR_CODE_PREFIX$childId"
        return generateQrCodeFromData(qrCodeData, size)
    }
    
    /**
     * Generates a QR code bitmap from raw data.
     */
    fun generateQrCodeFromData(data: String, size: Int = QR_CODE_SIZE): Bitmap {
        val hints = hashMapOf<EncodeHintType, Any>()
        hints[EncodeHintType.MARGIN] = 1
        
        val writer = QRCodeWriter()
        val bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, size, size, hints)
        
        val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565)
        for (x in 0 until size) {
            for (y in 0 until size) {
                bitmap.setPixel(
                    x, y,
                    if (bitMatrix.get(x, y)) android.graphics.Color.BLACK
                    else android.graphics.Color.WHITE
                )
            }
        }
        return bitmap
    }
    
    /**
     * Parses QR code data and extracts child ID if valid.
     */
    fun parseQrCode(data: String): String? {
        if (!data.startsWith(QR_CODE_PREFIX)) {
            return null
        }
        return data.removePrefix(QR_CODE_PREFIX)
    }
    
    /**
     * Validates if the given data is a valid NannyDays QR code.
     */
    fun isValidQrCode(data: String): Boolean {
        return data.startsWith(QR_CODE_PREFIX) && 
               data.length > QR_CODE_PREFIX.length
    }
}
