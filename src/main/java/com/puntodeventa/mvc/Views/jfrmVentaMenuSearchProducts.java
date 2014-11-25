package com.puntodeventa.mvc.Views;

import com.puntodeventa.global.Entity.Product;
import com.puntodeventa.global.Util.Constants.ShortCuts;
import com.puntodeventa.global.Util.Constants.TableColumns;
import com.puntodeventa.global.Util.Extended.DefaultTableModelExtended;
import com.puntodeventa.global.Util.TagHelper;
import com.puntodeventa.global.Util.Util;
import com.puntodeventa.global.Util.ValidacionForms;
import com.puntodeventa.mvc.Controller.ProductLogic;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 * @author JORGE E. HERNANDEZ
 */
public class jfrmVentaMenuSearchProducts extends javax.swing.JDialog {

    private DefaultTableModelExtended tblModel = new DefaultTableModelExtended();
    private ValidacionForms valid = new ValidacionForms();
    private ProductLogic productLogic = new ProductLogic();
    private jfrmVenta parent;

    public jfrmVentaMenuSearchProducts(jfrmVenta parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        configureControls();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblCodeOrDescr = new javax.swing.JLabel();
        jtxtCodeOrDescr = new javax.swing.JTextField();
        jbtnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblProducts = new javax.swing.JTable();
        jbtnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jlblCodeOrDescr.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblCodeOrDescr.setText("Descripción o código");
        jlblCodeOrDescr.setName("jlblCodeOrDescr"); // NOI18N

        jtxtCodeOrDescr.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jtxtCodeOrDescr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtCodeOrDescrKeyTyped(evt);
            }
        });

        jbtnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-icon.png"))); // NOI18N
        jbtnSearch.setText("Buscar");
        jbtnSearch.setMaximumSize(new java.awt.Dimension(93, 29));
        jbtnSearch.setMinimumSize(new java.awt.Dimension(93, 29));
        jbtnSearch.setName("jbtnSearch"); // NOI18N
        jbtnSearch.setPreferredSize(new java.awt.Dimension(93, 29));
        jbtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchActionPerformed(evt);
            }
        });

        jtblProducts.setModel(this.tblModel);
        jtblProducts.setRowHeight(20);
        jtblProducts.setRowMargin(5);
        jtblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtblProductsMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtblProducts);

        jbtnClose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconCritical.png"))); // NOI18N
        jbtnClose.setText("Cerrar");
        jbtnClose.setName("jbtnClose"); // NOI18N
        jbtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jlblCodeOrDescr)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtxtCodeOrDescr, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlblCodeOrDescr)
                        .addComponent(jtxtCodeOrDescr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnClose)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtCodeOrDescrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCodeOrDescrKeyTyped
        if (evt.getKeyChar() == ShortCuts.SC_ENTER) {
            this.jbtnSearch.doClick();
        }
    }//GEN-LAST:event_jtxtCodeOrDescrKeyTyped

    private void jbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchActionPerformed

        List<Product> products = null;
        String searchCriteria = this.jtxtCodeOrDescr.getText();
        int searchOption = 0;

        if (Util.isNumeric(searchCriteria)) {
            searchOption = 1;
        } else if (searchCriteria.length() > 0) {
            searchOption = 2;
        }

        if (searchOption > 0) {
            products = productLogic.searchProducts(searchCriteria, searchOption);
        }else{
            valid.cleanTable(jtblProducts);
        }

        if (products != null) {

            this.jtxtCodeOrDescr.setText("");
            valid.cleanTable(jtblProducts);

            DefaultTableModelExtended model = (DefaultTableModelExtended) this.jtblProducts.getModel();
            String[] rowData;

            for (Product product : products) {
                rowData = new String[4];

                rowData[0] = String.valueOf(product.getId_product());
                rowData[1] = product.getProduct();
                rowData[2] = product.getDescripcion();
                rowData[3] = String.valueOf(product.getP_venta());
                model.addRow(rowData);
            }
        }
    }//GEN-LAST:event_jbtnSearchActionPerformed

    private void jtblProductsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblProductsMousePressed
        if (evt.getClickCount() == 2) {
            String qty = valid.msjInput(TagHelper.getTag("jfrmVentaMenuSearchProducts.question"), TagHelper.getTag("jfrmVentaMenuSearchProducts.addProductMessage"));

            if (Util.isNumeric(qty)) {
                Product product = this.productLogic.getProductById(this.jtblProducts.getValueAt(this.jtblProducts.getSelectedRow(), 0).toString());
                this.parent.addProduct(Integer.parseInt(qty), product.getId_product());
            } else {
                valid.msjInfo(this, TagHelper.getTag("jfrmVentaMenuSearchProducts.captureValidQty"));
            }
        }
    }//GEN-LAST:event_jtblProductsMousePressed

    private void jbtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnCloseActionPerformed

    private void configureControls() {

        this.setLocationRelativeTo(null);
        this.setTableModel();

        KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        Action escPressed = new AbstractAction("esc") {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        jlblCodeOrDescr.getActionMap().put("escPressed", escPressed);
        jlblCodeOrDescr.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(esc, "escPressed");
    }

    private void setTableModel() {
        for (int i = 0; i < TableColumns.SEARCH_PRODUCTS_COLUMNS.length; i++) {
            tblModel.addColumn(TableColumns.SEARCH_PRODUCTS_COLUMNS[i]);
        }
        this.jtblProducts.setModel(tblModel);
        valid.anchoColumTable(jtblProducts);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnClose;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JLabel jlblCodeOrDescr;
    private javax.swing.JTable jtblProducts;
    private javax.swing.JTextField jtxtCodeOrDescr;
    // End of variables declaration//GEN-END:variables
}