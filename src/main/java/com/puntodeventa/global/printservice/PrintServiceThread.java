/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.printservice;

import com.puntodeventa.global.Enum.PrintType;
import com.puntodeventa.global.Util.LogHelper;
import java.io.IOException;
import javax.print.*;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PrintQuality;
import org.icepdf.core.exceptions.PDFException;
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
public class PrintServiceThread implements Runnable {

    private LogHelper objLog = new LogHelper("printServiceThread");
    private PrintType type;
    private String id_folio;

    public PrintServiceThread(PrintType type, String id_folio) {
        this.type = type;
        this.id_folio = id_folio;
    }

    /*
     * @Params type Indica el tipo de proceso que realiza: ventas, Corte para saber en qye directorio indicar
     * @Params if_folio indicara el nombre del Reporte a generar en disco
     */
    private void printICEPdf(){
        try {

            String file = "";
            
            if (type == PrintType.VENTA) {
                //file = ParamHelper.getParam("tickets.path.location").toString().replace("_ticketNumber_", id_folio);
                file = "D:\\vPuntoVenta/ventas/"+id_folio+".pdf";
            } else if (type == PrintType.CORTE) {
                //file = ParamHelper.getParam("cashout.path.location").toString().replace("_folio_", id_folio);                
                file = "D:\\vPuntoVenta/Corte/"+id_folio+".pdf";
            }
            
            Document pdf = new Document() {};
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
        } catch (PrintException | PDFException | PDFSecurityException | IOException ex) {
            objLog.Log(ex.getMessage());
        }
    }

    @Override
    public void run() {
        printICEPdf();
    }
}
