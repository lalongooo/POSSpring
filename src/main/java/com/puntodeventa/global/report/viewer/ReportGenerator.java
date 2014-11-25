/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.viewer;

import com.puntodeventa.global.Entity.Venta;
import com.puntodeventa.global.report.DataSource.VentaProductDS;
import com.puntodeventa.services.DAO.VentaDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Nato
 */
public class ReportGenerator {
    static JasperReport Reporte;
    static JasperPrint impresion;
    static JasperViewer jviewer;    
    static VentaDAO ventaDAO = new VentaDAO();
    static VentaProductDS ventaProductDS = new VentaProductDS();
    static VentaProduct listV;
    static String pathImage = System.getProperty("user.dir") + "/src/images/";
    byte[] pdfBuffer = null;
    

    
    public boolean generateTicket(String id_folio, String Pefectivo, String Pcambio){
        try {            
            List<VentaProduct> listVentaProduct;
            listVentaProduct = ventaDAO.getVentaId(id_folio);
            Map param = new HashMap();
            param.put("logo", pathImage + "splash1.jpg");
            param.put("efectivo", Pefectivo);
            param.put("cambio", Pcambio);
            
            for(VentaProduct v: listVentaProduct){                
                listV = new VentaProduct(
                        v.getId_folio(),
                        v.getFecha(),
                        v.getId_usuario(),
                        v.getUsuario(),
                        v.getId_product(),
                        v.getProducto(),
                        v.getDescripcion(),
                        v.getP_venta(),
                        v.getCantidad(),
                        v.getSubtotal(),
                        v.getTotCantidad(),
                        v.getTotal());
                ventaProductDS.addVentaList(listV);
            }
            
            String archivo = System.getProperty("user.dir") + "/src/com/puntodeventa/global/report/File/ventaId.jasper";
            Reporte = (JasperReport) JRLoader.loadObject(archivo);            
            JasperPrint jasperPrint = (JasperPrint)JasperFillManager.fillReport(Reporte, param, ventaProductDS);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(ParamHelper.getParam("tickets.path.location").toString().replace("_ticketNumber_", id_folio)));            
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("D:\\vPuntoVenta\\ventas\\"+id_folio+".pdf"));
            exporter.exportReport();
            ventaProductDS.cleanBean();
            return true;
        } catch (JRException ex) {
            System.out.println("- " + ex.getLocalizedMessage());
            return false;
        }
    }
    
    public byte[] generateTicketBuffer(Venta venta){
        try {
            List<VentaProduct> listVentaProduct = ventaDAO.getVentaId(venta != null ? String.valueOf(venta.getIdFolio()) : "1");
            
            Map param = new HashMap();
            param.put("logo", pathImage + "splash1.jpg");
            param.put("efectivo", venta != null ? String.valueOf(venta.getEfectivo()) : "");
            param.put("cambio", venta != null ? String.valueOf(venta.getCambio()) : "");
            
            for(VentaProduct v: listVentaProduct){                
                listV = new VentaProduct(
                        v.getId_folio(),
                        v.getFecha(),
                        v.getId_usuario(),
                        v.getUsuario(),
                        v.getId_product(),
                        v.getProducto(),
                        v.getDescripcion(),
                        v.getP_venta(),
                        v.getCantidad(),
                        v.getSubtotal(),
                        v.getTotCantidad(),
                        v.getTotal());
                ventaProductDS.addVentaList(listV);
            }
            
            String archivo = System.getProperty("user.dir") + "/src/com/puntodeventa/global/report/File/ventaId.jasper";
            InputStream is = new FileInputStream(new File(archivo));
            pdfBuffer = JasperRunManager.runReportToPdf(is, param, ventaProductDS);
            ventaProductDS.cleanBean();
            return pdfBuffer;
        } catch (JRException | FileNotFoundException ex) {
            System.out.println("Error al generar el archivo pdf");
            return pdfBuffer;
        }
    }
}