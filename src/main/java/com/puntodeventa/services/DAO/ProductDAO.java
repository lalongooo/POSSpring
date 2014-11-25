package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.Product;
import com.puntodeventa.global.Util.LogHelper;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fortunato Hdez Hdez
 */
public class ProductDAO {

    static final Logger LOG = Logger.getLogger(ProductDAO.class.getName());
    private Session session;
    private Transaction tx;
    private LogHelper objLog = new LogHelper("ProductDAO");

    //Metodo: Inicializa la operacion para procesos en la base de datos
    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    // Metodo: Obtenemos el error  que podria ocacionar an cada metodo
    private void manejaException(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrio un error en la capa de acceso a datos. Error: " + he.getMessage());
    }

    //Metodo Guarda Producto
    public String saveProduct(Product product) {
        String id_product;
        try {
            this.iniciaOperacion();
            id_product = (String) session.save(product);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return id_product;
    }

    /**
     * Actualiza los datos de la tabla Product
     */
    public void updateProduct(Product product) throws HibernateException {
        try {
            this.iniciaOperacion();
            session.update(product);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Elimina registro de la Tabla Product
     */
    public void deleteProduct(Product product) {
        try {
            this.iniciaOperacion();
            session.delete(product);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Metodo que devuelve un product
     */
    public Product selectProduct(String id_product) {
        Product product = null;
        try {
            this.iniciaOperacion();
            product = (Product) session.get(Product.class, id_product);
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return product;
    }

    public List<Product> listProduct() {
        List<Product> listProduct = null;
        try {
            this.iniciaOperacion();
            final SQLQuery sql = session.createSQLQuery("SELECT * FROM PRODUCT ORDER BY 2").addEntity(Product.class);
            listProduct = sql.list();
        } finally {
            session.close();
        }
        return listProduct;
    }

    public List<Product> searchProducts(String searchCriteria, int option) {
        List<Product> products = null;

        try {

            switch (option) {
                case 1:
                    this.iniciaOperacion();
                    products = session
                            .createCriteria(Product.class)
                            .add(Restrictions.like("id_product", "%" + searchCriteria + "%"))
                            .list();
                    this.tx.commit();
                    break;
                case 2:
                    this.iniciaOperacion();
                    products = session
                            .createCriteria(Product.class)
                            .add(Restrictions.or(Restrictions.ilike("product", "%" + searchCriteria + "%"), Restrictions.ilike("Descripcion", "%" + searchCriteria + "%")))
                            .list();
                    this.tx.commit();
                    break;
            }



        } catch (HibernateException he) {
            objLog.Log("Error while searching products by description. " + he.getMessage());
        } catch (Exception ex) {
            objLog.Log("Unexpected error. " + ex.getMessage());
        }

        return products;
    }
}