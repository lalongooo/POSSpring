/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.DataSource;


import com.puntodeventa.global.Entity.Corte;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Nato
 */
public class CorteDS implements JRDataSource{
    private List<Corte> listCorte = new ArrayList<>();
    private int indexCorteList = -1;
    
    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        switch (jrf.getName()) {
            case "id_folio":
                valor = listCorte.get(indexCorteList).getId_folio();
                break;
            case "fecha":
                valor = listCorte.get(indexCorteList).getFecha();
                break;
            case "efvo_inicial":
                valor = listCorte.get(indexCorteList).getEfvoInicial();
                break;
            case "total_precioventa":
                valor = listCorte.get(indexCorteList).getTotal_precioventa();
                break;
            case "efvo_caja":
                valor = listCorte.get(indexCorteList).getEfvoCaja();
                break;
            case "numero_de_ventas":
                valor = listCorte.get(indexCorteList).getNumero_de_ventas();
                break;
            case "id_usuario":
                valor = listCorte.get(indexCorteList).getId_usuario();
                break;
        }
        return valor;
    }
    
    @Override
    public boolean next() throws JRException {
        return ++ indexCorteList < listCorte.size();
    }
    
    public void addCompraList(Corte corte){
        this.listCorte.add(corte);
    }
    
    public void cleanBean(){
        this.listCorte.clear();
        this.indexCorteList = -1;
    }
}
