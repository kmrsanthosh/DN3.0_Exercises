package com.santhosh.factorymethod;

public class Main {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        wordDoc.open();
        wordDoc.save();

        pdfDoc.open();
        pdfDoc.save();

        excelDoc.open();
        excelDoc.save();
    }
}