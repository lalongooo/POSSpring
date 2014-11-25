/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.printservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;

/**
 *
 * @author Nato
 */
public class printServiceDummyThread implements Runnable{

    /*
     * Imprime archivo en la impresora predeterminada del equipo
     */
    private static void impresion() {
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
        System.out.println("Impresora: " + service.getName());

        Doc docPrint;
        try {
            docPrint = new SimpleDoc(new FileInputStream(file), docFlavor, null);
        } catch (FileNotFoundException e1) {
            System.out.println("Archivo no encontrado: " + e1.getMessage());
            return;
        }

        // inicio el proceso de impresion...
        DocPrintJob printJob = service.createPrintJob();
        try {
            printJob.print(docPrint, aset);
            System.out.println("salida...");
        } catch (PrintException e) {
            System.out.println("Error de impresion: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        impresion();
    }
}
