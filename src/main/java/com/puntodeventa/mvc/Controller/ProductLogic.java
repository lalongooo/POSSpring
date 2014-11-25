package com.puntodeventa.mvc.Controller;

import com.puntodeventa.global.Entity.Product;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.services.DAO.ProductDAO;
import java.util.List;

/**
 * @author USER
 */
public class ProductLogic {

    private LogHelper objLog = new LogHelper("ProductLogic");
    private ProductDAO productDAO = new ProductDAO();

    public List<Product> searchProducts(String searchCriteria, int option) {

        List<Product> products = null;

        try {
            products = this.productDAO.searchProducts(searchCriteria, option);
        } catch (Exception e) {
            this.objLog.Log("Error while searching products. " + e.getMessage());
        }

        return products;
    }

    public Product getProductById(String id) {

        Product product = null;

        try {
            product = this.productDAO.selectProduct(id);
        } catch (Exception e) {
            this.objLog.Log("Error while getting product by id. " + e.getMessage());
        }

        return product;
    }
}