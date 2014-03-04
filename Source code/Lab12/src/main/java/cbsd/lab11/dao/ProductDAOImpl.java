package cbsd.lab11.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cbsd.lab11.entity.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/25/13
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProduct(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
    }

    @Override
    public void deleteProduct(Product product) {
        sessionFactory.getCurrentSession().delete(product);
    }

    @Override
    public List<Product> getProducts() {
        return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public Product findById(Long id) {
        return (Product) sessionFactory.getCurrentSession().get(Product.class,id);
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        Set<Product> expected = new HashSet<Product>();
        List result = sessionFactory.getCurrentSession().createQuery("from Product p where lower(p.name) like '%"+ keyword.toLowerCase() +"%'").list();
        expected.addAll(result);
        try{
            Double price = Double.parseDouble(keyword);
            result = sessionFactory.getCurrentSession().createQuery("from Product p where p.price = "+ price +"").list();
            expected.addAll(result);
        } catch (Exception e) { }
        return new ArrayList<Product>(expected);
    }
}
