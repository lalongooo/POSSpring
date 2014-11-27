/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.printservice;

import com.puntodeventa.global.Entity.Venta;
import com.puntodeventa.global.Enum.PrintType;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.global.report.viewer.ReportGenerator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PrintQuality;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.views.DocumentViewController;
import org.icepdf.ri.common.PrintHelper;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.views.DocumentViewControllerImpl;

/**
 *
 * @author Nato
 */
public class POSPrintService {
    
    private static final LogHelper objLog = new LogHelper("POSPrintService");    

    /*
     * Imprime archivo en la impresora predeterminada del equipo
     */
    public static void impresion() {
        // tu archivo a imprimir
        String file = "c:\\anadirUsuario.gif";

        // definimos el tipo a imprimir
        DocFlavor docFlavor = DocFlavor.INPUT_STREAM.GIF;

        // establecemos algunos atributos de la impresora
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(MediaSizeName.ISO_A4);
        aset.add(new Copies(1));

        // mi impresora por default
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();

        Doc docPrint;
        try {
            docPrint = new SimpleDoc(new FileInputStream(file), docFlavor, null);
        } catch (FileNotFoundException e) {            
            objLog.Log(e.getMessage());
            return;
        }

        // inicio el proceso de impresion...
        DocPrintJob printJob = service.createPrintJob();
        try {
            printJob.print(docPrint, aset);
        } catch (PrintException e) {
            objLog.Log(e.getMessage());
        }
    }

    /*
     * @Params type Indica el tipo de proceso que realiza: ventas, Corte para saber en qye directorio indicar
     * @Params if_folio indicara el nombre del Reporte a generar en disco
     */
    public static void printICEPdf(PrintType type, String id_folio) throws PDFSecurityException {
        try {

            String file = "";

            if (type == PrintType.VENTA) {
                file = "D:\\vPuntoVenta/ventas/" + id_folio + ".pdf";
                //file = ParamHelper.getParam("tickets.path.location").toString().replace("_ticketNumber_", id_folio);
            } else if (type == PrintType.CORTE) {
                //file = ParamHelper.getParam("cashout.path.location").toString().replace("_folio_", id_folio);
                file = "D:\\vPuntoVenta/Corte/" + id_folio + ".pdf";
            }

            Document pdf = new Document() {
            };
            pdf.setFile(file);
            SwingController sc = new SwingController();
            DocumentViewController vc = new DocumentViewControllerImpl(sc);
            vc.setDocument(pdf);
            // create a new print helper with a specified paper size and print
            // quality
            PrintHelper printHelper = new PrintHelper(vc, pdf.getPageTree(),
                    MediaSizeName.NA_LEGAL, PrintQuality.DRAFT);
            // try and print pages 1 - 10, 1 copy, scale to fit paper.
            PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();

            //printHelper.setupPrintService(defaultService, 0, 9, 1, true);
            printHelper.setupPrintService(defaultService, 0, 0, 1, true);
            // print the document
            printHelper.print();
        } catch (PrintException ex) {
            System.out.println("1: " + ex.getMessage());
        } catch (org.icepdf.core.exceptions.PDFException ex) {
            System.out.println("2: " + ex.getMessage());
        } catch (PDFSecurityException ex) {
            System.out.println("3: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("4: " + ex.getMessage());
        }
    }

    public static void printTicket(Venta venta){
        
        ReportGenerator repGenerator = new ReportGenerator();
        byte[] pdfBuffer = null;
        
        try {
            
            pdfBuffer = repGenerator.generateTicketBuffer(venta);
            Document pdf = new Document() {};
            pdf.setByteArray(pdfBuffer, 0, pdfBuffer.length, null);
            
            
            DocumentViewController vc = new DocumentViewControllerImpl(new SwingController());
            vc.setDocument(pdf);
            
            // create a new print helper with a specified paper size and print quality
            PrintHelper printHelper = new PrintHelper(vc, pdf.getPageTree(), MediaSizeName.NA_LEGAL, PrintQuality.DRAFT);

            //printHelper.setupPrintService(defaultService, 0, 9, 1, true);
            printHelper.setupPrintService(PrintServiceLookup.lookupDefaultPrintService(), 0, 0, 1, true);
            
            // print the document
            printHelper.print();
            
        } catch (PrintException ex) {
            System.out.println("1: " + ex.getMessage());
        } catch (org.icepdf.core.exceptions.PDFException ex) {
            System.out.println("2: " + ex.getMessage());
        } catch (PDFSecurityException ex) {
            System.out.println("3: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("4: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("5: " + ex.getMessage());
        }
    }

    public static void printArrayPdf(byte[] pdfBuffer) throws PDFSecurityException {
        try {

            Document pdf = new Document() {};
            pdf.setByteArray(pdfBuffer, 0, pdfBuffer.length, null);

            DocumentViewController vc = new DocumentViewControllerImpl(new SwingController());
            vc.setDocument(pdf);

            // create a new print helper with a specified paper size and print quality
            PrintHelper printHelper = new PrintHelper(vc, pdf.getPageTree(), MediaSizeName.NA_LEGAL, PrintQuality.DRAFT);

            //printHelper.setupPrintService(defaultService, 0, 9, 1, true);
            printHelper.setupPrintService(PrintServiceLookup.lookupDefaultPrintService(), 0, 0, 1, true);

            // print the document
            printHelper.print();

        } catch (PrintException ex) {
            System.out.println("1: " + ex.getMessage());
        } catch (org.icepdf.core.exceptions.PDFException ex) {
            System.out.println("2: " + ex.getMessage());
        } catch (PDFSecurityException ex) {
            System.out.println("3: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("4: " + ex.getMessage());
        }
    }
    
}
