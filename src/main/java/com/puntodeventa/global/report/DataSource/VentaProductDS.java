/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.DataSource;


import com.puntodeventa.global.report.viewer.VentaProduct;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Nato
 */
public class VentaProductDS implements JRDataSource{
    private List<VentaProduct> listVentaDiaria = new ArrayList<VentaProduct>();
    private int indexVentaList = -1;

    
    
    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        if("id_folio".equals(jrf.getName())){
            valor = listVentaDiaria.get(indexVentaList).getId_folio();
        }else if("fecha".equals(jrf.getName())){
            valor = listVentaDiaria.get(indexVentaList).getFecha();
        }else if("id_usuario".equals(jrf.getName())){
            valor = listVentaDiaria.get(indexVentaList).getId_usuario();
        }else if("usuario".equals(jrf.getName())){
            valor = listVentaDiaria.get(indexVentaList).getUsuario();
        }else if("id_product".equals(jrf.getName())){
            valor = listVentaDiaria.get(indexVentaList).getId_product();
        }else if("product".equals(jrf.getName())){
            valor = listVentaDiaria.get(indexVentaList).getProducto();
        }else if("descripcion".equals(jrf.getName())){
            valor = listVentaDiaria.get(indexVentaList).getDescripcion();
        }else if("p_venta".equals(jrf.getName())){
            valor = listVentaDiaria.get(indexVentaList).getP_venta();
        }else if("cantidad".equals(jrf.getName())){
            valor = listVentaDiaria.get(indexVentaList).getCantidad();
        }else if("subtotal".equals(jrf.getName())){
            valor = listVentaDiaria.get(indexVentaList).getSubtotal();
        }else if("totCantidad".equals(jrf.getName())){
            valor = listVentaDiaria.get(indexVentaList).getTotCantidad();
        }else if("total".equals(jrf.getName())){
            valor = listVentaDiaria.get(indexVentaList).getTotal();
        }
        return valor;        
    }
    
    public boolean next() throws JRException {
        return ++ indexVentaList < listVentaDiaria.size();
    }   
    
    public void addVentaList(VentaProduct ventaProduct){
        this.listVentaDiaria.add(ventaProduct);
    }
    
    public void cleanBean(){
        this.listVentaDiaria.clear();
        this.indexVentaList = -1;
    }
    
}
