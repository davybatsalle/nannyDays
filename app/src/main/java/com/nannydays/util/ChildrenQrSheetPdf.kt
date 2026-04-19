package com.nannydays.util

import android.graphics.Bitmap
import com.itextpdf.io.image.ImageDataFactory
import com.itextpdf.kernel.colors.ColorConstants
import com.itextpdf.kernel.geom.PageSize
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Cell
import com.itextpdf.layout.element.Image
import com.itextpdf.layout.element.Paragraph
import com.itextpdf.layout.element.Table
import com.itextpdf.layout.properties.HorizontalAlignment
import com.itextpdf.layout.properties.TextAlignment
import com.itextpdf.layout.properties.UnitValue
import com.itextpdf.layout.properties.VerticalAlignment
import com.nannydays.data.model.Child
import java.io.ByteArrayOutputStream
import java.io.OutputStream

/**
 * Builds a single A4 PDF with one row per child: name and scannable QR code.
 */
object ChildrenQrSheetPdf {

    private const val QR_BITMAP_SIZE_PX = 320
    private const val QR_WIDTH_PT = 110f

    fun write(
        outputStream: OutputStream,
        children: List<Child>,
        title: String,
        subtitle: String,
        ageLine: (Child) -> String
    ) {
        val writer = PdfWriter(outputStream)
        val pdfDocument = PdfDocument(writer)
        val document = Document(pdfDocument, PageSize.A4)
        document.setMargins(40f, 40f, 40f, 40f)

        document.add(
            Paragraph(title)
                .setFontSize(18f)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER)
        )
        document.add(
            Paragraph(subtitle)
                .setFontSize(10f)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(18f)
                .setFontColor(ColorConstants.GRAY)
        )

        val sorted = children.sortedBy { it.name.lowercase() }
        val table = Table(UnitValue.createPercentArray(floatArrayOf(62f, 38f)))
            .useAllAvailableWidth()

        for (child in sorted) {
            val nameCell = Cell()
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setPadding(10f)
                .add(Paragraph(child.name).setBold().setFontSize(14f))
                .add(Paragraph(ageLine(child)).setFontSize(10f))

            var bitmap: Bitmap? = null
            try {
                bitmap = QrCodeUtils.generateQrCode(child.id, size = QR_BITMAP_SIZE_PX)
                val baos = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
                val image = Image(ImageDataFactory.create(baos.toByteArray()))
                image.setWidth(QR_WIDTH_PT)
                image.setHorizontalAlignment(HorizontalAlignment.CENTER)

                val imageCell = Cell()
                    .setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .setPadding(8f)
                    .add(image)

                table.addCell(nameCell)
                table.addCell(imageCell)
            } finally {
                bitmap?.recycle()
            }
        }

        document.add(table)
        document.close()
    }
}
