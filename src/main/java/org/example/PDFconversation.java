package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFconversation {
    public void pdfconversation(File file, String text) throws DocumentException, FileNotFoundException {
        //TODO PDF conversation function (you can add new code which you think is true)
        Document doc = new Document(PageSize.A4,50,50,50,50);
        PdfWriter.getInstance(doc, new FileOutputStream(file.getPath()+".pdf"));
        doc.open();
        doc.add(new Paragraph(text));
        doc.close();

    }
}
